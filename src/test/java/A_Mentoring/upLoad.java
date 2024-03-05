package A_Mentoring;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class upLoad extends TestBase {
    //Goto page: https://kitchen.applitools.com/ingredients/file-picker
    // Upload Png and verfiy "Upload Preview" txt


    @Test
    public void fileupload() throws InterruptedException {
        //Go to URL: https://kitchen.applitools.com/ingredients/file-picker
        driver.get("https://kitchen.applitools.com/ingredients/file-picker ");

        WebElement dosyaSec = driver.findElement(By.xpath("//*[@id=\"photo-upload\"]"));

        //Find the path of the file that you want to upload.
        String path = "C:\\Users\\etogr\\Downloads\\Näyttökuva 2023-08-21 224000.png"; // gönderilecek dosya path i
        dosyaSec.sendKeys(path); // dosyanin gönderilecegi yere path i send ettik
        Thread.sleep(3000);

        //Verify the upload message.
        WebElement uploadedMessage = driver.findElement(By.xpath("//img[@alt='Preview of uploaded file']"));
        assertTrue(uploadedMessage.isDisplayed());  // uploadedMessage görünüyor mu
        driver.quit();
    }
}
