package Selenium_JUnit;


import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class C52_WriteExcel {
/*

    //Create an object of FileInputStream class to read excel file.
    //Creating workbook instance that refers to .xlsx file.
    //Creating a Sheet object.
    //Get all rows in the sheet.
    //Create a row object to retrieve row at index 3.
    //Create a cell object to enter value in it using cell Index.
    //Write the data in excel using output stream.
*/
    @Test
    public void writeExcel() throws IOException {
        //Create an object of FileInputStream class to read excel file.
        String path1 =System.getProperty("user.dir")+ "\\src\\test\\resources\\excelData.xlsx";

        // Open the workbook using file input stream.
        FileInputStream fis = new FileInputStream(path1);  // bu dosyayi akisa aldim (akisa aldiktan sonra bir objeye cevirdik)
        Workbook wb = WorkbookFactory.create(fis);  // javanin icine hayali bir exel dosyaya aktardik

        //Creating a Sheet object.
        Sheet credentials =wb.createSheet("credentials"); // olusturulacak sayfa yazildi ve bir obje ye aktarildi

        Row row3 = credentials.createRow(2); //satiri ürettik

        Cell r3c7 = row3.createCell(6);  // 6. hücreyi elle olusturduk
    //__________________________________________________________________
        r3c7.setCellValue("NAME");  // NAME i manuel yazdirdik
    //__________________________________________________________________
        for (int i = 7; i < 12; i++) {  // birden cok veriyi yazdirdik
            String girilecekData="";
            switch (i) {
                case 7 : girilecekData="SURNAME"; break;
                case 8 : girilecekData="EMAIL"; break;
                case 9 : girilecekData="PASSWORD"; break;
                case 10 : girilecekData="GENDER"; break;
                case 11 : girilecekData="BIRTHDAY"; break;
            }
            row3.createCell(i).setCellValue(girilecekData);
        }
  //__________________________________________________________________
        Row row5 = credentials.createRow(4);  //2. yol-- cok veri olursa bu sekilde aktarabiliriz
        List<String> list = new ArrayList<>(Arrays.asList("ad","soyad","Kimlik No","Yas"));
        for (int i = 7; i < 11; i++) {
            row5.createCell(i).setCellValue(list.get(i-7));
        }
        FileOutputStream fos = new FileOutputStream(path1);
        wb.write(fos);
        fis.close();
        fos.close();


    }

}

