package com.axis.helper;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.axis.model.PaymentDetails;
import com.axis.model.TemplateDetails;
import com.axis.model.TemplateHeader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class Helper {
	
//	@Autowired
//	private EntityManagerFactory entityManagerFactory;
	
//	@Autowired
//	TemplateHeaderService templateHeaderService;

    //check that file is of excel type or not
    public static boolean checkExcelFormat(MultipartFile file) {

        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }

    }
    
    public static boolean checkHeaderAndExcel() {
    	
    	return true;
    }


    //convert excel to list of products

    public static Map<String, List<PaymentDetails>> convertExcelToListOfProduct(InputStream is, int templateId , Optional<TemplateHeader> templateHeader) {
    	List<PaymentDetails> savedFields = new ArrayList<>();
    	List<PaymentDetails> errorFields = new ArrayList<>();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);

            //XSSFSheet sheet = workbook.getSheet("Sheet1");
            XSSFSheet worksheet = workbook.getSheetAt(0);
            
            //storing fields of excel sheet
            Row headerRow = worksheet.getRow(0);
            List<String> fieldRow = new ArrayList<String>();
            List<String> tableRow = new ArrayList<String>();
            Iterator<Cell> cells = headerRow.iterator();
            
            while(cells.hasNext()) {
            	Cell cell=cells.next();
            	fieldRow.add(cell.getStringCellValue());
            }
            
            Collections.sort(fieldRow);
            for(String str : fieldRow)
            {
            	System.out.println(str);
            }
           
            List<TemplateDetails> templateDetails = templateHeader.get().getTemplateDetails();
            
            
            for(TemplateDetails templateDetail :templateDetails)
            {
            	tableRow.add(templateDetail.getFieldName());
            }
            
            Collections.sort(tableRow);
            
            for(String str : tableRow)
            {
            	System.out.println(str);
            }
   		
   		if(fieldRow.equals(tableRow)) {
   			int rowNumber = 0;
            Iterator<Row> iterator = worksheet.iterator();
            
            while (iterator.hasNext()) {
                Row row = iterator.next();
                Row columnName = worksheet.getRow(0);
                int i =0;
                
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                
                int flag=0;
           
                Iterator<Cell> cells1 = row.iterator();
                PaymentDetails p = new PaymentDetails();
                
                while (cells1.hasNext()) {
                    Cell cell = cells1.next();
                    
                    String name = columnName.getCell(i).getStringCellValue().trim();
                    //System.out.println(name);
                    
                    if(name.equals("Debit Account Number")) {
                    	if(cell.getCellType()!=CellType.NUMERIC)
                    	{
                    		flag=1;
                    	}
                    	else {
                    		p.setDebitAccountNumber((long) cell.getNumericCellValue());
                    	}
                    }
                    
                    if(name.equals("Transaction Amount")) {
                    	if(cell.getCellType()!=CellType.NUMERIC)
                    	{
                    		flag=1;
                    	}
                    	else {
                    		p.setTransactionAmount((double) cell.getNumericCellValue());
                    	}
                    }
                    
                    if(name.equals("Transaction Currency")) {
                    	if(cell.getCellType()!=CellType.STRING || cell==null) {
                    		flag=1;
                    	}
                    	else {
                    		p.setTransactionCurrency(cell.getStringCellValue());
                    	}
                    }
                    
                    if(name.equals("Beneficiary Name")) {
                    	if(cell.getCellType()!=CellType.STRING || cell==null)
                    	{
                    		flag=1;
                    	}
                    	else {
                    		p.setBeneficiaryName(cell.getStringCellValue());
                    	}
                    }
                    
                    if(name.equals("Beneficiary Account Number")) {
                    	if(cell.getCellType()!=CellType.NUMERIC)
                    	{
                    		flag=1;
                    	}
                    	else {
                    		p.setBeneficiaryAccountNumber((long) cell.getNumericCellValue());
                    	}
                    }
                    
                    if(name.equals("Beneficiary IFSC Code")) {
                    	if(cell.getCellType()!=CellType.STRING || cell==null)
                    	{
                    		flag=1;
                    	}
                    	else {
                    		p.setIFSCCode(cell.getStringCellValue());
                    	}
                    }
                    
                    if(name.equals("Transaction Date")) {
                    	if(cell.getCellType()!=CellType.STRING || cell==null)
                    	{
                    		flag=1;
                    	}else {
                    		p.setTransactionDate(cell.getStringCellValue());
                    	}
                    }
                    
                    if(name.equals("Payment Mode")) {
                    	if(cell.getCellType()!=CellType.STRING || cell==null)
                    	{
                    		flag=1;
                    	}else {
                    		p.setPaymentMode(cell.getStringCellValue());
                    	}
                    }
                    
                    if(name.equals("Customer Reference Number")) {
                    	if(cell.getCellType()!=CellType.NUMERIC)
                    	{
                    		flag=1;
                    	}else {
                    		p.setCustomerReferenceNumber((long) cell.getNumericCellValue());
                    	}
                    }
                    
                    if(name.equals("Beneficiary Code")) {
                    	if(cell.getCellType()!=CellType.NUMERIC)
                    	{
                    		flag=1;
                    	}else {
                    		p.setBeneficiaryCode((long) cell.getNumericCellValue());
                    	}
                    }
                    
                    if(name.equals("Account Type")) {
                    	if(cell.getCellType()!=CellType.STRING || cell==null)
                    	{
                    		flag=1;
                    	}else {
                    		p.setAccountType(cell.getStringCellValue());
                    	}
                    }
                    
                    if(name.equals("Beneficiary Type")) {
                    	if(cell.getCellType()!=CellType.STRING || cell==null)
                    	{
                    		flag=1;
                    	}
                    	else {
                    		p.setBeneficiaryType(cell.getStringCellValue());
                    	}
                    }
                    
                    if(name.equals("LEI")) {
                    	if(cell.getCellType()!=CellType.STRING || cell==null)
                    	{
                    		flag=1;
                    	}
                    	else {
                    		p.setLei(cell.getStringCellValue());
                    	}
                    }
                    
                    if(name.equals("Debit Narration")) {
                    	if(cell.getCellType()!=CellType.STRING || cell==null)
                    	{
                    		flag=1;
                    	}
                    	else {
                    		p.setDebitNarration(cell.getStringCellValue());
                    	}
                    }
                    
                    if(name.equals("Credit Narration")) {
                    	if(cell.getCellType()!=CellType.STRING || cell==null)
                    	{
                    		flag=1;
                    	}
                    	else {
                    		p.setCreditNarration(cell.getStringCellValue());
                    	}
                    }
                    
                    if(name.equals("Invoice Number")) {
                    	if(cell.getCellType()!=CellType.NUMERIC)
                    	{
                    		flag=1;
                    	}
                    	else {
                    		p.setInvoiceNumber((long) cell.getNumericCellValue());
                    	}
                    }
                    
                    if(name.equals("Beneficiary Address 1")) {
                    	if(cell.getCellType()!=CellType.STRING || cell==null)
                    	{
                    		flag=1;
                    	}
                    	else {
                    		p.setBeneficiaryAddress1(cell.getStringCellValue());
                    	}
                    }
                    
                    if(name.equals("Beneficiary Address 2")) {
                    	if(cell.getCellType()!=CellType.STRING || cell==null)
                    	{
                    		flag=1;
                    	}
                    	else {
                    		p.setBeneficiaryAddress2(cell.getStringCellValue());
                    	}
                    }
                    
                    if(name.equals("Beneficiary Address 3")) {
                    	if(cell.getCellType()!=CellType.STRING || cell==null)
                    	{
                    		flag=1;
                    	}
                    	else {
                    		p.setBeneficiaryAddress3(cell.getStringCellValue());
                    	}
                    }
                    
                    if(name.equals("Beneficiary City")) {
                    	if(cell.getCellType()!=CellType.STRING || cell==null)
                    	{
                    		flag=1;
                    	}
                    	else {
                    		p.setBeneficiaryCity(cell.getStringCellValue());
                    	}
                    }
                    
                    if(name.equals("Beneficiary State")) {
                    	if(cell.getCellType()!=CellType.STRING || cell==null)
                    	{
                    		flag=1;
                    	}
                    	else {
                    		p.setBeneficiaryState(cell.getStringCellValue());
                    	}
                    }
                    
                    if(name.equals("Beneficiary Pin Code")) {
                    	if(cell.getCellType()!=CellType.NUMERIC)
                    	{
                    		flag=1;
                    	}
                    	else {
                    		p.setBeneficiaryPinCode((int) cell.getNumericCellValue());
                    	}
                    }
                    
                    if(name.equals("Beneficiary Email 1")) {
                    	if(cell.getCellType()!=CellType.STRING || cell==null)
                    	{
                    		flag=1;
                    	}
                    	else {
                    		p.setBeneficiaryEmail1(cell.getStringCellValue());
                    	}
                    }
                    
                    if(name.equals("Beneficiary Email 2")) {
                    	if(cell.getCellType()!=CellType.STRING || cell==null)
                    	{
                    		flag=1;
                    	}
                    	else {
                    		p.setBeneficiaryEmail2(cell.getStringCellValue());
                    	}
                    }
                    
                    if(name.equals("Mobile Number")) {
                    	if(cell.getCellType()!=CellType.NUMERIC)
                    	{
                    		flag=1;
                    	}
                    	else {
                    		p.setMobileNumber((long) cell.getNumericCellValue());
                    	}
                    }
                    
                    if(name.equals("Add Info 1")) {
                    	if(cell.getCellType()!=CellType.STRING || cell==null)
                    	{
                    		flag=1;
                    	}
                    	else {
                    		p.setAddInfo1(cell.getStringCellValue());
                    	}
                    }
                    
                    if(name.equals("Add Info 2")) {
                    	if(cell.getCellType()!=CellType.STRING || cell==null)
                    	{
                    		flag=1;
                    	}
                    	else {
                    		p.setAddInfo2(cell.getStringCellValue());
                    	}
                    }
                    
                    if(name.equals("Add Info 3")) {
                    	if(cell.getCellType()!=CellType.STRING || cell==null)
                    	{
                    		flag=1;
                    	}
                    	else {
                    		p.setAddInfo3(cell.getStringCellValue());
                    	}
                    }
                    
                    if(name.equals("Add Info 4")) {
                    	if(cell.getCellType()!=CellType.STRING || cell==null)
                    	{
                    		flag=1;
                    	}
                    	else {
                    		p.setAddInfo4(cell.getStringCellValue());
                    	}
                    }
                    
                    if(name.equals("Add Info 5")) {
                    	if(cell.getCellType()!=CellType.STRING || cell==null)
                    	{
                    		flag=1;
                    	}
                    	else {
                    		p.setAddInfo5(cell.getStringCellValue());
                    	}
                    }
                    
                    if(name.equals("Add Info 6")) {
                    	if(cell.getCellType()!=CellType.STRING || cell==null)
                    	{
                    		flag=1;
                    	}
                    	else {
                    		p.setAddInfo6(cell.getStringCellValue());
                    	}
                    }
                    
                    i++;
                    

                }
                if(flag==1)
                {
                	errorFields.add(p);
                }
                else {
                	savedFields.add(p);
                }
                
                
            }
   		}
   		else {
   			System.out.println("Fields are not matching.");
   		}
   			
            


        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Map<String, List<PaymentDetails>> resultMap = new HashMap<>();
        resultMap.put("savedFields", savedFields);
        resultMap.put("errorFields", errorFields);
        return resultMap;

    }


}
