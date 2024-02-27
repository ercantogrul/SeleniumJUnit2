package Selenium_JUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C17_Checkboxes {
    /*
Go to https://the-internet.herokuapp.com/checkboxes
Locate the elements of checkboxes.
Then click on checkbox 1 if box is not selected.
Then click on checkbox 2 if box is not selected.
Then verify that checkbox 1 is checked.
 */
    static WebDriver driver;

    @BeforeAll
    public static void setup() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-cookies");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }
    @AfterAll
    public static void tearDown(){
        driver.close();
    }//Close driver.
    @Test
    public void test() throws InterruptedException {
        WebElement check1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement check2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        if(!check1.isSelected()){
            check1.click();
        }
        Thread.sleep(3000);

        if(!check2.isSelected()){
            check2.click();
        }
        Thread.sleep(3000);

        assertTrue(check1.isSelected());
    }
}