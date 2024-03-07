package A_Mentoring;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import utils.TestBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class createSheet_createRow_createCell extends TestBase {
    @Test
    public void readExcel2() throws IOException {
        // Add the excel file on the resources folder.
        // Open the file.
        String path1 = System.getProperty("user.dir") + "\\src\\test\\resources\\Muhtesem e-tablo.xlsx";

        // Open the workbook using file input stream.
        FileInputStream fis = new FileInputStream(path1);
        Workbook wb = WorkbookFactory.create(fis);

        Sheet sheet2 = wb.createSheet("Sayfa3"); // Sayfa4 ü creat ettik
        Row row2 = sheet2.createRow(1); // bir satir creat ettik

        Cell cell = row2.createCell(7);
        cell.setCellValue("xxxxxx");

        row2.createCell(0).setCellValue("Ercan"); // creat edilen satirin 1. hücresine
        row2.createCell(1).setCellValue("Zafer"); // creat edilen satirin 1. hücresine
        row2.createCell(2).setCellValue("Mahmut");
        row2.createCell(3).setCellValue("Ali");

        FileOutputStream fos1 = new FileOutputStream(path1);
        wb.write(fos1);
        fis.close();
        fos1.close();

        driver.quit();


    }
    @Test
    public void readExcel3() throws IOException {
        // Add the excel file on the resources folder.
        // Open the file.
        String path1 = System.getProperty("user.dir") + "\\src\\test\\resources\\Muhtesem e-tablo.xlsx";

        // Open the workbook using file input stream.
        FileInputStream fis = new FileInputStream(path1);
        Workbook wb = WorkbookFactory.create(fis);

        Sheet sheet2 = wb.createSheet("Sayfa2");

        Row row1 = sheet2.createRow(1);  //2. yol-- cok veri olursa bu sekilde aktarabiliriz

        List<String> list = new ArrayList<>(Arrays.asList("ad","soyad","Kimlik No","Yas"));
        for (int i = 1; i <= list.size(); i++) {
            row1.createCell(i).setCellValue(list.get(i-1));
        }
        FileOutputStream fos = new FileOutputStream(path1);
        wb.write(fos);
        fis.close();
        fos.close();

       driver.quit();

    }
    @Test
    public void test1() throws IOException {
        String path1 = System.getProperty("user.dir")+"\\src\\test\\resources\\Muhtesem.xlsx";

        // Open the workbook using file input stream.
        FileInputStream fis = new FileInputStream(path1); // ankaradan trene bindiriyoruz
        Workbook wb = WorkbookFactory.create(fis); // istanbul da workbook ile indiriyoruz
        // Open the first worksheet. calisma sayfasinin ya ismini ya da indexini vermemiz gerekiyor.
        Sheet sheet1 = wb.createSheet("Sayfa7");
        List<String> basliklar= new ArrayList<>(Arrays.asList("isim","soyisim","ID"));
        Row row1 = sheet1.createRow(0);
        Row row2 = sheet1.createRow(1);
        for (int j = 0; j < 3 ; j++) {
            row1.createCell(j).setCellValue(basliklar.get(j));
        }

        List<String> isimler= new ArrayList<>(Arrays.asList("ahmet","ali","365"));

        for (int j = 0; j < 3 ; j++) {
            row2.createCell(j).setCellValue(isimler.get(j));
        }


        FileOutputStream fos = new FileOutputStream(path1);
        wb.write(fos);
        fis.close();
        fos.close();
    }
}
