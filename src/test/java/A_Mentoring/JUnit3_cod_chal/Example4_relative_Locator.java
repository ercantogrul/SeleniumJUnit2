package A_Mentoring.JUnit3_cod_chal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Example4_relative_Locator {
    /*    Locators
driver.findElement(Locator);  Tanimladigimiz web elementin yerini driver’in bulabilmesi icin kullanilir
driver.findElement(By.id(String id));
driver.findElement(By.name(String name));
driver.findElement(By.className(String class name));
driver.findElement(By.linkText(String Link));
driver.findElement(By.partialLinkText(String link parcasi));
driver.findElement(By.tagName(String tag name));
driver.findElements(Locator);  Locator degerine uygun Web elementlerinin listesini döndürür
By.xpath(“String”)  //tagName[@attributeIsmi=’attributeValue’]
            //*[text()=’tam metin’]    (relative xpath)
            By.cssSelector(“String”)  TagName[attName=’value’];     tagName#idValue;    .classValue;*/
    /*
1) Open the browser
2) Enter the URL “https://hava-durumu-apps.netlify.app/”
3) Enter Berlin on ınput area
4) Verify result contains Berlin
5) After result locate Degrees of city by using relative locator
6)
   */

    static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-cookies");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://hava-durumu-apps.netlify.app/");
    }
    @AfterAll
    public static void tearDown(){

       driver.quit();
    }//Close driver.


    @Test
    public void test1() throws InterruptedException {
        WebElement box = driver.findElement(By.xpath("//input[@id='input']"));
        box.sendKeys("Geldern");
        Thread.sleep(2000);

        WebElement stadt = driver.findElement(By.cssSelector("h2[class='text-2xl font-semibold mb-3']"));
        assertEquals(stadt.getText(),"Geldern");

        WebElement logo = driver.findElement(RelativeLocator.with(By.tagName("h1")).above(By.cssSelector("h2[class='text-2xl font-semibold mb-3']")));
        assertTrue(logo.isDisplayed());
        System.out.println("logo.getText() = " + logo.getText());

    }

}
