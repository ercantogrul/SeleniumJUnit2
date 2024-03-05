package Selenium_JUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C49_FileUpload extends TestBase {
    //Go to URL: https://the-internet.herokuapp.com/upload
    //Find the path of the file that you want to upload.
    //Click on Upload button.
    //Verify the upload message.
    @Test
    public void fileupload() throws InterruptedException {
        //Go to URL: https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement dosyaSec = driver.findElement(By.id("file-upload"));

        //Find the path of the file that you want to upload.
        String path = System.getProperty("user.dir") + "\\src\\test\\resources\\selenium_methodlar.pdf"; // gönderilecek dosya path i
        dosyaSec.sendKeys(path); // dosyanin gönderilecegi yere path i send ettik
        Thread.sleep(3000);

        //Click on Upload button.
        driver.findElement(By.id("file-submit")).click(); // Upload yaptik

        //Verify the upload message.
        WebElement uploadedMessage = driver.findElement(By.tagName("h3"));
        assertTrue(uploadedMessage.isDisplayed());  // uploadedMessage görünüyor mu
    }
}

