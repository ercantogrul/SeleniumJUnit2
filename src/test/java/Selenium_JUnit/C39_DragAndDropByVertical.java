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

        WebElement verticalSlider = driver.findElement(By.xpath("(//div[@class='range-slider vertical-range']/span)[1]"));

        // y ekseninde asagi dogru  + yukari dogru - dir

        actions.dragAndDropBy(verticalSlider,0,-34).perform();// yukari dogru 34 birim tasi
        Thread.sleep(2000);
        actions.dragAndDropBy(verticalSlider,0,34).perform();// asagi dogru 34 birim tasi

    }
    @Test
    public void dragSliderYaxe2() throws InterruptedException {
        driver.get("https://foundation.zurb.com/sites/docs/v/5.5.3/components/range_slider.html");

        WebElement verticalSlider = driver.findElement
                (By.xpath("//div[starts-with(@class,\"small\")]/div[@class='range-slider vertical-range']/span[@role='slider']"));
        actions
                .dragAndDropBy(verticalSlider,0,-34)
                .perform();

        Thread.sleep(3000);
        actions
                .dragAndDropBy(verticalSlider,0,34)
                .perform();

    }
}
