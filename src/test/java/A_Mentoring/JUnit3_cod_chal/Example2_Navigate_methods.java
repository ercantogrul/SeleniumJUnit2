package A_Mentoring.JUnit3_cod_chal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Example2_Navigate_methods {
    /*
  1-Navigate to page: https://www.ikea.com/
    And verify title: contains Welcome
  2-Navigate to page:https://www.ikea.com/global/en/newsroom/
    And verify title: contains "Newsroom"
  3-Navigate back:https://www.ikea.com/
    verify title:contains Welcome
  4-Navigate forward:https://www.ikea.com/global/en/newsroom/
    verify title: contains "Newsroom"
  5-Refresh page:
    verify title: contains "Newsroom"
   */

    static WebDriver driver;
    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterAll
    public static void tearDown(){

        driver.quit();
    }//Close driver.

    @Test
    public void test1 () {
        driver.navigate().to("https://www.ikea.com/");
        assertTrue(driver.getTitle().contains("Welcome"));

        driver.navigate().to("https://www.ikea.com/global/en/newsroom/");
        assertTrue(driver.getTitle().contains("Newsroom"));


       // 3-Navigate back:https://www.ikea.com/
        driver.navigate().back();

       // verify title:contains Welcome
        assertTrue(driver.getTitle().contains("Welcome"));

      //  4-Navigate forward:https://www.ikea.com/global/en/newsroom/
        driver.navigate().forward();
       // verify title: contains "Newsroom"
        assertTrue(driver.getTitle().contains("Newsroom"));

      //  5-Refresh page:
        driver.navigate().refresh();

      //  verify title: contains "Newsroom
        assertTrue(driver.getTitle().contains("Newsroom"));



    }

}
