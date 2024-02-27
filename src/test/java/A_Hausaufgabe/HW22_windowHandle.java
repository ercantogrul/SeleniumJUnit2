package A_Hausaufgabe;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class HW22_windowHandle extends TestBase {
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
    public void javascriptExecutor(){
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
        WebElement searchText = driver.findElement(By.xpath("//div[@role='combobox']/input"));
        searchText.sendKeys("iPhone");
        searchText.submit();


    // Sonuçlar arasından 3.ürünün fiyatını alın

    // Arama sonucunda ortaya çıkan tüm ürünleri teker teker tıklayın
    // Tüm sekmelerin windowhandle değerlerini alt alta yazdırın
    // Herbir ürün sekmesindeki title'ı yazdırın
    // Arama sonucundaki 3.ürünün fiyatının, aynı ürünün sekmesindeki fiyatla aynı olduğunu doğrulayın
    // Ana sayfada iken 3 saniye bekleyip tüm sekmeleri kapatın













    }

}
