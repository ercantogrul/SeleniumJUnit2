package Selenium_JUnit;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C51_ApachePoiGetData {
    String sheetName="";
    int sheetIndex;
    int rowIndex;
    int cellIndex;

    public static Object getDataStringSheet (String sheetName, int rowIndex, int cellIndex) throws IOException {

        String istenenData = "";
        String path1 =System.getProperty("user.dir")+ "\\src\\test\\resources\\excelfile.xlsx";

        FileInputStream fis = new FileInputStream(path1);  // bu dosyayi akisa aldim
        Workbook wb = WorkbookFactory.create(fis);  // javanin icine hayali bir exel dosyaya aktardik

        istenenData =wb.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex).toString();

        return istenenData;
    }

    public static Object getDataIntSheet (int sheetIndex, int rowIndex, int cellIndex) throws IOException {

        String istenenData = "";
        String path1 =System.getProperty("user.dir")+ "\\src\\test\\resources\\excelfile.xlsx";

        FileInputStream fis = new FileInputStream(path1);  // bu dosyayi akisa aldim
        Workbook wb = WorkbookFactory.create(fis);  // javanin icine hayali bir exel dosyaya aktardik

        istenenData =wb.getSheetAt(sheetIndex).getRow(rowIndex).getCell(cellIndex).toString();

        return istenenData;
    }


}

