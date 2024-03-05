package A_Mentoring;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class downLoadFile extends TestBase {
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://autopract.com/selenium/download.html");

        WebElement downLoadFile = driver.findElement(By.xpath("//*[@id=\"download\"]"));
        downLoadFile.click();

        String indirilenlerPath = "C:\\Users\\etogr\\Downloads\\";
        Thread.sleep(5000);
        String dosyaAdi = "sample2.csv";

        String path = indirilenlerPath + dosyaAdi;

        Thread.sleep(6000);

        assertTrue(Files.exists(Paths.get(path))); //bu dosya var mi


    }


}