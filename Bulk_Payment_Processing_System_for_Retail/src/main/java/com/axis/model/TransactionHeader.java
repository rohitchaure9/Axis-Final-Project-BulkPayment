package com.axis.model;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
@Entity
public class TransactionHeader {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionHeaderId;
	
	private String name;
	
	private LocalDate uploadDate;
	
	private int templateId;
	
	private String fileType;
	
	@OneToMany(mappedBy = "transactionHeader", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnoreProperties("transactionHeader")
	private List<PaymentDetails> paymentDetails;

	public TransactionHeader() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionHeader(int transactionId, String name, LocalDate uploadDate,
			List<PaymentDetails> paymentDetails, int templateId, String fileType) {
		super();
		this.transactionHeaderId = transactionId;
		this.name = name;
		this.uploadDate = uploadDate;
		this.paymentDetails = paymentDetails;
		this.templateId = templateId;
		this.fileType = fileType;
	}

	
	
	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public int getTransactionHeaderId() {
		return transactionHeaderId;
	}

	public void setTransactionHeaderId(int transactionHeaderId) {
		this.transactionHeaderId = transactionHeaderId;
	}

	public int getTemplateId() {
		return templateId;
	}

	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}

	public int getTransactionId() {
		return transactionHeaderId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionHeaderId = transactionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(LocalDate uploadDate) {
		this.uploadDate = uploadDate;
	}

	public List<PaymentDetails> getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(List<PaymentDetails> paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	
	
	
}
