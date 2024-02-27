package A_Hausaufgabe;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HW12_dynamic_XPath_Locators {
    /*
Go to URL: lichess.org
Get dynamic XPath locators of webelements signed on the secreenshot
*/

    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://lichess.org/");
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }//Close driver.

    @Test @Order(1)
    public void test1() throws InterruptedException {
        WebElement yeniBirOyunKur = driver.findElement(By.xpath("//*[.='Yeni bir oyun kur'][@type='button']"));
        assertTrue(yeniBirOyunKur.isDisplayed());
        WebElement birArkadasinlaOyna = driver.findElement(By.xpath("//*[.='Bir arkadaşınla oyna'][@type='button']"));
        assertTrue(birArkadasinlaOyna.isDisplayed());
        WebElement bilgisayaraKarsiOyna = driver.findElement(By.xpath("//*[.='Bilgisayara karşı oyna'][@type='button']"));
        assertTrue(bilgisayaraKarsiOyna.isDisplayed());
        WebElement besSifir = driver.findElement(By.xpath("//div[@class='lobby__app__content lpools']/div[@data-id='5+0']"));
        assertTrue(besSifir.isDisplayed());
        WebElement ozel = driver.findElement(By.xpath("//div[@class='lobby__app__content lpools']/div[@data-id='custom']"));
        assertTrue(ozel.isDisplayed());
        //===================================================



    }



}
