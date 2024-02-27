package A_Mentoring.JUnit1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JUnit5_AssertionMethods {
    //    Goto page https://testpages.herokuapp.com/styled/basic-html-form-test.html
//        Create webdriver object
//        1-Test userName input text.Send name
//        2-Test password input text.Send password

    static WebDriver driver;
    @BeforeAll
    public static void beforAll(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
    }
    @AfterAll
    public static void afterAll(){
        driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Ercan");
        Thread.sleep(3000);
    }
    @Test
    public void test02() throws InterruptedException {
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Ercan");
        Thread.sleep(3000);
    }
    @Test
    public void test03() throws InterruptedException {
        WebElement comment = driver.findElement(By.name("comments"));
        comment.clear();
        comment.sendKeys("Ercan");
        Thread.sleep(3000);
    }
}
