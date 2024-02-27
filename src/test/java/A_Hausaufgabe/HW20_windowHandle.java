package A_Hausaufgabe;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.TestBase;

public class HW20_windowHandle extends TestBase {
    //Go to URL: https://the-internet.herokuapp.com/windows
//Verify the text: "Opening a new window"
//Verify the title of the page is "The Internet"
//Click on the "Click Here" button
//Verify the new window title is "New Window"
//Go back to the previous window and then verify the title: "The Internet"

    @Test
    public void javascriptExecutor(){
        driver.get("https://the-internet.herokuapp.com/windows");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement element = (WebElement) js.executeScript("return document.querySelector(\"body > efilli-layout-dynamic\")." +
                "shadowRoot.querySelector(\"div[id='b7bca45b-4b2f-4bf7-a04a-c5b0aec83d7e']\")");
        element.click();

        WebElement tamam = driver.findElement(By.xpath("//div[@id='button-1580496494']/div[.='Tamam']"));
        tamam.click();

    }


}
