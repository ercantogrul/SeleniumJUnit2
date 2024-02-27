package Selenium_JUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C30_SendKeys {
    // https://www.amazon.com/ a git
    // Arama kismina herhangi bir kelime yaz
    // Aramayi enter a tiklayarak yap
    static WebDriver driver;

    @BeforeAll
    public static void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-cookies");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().deleteAllCookies();

    }
    @AfterAll
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test() throws InterruptedException {
        //Go to URL: https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        driver.findElement(By.xpath("//a[.='Try different image']")).click(); //
        //locator ini id si ile aldik
        WebElement searcBox = driver.findElement(By.id("twotabsearchtextbox"));
        //sendKeys mutlaka String ister (tamsayi da göndersek mutlaka "4" seklinde cift tirnak icerisinde olmak zorunda
        searcBox.sendKeys("iPhone"+ Keys.ENTER);
       // searcBox.submit();


    }
}