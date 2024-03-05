package Selenium_JUnit;



import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utils.TestBase;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class C53_ScreenShot1 extends TestBase {
    // Go to ebay.com.
    // Take Page ScreenShot.
    // Spesific WebElement ScreenShot

    // Take Page ScreenShot.
    @Test
    public void takeFullPageScreenShot() throws IOException {
        driver.get("https://www.ebay.com/");

        //TakesScreenshot interface i ile bir obje olusturdukve ekran goruntusu almak icin getScreenshotAs methodunu kullandik
        TakesScreenshot ts = (TakesScreenshot) driver; //driver i, TakesScreenshot a cast yaptik
        File source = ts.getScreenshotAs(OutputType.FILE);

        String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());  // belirtilen formatta bir tarih belirtildi

        File destination = new File(".\\testOutput\\Screenshots\\ebayFullPage"+date+".png"); // logo nun varacagi yeri yani path ini yazdik
        // nokta (.) demek (Selenium2_JUnit) projesine kadar olan yolu aldi demek
        //C:\Users\etogr\IdeaProjects\Selenium2_JUnit\ yani buraya kadar olan yolu
        FileUtils.copyFile(source, destination);

    }

    // Spesific WebElement ScreenShot
    @Test
    public void takeSpesificWEScreenShot() throws IOException, InterruptedException {
        driver.get("https://www.ebay.com/");
        // sayfada sadece bir objenin ScreenShot i ni alirken driver i TakesScreenshot a CAST edilmez (Yukardaki ile farki bu)
        WebElement ebayLogo = driver.findElement(By.id("gh-la"));
        File source = ebayLogo.getScreenshotAs(OutputType.FILE);  // kaynagi yazdik

        String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());  // belirtilen formatta bir tarih belirtildi

        File destination = new File(".\\testOutput\\Screenshots\\ebayLogo"+date+".png"); // logo nun varacagi yeri yani path ini yazdik
        // nokta (.) demek (Selenium2_JUnit) projesine kadar olan yolu aldi demek
        //C:\Users\etogr\IdeaProjects\Selenium2_JUnit\ yani buraya kadar olan yolu
        FileUtils.copyFile(source, destination);  // kaynagi (source), (destination) path adresine gönderiyor

    }
}

