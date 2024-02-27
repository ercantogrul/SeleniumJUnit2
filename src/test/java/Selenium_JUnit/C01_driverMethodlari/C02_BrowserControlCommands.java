package Selenium_JUnit.C01_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_BrowserControlCommands {
    public static void main(String[] args) {
           /*
           Selenium automates browsers. That's it!
           What you do with that power is entirely up to you.
           */


        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/"); // talep edilen siteyi getirir.

        //getTitle() returns the title of the current tab. It returns a String.
        //getTitle() geçerli sekmenin başlığını döndürür. Bir String döndürür.
        String googleTitle = driver.getTitle(); // sitenin basligini getirir.
        System.out.println(googleTitle);

        //getCurrentURL() returns the URL of the current tab. It returns a String.
        //getCurrentURL() geçerli sekmenin URL'sini döndürür. Bir String döndürür.
        String googleURL = driver.getCurrentUrl();  // URL yi getirir
        System.out.println(googleURL);

        // getPageSource() retrieves the source HTML code of the current page. It returns a String.
        //getPageSource() geçerli sayfanın kaynak HTML kodunu alır. Bir String döndürür.
        String googlePageSource = driver.getPageSource(); // kaynak kodlari getirir
        System.out.println(googlePageSource);

    }

}
