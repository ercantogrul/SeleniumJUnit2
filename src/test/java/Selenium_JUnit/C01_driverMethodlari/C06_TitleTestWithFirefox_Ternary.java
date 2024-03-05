package Selenium_JUnit.C01_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C06_TitleTestWithFirefox_Ternary {

    /*
 Invoke FireFox Driver
 Go to https://www.youtube.com/
 Verify the page title contains the word video.
 Close the driver.

*/
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.youtube.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        System.out.println((driver.getTitle().toLowerCase().contains("video"))? "test passed" :"test failed"); //baslik ta video ismi varmi
        driver.quit();



    }
}
