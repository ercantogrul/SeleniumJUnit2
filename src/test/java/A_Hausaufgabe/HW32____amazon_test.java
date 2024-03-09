package A_Hausaufgabe;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HW32____amazon_test extends TestBase {
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
        //Ana sayfanın açıldığı kontrol edilir. // Başlık kontrolü
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        assertTrue(actualTitle.contains("Amazon.de: Günstige Preise für Elektronik & Foto"));

        if (driver.findElement(By.xpath("//*[@id=\"sp-cc-accept\"]")).isDisplayed()) {
            driver.findElement(By.xpath("//*[@id=\"sp-cc-accept\"]")).click();
        }
        //Ana sayfanın açıldığı kontrol edilir.// FullScreenshot ile
        getFullScreenMethos(driver);

        //Siteye login olunur.
        WebElement signInHowerButton = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
        actions
                .moveToElement(signInHowerButton)
                .click(signInHowerButton)
                .perform();

        WebElement emailButton = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
        emailButton.click();
        emailButton.sendKeys("erc@gmail.com");
        WebElement weiterButton = driver.findElement(By.id("continue"));
        weiterButton.click();

        WebElement passwordButton = driver.findElement(By.xpath("//input[@id='ap_password']"));
        passwordButton.click();
        passwordButton.sendKeys("***");
        WebElement anmelden = driver.findElement(By.id("signInSubmit"));
        anmelden.click();

        //Login işlemi kontrol edilir.
        assertTrue(driver.findElement(By.id("nav-link-accountList")).isDisplayed());

        //Hesabım bölümünden "Virgosol Liste" isimli yeni bir liste oluşturulur.
        WebElement signInHowerButton1 = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
        actions
                .moveToElement(signInHowerButton1).pause(2)
                .perform();

        WebElement neueListe = driver.findElement(By.xpath("//span[.='Neue Liste anlegen ']"));
        neueListe.click();

        WebElement einListeErstellen = driver.findElement(By.xpath("//*[@id=\"list-name\"]"));
        einListeErstellen.clear();
        einListeErstellen.sendKeys("Virgosol Liste");


        WebElement listeAnlegen = driver.findElement(By.xpath("//*[@id=\"wl-redesigned-create-list\"]"));
        listeAnlegen.click();

        //Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.

        WebElement kategoriler = driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));
        Select select = new Select(kategoriler);
        Thread.sleep(3000);
        select.selectByValue("search-alias=computers");
        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());

        //Bilgisayar kategorisi seçildiği kontrol edilir.
        Thread.sleep(2000);
        assertTrue(select.getFirstSelectedOption().getText().contains("Computer"));

        //Arama alanına msi yazılır ve arama yapılır.
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("msi", Keys.ENTER);
        Thread.sleep(2000);

        //Arama yapıldığı kontrol edilir.
        assertTrue(driver.getTitle().contains("msi"));

        //Arama sonuçları sayfasından 2. sayfa açılır.
        WebElement sayfa2 = driver.findElement(By.xpath("//a[@aria-label='Zu Seite 2']"));
        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        jsexecutor.executeScript("arguments[0].scrollIntoView();", sayfa2); // sayfa2 elementinin olduyu yere spring yapildi
        sayfa2.click();

        //2'inci sayfanın açıldığı kontrol edilir.
        String currentPageUrl = driver.getCurrentUrl();
        System.out.println("currentPageUrl = " + currentPageUrl);
        assertTrue(currentPageUrl.contains("&page=2"));

        //Sayfadaki 2'inci ürün oluşturulan "Virgosol Liste" listesine eklenir.
        WebElement zweiteProdukt = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]"));
        zweiteProdukt.click();
        WebElement addList = driver.findElement(By.id("add-to-wishlist-button-submit"));
        addList.click();

        //2'inci Ürünün listeye eklendiği kontrol edilir.
        WebElement listKontrol = driver.findElement(By.xpath("//*[@id=\"huc-atwl-header-section\"]/div/span[1]"));
        assertTrue(listKontrol.isDisplayed());

        // Hesabım  Alışveriş Listesi sayfasına gidilir.
        WebElement meineListeAnzeige = driver.findElement(By.xpath("//a[.='Meine Liste anzeigen']"));
        meineListeAnzeige.click();
        getFullScreenMethos(driver);

        //"Alışveriş Listesi" sayfası açıldığı kontrol edilir.
        getFullScreenMethos(driver);
        WebElement verifyEinkaufList = driver.findElement(By.id("profile-list-name"));
        assertTrue(verifyEinkaufList.isDisplayed());

        //Eklenen ürün Virgosol Liste'sinden silinir.
        WebElement produktLoschen = driver.findElement(By.name("submit.deleteItem"));
        jsexecutor.executeScript("arguments[0].click();", produktLoschen);

        //Ürünün Silindigi kontrol edildi
        WebElement gelosht = driver.findElement(By.xpath("//div[text()='Gelöscht']"));
        assertTrue(gelosht.isDisplayed());

        //Virgosol Liste'si silinir.
        WebElement signInHowerButton2 = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));

        actions
                .moveToElement(signInHowerButton2).pause(2)
                .perform();
        WebElement vigosolName = driver.findElement(By.xpath("//span[.='Virgosol Liste']"));
        jsexecutor.executeScript("arguments[0].click();", vigosolName);

        WebElement listEditBox = driver.findElement(By.id("overflow-menu-popover-trigger"));

        actions
                .moveToElement(listEditBox).pause(2)
                .perform();
        WebElement listEdit = driver.findElement(By.id("editYourList"));
        jsexecutor.executeScript("arguments[0].click();", listEdit);

        WebElement loschen = driver.findElement(By.xpath("(//span[.='Liste löschen'])[4]"));
        jsexecutor.executeScript("arguments[0].click();", loschen);
        WebElement save = driver.findElement(By.xpath("//span[@class='a-button-inner']"));
        jsexecutor.executeScript("arguments[0].click();", loschen);


        //Üye çıkış işlemi yapılır.
        WebElement signInHowerButton3 = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
        actions
                .moveToElement(signInHowerButton3).pause(2)
                .perform();
        WebElement abmelden = driver.findElement(By.xpath("//span[.='Abmelden']"));
        jsexecutor.executeScript("arguments[0].click();", abmelden);

        //Çıkış işleminin yapıldığı kontrol edilir.
        getFullScreenMethos(driver);

            //Not: Virgosol Liste'si task yeniden çalıştırıldığında sorun olmaması için silinmektedir.

    }


    private void getFullScreenMethos(WebDriver driver) throws InterruptedException, IOException {
        //TakesScreenshot interface i ile bir obje olusturdukve ekran goruntusu almak icin getScreenshotAs methodunu kullandik
        TakesScreenshot ts = (TakesScreenshot) driver; //driver i, TakesScreenshot a cast yaptik
        File source = ts.getScreenshotAs(OutputType.FILE);

        String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());  // belirtilen formatta bir tarih belirtildi
        Thread.sleep(2000);
        File destination = new File(".\\testOutput\\Screenshots\\AmazonFullPage"+date+".png"); // logo nun varacagi yeri yani path ini yazdik
        Thread.sleep(2000);
        // nokta (.) demek (Selenium2_JUnit) projesine kadar olan yolu aldi demek
        //C:\Users\etogr\IdeaProjects\Selenium2_JUnit\ yani buraya kadar olan yolu
        FileUtils.copyFile(source, destination);
    }

    private void getScreenShotMethod(WebElement verify) throws IOException {

        File source = verify.getScreenshotAs(OutputType.FILE);

        String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());  // belirtilen formatta bir tarih belirtildi

        File destination = new File(".\\testOutput\\Screenshots\\orangeLogo"+date+".png"); // logo nun varacagi yeri yani path ini yazdik
        // nokta (.) demek (Selenium2_JUnit) projesine kadar olan yolu aldi demek
        //C:\Users\etogr\IdeaProjects\Selenium2_JUnit\ yani buraya kadar olan yolu
        FileUtils.copyFile(source, destination);  // kaynagi (source), (destination) path adresine gönderiyor

        //Getting screenshot of  Orange HRM Page Section.
        TakesScreenshot ts = (TakesScreenshot) driver;

        File source2 = ts.getScreenshotAs(OutputType.FILE);
        File destination2 = new File("./testOutput/ScreenShots/orangeFullPage"+date+".png");

        FileUtils.copyFile(source2, destination2);
    }
}