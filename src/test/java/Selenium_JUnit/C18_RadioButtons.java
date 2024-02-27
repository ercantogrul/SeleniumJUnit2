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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class C18_RadioButtons {
    /*
        Go to URL:  https://www.facebook.com/
        Click on Create an Account button.
        Then click on the radio buttons.
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
        driver.get("https://www.facebook.com/");
        if (driver.findElement(By.xpath("//button[@title='Tüm çerezlere izin ver']")).isDisplayed()) {
            driver.findElement(By.xpath("//button[@title='Tüm çerezlere izin ver']")).click();
        }
    }
    @AfterAll
    public static void tearDown(){
        driver.close();
    }//Close driver.
    @Test
    public void test() throws InterruptedException {
        WebElement newAccountButton = driver.findElement(By.xpath("//a[starts-with(@id,'u_')]"));
        newAccountButton.click();
        List<WebElement> radioButtonList = driver.findElements(By.xpath("//input[@type='radio']"));
        for (WebElement each : radioButtonList){
            if ( !each.isSelected()){
                each.click();
            }
            Thread.sleep(2000);
        }

    }

}
