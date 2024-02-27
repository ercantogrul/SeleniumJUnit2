package A_Hausaufgabe;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HW16 {
  //  n11'e git basic auth ile giriş yapınız.
  static WebDriver driver;
    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.n11.com/");

    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void selectByIndex() throws InterruptedException {



    }

}
