package com.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelDataReader extends DriverTestCase{



    public static Object[][] getDataFromExcel(String excel_location) throws IOException {

        FileInputStream fis = new FileInputStream(excel_location);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int sheets = workbook.getNumberOfSheets();

                XSSFSheet sheet = workbook.getSheetAt(0);
                Object [][] data = new Object[sheet.getPhysicalNumberOfRows()-1][sheet.getRow(0).getLastCellNum()];
                Iterator<Row> rows = sheet.iterator();
                Row firstrow = rows.next();
                Iterator<Cell> ce = firstrow.cellIterator();

                 int line = 0;

                while (rows.hasNext()) {
                    Row r = rows.next();

                    Iterator<Cell> cv = r.cellIterator();
                    int col = 0 ;
                    while (cv.hasNext()) {
                        Cell c = cv.next();
                        //if(cv.next().getCellType()==CellType.STRING );
                        if (c.getCellType() == CellType.STRING) {
                            data[line][col] = (c.getStringCellValue());

                            col++;
                        }
                       else{
                        data[line][col] = NumberToTextConverter.toText(c.getNumericCellValue());
                        col++;
                       }
                    }
                     line++;

                }




        return  data;

    }

    public String toString(){
        return " Name ist    "   ;
    }


    public static  Object[][] writeElement() throws IOException {


        FileInputStream fis = new FileInputStream("/Users/oussamabenmahmoud/excel_automation/data_source.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int sheets = workbook.getNumberOfSheets();


        XSSFSheet sheet = workbook.getSheetAt(0);
        Object [][] data = new Object[sheet.getPhysicalNumberOfRows()-1][sheet.getRow(0).getLastCellNum()];

        int rowCount = sheet.getPhysicalNumberOfRows()-1;
        int line =0 ;


         for (int i = 0 ;i<rowCount;i++){
             XSSFRow row = sheet.getRow(i);
             int cellCount = row.getPhysicalNumberOfCells();
             int col = 0 ;
             for( int j = 0; j< cellCount;j++){
                 XSSFCell cell = row.getCell(j);
                 if (cell.getCellType() == CellType.STRING) {
                     data[line][col] = (cell.getStringCellValue());

                     col++;
                 }
                 else{
                     data[line][col] = NumberToTextConverter.toText(cell.getNumericCellValue());
                     col++;
                 }

             }
             line++;
         }
         return  data ;
    }


    public  void  main (String[]args) throws IOException {
        System.out.println(" erster mit Iterator ");
       String excel_lo = propertyReader.readApplicationFile("Excel_location");
        Object[][]af = new  Object[4][4];
        af = getDataFromExcel(excel_lo) ;
             for (int i = 0; i< getDataFromExcel(excel_lo).length; i++){
                 for( int j=0 ;j<19;j++){
                        System.out.print(af[i][j]);
                 }
                 System.out.println("   ");
             }

               Object[][] zw = new  Object[19][19] ;
                zw =  writeElement() ;
     for (int i=0 ;i< writeElement().length;i++){
         for( int j=0 ;j<19;j++){
             System.out.print(af[i][j]);
         }
         System.out.println("   ");
     }


 }


}
