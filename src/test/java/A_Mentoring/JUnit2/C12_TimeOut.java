package MENTOR;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C12_TimeOut {
    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();

    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void timeHard() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);
    }
    @Test
    public void timeImlicit() throws InterruptedException {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @Test
    public void timeExcilit() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(button));
    }
}