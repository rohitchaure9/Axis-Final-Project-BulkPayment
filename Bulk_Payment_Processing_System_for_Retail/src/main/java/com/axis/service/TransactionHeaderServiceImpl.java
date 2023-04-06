package com.axis.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.axis.helper.Helper;
import com.axis.model.PaymentDetails;
import com.axis.model.TemplateHeader;
import com.axis.model.TransactionHeader;
import com.axis.repository.PaymentDetailsRepository;
import com.axis.repository.TransactionHeaderRepository;

@Service
public class TransactionHeaderServiceImpl implements TransactionHeaderService{
	
	@Autowired
	TransactionHeaderRepository transactionHeaderRepository;
	
	@Autowired
	PaymentDetailsRepository paymentDetailsRepository;
	
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	@Autowired
	TemplateHeaderService templateHeaderService;

	@Override
	public List<PaymentDetails> saveTransactionHeader(MultipartFile file, int templateId , String fileName, String fileType) {
		// TODO Auto-generated method stub
		TransactionHeader transactionHeader = new TransactionHeader();
		try {
			Optional<TemplateHeader> templateHeader = templateHeaderService.getTemplateHeaderById(templateId);
	   		
			Map<String, List<PaymentDetails>> resultMap = Helper.convertExcelToListOfProduct(file.getInputStream(), templateId, templateHeader);
			List<PaymentDetails> paymentDetails = resultMap.get("savedFields");
            List<PaymentDetails> errorFields = resultMap.get("errorFields");
			for(PaymentDetails payment: paymentDetails)
			{
				payment.setTemplateId(templateId);
				payment.setTransactionHeader(transactionHeader);
			}
			transactionHeader.setUploadDate(LocalDate.now());
			transactionHeader.setName(fileName);
			transactionHeader.setPaymentDetails(paymentDetails);
			transactionHeader.setTemplateId(templateId);
			transactionHeader.setFileType(fileType);
			
			transactionHeaderRepository.save(transactionHeader);
			paymentDetailsRepository.saveAll(paymentDetails);
			
			return errorFields;
		}
		catch(Throwable e) {
			
		}
		
		return null;
		
		
		
		
	}

	@Override
	public Optional<TransactionHeader> getTransactionHeaderById(int id) {
		// TODO Auto-generated method stub
		Optional<TransactionHeader> transactionHeader = transactionHeaderRepository.findById(id);
		return transactionHeader;
	}
	
	@Override
	public List<TransactionHeader> getAllTransactionHeaders() {
		// TODO Auto-generated method stub
		List<TransactionHeader> transactionHeaders = transactionHeaderRepository.findAll();
		return transactionHeaders;
	}

	@Override
	public String deleteTransactionHeader(int id) {
		// TODO Auto-generated method stub
		transactionHeaderRepository.deleteById(id);
		return "Transaction Deleted.";	
	}
	
	@Override
	public List<PaymentDetails> getPaymentDetailsByTransactionIdTemplateId(int transactionId){
		List<PaymentDetails> templateDetails = new ArrayList<PaymentDetails>();
		EntityTransaction txn = null;
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			
			txn = entityManager.getTransaction();
    		txn.begin();
    		templateDetails = entityManager.createNativeQuery("SELECT * FROM payment_details WHERE transaction_header_id="+transactionId).getResultList();
    		txn.commit();
		}
		catch ( Throwable e ) {
			if ( txn != null && txn.isActive() ) {
				txn.rollback();
			}
			throw e;
		}
		
		return templateDetails;
	}
	
	public List<TransactionHeader> getTransactionHeaderByTemplateId(int templateId){
		List<TransactionHeader> transactionHeaders = new ArrayList<TransactionHeader>();
		EntityTransaction txn = null;
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			
			txn = entityManager.getTransaction();
    		txn.begin();
    		transactionHeaders = entityManager.createNativeQuery("SELECT * FROM transaction_header WHERE template_id="+templateId).getResultList();
    		txn.commit();
		}
		catch ( Throwable e ) {
			if ( txn != null && txn.isActive() ) {
				txn.rollback();
			}
			throw e;
		}
		
		return transactionHeaders;
	}

}
