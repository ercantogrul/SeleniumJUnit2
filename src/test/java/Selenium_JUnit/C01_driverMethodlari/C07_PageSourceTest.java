package Selenium_JUnit.C01_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C07_PageSourceTest {
    /*
     Go to the Amazon URL: https://www.amazon.com/
     Verify that it writes "Performance Metrics" and "Gateway" from the Source code.
    */
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        String word1 = "performance metrics";
        String word2 = "gateway";
        String pageSource = driver.getPageSource().toLowerCase();

        System.out.println((pageSource.contains(word1) || pageSource.contains(word2))? "PASSED" : "FAILED");  // kaynak kodlarinda bu 2 kelime varmi
        driver.quit();


    }
}
