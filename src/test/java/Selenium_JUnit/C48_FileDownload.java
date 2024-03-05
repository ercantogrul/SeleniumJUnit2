package Selenium_JUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C48_FileDownload extends TestBase {
    //    Go to URL: https://the-internet.herokuapp.com/download
    //    Download selenium-snapshot.png
    //    Verify if the file downloaded successfully.
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement seleniunSnapshot = driver.findElement(By.xpath("//a[.='selenium-snapshot.png']"));
        seleniunSnapshot.click();
        Thread.sleep(5000);

        // indilirlen dosyalaindan birinin path ini aldik
        //// /Users/josephhunter/Downloads/sample.txt
        // son eleman  haric önceki uzantisi bir stringe attik (indirilenlerPath)

        //1.yol
        String indirilenlerPath = "C:\\Users\\etogr\\Downloads\\";

        String path1 = indirilenlerPath + seleniunSnapshot.getText();  //
        assertTrue(Files.exists(Paths.get(path1))); //bu dosya var mi

        //2. yol
        String path = System.getProperty("user.home") + System.getProperty("file.separator") + "Downloads" +
                System.getProperty("file.separator") + "selenium-snapshot.png";
        assertTrue(Files.exists(Paths.get(path))); //bu dosya var mi

    }
   @Test//Bütün linklerin çalıştığını test et.
    public void testAll() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");

       List<WebElement> list = driver.findElements(By.tagName("a"));
       System.out.println("list.size() = " + list.size());

       for (int i = 1; i <list.size() ; i++) {
           WebElement element = list.get(i);

           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
           wait.until(ExpectedConditions.elementToBeClickable(element));

           JavascriptExecutor jsexecutor = ((JavascriptExecutor) driver);
           jsexecutor.executeScript("arguments[0].click();", element);
           if(i==3){
               wait.until(ExpectedConditions.alertIsPresent());
               driver.switchTo().alert().accept();
           }

           String indirilenlerPath = "C:\\Users\\etogr\\Downloads\\";
           String path = indirilenlerPath + element.getText();
           System.out.println(i+ " . eleman");
           Thread.sleep(6000);


           assertTrue(Files.exists(Paths.get(path))); //bu dosya var mi

       }
       driver.quit();


    }
    @Test//Bütün linklerin çalıştığını test et.
    public void testAll2() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");

    }

    @Test
    public void test2() throws InterruptedException {  // Yusuf Hoca cözümü
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement seleniumSnapshot = driver.findElement(By.xpath("//a[.='selenium-snapshot.png']"));
        seleniumSnapshot.click();
        Thread.sleep(5000);

        String path2 = System.getProperty("user.home")+System.getProperty("file.separator")+"Downloads" +
                System.getProperty("file.separator")+"selenium-snapshot.png";

        String indirilenlerPath = "/Users/josephhunter/Downloads/";
        String path = indirilenlerPath + seleniumSnapshot.getText();
        System.out.println(path);

        assertTrue(Files.exists(Paths.get(path)));

    }
    @Test//Bütün linklerin çalıştığını test et.
    public void testAll3() throws InterruptedException {  // Yusuf Hoca cözümü
        driver.get("https://the-internet.herokuapp.com/download");

        List<WebElement> downloadList = driver.findElements(By.tagName("a"));

        for(int i=1; i<downloadList.size()-1; i++) {
            System.out.println(downloadList.get(i).getText());
            if(!downloadList.get(i).getText().toLowerCase().contains("5mb")) {
                downloadList.get(i).click();
                Thread.sleep(5000);
                assertTrue(Files.exists(Paths.get(System.getProperty("user.home") + System.getProperty("file.separator") + "Downloads" +
                        System.getProperty("file.separator") + downloadList.get(i).getText())));
            }
        }
    }
    @Test//Bütün linklerin çalıştığını test et.
    public void testAll4() throws InterruptedException {  // Yusuf Hoca cözümü
        driver.get("https://the-internet.herokuapp.com/download");
        List<WebElement> downloadList = driver.findElements(By.tagName("a"));

        for(int i=1; i<downloadList.size()-1; i++) {
            System.out.println(downloadList.get(i).getText());
            if(!downloadList.get(i).getText().toLowerCase().contains("5mb")) {
                downloadList.get(i).click();
                Thread.sleep(5000);
                assertTrue(Files.exists(Paths.get("/Users/josephhunter/Downloads/" + downloadList.get(i).getText())));
            }
        }
    }
}














