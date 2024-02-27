package A_Mentoring;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WindowHandle01_ extends TestBase {
    /*
     Example-1: How to Handle Multiple Windows in Selenium?
     Test website: http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target
     Test Scenario:
     Go to the above URL.
     Get the current window’s handle and write to the console window. It must be the first window handle.
     Locate the “Visit W3Schools.com!” link and click it.

     Get all window handles and hold them in a list.
     Write to total window handle number to the console. It must be 2.

     Switch t the second window.

     Get the current window’s handle and write to the console window. It must be a second window handle.
     Check the upper left side logo in the second window.
     Go back (Switch) to the first window.
     Get the current window’s handle and write to the console window. It must be the first window handle.
     Check the See Run Button Text. It must contain “Run >” text.
      */

    @Test
    public void withGetShadowRootMethod(){
    // Test website: http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target
        driver.get("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");

        WebElement akzept = driver.findElement(By.xpath("//div[@id='accept-choices']"));
        akzept.click();

    //Get the current window’s handle and write to the console window. It must be the first window handle.
        String mainHandle = driver.getWindowHandle();
        System.out.println(mainHandle);

        WebElement frame = driver.findElement(By.id("iframeResult")); //driver i iframe ye soktuk
        driver.switchTo().frame(frame);

    // Locate the “Visit W3Schools.com!” link and click it.
        WebElement visit = driver.findElement(By.linkText("Visit W3Schools.com!")); // iframe icindeki link i tikladik
        visit.click();

    //Get all window handles and hold them in a list.
    //Write to total window handle number to the console. It must be 2.
     //Switch t the second window.
        Set<String> windowHandleSet = driver.getWindowHandles();
        System.out.println(windowHandleSet);
        for (String s : windowHandleSet) {
            driver.switchTo().window(s);
            if (!s.equals(mainHandle)){
                driver.switchTo().window(s);  //  driver.switchTo().window(visitWindow);
                break;
            }
        }

        String second =driver.getWindowHandle();
        System.out.println(second);

        WebElement leftLogo = driver.findElement(By.id("w3-logo"));
        leftLogo.click();

        driver.switchTo().window(mainHandle);
        assertTrue(driver.getTitle().contains("Tryit"));









    }


}
