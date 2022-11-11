package org.training.io_operations;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class ReadAllDataFromExcelSheet {
    public static void main(String[] args) throws Exception {
        Workbook workbook = null;
        try {
            //Open excel
            workbook = new XSSFWorkbook(FileUtilsData.PROJECT_HOME + File.separator + "Details.xlsx");
            //select the sheet
            Sheet sheet = workbook.getSheet("test");
//           sheet.getLastRowNum();
            int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
            for(int i=0;i<physicalNumberOfRows;i++) {
                Row row = sheet.getRow(i);
                int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                for(int j=0;j<physicalNumberOfCells;j++) {
                    Cell cell = row.getCell(j);
                    CellType cellType = cell.getCellType();
                    switch (cellType) {
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + " ");
                            break;
                        case STRING:
                            System.out.print(cell.getStringCellValue() + " ");
                            break;
                        case BOOLEAN:
                            System.out.println(cell.getBooleanCellValue() + " ");
                            break;
                        case FORMULA:
                            System.out.println(cell.getCellFormula() + " ");
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            workbook.close();
        }

    }
}
