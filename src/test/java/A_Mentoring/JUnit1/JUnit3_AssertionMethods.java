package A_Mentoring.JUnit1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnit3_AssertionMethods {
     /*
Invoke FireFox Driver
Go to https://www.youtube.com/
Maximize the window
Verify the page title contains the word video.
Minimize the window
Verify the page title contains the word video.
Make the page fullscreen
Close the driver.
 */

    static WebDriver driver;
    @BeforeAll
    public static void beforAll(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com/");


    }
    @AfterAll
    public static void afterAll(){
        driver.quit();
    }
    @Test
    public void test01() {
        assertTrue(driver.getTitle().contains("video"));
        driver.manage().window().minimize();
    }
    @Test
    public void test02() {
        assertTrue(driver.getTitle().contains("video"));;
        driver.manage().window().fullscreen();
    }



}
