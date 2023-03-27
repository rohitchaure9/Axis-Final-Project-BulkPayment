package com.axis.controller;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.axis.helper.Helper;
import com.axis.model.PaymentTemplate;
import com.axis.service.PaymentService;

@RestController
@RequestMapping("/api/bulkpayment/")
@CrossOrigin("*")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	@PostMapping("/upload/file")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file){
		if(Helper.checkExcelFormat(file))
		{
			String name = file.getOriginalFilename();
        	String fileName = name.substring(0, name.indexOf("."));
        	EntityTransaction txn = null;
    		try {
    			EntityManager entityManager = entityManagerFactory.createEntityManager();
    			txn = entityManager.getTransaction();
    			txn.begin();
    			entityManager.createNativeQuery( "CREATE TABLE "+fileName+" (debit_account_number BIGINT(255), transaction_amount DOUBLE(20,2), transaction_currency varchar(255), beneficiary_name varchar(255), beneficiary_account_number BIGINT(255), ifsc_code varchar(255), transaction_date varchar(255), payment_mode varchar(255), customer_ref_number BIGINT(255), beneficiary_code BIGINT(255), account_type varchar(255), beneficiary_type varchar(255), lei varchar(255), debit_narration varchar(255), credit_narration varchar(255), invoice_number BIGINT(255), beneficiary_address_1 varchar(255), beneficiary_address_2 varchar(255), beneficiary_address_3 varchar(255), beneficiary_city varchar(255), beneficiary_state varchar(255), beneficiary_pin_code int(255), beneficiary_email_1 varchar(255), beneficiary_email_2 varchar(255), mobile_number BIGINT(255), add_info_1 varchar(255), add_info_2 varchar(255), add_info_3 varchar(255), add_info_4 varchar(255), add_info_5 varchar(255), add_info_6 varchar(255), PRIMARY KEY (debit_account_number))" ).executeUpdate();
    			txn.commit();
    		}
    		catch ( Throwable e ) {
    			if ( txn != null && txn.isActive() ) {
    				txn.rollback();
    			}
    			throw e;
    		}
        	
            this.paymentService.save(file,fileName);
		}
		return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));
	}
	
	@GetMapping("/tablenames")
    public ResponseEntity<List<String>> getTableNames(){
    	return new ResponseEntity<List<String>> (paymentService.showFiles(),HttpStatus.OK);
    }
    
    @GetMapping("/table/{tableName}")
    public ResponseEntity<List<PaymentTemplate>> getTable(@PathVariable String tableName){
    	return new ResponseEntity<List<PaymentTemplate>> (paymentService.getTable(tableName),HttpStatus.OK);
    }
    
    @DeleteMapping("/table/{tableName}")
    public ResponseEntity<String> deleteTable(@PathVariable String tableName){
    	return new ResponseEntity<String> (paymentService.deleteTable(tableName),HttpStatus.OK);
    }
	
}
