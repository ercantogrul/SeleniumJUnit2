package Selenium_JUnit.C01_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class C01_FirstClass {

    // When starting with Selenium, we first need to specify which driver to use.
    // We'll communicate with the browser via the driver.

    public static void main(String[] args) throws InterruptedException {

        // We need to create our driver object
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");  //amazon sayfasina gider

        Thread.sleep(3000);  //3 saniye bekle // exception firlattigi icin signitor a throws InterruptedException yazmaliyiz

        // With the get() method: if we want to open a website with the driver, we use the get() method of our driver object.
        // We instruct our driver to go to google.com.
        // Even if we don't redirect to any address;
        // ChromeDriver() constructor creates an empty WebDriver.

        driver.get("https://www.google.com/");
        Thread.sleep(3000);
        driver.get("https://www.google.com/");
        Thread.sleep(3000);
        WebDriver driver1 = new EdgeDriver();
        driver1.get("https://www.amazon.com/");

        //driver.close();  // close methodu= son sayfayi kapatiyor sonra driver obje sini siliyor
        //close methodu= ayrica ayni browser dan birden cok sayfa acildiysa sadece sonuncu sayfayi kapatiyor
        //driver1.close();
        driver.quit(); //methodu= tüm sayfalari kapatiyor sonra driver obje sini siliyor
        driver1.quit();

        driver.get("https://www.google.com/");
        //driver.quit(); // This line closes all open pages in the driver (exit)

        driver.close(); // It must be added at the end of the driver class, because when this code runs, our driver closes.

        // driver.get("https://www.google.com/"); // This line will throw an error..
        // If we want to open a new browser after this line, we need to assign a new value to the driver
        // and create a new driver object.



    }






}
