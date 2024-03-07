package A_Hausaufgabe;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.io.IOException;
import java.util.List;

public class HW31_WebTables extends TestBase {

    //Go to URL: https://the-internet.herokuapp.com/tables
//Print the entire table
//Print All Rows
//Print Last row data only
//Print column 5 data in the table body
//Write a method that accepts 2 parameters
//parameter 1 = row number  parameter 2 = column number
//printData(3,4); => prints
//Write a method that accepts 3 parameters, parameter 3 = table id
//printData(3,4,"table1") => prints data in 3rd row 4th Column with table id

    @Test
    public void hw31_2 () throws IOException {
        //Go to URL: https://the-internet.herokuapp.com/tables
        driver.get("https://the-internet.herokuapp.com/tables");

        //Print the entire table
        System.out.println("*************//Print the entire tables*****************");
        WebElement webTable1 = driver.findElement(By.xpath("//*[@id=\"table1\"]"));
        System.out.println(webTable1.getText());

        //Print All Rows
        List<WebElement> tableTDList = driver.findElements(By.xpath("//table[@id='table1']//td")); //size 24
        List<WebElement> tableRowList = driver.findElements(By.xpath("//table[@id='table1']//tr"));//size 5
        List<WebElement> tableTHList = driver.findElements(By.xpath("//table[@id='table1']//th")); //size 6
        System.out.println(tableTDList.size());
        System.out.println(tableRowList.size());
        System.out.println(tableTHList.size());

        for (int i = 0; i <tableRowList.size() ; i++) {
            System.out.println(tableRowList.get(i).getText());
        }

        //Print Last row data only
        // System.out.println(tableRowList.get(tableRowList.size()-1).getText());
        System.out.println(tableRowList.getLast().getText());

        //Print column 5 data in the table body
        List<WebElement> column5 = driver.findElements(By.xpath("//table[@id='table1']//tr/td[5]"));
        System.out.println(driver.findElement(By.xpath("//table[@id='table1']//tr/th[5]")).getText());

        for (int i = 0; i <column5.size() ; i++) {
            System.out.println(column5.get(i).getText());
        }

        //printData(3,4); => prints
        getData2Parameters(3,4);

        //printData(3,4,"table1") => prints data in 3rd row 4th Column with table id
        System.out.println("getData3Parameters(3,4,\"table1\") = " + getData3Parameters(3, 4, "table1"));


        //printData(2,3,"table2") => prints data in 3rd row 4th Column with table id
        System.out.println("getData3Parameters(2,3,\"table2\") = " + getData3Parameters(2, 3, "table2"));



        driver.quit();
    }

    //Write a method that accepts 2 parameters
    //parameter 1 = row number  parameter 2 = column number
    public String getData2Parameters (int rowNum, int columnNum){
        return driver.findElement(By.xpath("//table[@id='table1']//tr["+rowNum+"]/td["+columnNum+"]")).getText();
    }
    //Write a method that accepts 3 parameters, parameter 3 = table id
    public String getData3Parameters (int rowNum, int columnNum, String tableId){
        return driver.findElement(By.xpath("//table[@id='"+tableId+"']//tr["+rowNum+"]/td["+columnNum+"]")).getText();
    }


