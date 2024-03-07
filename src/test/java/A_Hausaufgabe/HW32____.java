package A_Hausaufgabe;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestBase;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HW32____ extends TestBase {
    /*
    Amazon Senaryosu
//https://www.amazon.com.tr/ sitesi açılır.
//Ana sayfanın açıldığı kontrol edilir.
//Çerez tercihlerinden Çerezleri kabul et seçilir.

//Siteye login olunur.
//Login işlemi kontrol edilir.

//Hesabım bölümünden "Virgosol Liste" isimli yeni bir liste oluşturulur.
//Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
//Bilgisayar kategorisi seçildiği kontrol edilir.
//Arama alanına msi yazılır ve arama yapılır.
//Arama yapıldığı kontrol edilir.
//Arama sonuçları sayfasından 2. sayfa açılır.
//2'inci sayfanın açıldığı kontrol edilir.
//Sayfadaki 2'inci ürün oluşturulan "Virgosol Liste" listesine eklenir.
//2'inci Ürünün listeye eklendiği kontrol edilir.
//Hesabım  Alışveriş Listesi sayfasına gidilir.
//"Alışveriş Listesi" sayfası açıldığı kontrol edilir.
//Eklenen ürün Virgosol Liste'sinden silinir.
//Silme işleminin gerçekleştiği kontrol edilir.
//Virgosol Liste'si silinir.
//Üye çıkış işlemi yapılır.
//Çıkış işleminin yapıldığı kontrol edilir.
//Not: Virgosol Liste'si task yeniden çalıştırıldığında sorun olmaması için silinmektedir.
     */
    @Test
    public void test() throws Exception {
        //https://www.amazon.com.tr/ sitesi açılır.
        driver.get("https://www.amazon.de/");

        //Çerez tercihlerinden Çerezleri kabul et seçilir.
        if (driver.findElement(By.xpath("//*[.='Anderes Bild probieren']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[.='Anderes Bild probieren']")).click();
        }
        if (driver.findElement(By.xpath("//*[@id=\"sp-cc-accept\"]")).isDisplayed()) {
            driver.findElement(By.xpath("//*[@id=\"sp-cc-accept\"]")).click();
        }
//        if (driver.findElement(By.xpath("//div[@class='a-row a-text-center']/img")).isDisplayed()) {
//            getSpecificScreenShoot(driver.findElement(By.xpath("//div[@class='a-row a-text-center']/img")));
//            driver.findElement(By.xpath("//*[@id=\"sp-cc-accept\"]")).click();
//        }

            //div[@class='a-row a-text-center']/img

            //Ana sayfanın açıldığı kontrol edilir. // Başlık kontrolü
            String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
            assertTrue(actualTitle.contains("Amazon.de: Günstige Preise für Elektronik & Foto"));

            //Siteye login olunur.


            WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
            signInButton.click();

            WebElement emailButton = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
            emailButton.click();
            emailButton.sendKeys("ercntgrl@gmail.com");
            Thread.sleep(2000);
            WebElement devamEtButton = driver.findElement(By.id("continue"));
            devamEtButton.click();

            // Giriş yapıldığını doğrulama
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nav-link-accountList")));
            assertTrue(driver.findElement(By.id("nav-link-accountList")).isDisplayed());



    }
}