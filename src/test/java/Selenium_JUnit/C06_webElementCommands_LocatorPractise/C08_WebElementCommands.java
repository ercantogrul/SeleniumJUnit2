package Selenium_JUnit.C06_webElementCommands_LocatorPractise;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class C08_WebElementCommands {
//    sendKeys(String keys) methodu elementimize gonderilen degerleri klavyeyle yazarmis gibi gonderir
//    isDisplayed() bize boolean ifadeler dondurur!!!!!!!!!! Elementin sayfada goruntulenip goruntulenmedigi bilgisini verir
//    isSelected() methodumuz bize elementin secili olup olmadigi bilgisini verir. (checkbox, radio)
//    isEnabled() bir elementin aktif mi degil mi oldugunun bilgisini verir (button ve girdi yapilan elementlerde kullanilabilir)
//    submit() methodu formlari submit etmemize yani gondermemize yardimci olur. ENTER tusunun gorevini gorur.
//    click() methodu bir elemente sol tiklamamizi saglar.
//    getLocation() methodu bize elementin konumunu verir
//    clear() methodu input alanlarindaki yazilarin temizlenmesini saglar.
//    getText() methodu elementin contentini bize verir  // web elementin üzerinde (icinde degil) bir yazi varsa bize getirir
//    getAttribute(String key) methodu bize elementin istedigimiz attribute degerini getirir.
//    getSize() elementin boyutunu bize verir.
//    element.method().

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
    public static void afterAll() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='field-keywords']"));
        // tag'i input olan name attribute degeri 'field-keywords' olan webelement bul

        assertTrue(searchBox.isDisplayed());
        searchBox.sendKeys("smart watch");
        Thread.sleep(2000);
        searchBox.clear();
        Thread.sleep(2000);
        searchBox.sendKeys("iphone 15 pro max");
        searchBox.submit();
        WebElement resultText = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        //web elementin üzerinde (icinde degil) bir yazi varsa bize getirir
        // resultText obje sine elementin üzerindeki yazi aktarildi.
        assertEquals("\"iphone 15 pro max\"",resultText.getText());
        assertTrue(resultText.getText().contains("iphone 15 pro")); // resultText.getText() icerisinde "iphone 15 pro max" var mi


    }



}
