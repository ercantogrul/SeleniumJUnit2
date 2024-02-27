package Selenium_JUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C15_RelativeLocator {
    /*
     sabit bir elemanın üzerinde bulunan bir eleman veya elemanları bulur.
    above() –
    below() –
    near() –
    toLeftOf() –
    toRightOf() –

Go to http://www.bestbuy.com
Verify that the page header contains " Hello" Also,
using Relative Locator.
LogoTest  Verify if the BestBuy logo is displayed.
CanadaLinkTest  Verify if the link is displayed.
 */

    static WebDriver driver;
    @BeforeAll
    public static void beforeAll(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://www.bestbuy.com");

    }
    @AfterAll
    public static void afterAll() throws InterruptedException {
        driver.quit();
    }
    @Test @Order(1)
    public void test1(){
        WebElement hello = driver.findElement(RelativeLocator.with(By.tagName("div")).below(By.xpath("(//img[@class='logo'])[1]")));
        //xpath i 1 of 1 olan "(//img[@class='logo'])[1]"))) Best Buy img sinin altinda tanname si div olan elementi bulduk.
        assertTrue(hello.getText().contains("Hello"));

    }
    @Test @Order(2)
    public void test2(){
        WebElement logo = driver.findElement(RelativeLocator.with(By.tagName("img")).above(By.xpath("(//*[.='Hello!'])")));
        assertTrue(logo.isDisplayed());

    }
    @Test @Order(3)
    public void test3(){
        WebElement canadaFlag = driver.findElement(RelativeLocator.with(By.tagName("img")).toLeftOf(By.xpath("(//*[.='United States'])")));
        assertTrue(canadaFlag.isDisplayed());

    }

}
