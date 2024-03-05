package Selenium_JUnit.C04_Locators;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C06_Locators {
       /*seleniumda 8 adet locator (webelement konumlandirici) var
    -ID
        * ID locator aslinda bir webElementin id attribute udur..
        * id="value" seklindeyse biz elementi value ile buluruz
    -NAME
        * NAME locator aslinda bir webElementin name attribute udur..
        * name="value" seklindeyse biz elementi value ile buluruz
    -CLASS
        * CLASS locator aslinda bir webElementin class attribute udur..
        * class="value" seklindeyse biz elementi value ile buluruz
    -TAGNAME
        * html elementlerinin taglari ile locate etme stratejisidir
        * <tagName></tagName>  ise biz bu elementi tagName degeri ile locate ederiz
    -LINK TEST
        *linkText locator sadece <a> elementlerde bulunur
    -PARTIALLINK TEST
        *linkText ile ayni olmakla beraber, textin bir bolumunu almak yeterlidir..
    -CSS
    -XPATH
   */

    static WebDriver driver;

    @BeforeAll
    public static void beforeAll(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
        if (driver.findElement(By.xpath("//*[.='Try different image']")).isDisplayed()){  // kapca cikiyorsa "Try different image" bu ikona tikla
            driver.findElement(By.xpath("//*[.='Try different image']")).click();
        }
        // Try different image bu bilgiyi ise sayfa acilinca incele tusuna basarak "dom " ekraninda element sekmesi icerisinde buluyoruz

    }
    @AfterAll
    public static void afterAll() {
       driver.quit();
    }
    @Test
    public void test1(){
        WebElement searcBox1 = driver.findElement(By.id("twotabsearchtextbox"));
        WebElement searcBox2 = driver.findElement(By.name("field-keywords"));
        WebElement searcBox3 = driver.findElement(By.className("nav-input nav-progressive-attribute"));
        WebElement searcBox4 = driver.findElement(By.tagName("input"));
        WebElement link = driver.findElement(By.linkText("Advertise Your Products"));
        /*
        <a href="https://advertising.amazon.com/?ref=ext_amzn_ftr"
        class="nav_a">Advertise Your Products</a>
        yani taglar arasindaki Text alinir
         */

        WebElement link2 = driver.findElement(By.partialLinkText("Advertise"));
        // partialLinkText de ise kisa bir parca alinir

    }



}
// /html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input









