package Selenium_JUnit.C03_JUnit_AssertionsMethods;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class C05_AssertionTest {
        /*
    Go to Amazon homepage
    Do the following tasks by creating 3 different test methods.
    1- Test if the URL contains Amazon.
    2- Test if the title does not contain Facebook.
    3- Test that the Amazon logo appears in the upper left corner.
     */

    static WebDriver driver;

    @BeforeAll
    public static void beforeAll(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
        if (driver.findElement(By.xpath("//*[.='Try different image']")).isDisplayed()){  // kapca cikiyorsa "Try different image" bu ikona tikla
            driver.findElement(By.xpath("//*[.='Try different image']")).click();
        }
        // Try different image bu bilgiyi ise sayfa acilinca incele tusuna basarak "dom " ekraninda element sekmesi icerisinde buluyoruz

    }
    @AfterAll
    public static void afterAll(){
        driver.quit();
    }

    @Test
    public void test1(){
        assertTrue(driver.getCurrentUrl().contains("amazon"));;

    }
    @Test
    public void test2(){
        assertFalse(driver.getTitle().contains("facebook"));;

    }





}