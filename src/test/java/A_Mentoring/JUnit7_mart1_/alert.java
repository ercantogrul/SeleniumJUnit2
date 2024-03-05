package A_Mentoring.JUnit7_mart1_;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class alert extends TestBase {
     /*
     https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html adresine gidin
     Launch alert buttonuna tıklayın
     Alert pop-up textin <Hello world!> olduğunu doğrulayın
    */

    @Test
    public void withGetShadowRootMethod() throws InterruptedException {

        driver.get("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");

        WebElement alert = driver.findElement(By.xpath("//*[@id=\"my-alert\"]"));
        alert.click();
        Thread.sleep(3000);

        String text =  driver.switchTo().alert().getText();
        System.out.println(text);
        assertEquals("Hello world!", text);

        driver.switchTo().alert().accept();
        driver.quit();


    }
}
