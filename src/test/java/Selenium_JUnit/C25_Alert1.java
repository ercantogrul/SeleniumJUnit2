package Selenium_JUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C25_Alert1 {
    /*
    js tabanlidir
Alerts : Web sitelerinde iki tur alert vardir.
    1.HTML alerts : sag click yapip incelenebilir, dolayisla diger web elementler gibidir
    2.JS alerts: bunlar sag click yapilip incelenemez, dolayisiyla da diger WebElementler’den farklidir.
     Interview sorusu
        - Alertleri nasıl kullanırsın (handle edersin)
          driver.switchTo().alert()   bununla kullanılır.
          komutları:
          accept -> OK, TAMAM yani olumlu butona basmak
          dismiss -> CANCEL, HAYIR yani olumsuz butona basmak
          getText -> Alertin mesaj alınır.
          SendKeys -> Alertin inputuna mesaj göndermek için kullanılır.
 */
    /*
    Go to URL: http://demo.guru99.com/test/delete_customer.php
    Delete customer ID: 123
    Remove 2 alerts that appear.
     */

    static WebDriver driver;

    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
//        driver.get("http://demo.guru99.com/test/delete_customer.php");
//        Thread.sleep(3000);
//        driver.switchTo().frame("gdpr-consent-notice");
//        WebElement acceptAll = driver.findElement(By.id("save"));
//        if (acceptAll.isDisplayed()){
//            acceptAll.click();
//        }
//        driver.switchTo().defaultContent();
//        WebElement deleteBox = driver.findElement(By.name("cusid"));
//        deleteBox.sendKeys("123", Keys.ENTER);

        //Go to URL: http://demo.guru99.com/test/delete_customer.php
        driver.get("http://demo.guru99.com/test/delete_customer.php");

        //Delete customer ID: 123
        WebElement deleteBox = driver.findElement(By.name("cusid"));
        deleteBox.sendKeys("123"+Keys.ENTER);
        Thread.sleep(2000);
        //========================================

        //1. alert i handle ediyoruz
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        //2. alert i handle ediyoruz
        Thread.sleep(2000);
        System.out.println("driver.switchTo().alert().getText() = " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }


}
