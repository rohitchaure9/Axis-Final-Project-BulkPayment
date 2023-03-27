package com.axis.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.axis.helper.Helper;
import com.axis.model.PaymentTemplate;

@Service
public class PaymentService {
	
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	public void save(MultipartFile file, String table) {

        try {
            List<PaymentTemplate> payments = Helper.convertExcelToListOfProduct(file.getInputStream());
            EntityTransaction txn = null;
    		try {
    			EntityManager entityManager = entityManagerFactory.createEntityManager();
    			for(PaymentTemplate payment : payments) {
    				txn = entityManager.getTransaction();
        			txn.begin();
        			entityManager.createNativeQuery( 
        					"INSERT INTO "+table+" VALUES ("+payment.getDebitAccountNumber()+","+payment.getTransactionAmount()+",'"+payment.getTransactionCurrency()+"','"+payment.getBeneficiaryName()+"',"+payment.getBeneficiaryAccountNumber()+",'"+payment.getIFSCCode()+"','"+payment.getTransactionDate()+"','"+payment.getPaymentMode()+"',"+payment.getCustomerReferenceNumber()+","+payment.getBeneficiaryCode()+",'"+payment.getAccountType()+"','"+payment.getBeneficiaryType()+"','"+payment.getLei()+"','"+payment.getDebitNarration()+"','"+payment.getCreditNarration()+"',"+payment.getInvoiceNumber()+",'"+payment.getBeneficiaryAddress1()+"','"+payment.getBeneficiaryAddress2()+"','"+payment.getBeneficiaryAddress3()+"','"+payment.getBeneficiaryCity()+"','"+payment.getBeneficiaryState()+"',"+payment.getBeneficiaryPinCode()+",'"+payment.getBeneficiaryEmail1()+"','"+payment.getBeneficiaryEmail2()+"',"+payment.getMobileNumber()+",'"+payment.getAddInfo1()+"','"+payment.getAddInfo2()+"','"+payment.getAddInfo3()+"','"+payment.getAddInfo4()+"','"+payment.getAddInfo5()+"','"+payment.getAddInfo6()+"')").executeUpdate();
        			txn.commit();
    			}
    		}
    		catch ( Throwable e ) {
    			if ( txn != null && txn.isActive() ) {
    				txn.rollback();
    			}
    			throw e;
    		}
            //this.productRepo.saveAll(products);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	
	 public List<String> showFiles() {
	    	List<String> tableNames= new ArrayList<String>();
	    	EntityTransaction txn = null;
			try {
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				txn = entityManager.getTransaction();
				txn.begin();
				tableNames = entityManager.createNativeQuery("SHOW TABLES").getResultList();
				txn.commit();
			}
			catch ( Throwable e ) {
				if ( txn != null && txn.isActive() ) {
					txn.rollback();
				}
				throw e;
			}
			return tableNames;
	 }
	 
	 public List<PaymentTemplate> getTable(String table){
	    	List<PaymentTemplate> products= new ArrayList<PaymentTemplate>();
	    	EntityTransaction txn = null;
			try {
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				txn = entityManager.getTransaction();
				txn.begin();
				products = entityManager.createNativeQuery("SELECT * FROM "+table).getResultList();
				txn.commit();
			}
			catch ( Throwable e ) {
				if ( txn != null && txn.isActive() ) {
					txn.rollback();
				}
				throw e;
			}
			return products;
	}
	
	 public String deleteTable(String table)
	 {
		 EntityTransaction txn = null;
			try {
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				txn = entityManager.getTransaction();
				txn.begin();
				entityManager.createNativeQuery("DROP TABLE "+table).executeUpdate();
				txn.commit();
			}
			catch ( Throwable e ) {
				if ( txn != null && txn.isActive() ) {
					txn.rollback();
				}
				throw e;
			}
			return "Table is deleted.";
	 }
}