    @Test
    public void hw31 () throws IOException {
//Go to URL: https://the-internet.herokuapp.com/tables
        driver.get("https://the-internet.herokuapp.com/tables");

  //Print the entire table
        System.out.println("*************//Print the entire tables*****************");
        WebElement webTable1 = driver.findElement(By.xpath("//*[@id=\"table1\"]"));
        System.out.println(webTable1.getText());

        System.out.println("*************//Print the entire tables 2. yol*****************");
        int satirNum = webTable1.findElements(By.xpath("./tbody/tr")).size(); // satir sayisi
        System.out.println("satirNum = " + satirNum);
        int sutunNum = webTable1.findElements(By.xpath(".//tr[3]//td")).size(); // sutun sayisi
        System.out.println("sutunNum = " + sutunNum);

        System.out.println(webTable1.findElement(By.xpath("./thead/tr")).getText()); //tablonun header yazdik
        for (int i = 1; i <=satirNum ; i++) {
            for (int j = 1; j <=sutunNum; j++) {
                String tdata = webTable1.findElement(By.xpath(".//tr["+i+"]/td["+j+"]")).getText();
                System.out.print(tdata+"  ");
            }
            System.out.println();

        }

        System.out.println("*************//Print All Rows*****************");
        //Print All Rows
        for (int i = 1; i <=satirNum ; i++) {
            String tdata = webTable1.findElement(By.xpath(".//tr["+i+"]")).getText();
            System.out.println(tdata+"  ");
        }

        System.out.println("*************//Print Last row data only*****************");
        //Print Last row data only
        String tdata = webTable1.findElement(By.xpath(".//tr["+(satirNum-1)+"]")).getText();
        System.out.println(tdata+"  ");

        System.out.println("*************//Print column 5 data in the table body*****************");
        //Print column 5 data in the table body
        for (int i = 1; i <=satirNum ; i++) {
            for (int j = 5; j <=5; j++) {
                String tdata1 = webTable1.findElement(By.xpath(".//tr["+i+"]/td["+5+"]")).getText();
                System.out.println(tdata1+"  ");
            }
        }

        System.out.println("*************//Write a method that accepts 2 parameters*****************");
        //Write a method that accepts 2 parameters
        methode(satirNum,sutunNum);


        //parameter 1 = row number  parameter 2 = column number
        System.out.println("*************//parameter 1 = row number  parameter 2 = column number*****************");
        methode(1,2);

        //printData(3,4); => prints
        System.out.println("*************//printData(3,4); => prints*****************");
        methode(3,4);

        //Write a method that accepts 3 parameters, parameter 3 = table id
        System.out.println("*************//Write a method that accepts 3 parameters, parameter 3 = table id*****************");

        WebElement table1= webTable1.findElement(By.xpath("//h4[.='Example 1']")); // satir sayisi
        methodeDreiParametres(satirNum,sutunNum,table1);

        //printData(3,4,"table1") => prints data in 3rd row 4th Column with table id
        System.out.println("*************//printData(3,4,\"table1\") => prints data in 3rd row 4th Column with table id*****************");
        methodeDreiParametres(3,4,table1);



        driver.quit();


    }

    private void methodeDreiParametres(int satirNum, int sutunNum, WebElement table1) {
        WebElement webTable1 = driver.findElement(By.xpath("//*[@id=\"table1\"]"));
        for (int i = satirNum; i <=satirNum ; i++) {
            for (int j = sutunNum; j <=sutunNum; j++) {
                String tdata1 = webTable1.findElement(By.xpath(".//tr["+i+"]/td["+j+"]")).getText();
                System.out.print(tdata1+"  ");
            }
        }
        System.out.println(table1.getText());
    }

    private void methode(int satirNum, int sutunNum) {
        WebElement webTable1 = driver.findElement(By.xpath("//*[@id=\"table1\"]"));
        for (int i = satirNum; i <=satirNum ; i++) {
            for (int j = sutunNum; j <=sutunNum; j++) {
                String tdata1 = webTable1.findElement(By.xpath(".//tr["+i+"]/td["+j+"]")).getText();
                System.out.println(tdata1+"  ");
            }
        }

    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/tables");

        //Print the entire table
        WebElement webTable1 = driver.findElement(By.xpath("//table[@id='table1']"));
        List<WebElement> rows = webTable1.findElements(By.xpath(".//tbody/tr"));

        System.out.println(webTable1.findElement(By.xpath("./thead/tr")).getText());// baslik icin

        for (WebElement row : rows) {
            String rowData = row.getText();
            System.out.println(rowData);
        }

        //Print Last row data only
        System.out.println();
        System.out.println("Last Row = " + rows.getLast().getText());

        //Print column 5 data in the table body
        System.out.println();
        List<WebElement> columns = webTable1.findElements(By.xpath("./tbody//td[4]"));
        for (WebElement element : columns) {
            String col5 = element.getText();
            System.out.println(col5);
        }

        //printData(3,4); => prints
        System.out.println();
        String r3c4 = rows.get(3).findElement(By.xpath("./td[5]")).getText();
        System.out.println("r3c4 = " + r3c4);


        //Write a method that accepts 3 parameters, parameter 3 = table id
        //printData(3,4,"table1") => prints data in 3rd row 4th Column with table id

        printData(2,4,"table1");//Row u listeden aldigimiz icin 2 yazdik. Index 0 dan basliyor

    }
    private void printData(int r, int c, String table) {
        System.out.println("********************************************");
        WebElement webTable = driver.findElement(By.xpath("//table[@id='"+table+"']"));
        List<WebElement> rows = webTable.findElements(By.xpath(".//tbody/tr"));
        String cell = rows.get(r).findElement(By.xpath("./td["+c+"]")).getText();
        System.out.println("cell = " + cell);
    }
}




