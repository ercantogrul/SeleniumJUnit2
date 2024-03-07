package A_Mentoring;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import utils.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;


public class readExcel extends TestBase {
    //Muhtesem.xlsx dosyasındaki isimleri yazdırın
    //Muhtesem.xlsx Id'leri yazdırın
    //Yukardakaki isim ve Id leri bir Map'te toplayarak yazdırın

    @Test
    public void readExcel() throws IOException {

        String path = "C:\\Users\\etogr\\IdeaProjects\\Selenium2_JUnit\\src\\test\\resources\\Muhtesem e-tablo.xlsx";  // manualy

        FileInputStream fis = new FileInputStream(path);
        Workbook wb = WorkbookFactory.create(fis);

        // Open the first worksheet. (worksheet in isminden gidiyoruz ismi "Sayfa1", index "0")
        Sheet sheet1 = wb.getSheet("Sayfa1");  // worksheet e isimle ulastik

        for (int i = 0; i < sheet1.getLastRowNum(); i++) {
            String ad = sheet1.getRow(i).getCell(0).toString();
            System.out.println(ad + " ");
        }
        System.out.println("**************************************************");

        for (int i = 0; i < sheet1.getLastRowNum(); i++) {
            String soyad = sheet1.getRow(i).getCell(1).toString();
            System.out.println(soyad + " ");
        }
        System.out.println("**********************************************");

        Map<String, String> countryArea = new LinkedHashMap<>();
        for (int i = 0; i <= sheet1.getLastRowNum(); i++) {
            String ad = sheet1.getRow(i).getCell(0).toString();
            String yas = sheet1.getRow(i).getCell(2).toString();

            countryArea.put(ad, yas);  // for döndüsü ile aldigimiz her veriyi string olarak Map e aktardik
        }
       //     System.out.println(countryArea); // Map i yazdirdik
        countryArea.forEach((key, value) -> System.out.println("Ad: " + key + "  Yas: " + value));

    }

    @Test
    public void readExcel2() throws IOException {
        // Add the excel file on the resources folder.
        // Open the file.
        String path1 = System.getProperty("user.dir") + "\\src\\test\\resources\\Muhtesem e-tablo.xlsx";

        // Open the workbook using file input stream.
        FileInputStream fis = new FileInputStream(path1);
        Workbook wb = WorkbookFactory.create(fis);

        Sheet sheet1 = wb.getSheet("Sayfa1");

        Map<String, String> countryMap = new LinkedHashMap<String, String>();
        for (int i = 0; i <= sheet1.getLastRowNum(); i++) {
            String ad = sheet1.getRow(i).getCell(0).toString();
            String yas = sheet1.getRow(i).getCell(2).toString();
            countryMap.put(ad, yas);
        }
        countryMap.forEach((key, value) -> System.out.println("Ad: " + key + "  Yas: " + value));

    }
}