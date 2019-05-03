package com.learnautomation.utility;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelDataProvider {

    XSSFWorkbook mWorkbook;
    public ExcelDataProvider() {
        File scr = new File("TestData/Data.xlsx");
        FileInputStream mFileInputStream = null;
        try {
            mFileInputStream = new FileInputStream(scr);
            mWorkbook = new XSSFWorkbook(mFileInputStream);

        } catch (Exception  e) {
            System.out.println("Unable to read Excel File >>" + e.getMessage());
        }
    }

    public String getStringData(String sheetName, int row, int column){
        return mWorkbook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }

    public String getStringData(int sheetIndex, int row, int column){
        return mWorkbook.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
    }

    public double getNumericData(String sheetName, int row, int column){
        return mWorkbook.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
    }

    public int getRowNumbers(String sheetName){
        return mWorkbook.getSheet(sheetName).getPhysicalNumberOfRows();
    }
}
