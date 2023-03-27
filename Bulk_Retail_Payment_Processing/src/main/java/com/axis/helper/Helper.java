package com.axis.helper;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.axis.model.PaymentTemplate;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Helper {


    //check that file is of excel type or not
    public static boolean checkExcelFormat(MultipartFile file) {

        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }

    }


    //convert excel to list of products

    public static List<PaymentTemplate> convertExcelToListOfProduct(InputStream is) {
        List<PaymentTemplate> list = new ArrayList<>();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);

            //XSSFSheet sheet = workbook.getSheet("Sheet1");
            XSSFSheet worksheet = workbook.getSheetAt(0);

            int rowNumber = 0;
            Iterator<Row> iterator = worksheet.iterator();

            while (iterator.hasNext()) {
                Row row = iterator.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();

                int cid = 0;

                PaymentTemplate p = new PaymentTemplate();

                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cid) {
                        case 0:
                        	p.setDebitAccountNumber((long) cell.getNumericCellValue());
                            break;
                        case 1:
                            p.setTransactionAmount((double) cell.getNumericCellValue());
                            break;
                        case 2:
                            p.setTransactionCurrency(cell.getStringCellValue());
                            break;
                        case 3:
                            p.setBeneficiaryName(cell.getStringCellValue());
                            break;
                        case 4:
                            p.setBeneficiaryAccountNumber((long) cell.getNumericCellValue());
                            break;
                        case 5:
                            p.setIFSCCode(cell.getStringCellValue());
                            break;
                        case 6:
                            p.setTransactionDate(cell.getStringCellValue());
                            break;
                        case 7:
                            p.setPaymentMode(cell.getStringCellValue());
                            break;
                        case 8:
                            p.setCustomerReferenceNumber((long) cell.getNumericCellValue());
                            break;
                        case 9:
                            p.setBeneficiaryCode((long) cell.getNumericCellValue());
                            break;
                        case 10:
                            p.setAccountType(cell.getStringCellValue());
                            break;
                        case 11:
                            p.setBeneficiaryType(cell.getStringCellValue());
                            break;
                        case 12:
                            p.setLei(cell.getStringCellValue());
                            break;
                        case 13:
                            p.setDebitNarration(cell.getStringCellValue());
                            break;
                        case 14:
                            p.setCreditNarration(cell.getStringCellValue());
                            break;
                        case 15:
                            p.setInvoiceNumber((long) cell.getNumericCellValue());
                            break;
                        case 16:
                            p.setBeneficiaryAddress1(cell.getStringCellValue());
                            break;
                        case 17:
                            p.setBeneficiaryAddress2(cell.getStringCellValue());
                            break;
                        case 18:
                            p.setBeneficiaryAddress3(cell.getStringCellValue());
                            break;
                        case 19:
                            p.setBeneficiaryCity(cell.getStringCellValue());
                            break;
                        case 20:
                            p.setBeneficiaryState(cell.getStringCellValue());
                            break;
                        case 21:
                            p.setBeneficiaryPinCode((int)cell.getNumericCellValue());
                            break;
                        case 22:
                            p.setBeneficiaryEmail1(cell.getStringCellValue());
                            break;
                        case 23:
                            p.setBeneficiaryEmail2(cell.getStringCellValue());
                            break;    
                        case 24:
                            p.setMobileNumber((long) cell.getNumericCellValue());
                            break;
                        case 25:
                            p.setAddInfo1(cell.getStringCellValue());
                            break;
                        case 26:
                            p.setAddInfo2(cell.getStringCellValue());
                            break;
                        case 27:
                            p.setAddInfo3(cell.getStringCellValue());
                            break;
                        case 28:
                            p.setAddInfo4(cell.getStringCellValue());
                            break;
                        case 29:
                            p.setAddInfo5(cell.getStringCellValue());
                            break;
                        case 30:
                            p.setAddInfo6(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    cid++;

                }

                list.add(p);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }


}
