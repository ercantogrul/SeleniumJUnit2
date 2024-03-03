package A_Hausaufgabe;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.util.List;
import java.util.Set;

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

        if (driver.findElement(By.xpath("//button[@aria-label='Consent']/p")).isDisplayed()) {
            driver.findElement(By.xpath("//button[@aria-label='Consent']/p")).click();
        }
        WebElement kabulEt = driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']"));
        kabulEt.click();
        Thread.sleep(2000);

    // iphone kelimesini aratın
        System.out.println("_____// iphone kelimesini aratın_________");
        WebElement searchBox1 = driver.findElement(By.xpath("//div[@style='justify-content:flex-start']"));
        searchBox1.click();

        WebElement searchBox = driver.findElement(By.xpath("//div[@role='combobox']/input[@type='text']"));
        searchBox.sendKeys("iphone",Keys.ENTER);

        // Sonuçlar arasından 3.ürünün fiyatını alın
        System.out.println("_____// Sonuçlar arasından 3.ürünün fiyatını alın________");
        WebElement preis = driver.findElement(By.xpath("//*[@id='1']/li[3]"));
        System.out.println("preis.getText() = " + preis.getText());

        System.out.println("___________// Arama sonucunda ortaya çıkan tüm ürünleri teker teker tıklayın________");
    // Arama sonucunda ortaya çıkan tüm ürünleri teker teker tıklayın
        List<WebElement> list = driver.findElements(By.xpath("//*[@id='1']/li"));
        for (WebElement webElement : list) {
           // webElement.click();
            //System.out.println("webElement.getText() = " + webElement.getText());

        }

        System.out.println("_________// Tüm sekmelerin windowhandle değerlerini alt alta yazdırın_________");
// Tüm sekmelerin windowhandle değerlerini alt alta yazdırın
        Set<String> windowhandleList = driver.getWindowHandles();
        for (String s : windowhandleList) {
          //  System.out.println(s);
        }

        System.out.println("________// Herbir ürün sekmesindeki title'ı yazdırın______________");
// Herbir ürün sekmesindeki title'ı yazdırın
        for (String s : windowhandleList) {
            driver.switchTo().window(s);
           // System.out.println("driver.getTitle() = " + driver.getTitle());
        }

        driver.switchTo().window(main);
        System.out.println("__// Arama sonucundaki 3.ürünün fiyatının, aynı ürünün sekmesindeki fiyatla aynı olduğunu doğrulayın__");
// Arama sonucundaki 3.ürünün fiyatının, aynı ürünün sekmesindeki fiyatla aynı olduğunu doğrulayın

        String urunFiyati="";
        String sekmedekiFiyati="";
        for (String s : windowhandleList) {
            if (driver.getTitle().contains("iphone-12-128")) {
                driver.switchTo().window(s);
                sekmedekiFiyati= String.valueOf(driver.findElement(By.xpath("//*[@id=\"offering-price\"]/span[1]")));
                break;
            }
        }

        driver.switchTo().window(main);
        urunFiyati = String.valueOf(driver.findElement(By.xpath("(//div[@data-test-id='price-current-price'])[3]")));
        assertEquals(urunFiyati,sekmedekiFiyati);


        System.out.println("____// Ana sayfada iken 3 saniye bekleyip tüm sekmeleri kapatın_____");
   // Ana sayfada iken 3 saniye bekleyip tüm sekmeleri kapatın
        driver.switchTo().window(main);
        driver.quit();


    }
    @Test
    public void test1() throws InterruptedException {
// https://www.hepsiburada.com/ adresine gidin
// Sayfanın windowhandle değerini alın.
// iphone kelimesini aratın
// Sonuçlar arasından 3.ürünün fiyatını alın
// Arama sonucunda ortaya çıkan tüm ürünleri teker teker tıklayın
// Tüm sekmelerin windowhandle değerlerini alt alta yazdırın
// Herbir ürün sekmesindeki title'ı yazdırın
// Arama sonucundaki 3.ürünün fiyatının, aynı ürünün sekmesindeki fiyatla aynı olduğunu doğrulayın
// Ana sayfada iken 3 saniye bekleyip tüm sekmeleri kapatın


        driver.get("https://www.hepsiburada.com/");
        String firstHandle = driver.getWindowHandle();
        System.out.println("firstHandle = " + firstHandle);
        if (driver.findElement(By.xpath("//*[.='Kabul et']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[.='Kabul et']")).click();
        }
        Thread.sleep(2000);
        if (driver.findElement(By.xpath("//*[.='Consent']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[.='Consent']")).click();
        }

        Thread.sleep(2000);
        WebElement searchbox1 = driver.findElement(By.xpath("//div[@class='searchBoxOld-yDJzsIfi_S5gVgoapx6f']"));
        searchbox1.click();
        WebElement searchbox2 = driver.findElement(By.xpath("//input[@type='text']"));
        searchbox2.sendKeys("iphone" + Keys.ENTER);
        Thread.sleep(2000);
        WebElement thirdPrice = driver.findElement(By.xpath("(//div[@data-test-id='price-current-price'])[3]"));
        String thirdPriceText = thirdPrice.getText();
        for (int i = 0; i < 5; i++) {
            WebElement eleman = driver.findElement(By.xpath("//li[@id='i" + i + "']"));
            eleman.click();
        }
        Thread.sleep(10000);
        Set<String> handles = driver.getWindowHandles();
        WebElement thirdPrice2 = thirdPrice;
        String thirdPrice2Text = "";
        for (String handle : handles) {
            System.out.println(handle);
            System.out.println("driver.switchTo().window(handle).getTitle() = " + driver.switchTo().window(handle).getTitle());
            if (driver.getTitle().contains("iPhone 12")) {
                thirdPrice2 = driver.findElement(By.xpath("//*[@id=\"offering-price\"]/span[1]"));
                thirdPrice2Text = thirdPrice2.getText();
                break;
            }
        }

        thirdPriceText = thirdPriceText.substring(0, 6);
        System.out.println("thirdPriceText = " + thirdPriceText);
        System.out.println("thirdPrice2Text = " + thirdPrice2Text);
        assertEquals(thirdPriceText, thirdPrice2Text);
    }
}
