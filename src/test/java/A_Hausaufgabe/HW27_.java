package A_Hausaufgabe;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HW27_ extends TestBase {
    //Go to URL: https://opensource-demo.orangehrmlive.com/
//Login page valid credentials.
//Download sample CSV file. pim->configuration->importData CSV file dosya yolu budur.
//Verify if the file downloaded successfully.

    @Test
    public void test1() throws InterruptedException {

        //Go to URL: https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //__________________________
        WebElement admin = driver.findElement(By.xpath("//input[@name='username']"));
        admin.sendKeys("admin");

        WebElement passWord = driver.findElement(By.xpath("//input[@name='password']"));
        passWord.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginButton);

        //_______________________________
        WebElement pim = driver.findElement(By.xpath("//span[text()='PIM']"));
        js.executeScript("arguments[0].click();", pim);

        //_______________________________
        WebElement configuration = driver.findElement(By.xpath("//span[text()='Configuration ']"));
        js.executeScript("arguments[0].click();", configuration);

        //_______________________________
        WebElement dataImport = driver.findElement(By.xpath("//a[text()='Data Import']"));
        js.executeScript("arguments[0].click();", dataImport);
        Thread.sleep(3000);

        WebElement download = driver.findElement(By.xpath("//a[text()='Download']"));
        js.executeScript("arguments[0].click();", download);
        Thread.sleep(3000);


        String downloadPath = "C:\\Users\\etogr\\Downloads\\";
        String path = downloadPath + "importData.csv";
        System.out.println("download.getText() = " + download.getText());
        System.out.println("path = " + path);

        //Verify if the file downloaded successfully.
        assertTrue(Files.exists(Paths.get(path)));


    }
    @Test
    public void test3() throws InterruptedException {

        //Go to URL: https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //Login page valid credentials.
        WebElement admin = driver.findElement(By.xpath("//input[@name='username']"));
        actions.click(admin)
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("dmin")
                .perform();

        WebElement passWord = driver.findElement(By.xpath("//input[@name='password']"));
        actions.click(passWord)
                .sendKeys("admin123")
                .perform();

        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginBtn);

        //Download sample CSV file. pim->configuration->importData CSV file dosya yolu budur.
        WebElement pim = driver.findElement(By.xpath("//span[text()='PIM']"));
        js.executeScript("arguments[0].click();", pim);
        Thread.sleep(2000);

        WebElement configuration = driver.findElement(By.xpath("//span[text()='Configuration ']"));
        js.executeScript("arguments[0].click();", configuration);
        Thread.sleep(2000);

        WebElement dataImport = driver.findElement(By.xpath("//a[text()='Data Import']"));
        js.executeScript("arguments[0].click();", dataImport);
        Thread.sleep(2000);

        WebElement download = driver.findElement(By.xpath("//a[text()='Download']"));
        js.executeScript("arguments[0].click();", download);
        Thread.sleep(2000);

        String downloadPath = "C:\\Users\\nuray\\Downloads\\importData (1).csv";
        String path = "C:\\Users\\nuray\\Downloads\\";

        //Verify if the file downloaded successfully.
        assertTrue(Files.exists(Paths.get(path)));

    }



}
