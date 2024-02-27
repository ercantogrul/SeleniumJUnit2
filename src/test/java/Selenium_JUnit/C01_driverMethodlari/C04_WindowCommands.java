package Selenium_JUnit.C01_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_WindowCommands {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        driver.manage().window().maximize(); //ekrani maximize ediyor// bütün testlerimizde maximize() kullanacagiz

        System.out.println("Sayfanin Pozisyonu"+driver.manage().window().getPosition());
        System.out.println("Sayfanin Ölcüleri"+driver.manage().window().getSize());


        Thread.sleep(3000);
        driver.manage().window().minimize();//ekrani minimize ediyor
        System.out.println("Sayfanin Pozisyonu"+driver.manage().window().getPosition());
        System.out.println("Sayfanin Ölcüleri"+driver.manage().window().getSize());

        Thread.sleep(3000);
        driver.manage().window().fullscreen();//ekrani fullscreen ediyor  toolBar lar gider
        System.out.println("Sayfanin Pozisyonu"+driver.manage().window().getPosition());
        System.out.println("Sayfanin Ölcüleri"+driver.manage().window().getSize());
        Thread.sleep(3000);

        driver.quit();

    }
}
