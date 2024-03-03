package A_Mentoring.JUnit5_action;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.JavascriptUtils;
import utils.TestBase;

public class hower extends TestBase {
    @Test
    public void testSlider() {
        driver.get("https://www.garantibbva.com.tr/krediler/kredi-hesaplama");
        WebElement krediler = driver.findElement(By.xpath("//a[@role='menuitem']//span[.='Krediler']"));
        actions.moveToElement(krediler).perform();

        WebElement bonus = driver.findElement(By.xpath("(//*[.='Avans Hesap'])[1]"));
        bonus.click();

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
