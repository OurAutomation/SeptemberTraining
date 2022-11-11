package org.training.io_operations;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class ReadDataFromExcelFile {
    public static void main(String[] args) throws Exception {

        Workbook workbook = null;
        try {
            //Open excel
            workbook = new XSSFWorkbook(FileUtilsData.PROJECT_HOME + File.separator + "Details.xlsx");
            //select the sheet
            Sheet sheet = workbook.getSheet("Sheet1");
            //select the row
            Row row = sheet.getRow(2);
            //select the column
            Cell cell = row.getCell(1);
            CellType cellType = cell.getCellType();
            switch (cellType) {
                case NUMERIC:
                    System.out.println(cell.getNumericCellValue());
                    break;
                case STRING:
                    System.out.println(cell.getStringCellValue());
                    break;
                case BOOLEAN:
                    System.out.println(cell.getBooleanCellValue());
                    break;
                case FORMULA:
                    System.out.println(cell.getCellFormula());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            workbook.close();
        }

    }
}
