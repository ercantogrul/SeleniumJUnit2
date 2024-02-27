package A_Mentoring.JUnit2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Example8_allert {
    // Goto page https://testpages.herokuapp.com/styled/alerts/alert-test.html
    //1-Click "Show Alert Box button
    //2-Handle warning alert
    //3-Get allert message
    //4-After accept() alert verify "You triggered and handled the alert dialog" text
    //5-Click Show confirm button
    //6-Get allert message
    //7-Dismiss alert
    //8-After dismiss() alert verify "YYou clicked Cancel, confirm returned false." text

    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");

    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        //1-Click "Show Alert Box button
        WebElement showAllertBox = driver.findElement(By.id("alertexamples"));
        showAllertBox.click();
        //3-Get allert message
        System.out.println("driver.switchTo().alert().getText() = " + driver.switchTo().alert().getText());
        Thread.sleep(2000);
        //2-Handle warning alert
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        //4-After accept() alert verify "You triggered and handled the alert dialog" text
        WebElement text=driver.findElement(By.xpath("(//p[@class='inline-explanation'])[1]"));
        assertTrue(text.getText().contains("You triggered and handled the alert dialog"));
    }
    @Test
    public void test2() throws InterruptedException {
        //5-Click Show confirm button
        WebElement showConfirmBox = driver.findElement(By.id("confirmexample"));
        showConfirmBox.click();
        Thread.sleep(2000);
        driver.switchTo().alert().getText();
        driver.switchTo().alert().dismiss();
    }
    @Test
    public void test3() throws InterruptedException {
        WebElement showPromptBox = driver.findElement(By.id("promptexample"));
        showPromptBox.click();
        Thread.sleep(2000);
        System.out.println("driver.switchTo().alert().getText() = " + driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("Hello");
        driver.switchTo().alert().accept();


    }



}
