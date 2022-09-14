package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtils {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    public ExcelUtils(String excelPath, String sheetName){
        try{
            File file = new File(excelPath);
            FileInputStream fIP = new FileInputStream(file);
            //Get the workbook instance for XLSX file
            workbook = new XSSFWorkbook(fIP);
            sheet = workbook.getSheet(sheetName);
        }catch (Exception exp){
            System.out.println(exp.getCause());
            System.out.println(exp.getMessage());
            System.out.println(exp.getStackTrace());
        }
    }
    public Object getCellData(int rowNo,int colNo){
        DataFormatter formatter = new DataFormatter();
        Object value = formatter.formatCellValue(sheet.getRow(rowNo).getCell(colNo));
        return value;
    }
    public int getRowCount(){
        int rowCount = sheet.getPhysicalNumberOfRows();
        return rowCount;
    }
    public int getColumnCount(){
        int colCount = sheet.getDefaultColumnWidth();
        return colCount;
    }

}
