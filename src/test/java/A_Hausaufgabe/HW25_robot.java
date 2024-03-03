package A_Hausaufgabe;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.awt.*;

public class HW25_robot extends TestBase {
    /*
Amazona gidin
robot ile sayfanın en altına gidin
"Back to top" weblementini clickleyin
javascriptexecutor ile sayfanın altındaki (footer bölümündeki logo) Amazon logosunu clickleyin (scroll yapmadan, direkt clickleyin)
Actions ile Arama kutusuna "ClarusWay" yazdırıp aratın
*/
    @Test
    public void KeyboardActions() throws InterruptedException, AWTException {
        driver.get("https://www.amazon.com/");

        if (driver.findElement(By.xpath("//a[.='Try different image']")).isDisplayed()) {
            driver.findElement(By.xpath("//a[.='Try different image']")).click();
        }

        // robot ile sayfanın en altına gidin
        Robot robot = new Robot();
        robot.mouseWheel(400);
        Thread.sleep(3000);

        //"Back to top" weblementini clickleyin

        WebElement backToTop = driver.findElement(By.xpath("//*[@id='navBackToTop']/div/span"));
        actions.moveToElement(backToTop).click(backToTop).pause(3).perform();

     // javascriptexecutor ile sayfanın altındaki (footer bölümündeki logo) Amazon logosunu clickleyin (scroll yapmadan, direkt clickleyin)
        WebElement amazonLogo= driver.findElement(By.xpath("//div[@class='nav-logo-base nav-sprite']"));

        JavascriptExecutor jsexecutor = ((JavascriptExecutor) driver);
        jsexecutor.executeScript("arguments[0].click();", amazonLogo);

      //  Actions ile Arama kutusuna "ClarusWay" yazdırıp aratın

        WebElement searchBox= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        actions.click(searchBox).sendKeys("ClarusWay").pause(2).perform();



    }

}
