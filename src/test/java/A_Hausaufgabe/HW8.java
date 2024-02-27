package A_Hausaufgabe;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HW8 {
    // Navigate to  https://testpages.herokuapp.com/styled/index.html
// Click on  Calculate under Micro Apps
// Type any number in the first input
// Type any number in the second input
// Click on Calculate
// Get the result
// Print the result
    static WebDriver driver;
    @BeforeAll
    public static void beforeAll() {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testpages.herokuapp.com/styled/index.html");
    }
    @AfterAll
    public static void afterAll() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        WebElement calculate = driver.findElement(By.xpath("//a[@id='calculatetest']"));
        calculate.click();

        WebElement box1 = driver.findElement(By.xpath("//input[@id='number1']"));
        box1.sendKeys("97531");
        Thread.sleep(2000);
        WebElement box2 = driver.findElement(By.id("number2"));
        box2.sendKeys("86420");
        Thread.sleep(2000);

        WebElement calculateButton = driver.findElement(By.xpath("//*[@id='calculate']"));
        calculateButton.click();
        Thread.sleep(2000);

        WebElement ergebnis = driver.findElement(By.xpath("//span[@id='answer']"));
        System.out.println(ergebnis.getText());


    }
}
