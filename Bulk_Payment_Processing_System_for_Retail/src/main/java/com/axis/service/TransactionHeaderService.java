package com.axis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.axis.model.PaymentDetails;
import com.axis.model.TransactionHeader;

public interface TransactionHeaderService {
	List<PaymentDetails> saveTransactionHeader(MultipartFile file, int templateId, String fileName, String fileType);
    Optional<TransactionHeader> getTransactionHeaderById(int id);
    List<TransactionHeader> getAllTransactionHeaders();
    String deleteTransactionHeader(int id);
    List<PaymentDetails> getPaymentDetailsByTransactionIdTemplateId(int transactionId);
    List<TransactionHeader> getTransactionHeaderByTemplateId(int templateId);
}
