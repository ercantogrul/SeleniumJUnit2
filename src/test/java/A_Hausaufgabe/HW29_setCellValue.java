package A_Hausaufgabe;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;
import utils.TestBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class HW29_setCellValue extends TestBase {
    //Store the path of the file as string and open the file.
//Open the workbook.
//Open the first worksheet.
//Go to the first row.
//Create a cell on the 3rd column (2nd index) on the first row.
//Write "POPULATION" on that cell.
//Create a cell on the 2nd row 3rd cell(index2), and write data.
//Create a cell on the 3rd row 3rd cell(index2), and write data.
//Create a cell on the 4th row 3rd cell(index2), and write data.
//Write and save the workbook.
//Close the file.
//Close the workbook

    @Test
    public void writeExcel() throws IOException {
        //Store the path of the file as string and open the file.
        String path = System.getProperty("user.dir") + "\\src\\test\\resources\\excelfile.xlsx";

        //Open the workbook.
        FileInputStream fis = new FileInputStream(path);
        Workbook wb = WorkbookFactory.create(fis);

        //Open the first worksheet.
        Sheet sheet1 = wb.getSheetAt(0);

        //Go to the first row.
        Row row1 = sheet1.createRow(0);
        //Create a cell on the 3rd column (2nd index) on the first row.
        //Write "POPULATION" on that cell.
        row1.createCell(1).setCellValue("POPULATION");

        //Create a cell on the 2nd row 3rd cell(index2), and write data.
        Row row2 = sheet1.createRow(1);
        row2.createCell(1).setCellValue("16000000");

        //Create a cell on the 3rd row 3rd cell(index2), and write data.
        Row row3 = sheet1.createRow(2);
        row3.createCell(1).setCellValue("9500000");

        //Create a cell on the 4th row 3rd cell(index2), and write data.
        Row row4 = sheet1.createRow(3);
        row4.createCell(1).setCellValue("9000000");

        FileOutputStream fos = new FileOutputStream(path);
        wb.write(fos);
        fis.close();
        fos.close();
    }

    @Test
    public void writeExcel2() throws IOException {
        //Create an object of File class to open xlsx file.
        String path1 = System.getProperty("user.dir") + "\\src\\test\\resources\\HomeWork.xlsx";// burada yolu yaziyoruz

        //Create an object of FileInputStream class to read excel file.
        FileInputStream fis = new FileInputStream(path1);

        //Creating workbook instance that refers to .xlsx file.
        Workbook wb = WorkbookFactory.create(fis);

        //Creating a Sheet object.
        Sheet sayfa = wb.getSheet("Sayfa1");

        //Get all rows in the sheet.
        for (int i = 0; i <= sayfa.getLastRowNum(); i++) {
            System.out.println("Row = " + sayfa.getRow(i).toString());
        }

        //Create a row object to retrieve row at index 7.
        Row r7 = sayfa.createRow(7);

        //Create a cell object to enter value in it using cell Index.
        r7.createCell(10).setCellValue("Rasit");

        //Write the data in excel using output stream.
        FileOutputStream fos = new FileOutputStream(path1);
        wb.write(fos);

        fis.close();
        fos.close();
    }
}
