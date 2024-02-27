package Selenium_JUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C16_ChromeOptions {
    /*
 ChromeOptions Class

Selenium WebDriver'da Chrome sürücüsünün çeşitli özelliklerini değiştirmek için kullanılan bir kavramdır.

start-maximized: Chrome'u büyütme modunda açar.
incognito: Chrome'u gizli modda açar.
headless: Chrome'u görüntülenmeyen modda çalıştırır.(headless modda)
disable-extensions: Chrome tarayıcısında mevcut uzantıları devre dışı bırakır.
disable-popup-blocking: Chrome tarayıcısında görüntülenen açılır pencereleri devre dışı bırakır.
make-default-browser: Chrome'u varsayılan tarayıcı yapar.
version: Chrome tarayıcı sürümünü yazdırır.
disable-infobars: Chrome'un "Chrome otomatik yazılım tarafından kontrol ediliyor" bildirimini görüntülemesini engeller.
disable-cookies: cerezleri bloke eder.
 */
    static WebDriver driver;
    @BeforeAll
    public static void beforeAll() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-cookies");

        driver= new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://www.bestbuy.com");
        Thread.sleep(3000);

    }
    @AfterAll
    public static void afterAll() throws InterruptedException {
        driver.quit();
    }
    @Test @Order(1)
    public void test1(){

    }

}
