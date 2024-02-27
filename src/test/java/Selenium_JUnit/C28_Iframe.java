package Selenium_JUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C28_Iframe {
    //Go to URL: https://the-internet.herokuapp.com/iframe
    //Verify the Bolded text contains “Editor”
    //Locate the text box
    //textBox webelemetine erismek icin iframe e switch yapmamiz gerekir, aksi takdirde NoSuchElementExcepion aliriz.
    //Delete the text in the text box
    //Type “Hi everyone”
    //Verify the text Elemental Selenium text is displayed on the page.

    static WebDriver driver;

    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/iframe");
    }
    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        //Verify the Bolded text contains “Editor”
        WebElement boldText = driver.findElement(By.tagName("h3"));
        assertTrue(boldText.getText().contains("Editor"));

        //Locate the text box
        driver.switchTo().frame("mce_0_ifr");
        WebElement textBox = driver.findElement(By.tagName("p"));

        //textBox webelemetine erismek icin iframe e switch yapmamiz gerekir, aksi takdirde NoSuchElementExcepion aliriz.

        //Delete the text in the text box
        textBox.clear();

        //Type “Hi everyone”
        textBox.sendKeys("Hi everyone!");
        Thread.sleep(2000);

        //Verify the text Elemental Selenium text is displayed on the page.
        driver.switchTo().defaultContent();
        WebElement textSelenium = driver.findElement(By.linkText("Elemental Selenium"));
        assertTrue(textSelenium.isDisplayed());


    }

}
