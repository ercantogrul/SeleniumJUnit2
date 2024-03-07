package A_Mentoring;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.io.IOException;
import java.util.List;

public class tables extends TestBase {
    //Goto: "https://www.bundesliga.com/en/bundesliga/table"
    //Locate WebTable
    //How many rows
    //Print all rows
    //Get Screen Shoot include "Bayer"
    @Test
    public void tables () throws IOException {
        //Go to URL: https://www.bundesliga.com/en/bundesliga/table
        driver.get("https://www.bundesliga.com/en/bundesliga/table");

        WebElement alleAkzepieren = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
        alleAkzepieren.click();

        //Locate WebTable
        WebElement webTable1 = driver.findElement(By.xpath("//table[@class='table']"));
       // System.out.println(webTable1.getText());

        //How many rows
        System.out.println("*****************//How many rows**************************");
        List<WebElement> tableRowList = driver.findElements(By.xpath("//table[@class='table']/tbody//tr"));//size 18
        List<WebElement> rows = webTable1.findElements(By.xpath(".//tbody//tr"));//size 18 burada driver yerine webTable1 alin di
        System.out.println("tableRowList.size() = " + tableRowList.size());

        // Tabela basligi icin
        System.out.println("*****************// Tabela basligi icin**************************");
        System.out.println(webTable1.findElement(By.xpath("./thead/tr")).getText());


        //Print all rows
        System.out.println("*********//Print all rows 1. YOL*****************");
//        for (int i = 0; i <tableRowList.size() ; i++) {
//            System.out.println(tableRowList.get(i).getText());
//        }
        System.out.println("*********//Print all rows 2. YOL*****************");
        for (WebElement row : rows) {
            String rowData = row.getText();
            System.out.println(rowData);

        }

        System.out.println("******************//Get Screen Shoot include \"Bayer\"************************************");
        //Get Screen Shoot include "Bayer"
        WebElement webTable = driver.findElement(By.xpath("(//img[@class='logo ng-star-inserted'])[1]"));
        getSpecificScreenShoot(webTable);


    }
    @Test
    public void test() throws InterruptedException {
        //Goto: "https://www.bundesliga.com/en/bundesliga/table"
        driver.get("https://www.bundesliga.com/en/bundesliga/table");
        WebElement acceptButton = driver.findElement(By.xpath("//*[.='Accept All Cookies']"));
        if (acceptButton.isDisplayed()) {
            acceptButton.click();
        }

        //Locate WebTable
        WebElement webTable1 = driver.findElement(By.tagName("table"));

        //How many rows
        List<WebElement> rows = webTable1.findElements(By.xpath(".//tbody/tr"));
        System.out.println("rows.size() = " + rows.size());


        // Tabela basligi icin
        System.out.println(webTable1.findElement(By.xpath("./thead/tr")).getText());

        //Print all rows
        for (WebElement row : rows) {
            String rowData = row.getText();
            System.out.println(rowData);
        }

        //Get Screen Shoot include "Bayern"
        WebElement bayern = driver.findElement(By.xpath("//span[normalize-space()='FC Bayern München']"));
        getSpecificScreenShoot(bayern);


    }
}
