package A_Hausaufgabe;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HW22_windowHandle____ extends TestBase {
    // https://www.hepsiburada.com/ adresine gidin
// Sayfanın windowhandle değerini alın.
// iphone kelimesini aratın
// Sonuçlar arasından 3.ürünün fiyatını alın
// Arama sonucunda ortaya çıkan tüm ürünleri teker teker tıklayın
// Tüm sekmelerin windowhandle değerlerini alt alta yazdırın
// Herbir ürün sekmesindeki title'ı yazdırın
// Arama sonucundaki 3.ürünün fiyatının, aynı ürünün sekmesindeki fiyatla aynı olduğunu doğrulayın
// Ana sayfada iken 3 saniye bekleyip tüm sekmeleri kapatın

    @Test
    public void javascriptExecutor() throws InterruptedException {
     // https://www.hepsiburada.com/ adresine gidin
        driver.get("https://www.hepsiburada.com/");
    // Sayfanın windowhandle değerini alın.
        String main = driver.getWindowHandle();
        System.out.println(main);

      //Kabul et cerezleri handle edildi
        WebElement kabulEt = driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']"));
        kabulEt.click();
        if (driver.findElement(By.xpath("//div[@class='fc-footer-buttons']/button[@aria-label='Consent']")).isDisplayed()) {
            driver.findElement(By.xpath("//div[@class='fc-footer-buttons']/button[@aria-label='Consent']")).click();
        }

    // iphone kelimesini aratın

        WebElement searchBox= driver.findElement(By.xpath("//input[@type='text']"));
        searchBox.sendKeys("iPhone");
        searchBox.submit();


    // Sonuçlar arasından 3.ürünün fiyatını alın
        WebElement price= driver.findElement(By.xpath("(//div[@data-test-id='price-current-price'])[3]"));
        Thread.sleep(2000);

    // Arama sonucunda ortaya çıkan tüm ürünleri teker teker tıklayın
        List<WebElement> urunListesi=driver.findElements(By.className("productListContent-zAP0Y5msy8OHn5z7T_K_"));

    // Tüm sekmelerin windowhandle değerlerini alt alta yazdırın
    // Herbir ürün sekmesindeki title'ı yazdırın
    // Arama sonucundaki 3.ürünün fiyatının, aynı ürünün sekmesindeki fiyatla aynı olduğunu doğrulayın
    // Ana sayfada iken 3 saniye bekleyip tüm sekmeleri kapatın


    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.hepsiburada.com/");
        String mainHandle= driver.getWindowHandle();

        if (driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).isDisplayed()) {
            driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        }
        Thread.sleep(2000);
        if (driver.findElement(By.xpath("//*[.='Accept all & visit the site']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[.='Accept all & visit the site']")).click();
        }

        WebElement searchBox= driver.findElement(By.xpath("//input[@type='text']"));
        searchBox.sendKeys("iphone", Keys.ENTER);
        Thread.sleep(2000);

        WebElement price= driver.findElement(By.xpath("(//div[@data-test-id='price-current-price'])[3]"));
        Thread.sleep(2000);

        List<WebElement> urunListesi=driver.findElements(By.className("productListContent-zAP0Y5msy8OHn5z7T_K_"));

        for (WebElement webElement : urunListesi) {
            webElement.click();
            String handle=driver.getWindowHandle();

            System.out.println( handle);
            System.out.println(driver.getTitle());
            if (driver.getTitle().contains("Yenilenmis")){
                assertEquals(price,driver.findElement(By.xpath("//span[.='16.999']")));
            }
        }
        Thread.sleep(2000);

        driver.switchTo().window(mainHandle);
        Thread.sleep(3000);

    }


}
