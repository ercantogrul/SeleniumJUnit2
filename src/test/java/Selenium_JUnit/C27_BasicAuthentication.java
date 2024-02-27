package Selenium_JUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C27_BasicAuthentication {
       /* BasicAuthentication : Normal olarak web sitelerinde login fonksiyonu icin kullanici adi ve sifre
    webelementlerine bilgileri girip, login buttonuna basariz.
    Ancak bazi websitelerinde ve ozellikle API haberlesmesinde kullanici adi ve sifreyi manuel olarak tek
    tek girmek yerine, servis saglayicinin bize vereccegi bilgiler dogrultusunda, kulllanici adi ve sifreyi
    URL’e ekleyebiliriz.
    Boylece sayfaya gitme ve login fonksiyonu tek adimda halledilmis olur.

    Auth güvenlik nedeniyle kullanılır
    Yetkilendirmenin bir yolu, aşağıdaki sözdizimini kullanmaktır:
    https://kullanıcı adı:şifre@URL    */
    /*
    Go to URL: https://the-internet.herokuapp.com/basic_auth
    Username: admin
    Password: admin
    Syntax:  driver.get("https://USERNAME:PASSWORD@URL");
    Authenticate using the above method and test data.
    https://admin:admin@the-internet.herokuapp.com/basic_auth
    Verify the congratulations message.

     */

    static WebDriver driver;

    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1(){
        //Syntax:  driver.get("https://USERNAME:PASSWORD@URL");
        driver.get("https://the-internet.herokuapp.com/basic_auth");

    }

    @Test
    public void test2(){
        //Syntax:  driver.get("https://USERNAME:PASSWORD@URL");
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

    }
    @Test
    public void test3(){
        //Syntax:  driver.get("https://USERNAME:PASSWORD@URL");
        driver.get("");

    }
}
