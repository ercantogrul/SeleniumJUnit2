package A_Mentoring.JUnit1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnit7_ {
    //http://www.automationpractice.pl/index.php

    static WebDriver driver;
    @BeforeAll
    public static void beforAll(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://www.automationpractice.pl/index.php");
    }
    @AfterAll
    public static void afterAll(){
        driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
        WebElement sign = driver.findElement(By.xpath("//*[@class='login']"));
       // WebElement sign2 = driver.findElement(By.xpath("//*[contains(@class,'login')]"));
       // WebElement sign3 = driver.findElement(By.xpath("//*[starts-with(@class,'login')]"));
        sign.click();
        Thread.sleep(2000);

        WebElement emailBox = driver.findElement(By.xpath("//*[@id='email_create']"));
       // WebElement emailBox2 = driver.findElement(By.xpath("//input[contains(@id,'email_create')]"));
        emailBox.sendKeys("abc");
        emailBox.submit();
        Thread.sleep(2000);


       // WebElement text = driver.findElement(By.xpath("//div[@id='create_account_error']"));
        WebElement text = driver.findElement(By.xpath("//*[contains(text(),' email address.')]"));
        System.out.println(text.getText());
        assertEquals("Invalid email address.",text.getText());



    }
}
