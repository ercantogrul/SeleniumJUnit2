package A_Hausaufgabe;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class HW21_windowHandle extends TestBase {
    //Go to URL: https://demoqa.com/browser-windows
//Click on the windows - "WindowButton"
//Click on all the child windows.
//Print the text present on all the child windows in the console.
//Print the heading of the parent window in the console.

    @Test
    public void javascriptExecutor(){
     //Go to URL: https://demoqa.com/browser-windows
        driver.get("https://demoqa.com/browser-windows");
        String main = driver.getWindowHandle();
        System.out.println(main);

    //Click on the windows - "WindowButton"
        WebElement windowButton = driver.findElement(By.xpath("//*[@id='windowButton']"));
        windowButton.click();

    //Click on all the child windows.
    //Print the text present on all the child windows in the console.







    }

}
