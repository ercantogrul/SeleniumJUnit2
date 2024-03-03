package A_Hausaufgabe;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.TestBase;

public class HW24_KeyboardActions extends TestBase {
    //  HW24_KeyboardActions
// https://www.google.com/ u ac
// Arama kismina  keyboard Actionlarla "Scroll Methodlar"  yaz
// Büyük harfleri klavyedeki SHIFT tuşuyla yazdırınız.
    @Test
    public void KeyboardActions() throws InterruptedException {
        driver.get("https://www.google.com/");

        if (driver.findElement(By.xpath("//div[.='Tümünü kabul et']")).isDisplayed()) {
            driver.findElement(By.xpath("//div[.='Tümünü kabul et']")).click();
        }
        // Arama kismina  keyboard Actionlarla "Scroll Methodlar"  yaz
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        actions
                .click(searchBox)
                .keyDown(Keys.SHIFT)// shift tusuna bastik ilk harfi büyük yazmak icin
                .sendKeys("s")      //ilk harfi büyük yazdik
                .keyUp(Keys.SHIFT)   // shift tusunu biraktik geri kalan kismi kücük yazmak icin
                .sendKeys("croll")
                .keyDown(Keys.SPACE) // bosluk biraktik
                .keyDown(Keys.SHIFT)
                .sendKeys("m")
                .keyUp(Keys.SHIFT)
                .sendKeys("ethodlar")
                .pause(3)
                .perform();

    }
}

