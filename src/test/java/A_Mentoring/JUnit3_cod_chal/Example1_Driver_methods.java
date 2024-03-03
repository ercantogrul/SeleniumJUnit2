package A_Mentoring.JUnit3_cod_chal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Example1_Driver_methods {
     /*
    * driver.get() Methodlari
-  driver.get(String Url);     String olarak girilen Url’e gider
-  driver.getTitle();          Icinde olunan sayfanin basligini String olarak getirir
-  driver.getCurrentUrl();     Icinde olunan sayfanin Url’ini String olarak getirir
-  driver.getPageSource();     Icinde olunan sayfanin kaynak kodlarini String olarak getirir */
    /*
    //opening the target website https://www.ikea.com/
    //set expected title contains "Welcome"
    //using getTitle() to retrieve actual title.
    //get currentUrl text
    //get pageSource
     */
    //close driver

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
        driver.get("https://www.ikea.com/");
        assertTrue(driver.getTitle().contains("Welcome"));
        System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        System.out.println("driver.getPageSource() = " + driver.getPageSource());

    }
}
