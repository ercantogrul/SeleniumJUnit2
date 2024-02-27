package Selenium_JUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C26_Alert2 {
    /*
https://the-internet.herokuapp.com/javascript_alerts
 */

    //Click for JS Alert butonuna tikla
//I am a JS Alert alertini kabul et
//JS Confirm butonuna tikla
//I am a JS Confirm alertini iptal et
//JS Prompt butonuna tikla
//I am a JS prompt alertine text yolla ve kabul et
    static WebDriver driver;

    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }//Close driver.

    @Test
    public void test() throws InterruptedException {
        //Go to URL: https://the-internet.herokuapp.com/javascript_alerts
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //Click for JS Alert butonuna tikla
        WebElement alert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        alert.click();

        //I am a JS Alert alertini kabul et jsConfirm
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        //JS Confirm butonuna tikla
        WebElement alert2 = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        alert2.click();

        //I am a JS Confirm alertini iptal et
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();

        //JS Prompt butonuna tikla
        WebElement alert3 = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        alert3.click();

        //I am a JS prompt alertine text yolla ve kabul et
        driver.switchTo().alert().sendKeys("Hello World! from DE3 cohort");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
    }

}
