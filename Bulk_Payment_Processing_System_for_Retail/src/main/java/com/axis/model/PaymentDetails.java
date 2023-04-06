package com.axis.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PaymentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	
	private long debitAccountNumber;
	private double transactionAmount;
	private String transactionCurrency;
	private String beneficiaryName;
	private long beneficiaryAccountNumber;
	private String IFSCCode;
	private String transactionDate;
	private String paymentMode;
	private long customerReferenceNumber;
	private long beneficiaryCode;
	private String accountType;
	private String beneficiaryType;
	private String lei;
	private String debitNarration;
	private String creditNarration;
	private long invoiceNumber;
	private String beneficiaryAddress1;
	private String beneficiaryAddress2;
	private String beneficiaryAddress3;
	private String beneficiaryCity;
	private String beneficiaryState;
	private int beneficiaryPinCode;
	private String beneficiaryEmail1;
	private String beneficiaryEmail2;
	private long mobileNumber;
	private String addInfo1;
	private String addInfo2;
	private String addInfo3;
	private String addInfo4;
	private String addInfo5;
	private String addInfo6;
	
	private int templateId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="transactionHeaderId")
	private TransactionHeader transactionHeader;

	public PaymentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public PaymentDetails(int paymentId, long debitAccountNumber, double transactionAmount, String transactionCurrency,
			String beneficiaryName, long beneficiaryAccountNumber, String iFSCCode, String transactionDate,
			String paymentMode, long customerReferenceNumber, long beneficiaryCode, String accountType,
			String beneficiaryType, String lei, String debitNarration, String creditNarration, long invoiceNumber,
			String beneficiaryAddress1, String beneficiaryAddress2, String beneficiaryAddress3, String beneficiaryCity,
			String beneficiaryState, int beneficiaryPinCode, String beneficiaryEmail1, String beneficiaryEmail2,
			long mobileNumber, String addInfo1, String addInfo2, String addInfo3, String addInfo4, String addInfo5,
			String addInfo6, int templateId, TransactionHeader transactionHeader) {
		super();
		this.paymentId = paymentId;
		this.debitAccountNumber = debitAccountNumber;
		this.transactionAmount = transactionAmount;
		this.transactionCurrency = transactionCurrency;
		this.beneficiaryName = beneficiaryName;
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
		IFSCCode = iFSCCode;
		this.transactionDate = transactionDate;
		this.paymentMode = paymentMode;
		this.customerReferenceNumber = customerReferenceNumber;
		this.beneficiaryCode = beneficiaryCode;
		this.accountType = accountType;
		this.beneficiaryType = beneficiaryType;
		this.lei = lei;
		this.debitNarration = debitNarration;
		this.creditNarration = creditNarration;
		this.invoiceNumber = invoiceNumber;
		this.beneficiaryAddress1 = beneficiaryAddress1;
		this.beneficiaryAddress2 = beneficiaryAddress2;
		this.beneficiaryAddress3 = beneficiaryAddress3;
		this.beneficiaryCity = beneficiaryCity;
		this.beneficiaryState = beneficiaryState;
		this.beneficiaryPinCode = beneficiaryPinCode;
		this.beneficiaryEmail1 = beneficiaryEmail1;
		this.beneficiaryEmail2 = beneficiaryEmail2;
		this.mobileNumber = mobileNumber;
		this.addInfo1 = addInfo1;
		this.addInfo2 = addInfo2;
		this.addInfo3 = addInfo3;
		this.addInfo4 = addInfo4;
		this.addInfo5 = addInfo5;
		this.addInfo6 = addInfo6;
		this.templateId = templateId;
		this.transactionHeader = transactionHeader;
	}



	public int getTemplateId() {
		return templateId;
	}



	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}



	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public long getDebitAccountNumber() {
		return debitAccountNumber;
	}

	public void setDebitAccountNumber(long debitAccountNumber) {
		this.debitAccountNumber = debitAccountNumber;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionCurrency() {
		return transactionCurrency;
	}

	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public long getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}

	public void setBeneficiaryAccountNumber(long beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}

	public String getIFSCCode() {
		return IFSCCode;
	}

	public void setIFSCCode(String iFSCCode) {
		IFSCCode = iFSCCode;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public long getCustomerReferenceNumber() {
		return customerReferenceNumber;
	}

	public void setCustomerReferenceNumber(long customerReferenceNumber) {
		this.customerReferenceNumber = customerReferenceNumber;
	}

	public long getBeneficiaryCode() {
		return beneficiaryCode;
	}

	public void setBeneficiaryCode(long beneficiaryCode) {
		this.beneficiaryCode = beneficiaryCode;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBeneficiaryType() {
		return beneficiaryType;
	}

	public void setBeneficiaryType(String beneficiaryType) {
		this.beneficiaryType = beneficiaryType;
	}

	public String getLei() {
		return lei;
	}

	public void setLei(String lei) {
		this.lei = lei;
	}

	public String getDebitNarration() {
		return debitNarration;
	}

	public void setDebitNarration(String debitNarration) {
		this.debitNarration = debitNarration;
	}

	public String getCreditNarration() {
		return creditNarration;
	}

	public void setCreditNarration(String creditNarration) {
		this.creditNarration = creditNarration;
	}

	public long getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getBeneficiaryAddress1() {
		return beneficiaryAddress1;
	}

	public void setBeneficiaryAddress1(String beneficiaryAddress1) {
		this.beneficiaryAddress1 = beneficiaryAddress1;
	}

	public String getBeneficiaryAddress2() {
		return beneficiaryAddress2;
	}

	public void setBeneficiaryAddress2(String beneficiaryAddress2) {
		this.beneficiaryAddress2 = beneficiaryAddress2;
	}

	public String getBeneficiaryAddress3() {
		return beneficiaryAddress3;
	}

	public void setBeneficiaryAddress3(String beneficiaryAddress3) {
		this.beneficiaryAddress3 = beneficiaryAddress3;
	}

	public String getBeneficiaryCity() {
		return beneficiaryCity;
	}

	public void setBeneficiaryCity(String beneficiaryCity) {
		this.beneficiaryCity = beneficiaryCity;
	}

	public String getBeneficiaryState() {
		return beneficiaryState;
	}

	public void setBeneficiaryState(String beneficiaryState) {
		this.beneficiaryState = beneficiaryState;
	}

	public int getBeneficiaryPinCode() {
		return beneficiaryPinCode;
	}

	public void setBeneficiaryPinCode(int beneficiaryPinCode) {
		this.beneficiaryPinCode = beneficiaryPinCode;
	}

	public String getBeneficiaryEmail1() {
		return beneficiaryEmail1;
	}

	public void setBeneficiaryEmail1(String beneficiaryEmail1) {
		this.beneficiaryEmail1 = beneficiaryEmail1;
	}

	public String getBeneficiaryEmail2() {
		return beneficiaryEmail2;
	}

	public void setBeneficiaryEmail2(String beneficiaryEmail2) {
		this.beneficiaryEmail2 = beneficiaryEmail2;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddInfo1() {
		return addInfo1;
	}

	public void setAddInfo1(String addInfo1) {
		this.addInfo1 = addInfo1;
	}

	public String getAddInfo2() {
		return addInfo2;
	}

	public void setAddInfo2(String addInfo2) {
		this.addInfo2 = addInfo2;
	}

	public String getAddInfo3() {
		return addInfo3;
	}

	public void setAddInfo3(String addInfo3) {
		this.addInfo3 = addInfo3;
	}

	public String getAddInfo4() {
		return addInfo4;
	}

	public void setAddInfo4(String addInfo4) {
		this.addInfo4 = addInfo4;
	}

	public String getAddInfo5() {
		return addInfo5;
	}

	public void setAddInfo5(String addInfo5) {
		this.addInfo5 = addInfo5;
	}

	public String getAddInfo6() {
		return addInfo6;
	}

	public void setAddInfo6(String addInfo6) {
		this.addInfo6 = addInfo6;
	}

	public TransactionHeader getTransactionHeader() {
		return transactionHeader;
	}

	public void setTransactionHeader(TransactionHeader transactionHeader) {
		this.transactionHeader = transactionHeader;
	}
	
	
}
