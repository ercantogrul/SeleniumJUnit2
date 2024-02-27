package Selenium_JUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.TestBase;

public class C39_DragAndDropByVertical extends TestBase {
    // Go to URL: https://foundation.zurb.com/sites/docs/v/5.5.3/components/range_slider.html
    // Shift 34 units to the up and 34 units to the down on the vertical axis.

    @Test
    public void dragSliderYaxe() throws InterruptedException {
        driver.get("https://foundation.zurb.com/sites/docs/v/5.5.3/components/range_slider.html");

    }
}
