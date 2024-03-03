package A_Mentoring.JUnit4_windowHandle;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class windowHandle01 extends TestBase {

    @Test
    public void test() {
        String handleFirstTab = driver.getWindowHandle();
        System.out.println("handleFirstTab = " + handleFirstTab);

        driver.get("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");

        if (driver.findElement(By.xpath("//*[.='Accept all & visit the site']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[.='Accept all & visit the site']")).click();
        }

        driver.switchTo().frame("iframeResult");
        WebElement link = driver.findElement(By.xpath("//a[.='Visit W3Schools.com!']"));
        link.click();

        Set<String> windowHandleSet = driver.getWindowHandles();
        Iterator<String> i = windowHandleSet.iterator();
        String currentHandle = "";
        while (i.hasNext()) {
            currentHandle = i.next();
            if (!currentHandle.equals(handleFirstTab)) {
                driver.switchTo().window(currentHandle);
            }
            System.out.println(currentHandle);
        }

        WebElement logo = driver.findElement(By.id("w3-logo"));
        logo.click();
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
        driver.switchTo().window(handleFirstTab);
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
        WebElement button = driver.findElement(By.xpath("//button[.='Run ❯']"));
        System.out.println("button.getText() = " + button.getText());
        assertTrue(button.getText().contains("Run"));
    }
}