package A_Hausaufgabe;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HW18_iframe {
    //Go to URL: http://demo.guru99.com/test/guru99home/
//Find the number of iframes on the page.
//Link to the third iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.
//Exit the iframe and return to the main page.

    static WebDriver driver;
    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://demo.guru99.com/test/guru99home/");
    }

    @AfterAll
    public static void tearDown() {
      driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
      //Find the number of iframes on the page.
        List<WebElement> iframeSayisi = driver.findElements(By.tagName("iframe"));
        System.out.println("the number of iframes on the page = " + iframeSayisi.size());

    }
    @Test
    public void test2() throws InterruptedException {
     // Burada sayfa acildiginda cerezlerin icinde bulundugu Iframe i handle ediyoruz.

        WebElement iFrameCerez1 = driver.findElement(By.xpath("//*[@id='gdpr-consent-notice']"));
        driver.switchTo().frame(iFrameCerez1);
        if (driver.findElement(By.xpath("(//button[@id='save']//span[.='Tümünü Kabul Et'])[2]")).isDisplayed()){
            driver.findElement(By.xpath("(//button[@id='save']//span[.='Tümünü Kabul Et'])[2]")).click();
        }
        driver.switchTo().defaultContent();

   //Link to the third iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.
        WebElement JMeterMadeEasyElement = driver.findElement(By.xpath("//*[@id='a077aa5e']"));
        driver.switchTo().frame(JMeterMadeEasyElement);

        WebElement href = driver.findElement(By.xpath("//a[@href='http://www.guru99.com/live-selenium-project.html']"));
        href.click();
        driver.switchTo().defaultContent();

    // ikinci defa Iframe de cikan kabul et cerezini handle ediyoruz.
        driver.get("https://www.guru99.com/live-selenium-project.html");
        WebElement iFrameCerez2 = driver.findElement(By.xpath("//*[@id='sp_message_iframe_1037215']"));
        driver.switchTo().frame(iFrameCerez2);

        if (driver.findElement(By.xpath("//div[@class='message-component message-column']//button[@title='İzin Ver']")).isDisplayed()){
            driver.findElement(By.xpath("//div[@class='message-component message-column']//button[@title='İzin Ver']")).click();
        }
        driver.switchTo().defaultContent();


    }

}
