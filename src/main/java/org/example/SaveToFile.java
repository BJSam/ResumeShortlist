package org.example;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class SaveToFile {
    public boolean excel(String filePath, Map<String,Double> DataToSave){
        boolean successs = false;
        try {
            String filename = filePath+"results"+".xls" ;
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet(new SimpleDateFormat("yyyy_MM_dd-hh_mm_ss").format(new Date()));

            HSSFRow rowHead = sheet.createRow((short)0);
            rowHead.createCell(0).setCellValue("Resume");
            rowHead.createCell(1).setCellValue("Match percentage");
            short rowIndex = 1;
            for (Map.Entry<String, Double> entry : DataToSave.entrySet()) {
                System.out.println(entry.getKey() + "/" + entry.getValue());
                HSSFRow row = sheet.createRow(rowIndex);
                row.createCell(0).setCellValue(entry.getKey());
                row.createCell(1).setCellValue(entry.getValue());
                rowIndex++;
            }
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("results are saved to "+filename);
            successs = true;
        } catch ( Exception ex ) {
            System.out.println(ex.getMessage());
        }
        return successs;
    }
}
