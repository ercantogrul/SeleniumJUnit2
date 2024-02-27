package A_Mentoring.JUnit2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Example9_BasicAuthentication {
    //Goto page https://authenticationtest.com/
    //Click Basic HTTP/NTLM Authentication
    //user: user   pass:pass use authentication
    //verify succes login


    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://authenticationtest.com/");

    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://authenticationtest.com/");
        WebElement httpBox = driver.findElement(By.xpath("//div[@class='card-body']//a[.='HTTP/NTLM Auth']"));
        httpBox.click();
        Thread.sleep(3000);
        driver.get("https://user:pass@authenticationtest.com/HTTPAuth/");
        Thread.sleep(3000);

        WebElement verify = driver.findElement(By.xpath("//*[.='Login Success']"));
        assertTrue(verify.isDisplayed());
        Thread.sleep(3000);



    }


}
