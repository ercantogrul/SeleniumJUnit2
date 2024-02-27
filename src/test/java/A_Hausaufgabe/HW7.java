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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HW7 {
    /*
//https://id.heroku.com/login sayfasına gidiniz.
//Bir mail adresi giriniz.
//Bir password giriniz.
//Login butonuna tıklayınız.
//"There was a problem with your login." text görünür ise "Kayıt Yapılamadı" yazdırınız.
//Eğer yazı görünür değilse "Kayıt Yapıldı" yazdırınız.
//Tüm sayfaları kapatınız.
 */

    static WebDriver driver;
    @BeforeAll
    public static void beforeAll() {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://id.heroku.com/login");
        if (driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).isDisplayed()){
            driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        }
    }
    @AfterAll
    public static void afterAll() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        WebElement emailBox = driver.findElement(By.xpath("//*[@id='email']"));
        emailBox.sendKeys("abc@gmail.com");

        WebElement passwortBox = driver.findElement(By.xpath("//input[@id='password']"));
        passwortBox.sendKeys("abc123");

        WebElement loginBox = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']"));
        loginBox.click();

        WebElement textCikan= driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
        System.out.println(textCikan.getText());
        String text= "There was a problem with your login.";

        if(text.equals(textCikan.getText())){
            System.out.println("kayit yapilamadi");
        }else {
            System.out.println("Kayıt Yapıldı");
        }


    }
}
