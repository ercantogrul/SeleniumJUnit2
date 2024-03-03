package A_Mentoring.JUnit5_action;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.JavascriptUtils;
import utils.TestBase;

public class dragAndDropBy extends TestBase {
    /*
    //Goto website: https://www.garantibbva.com.tr/krediler/kredi-hesaplama
    //Locate Slider
    // goto x:30 y:0 position
    //Wait 1 sn
    //Goto x:150 y:0 position

     */

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.garantibbva.com.tr/krediler/kredi-hesaplama");
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        WebElement icon = driver.findElement(By.xpath("(//span[@class='icon'])[1]"));
        actions.dragAndDropBy(icon, 30, 0).pause(2).dragAndDropBy(icon, 150, 0).perform();


    }
    @Test
    public void testSlider1() {

        driver.get("https://www.garantibbva.com.tr/krediler/kredi-hesaplama");
        actions.sendKeys(Keys.PAGE_DOWN).pause(1000).perform();
        actions.sendKeys(Keys.PAGE_UP).pause(1000).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        WebElement slider= driver.findElement(By.xpath("(//span[@class='icon'])[1]"));
        JavascriptUtils.scrollIntoViewJS(driver,slider);
        actions.clickAndHold(slider).moveToElement(slider,100,0).perform();
        actions.dragAndDropBy(slider,30,0).
                pause(1000).
                dragAndDropBy(slider,140,0).
                perform();
        actions.release(slider).perform();



        WebElement element= driver.findElement(By.xpath("//strong[@class='js-calc__total']"));
        System.out.println("element.getText() = " + element.getText());


    }


}

