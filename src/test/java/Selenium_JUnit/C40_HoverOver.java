package Selenium_JUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.TestBase;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C40_HoverOver extends TestBase {
    //Go to URL: https://www.amazon.com/
    //move to “Hello, Sign in Account & Lists” link.
    //Click on Orders page.
    //Verify the page title contains “Amazon”.

    @Test
    public void hoverOver(){
        driver.get("https://www.amazon.com/");
        driver.findElement(By.xpath("//a[.='Try different image']")).click();


    //move to “Hello, Sign in Account & Lists” link.

        WebElement signLink = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]"));
        WebElement orders = driver.findElement(By.xpath("//span[.='Orders']"));

        actions
                .moveToElement(signLink)  // üstüne gidip bekledim (tiklamadim) ////move to “Hello, Sign in Account & Lists” link.
                .click(orders)           // link icindeki orders locater ini alip tikladim
                .perform();

        //verify the page title contains "Amazon
        assertTrue(driver.getTitle().contains("Amazon"));


    }

}
