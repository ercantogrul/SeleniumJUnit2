package A_Mentoring.JUnit2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class Example2_RelativeLocator {
    //Relative Locative
    /*
    * Types of relative locators:

above(target): Locates an element directly above the target element.
below(target): Locates an element directly below the target element.
toLeftOf(target): Locates an element directly to the left of the target element.
toRightOf(target): Locates an element directly to the right of the target element.
near(target): Locates an element within a certain distance (in pixels) from the target element.*/

//Bir webelement baz alınarak etrafındaki diğer web elemenler locate edilebilir.

    // 1-Goto clarusway home page
    // 2-Cybersecurity linkini baz alarak solundaki AWS linkini locate ediniz.
    // 3-Linkin üzerinde "AWS & DEVOPS" yazısını doğrulayın
    // 4-Cybersecurity linkini baz alarak yukarıdaki  Take Our Quiz and Find Your Ideal Career metnini locate edin ve doğrulayın
    // 5- Cybersecurity linkini baz alarak yan taraftaki görselin varlığını test edin
static WebDriver driver;
    @BeforeAll
    public static void setUP(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://clarusway.com/");
    }
    @AfterAll
    public static void tearDown(){
        driver.close();
    }//Close driver.

    @Test
    public void relativeLocator(){
        //Önce Baz alacağımız web elemenyt locate edilmeli
        WebElement cyberlink= driver.findElement(By.xpath("(//span[.='Cybersecurity'])[1]"));
        //Sol tarafındaki link i locate etme
        WebElement aws=driver.findElement(RelativeLocator.with(By.tagName("a")).toLeftOf(cyberlink));
        assertTrue(aws.getText().contains("AWS"));

        WebElement text=driver.findElement(RelativeLocator.with(By.tagName("b")).above(cyberlink));
        assertTrue(text.getText().contains(" Ideal Career"));
        WebElement picture=driver.findElement(RelativeLocator.with(By.xpath("//div[@data-id='7a3b91a2']")).near(cyberlink));
        assertTrue(picture.isDisplayed());


    }

}
