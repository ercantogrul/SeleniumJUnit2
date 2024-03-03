package A_Mentoring.JUnit5_action;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class dragAndDrop extends TestBase {
    //Goto page:Goto page: https://demo.guru99.com/test/drag_drop.html
//First Manel Test Application
//Darg and drop values related space
//After Succesfully moved
//Verify Perfect

    @Test
    public void test(){
        //  Go to URL: http://demo.guru99.com/test/drag_drop.html
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        // iframe de bulunan cerezler handle edildi
        WebElement iframe = driver.findElement(By.xpath("//*[@id=\"gdpr-consent-notice\"]"));
        driver.switchTo().frame(iframe);
        if (driver.findElement(By.xpath("//*[@id=\"save\"]/span[1]/div/span")).isDisplayed()) {
            driver.findElement(By.xpath("//*[@id=\"save\"]/span[1]/div/span")).click();
        }

        WebElement bankaBox = driver.findElement(By.xpath("//*[@id=\"credit\"]/a"));
        WebElement bankaBoxneuerOrt = driver.findElement(By.xpath("//*[@id=\"bank\"]/li"));
        actions.dragAndDrop(bankaBox, bankaBoxneuerOrt).perform();

        WebElement salesBox = driver.findElement(By.xpath("//*[@id=\"credit0\"]/a"));
        WebElement salesBoxneuerOrt = driver.findElement(By.xpath("//*[@id=\"loan\"]/li"));
        actions.dragAndDrop(salesBox, salesBoxneuerOrt).perform();

        WebElement funfTBox = driver.findElement(By.xpath("(//*[@id=\"fourth\"]/a)[1]"));
        WebElement funfTBoxneuerOrt = driver.findElement(By.xpath("//*[@id=\"amt7\"]/li"));
        actions.dragAndDrop(funfTBox, funfTBoxneuerOrt).perform();

        WebElement funfTBox2 = driver.findElement(By.xpath("(//*[@id=\"fourth\"]/a)[2]"));
        WebElement funfTBox2neuerOrt = driver.findElement(By.xpath("//*[@id=\"amt8\"]/li"));
        actions.dragAndDrop(funfTBox2, funfTBox2neuerOrt).perform();

        // Verify the visibility of Perfect text.
        WebElement perfectText = driver.findElement(By.xpath("(//*[@id=\"equal\"]/a)[1]"));
        assertTrue(perfectText.isEnabled());





    }

}
