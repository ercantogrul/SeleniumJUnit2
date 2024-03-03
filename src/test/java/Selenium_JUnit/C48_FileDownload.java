package Selenium_JUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

        String path1 = indirilenlerPath+seleniunSnapshot.getText();  //
        assertTrue(Files.exists(Paths.get(path1))); //bu dosya var mi

        //2. yol
        String path = System.getProperty("user.home")+System.getProperty("file.separator")+"Downloads" +
                System.getProperty("file.separator")+"selenium-snapshot.png";
        assertTrue(Files.exists(Paths.get(path))); //bu dosya var mi

    }
   @Test//Bütün linklerin çalıştığını test et.
    public void testAll() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");  //list e atip for döngüsü icerisinde tek tek idi mi diye kontrol ediledcek

    }
    @Test//Bütün linklerin çalıştığını test et.
    public void testAll2() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");

    }
}














