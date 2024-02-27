package A_Mentoring.JUnit_cod_chal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Example3_farkli {
    /*    driver.manage().window( );Method'lari
-  driver.manage().window().maximize();    Browser'i  maximize yapar
-  driver.manage().window().minimize();    Browser'i  minimize yapar
-  driver.manage().window().fullscreen();   Browser'i full screen yapar
-  driver.manage().window().getPosition( );   Browser'in koordinatlarini verir
-  driver.manage().window().getSize( );     Browser'in olculerini verir
-  driver.manage().window().setPosition(new Point ( x:80 , y:0 ) ) ; Browser'i  istenen koordinata tasir
-  driver.manage().window().setSize(new Dimension( 800 , 600 )); Browser'i  istenen olculere getirir. */
        /*
    /*
       1- go to https://the-internet.herokuapp.com/geolocation
       2- Before get browser coordinate and write
       3- Click "Where I am buttun"
       4- Get your coordinate write
       5- Then click " See it on Google "
       6- Verify your coordinate in map
        */


    static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-cookies");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://the-internet.herokuapp.com/geolocation");
    }

    @Test
    public void test1() throws InterruptedException {
        System.out.println("Window Size = " + driver.manage().window().getSize());
        System.out.println("Position = " + driver.manage().window().getPosition());

        WebElement whereIam = driver.findElement(By.xpath("//*[@onclick='getLocation()']"));
        whereIam.click();

        WebElement loc = driver.findElement(By.xpath("//*[@id=\"lat-value\"]"));
        System.out.println("loc.getText() ilk 6 sayi = " + loc.getText().substring(0,6));
        String locString = loc.getText().substring(0,6);

        WebElement google = driver.findElement(By.xpath("//*[@id=\"map-link\"]/a"));
        google.click();
        Thread.sleep(3000);

        WebElement actualLoc = driver.findElement(By.xpath("//h2/span"));
        System.out.println("actual = " + actualLoc.getText());

        Assertions.assertTrue(actualLoc.getText().contains(locString));


    }
}
