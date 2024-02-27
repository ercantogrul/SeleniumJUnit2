package A_Mentoring.JUnit2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example4 {
    static WebDriver driver;

    @BeforeAll
    public static void setUP(){
        driver=new ChromeDriver();
        driver.get("https://www.etsy.com/?ref=lgo");
        driver.manage().window().maximize();
    }

    @Test
    public void test1(){
        WebElement link= driver.findElement(By.xpath("(//p[contains(text(),'Personalized Gifts')])[1]"));
        link.click();

    }

}
