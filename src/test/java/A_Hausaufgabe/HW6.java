package A_Hausaufgabe;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HW6 {
    /*
   //Navigate to website  https://testpages.herokuapp.com/styled/index.html
   //Under the Examples
   //Click on Locators - Find By Playground Test Page
   //Print the URL

   //Navigate back
   //Print the URL

   //Click on WebDriver Example Page
   //Print the URL

   //Enter value  20 and Enter to "Enter Some Numbers inputBox"
   //And then verify 'two, zero' message is displayed
   //Close driver.
    */
    static WebDriver driver;
    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterAll
    public static void afterAll() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @BeforeEach
    public void beforeEach() {
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
    }
    @Test
    public void test1() throws InterruptedException {
        WebElement locater1 = driver.findElement(By.xpath("//*[@id='findbytest']"));
        locater1.click();
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);

        driver.navigate().back();
        Thread.sleep(3000);
        System.out.println(driver.getCurrentUrl());

        WebElement examplePage = driver.findElement(By.xpath("//*[@id='webdriverexamplepage']"));
        examplePage.click();
        System.out.println(driver.getCurrentUrl());

        WebElement inputBox = driver.findElement(By.xpath("//input[@id='numentry']"));
        assertTrue(inputBox.isDisplayed());
        inputBox.sendKeys("20");
        inputBox.submit();

        WebElement twoZeroMessage = driver.findElement(By.xpath(" //*[@id='message']"));
        System.out.println(twoZeroMessage.getText());
        assertEquals("two, zero", twoZeroMessage.getText());
        driver.close();

    }
}