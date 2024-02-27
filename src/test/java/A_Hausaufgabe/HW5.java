package A_Hausaufgabe;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HW5 {
    static WebDriver driver;
    @BeforeAll
    public static void beforAll(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://facebook.com/");
        if (driver.findElement(By.xpath("//button[@title='Tüm çerezlere izin ver']")).isDisplayed()){
            driver.findElement(By.xpath("//button[@title='Tüm çerezlere izin ver']")).click();
        }


    }
    @AfterAll
    public static void afterAll(){
       driver.quit();
    }
    @Test
    public void testName() throws InterruptedException {
        WebElement username1= driver.findElement(By.id("email"));
        WebElement username2= driver.findElement(By.name("email"));
        WebElement username3= driver.findElement(By.className("inputtext _55r1 _6luy"));
        WebElement username4= driver.findElement(By.tagName("input"));

        username1.sendKeys("ercan");
        Thread.sleep(2000);
    }
    @Test
    public void testPassword() throws InterruptedException {
        WebElement password1= driver.findElement(By.id("pass"));
        WebElement password2= driver.findElement(By.name("pass"));
        WebElement password3= driver.findElement(By.className("inputtext _55r1 _6luy _9npi"));
        WebElement password4= driver.findElement(By.tagName("input"));

        password1.sendKeys("Ercan");
        Thread.sleep(2000);
    }
    @Test
    public void testGiris() throws InterruptedException {
        WebElement loginButton1= driver.findElement(By.id("u_0_5_n2"));
        WebElement loginButton2= driver.findElement(By.name("login"));
        WebElement loginButton3= driver.findElement(By.className("_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy"));
        WebElement loginButton4= driver.findElement(By.tagName("button"));

        loginButton1.click();
        Thread.sleep(2000);
    }
    @Test
    public void testParolaUnutma() throws InterruptedException {
        WebElement searchBox3= driver.findElement(By.className("_6ltj"));
        WebElement searchBox4= driver.findElement(By.tagName("a href"));
        WebElement link1= driver.findElement(By.linkText("facebook login"));
        WebElement link2= driver.findElement(By.partialLinkText("login"));

        driver.navigate().refresh();
        WebElement linkSifre = driver.findElement(By.linkText("Şifreni mi Unuttun?"));
        assertTrue(linkSifre.isDisplayed());
        Thread.sleep(2000);
    }
    @Test
    public void testHesapOlustur() throws InterruptedException {
        WebElement searchBox1= driver.findElement(By.id("u_0_0_pT"));
        WebElement searchBox3= driver.findElement(By.className("_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy"));
        WebElement searchBox4= driver.findElement(By.tagName("a role"));

        assertTrue(searchBox1.isDisplayed());
        Thread.sleep(3000);
    }
    @Test
    public void test06() throws InterruptedException {
      //  WebElement faceBookTitel = driver.findElement(By.cssSelector("img[src='https://static.xx.fbcdn.net/rsrc.php/y1/r/4lCu2zih0ca.svg']"));

        WebElement searchBox3 = driver.findElement(By.className("fb_logo _8ilh img"));
        WebElement searchBox4= driver.findElement(By.tagName("img"));

        assertTrue(searchBox3.isDisplayed());
        Thread.sleep(2000);


    }
}
