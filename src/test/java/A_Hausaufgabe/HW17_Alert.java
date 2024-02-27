package A_Hausaufgabe;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HW17_Alert {
    //Go to URL: http://demo.automationtesting.in/Alerts.html
//Click "Alert with OK" and click 'click the button to display an alert box:'
//Accept Alert(I am an alert box!) and print alert on console.
//Click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
//Cancel Alert (Press a Button !)
//Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
//And then sendKeys «Bootcamp» (Please enter your name)
//Finally print on console this message "Hello Bootcamp How are you today" assertion these message.

    static WebDriver driver;
    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://demo.automationtesting.in/Alerts.html");
         if (driver.findElement(By.xpath("//button[@aria-label='Consent']")).isDisplayed()){
                driver.findElement(By.xpath("//button[@aria-label='Consent']")).click();
         }
    }

    @AfterAll
    public static void tearDown() {
       driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
    //Click "Alert with OK" and click 'click the button to display an alert box:'
        WebElement allertWittOk = driver.findElement(By.xpath("//li[@class='active']/a"));
        Thread.sleep(2000);
        allertWittOk.click();


        WebElement allertBox = driver.findElement(By.xpath("//*[@id='OKTab']/button"));
        allertBox.click();
     //Accept Alert(I am an alert box!) and print alert on console.
        System.out.println("driver.switchTo().alert().getText() = " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    @Test
    public void test2() throws InterruptedException {
    //Click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        WebElement allertWithOkCancel = driver.findElement(By.xpath("(//*[.='Alert with OK & Cancel '])[1]"));
        allertWithOkCancel.click();

        WebElement confirmBox = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        confirmBox.click();

    //Cancel Alert (Press a Button !)
        System.out.println("driver.switchTo().alert().getText() = " + driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
    }
    @Test
    public void test3() throws InterruptedException {
    //Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        WebElement allertWithTextBox = driver.findElement(By.xpath("(//*[.='Alert with Textbox '])[1]"));
        allertWithTextBox.click();

        WebElement promptBox = driver.findElement(By.xpath("//*[@id='Textbox']/button"));
        promptBox.click();

    //And then sendKeys «Bootcamp» (Please enter your name)
        driver.switchTo().alert().sendKeys("Ercan");
        driver.switchTo().alert().accept();

    //Finally print on console this message "Hello Bootcamp How are you today" assertion these message.
        WebElement message = driver.findElement(By.xpath("//div[@id='Textbox']/p[@id='demo1']"));
        System.out.println("driver.switchTo().alert().getText() = " + message.getText());
        assertEquals("Hello Ercan How are you today", message.getText());

    }



}
