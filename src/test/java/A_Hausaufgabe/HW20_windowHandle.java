package A_Hausaufgabe;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class HW20_windowHandle extends TestBase {
    //Go to URL: https://the-internet.herokuapp.com/windows
//Verify the text: "Opening a new window"

//Verify the title of the page is "The Internet"
//Click on the "Click Here" button
//Verify the new window title is "New Window"
//Go back to the previous window and then verify the title: "The Internet"

    @Test
    public void javascriptExecutor(){
    //Go to URL: https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");
        String main = driver.getWindowHandle();
        System.out.println(main);


        //Verify the text: "Opening a new window"
        WebElement window = driver.findElement(By.xpath("//*[@id='content']/div/h3"));
        System.out.println("window.getText() = " + window.getText());
        assertEquals("Opening a new window", window.getText());

    //Verify the title of the page is "The Internet"
        System.out.println("driver.getTitle() = " + driver.getTitle());
        assertFalse(driver.getTitle().contains("New Window"));

    //Click on the "Click Here" button
        WebElement clickHere = driver.findElement(By.xpath("//*[@id='content']/div/a"));
        clickHere.click();

        Set<String> windowHandleSet = driver.getWindowHandles();
        for (String s : windowHandleSet) {
            System.out.println(s);
            if (!s.equals(main)){
                driver.switchTo().window(s);
            }

        }
     //Go back to the previous window and then verify the title: "The Internet"
        driver.switchTo().window(main);
        assertTrue(driver.getTitle().contains("The Internet"));






    }


}
