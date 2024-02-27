package Selenium_JUnit.C02_JUnit_JUnitAnnotations;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforAll_AfterAll {
    static WebDriver driver;
    @BeforeAll
    public static void beforAll(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));// web elementlerinin tamaminin gelmesi icin taninan süre bu süre icinde gelmez ise TimeoutException verir
        //ama web elementleri önce de gelebilir
        System.out.println("BeforAll calisti");
    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);
    }
    @Test
    public void test02() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
    }


    @AfterAll
    public static void afterAll(){
        System.out.println("AfterAll calisti");
        driver.quit();
    }
}
