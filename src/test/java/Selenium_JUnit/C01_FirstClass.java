package Selenium_JUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class C01_FirstClass {
    // When starting with Selenium, we first need to specify which driver to use.
    // We'll communicate with the browser via the driver.



    public static void main(String[] args) throws InterruptedException {
        // We need to create our driver object
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");

        Thread.sleep(3000);

        // With the get() method: if we want to open a website with the driver, we use the get() method of our driver object.
        // We instruct our driver to go to google.com.

        // Even if we don't redirect to any address;
        // ChromeDriver() constructor creates an empty WebDriver.

        driver.get("https://www.google.com/");

        Thread.sleep(3000);

        WebDriver driver1 = new EdgeDriver();
        driver1.get("https://www.amazon.com/");

        Thread.sleep(3000);

        WebDriver driver2 = new FirefoxDriver();
        driver2.get("https://www.google.com/");


        //driver.quit(); // This line closes all open pages in the driver (exit)

        driver.close(); // It must be added at the end of the driver class, because when this code runs, our driver closes.

        driver.get("https://www.google.com/"); // This line will throw an error.
        // If we want to open a new browser after this line, we need to assign a new value to the driver
        // and create a new driver object.


/*       Selenium WebDriver'da close() ve quit() metotları, tarayıcı oturumunu sonlandırmak için kullanılır, ancak aralarında bazı farklar vardır:

        close(): Bu metot, sadece mevcut aktif pencereyi kapatır, yani sadece o anki pencereyi kapatırken, diğer açık pencereleri etkilemez.
                Yani, birden fazla pencere açılmışsa, close() çağrıldığında sadece o pencereyi kapatır ve diğer pencereler açık kalır.

        quit(): Bu metot, tüm WebDriver oturumunu sonlandırır ve tüm açık pencereleri kapatır. Yani, quit() çağrıldığında, tarayıcı tamamen kapatılır
                ve tüm açık pencereler kapatılır. Oturumu tamamen sonlandırır ve tarayıcıyı kapatır.

        Genel olarak, tek bir pencere veya sekme ile çalışırken close() kullanılabilirken, tüm tarayıcı oturumunu sonlandırmak istendiğinde quit()
                kullanılması daha uygundur.
                */
    }
}
