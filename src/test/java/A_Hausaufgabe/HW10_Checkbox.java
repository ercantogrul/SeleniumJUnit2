package A_Hausaufgabe;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HW10_Checkbox {
     /*
Go to URL: https://demoqa.com/
Click on Elements.
Click on Checkbox.
Verify if Home checkbox is selected.
Verify that "You have selected" is visible.
     */
     static WebDriver driver;

    @BeforeAll
    public static void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-cookies");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/");
        if (driver.findElement(By.xpath("(//*[.='İzin ver'])[1]")).isDisplayed()){
            driver.findElement(By.xpath("(//*[.='İzin ver'])[1]")).click();
        }

    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }//Close driver.

    @Test @Order(1)
    public void test1() throws InterruptedException {
        //Click on Elements.
        WebElement elements = driver.findElement(By.xpath("(//*[.='Elements'])[3]"));
        elements.click();
        Thread.sleep(3000);
    }
    @Test @Order(2)
    public void test2() throws InterruptedException {
        //Click on Checkbox.
        WebElement check = driver.findElement(By.xpath("//*[@id='item-1']/span[.='Check Box']"));
        check.click();
        Thread.sleep(3000);
    }
    @Test @Order(3)
    public void test3() throws InterruptedException {
        //Verify if Home checkbox is selected.
        WebElement verify = driver.findElement(By.xpath("//*[@class='rct-icon rct-icon-uncheck']"));
        System.out.println(verify.getText());
        assertTrue(verify.isDisplayed());
        Thread.sleep(3000);
    }
    @Test @Order(4)
    public void test4() throws InterruptedException {
        //Verify that "You have selected" is visible.
        WebElement home = driver.findElement(By.xpath("//span[@class='rct-checkbox']"));
        home.click();
        WebElement selected = driver.findElement(By.xpath("//*[@id='result']"));
        System.out.println("selected.getText() = " + selected.getText());
        assertEquals(selected.getText(), "You have selected");


    }
}
