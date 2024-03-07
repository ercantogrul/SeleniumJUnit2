package A_Hausaufgabe;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class HW30_FullPageScreenshot extends TestBase {
    @Test
    public void testScreenShot () throws IOException {

        // Go to n11.com.
        // Take Full Page Screenshot.
        // Spesific WebElement ScreenShot

        driver.get("https://www.n11.com/");

        WebElement tumunuKabulEt =driver.findElement(By.tagName("efilli-layout-dynamic")).getShadowRoot().
                findElement(By.cssSelector("div[id='480698fc-e6ac-41bc-a722-51059b783200']"));
        tumunuKabulEt.click();

        String data = new SimpleDateFormat("yyyy-MM-dd__hh__mm_ss").format(new Date());

        // Take Full Page Screenshot.
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File(".\\testOutput\\ScreenShots\\n11FullPageScreenshot"+data+".png");
        FileUtils.copyFile(source,destination);

        // Spesific WebElement ScreenShot
        WebElement n11Logo = driver.findElement(By.xpath("//a[@title='hayat sana gelir']"));
        File source1 = n11Logo.getScreenshotAs(OutputType.FILE);
        File destination1 = new File(".\\testOutput\\ScreenShots\\n11Logo"+data+".png");
        FileUtils.copyFile(source1,destination1);

    }
    @Test
    public void takeFullPageScreenShot1() throws IOException, InterruptedException {
        driver.get("https://www.n11.com/");

        // SCHADOW-ROOT oldugu icin
        Thread.sleep(3000);
        WebElement target = driver.findElement(By.tagName("efilli-layout-dynamic")).getShadowRoot()
                .findElement(By.cssSelector("div[id='480698fc-e6ac-41bc-a722-51059b783200']"));
        target.click();


        // Ekran görüntüsü almak için TakesScreenshot arayüzü kullanılır. Bu sadece tüm ekranin fotosu icin gerekli.
        TakesScreenshot ts = (TakesScreenshot) driver; // driver nesnesi, TakesScreenshot arayüzüne cast edilir.

        // Ekran görüntüsü alınır ve bir File nesnesine atanır.
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Ekran görüntüsünün adı için bir tarih formatı belirlenir.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        String date = LocalDateTime.now().format(formatter);

        // Ekran görüntüsünün kaydedileceği dosyanın yolu belirlenir.
        File destination = new File("./testOutput/ScreenShots/n11FullPage" + date + ".png");

        // Ekran görüntüsü kaydedilir veya kopyalanmis olur.
        FileUtils.copyFile(source, destination);
    }

}