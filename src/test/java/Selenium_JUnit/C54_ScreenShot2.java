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

public class C54_ScreenShot2 extends TestBase {

    //Go to URL: https://opensource-demo.orangehrmlive.com/
    //Saving the image to  the path.
    //Getting screenshot of Orange HRM Logo.
    //Getting screenshot of  Orange HRM Page Section.

    @Test
    public void testScreenShot() throws IOException {
        //Go to URL: https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebElement orangeLogo = driver.findElement(By.xpath("//img[@alt='company-branding']"));
        File source = orangeLogo.getScreenshotAs(OutputType.FILE);

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

    @Test
    public void takeFullPageScreenShot() throws IOException, InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //TakesScreenshot interface i ile bir obje olusturdukve ekran goruntusu almak icin getScreenshotAs methodunu kullandik
        TakesScreenshot ts = (TakesScreenshot) driver; //driver i, TakesScreenshot a cast yaptik
        File source = ts.getScreenshotAs(OutputType.FILE);

        String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());  // belirtilen formatta bir tarih belirtildi
        Thread.sleep(2000);
        File destination = new File(".\\testOutput\\Screenshots\\orangeFullPage"+date+".png"); // logo nun varacagi yeri yani path ini yazdik
        Thread.sleep(2000);
        // nokta (.) demek (Selenium2_JUnit) projesine kadar olan yolu aldi demek
        //C:\Users\etogr\IdeaProjects\Selenium2_JUnit\ yani buraya kadar olan yolu
        FileUtils.copyFile(source, destination);




    }
}

