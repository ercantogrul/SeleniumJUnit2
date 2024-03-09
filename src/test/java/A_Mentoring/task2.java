package A_Mentoring;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class task2 extends TestBase {
    @Test
    public void test() throws IOException {
        // Step 1: Go to the URL
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        String main = driver.getWindowHandle();

// driver.findElement(By.id("accept-choices")).click();
        if (driver.findElement(By.xpath("//*[@id='accept-choices']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[@id='accept-choices']")).click();
        }

   // Step 2: Switch to the iframe containing the "Try it" button
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
        driver.switchTo().frame(iframe);
        
// Locate and click the "Try it" button
        WebElement try_it = driver.findElement(By.xpath("//button[@onclick='myFunction()']"));
        try_it.click();

// Step 3: Switch to the new window that opened
        Set<String> windowHandleSet = driver.getWindowHandles();
        for (String currentHandle : windowHandleSet) {
            System.out.println(currentHandle);
            if (!currentHandle.equals(main)){
                driver.switchTo().window(currentHandle);
            }
        }

        // Step 4: Switch back to the original window by using the window handle
        driver.switchTo().window(main);


    }
    @Test
    public void test1() throws InterruptedException {
        //Go to the above URL.
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        String currentHandle = driver.getWindowHandle();
        //cerezler icin
        driver.findElement(By.id("accept-choices")).click();

        // Step 2: Switch to the iframe containing the "Try it" button
        WebElement iframe = driver.findElement(By.xpath("//*[@id=\"iframeResult\"]"));

        // Locate and click the "Try it" button
        driver.switchTo().frame(iframe);
        WebElement tryIt = driver.findElement(By.xpath("//button[.='Try it']"));
        tryIt.click();

        // Step 3: Switch to the new window that opened
        /*List<String> handles = new ArrayList<>(driver.getWindowHandles());
        for (String string : handles) {
            if (driver.getWindowHandle().equals(string)) {
                driver.switchTo().window(string);
            }
        }*/
        // Step 4: Switch back to the original window by using the window handle
        driver.switchTo().window(currentHandle);

    }

}
