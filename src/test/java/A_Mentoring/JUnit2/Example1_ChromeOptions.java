package A_Mentoring.JUnit2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Example1_ChromeOptions {
    //Example-1
    //1-Goto IKEA home page with incognito mode
    //2-diğer chrome extensionları da deneyelim , maxi-sized vs.

    static WebDriver driver;
    @BeforeAll
    public static void setup() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-cookies");
        options.addArguments("incognito");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.ikea.com/");
        if (driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).isDisplayed()) {
            driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        }

    }
    @AfterAll
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test() throws InterruptedException {


    }
}
