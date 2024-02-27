package Selenium_JUnit.C06_webElementCommands_LocatorPractise;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C12_AbsoluteRelative {
    /*
    Go to URL: https://opensource-demo.orangehrmlive.com/
    Locate the username, password, login button using absolute xpath and relative xpath.
    */
    static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @AfterAll
    public static void afterAll() throws InterruptedException {
        driver.quit();
    }
    @Test
    public void testAbsolute() throws InterruptedException {
        WebElement usernameAbsolute = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
        usernameAbsolute.sendKeys("abc");
        Thread.sleep(2000);

        WebElement passwordAbsolute = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
        passwordAbsolute.sendKeys("xyz");
        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        loginButton.click();

    }
    @Test
    public void testRelative() throws InterruptedException {

        driver.navigate().refresh();

        WebElement usernameRelative = driver.findElement(By.xpath("//input[@name='username']"));
        usernameRelative.clear();
        usernameRelative.sendKeys("xxx");
        Thread.sleep(2000);

        WebElement passwordRelative = driver.findElement(By.xpath("//input[@name='password']"));
        passwordRelative.clear();
        passwordRelative.sendKeys("yyyy");
        Thread.sleep(2000);

        WebElement loginRelative = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
        WebElement loginRelative1 = driver.findElement(By.xpath("//button[@type='submit']"));
        loginRelative.click();


    }

}
