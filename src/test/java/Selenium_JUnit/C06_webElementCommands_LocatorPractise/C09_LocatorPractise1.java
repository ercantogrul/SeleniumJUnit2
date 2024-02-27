package Selenium_JUnit.C06_webElementCommands_LocatorPractise;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class C09_LocatorPractise1 {
        /*
    Create the driver with BeforeClass and make it static inside the class.
    Go to http://www.google.com
    Type "Green Mile" in the search box and print the number of results.
    Type "Premonition" in the search box and print the number of results.
    Type "The Curious Case of Benjamin Button" in the search box and print the number of results.
    Close with AfterClass.
     */
        static WebDriver driver;
    @BeforeAll
    public static void beforeAll(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @AfterAll
    public static void afterAll() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @BeforeEach
    public void beforeEach(){
        driver.navigate().to("http://www.google.com");

    }
    @AfterEach
    public void AfterEach(){
        driver.navigate().back();
    }

    @Test
    public void Atest1GreenMile() throws InterruptedException {
        if(driver.findElement(By.xpath("//div[.='Tümünü kabul et']")).isDisplayed()){
            driver.findElement(By.xpath("//div[.='Tümünü kabul et']")).click();
        }
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys("Green Mile"+Keys.ENTER);
        WebElement result = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(result.getText());

    }
    @Test
    public void Btest2Premonition() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys("Premonition"+Keys.ENTER);
        WebElement result = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(result.getText());

    }
    @Test
    public void Ctes3Benjamin() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys("The Curious Case of Benjamin Button"+Keys.ENTER);
        WebElement result = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(result.getText());

    }

}
