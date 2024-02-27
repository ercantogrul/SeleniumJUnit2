package A_Mentoring.JUnit_cod_chal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Example3_manage_Window {
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
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));




    }
    @AfterAll
    public static void tearDown(){

     //   driver.quit();
    }//Close driver.

    @Test
    public void test1 () throws InterruptedException {
        System.out.println("sayfanın pozisyonu: " + driver.manage().window().getPosition());
        System.out.println("sayfanın ölçüleri: " + driver.manage().window().getSize());
        Thread.sleep(2000);

        driver.get("https://the-internet.herokuapp.com/geolocation");
        System.out.println("driver.manage().window().getPosition() = " + driver.manage().window().getPosition());

        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='getLocation()']"));
        button1.click();

        WebElement konumx = driver.findElement(By.xpath("//div[@id='lat-value']"));
        System.out.println("konumx.getText() = " + konumx.getText());

        WebElement konumy = driver.findElement(By.xpath("//div[@id='long-value']"));
        System.out.println("konumy.getText() = " + konumy.getText());


        WebElement buttonGoogle = driver.findElement(By.xpath("//*[@id='map-link']/a"));
        buttonGoogle.click();

        if (driver.findElement(By.xpath("//button[@aria-label='Tümünü kabul et']")).isDisplayed()) {
            driver.findElement(By.xpath("//button[@aria-label='Tümünü kabul et']")).click();
        }


        WebElement location = driver.findElement(By.xpath("//h2[@class='bwoZTb']"));
        System.out.println("location.getText() = " + location.getText());






    }
}
