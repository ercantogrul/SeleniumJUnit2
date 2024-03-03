package A_Mentoring.JUnit5_action;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.JavascriptUtils;
import utils.TestBase;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class maus_actions extends TestBase {
    // Go to http://szimek.github.io/signature_pad/


    @Test
    public void testSlider1() {


        driver.get("http://szimek.github.io/signature_pad/");

        WebElement tablet = driver.findElement(By.xpath("//*[@id=\"signature-pad\"]/div[1]/canvas"));


        actions
                .moveToElement(tablet)  // üstüne gidip bekledim (tiklamadim) ////move to “Hello, Sign in Account & Lists” link.
                .click()
                .dragAndDropBy(tablet,30,0)
                .dragAndDropBy(tablet,30,50)
                .dragAndDropBy(tablet,0,50)
                .dragAndDropBy(tablet,0,0)
                .release()
                .perform();





    }





}
