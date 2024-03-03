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
    public void javascriptExecutor() {
        //Go to URL: https://demoqa.com/browser-windows
        driver.get("https://demoqa.com/browser-windows");
        if (driver.findElement(By.xpath("//*[.='İzin ver']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[.='İzin ver']")).click();
        }
        String main = driver.getWindowHandle();
        System.out.println(main);


        //Click on the windows - "WindowButton"
        //Click on all the child windows.
        WebElement windowButton = driver.findElement(By.xpath("//*[@id='windowButton']"));
        windowButton.click();

        WebElement tabButton = driver.findElement(By.xpath("//*[@id='tabButton']"));
        tabButton.click();

        WebElement messageButton = driver.findElement(By.id("messageWindowButton"));
        messageButton.click();

        //Print the text present on all the child windows in the console.
        for (String s : driver.getWindowHandles()) {
            System.out.println(s);

            driver.switchTo().window(s);
            System.out.println("driver.getTitle() = " + driver.getTitle());
            if (driver.getTitle().toLowerCase().contains("demoqa.com")) {
                System.out.println("driver.findElement(By.cssSelector(\"html>body\")).getText() = " + driver.findElement(By.cssSelector("html>body")).getText());
            }
            if (driver.getTitle().contains("about:blank")) {
                System.out.println("driver.findElement(By.xpath(\"//*[@id='sampleHeading']\")).getText() = " + driver.findElement(By.xpath("//*[@id='sampleHeading']")).getText());
            }


        }
        //   Print the heading of the parent window in the console.
        driver.switchTo().window(main);
        WebElement head = driver.findElement(By.xpath("//*[@id='app']/header/a/img"));
        System.out.println("header.getText() = " + head.getText());


    }
}