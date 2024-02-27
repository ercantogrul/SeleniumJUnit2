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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HW11_radioButtons {
     /*
Go to URL: https://demoqa.com/radio-button
Soruya verilen 3 seçeneğin de seçilme durumlarını doğrulayınız.
Her bir seçenek seçildiğinde aşağısında çıkan text'leri konsolda yazdırınız.
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
        driver.get("https://demoqa.com/radio-button");
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }//Close driver.

    @Test
    @Order(1)
    public void test1() throws InterruptedException {

        List<WebElement> radioButtons = driver.findElements(By.xpath("//label[starts-with(@class,'custom-control')]"));
        System.out.println(radioButtons.size());
        //Soruya verilen 3 seçeneğin de seçilme durumlarını doğrulayınız.
        for (WebElement each: radioButtons) {
            each.click();
            assertTrue(each.isDisplayed());

           // Her bir seçenek seçildiğinde aşağısında çıkan text'leri konsolda yazdırınız.
            WebElement text = driver.findElement(By.xpath("//*[text()='You have selected ']"));
            Thread.sleep(2000);
            System.out.println("text.getText() = " + text.getText());
        }

    }

}
