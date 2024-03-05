package Selenium_JUnit.C01_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_WindowCommands {
    public static void main(String[] args) throws InterruptedException {
        /*
        WebDriver driver = new ChromeDriver();

        // Pencereyi maksimum boyuta getir
        driver.manage().window().maximize();
        // Pencereyi minimize boyuta getir
        driver.manage().window().minimize();
        // Pencereyi fullscreen yapar
        driver.manage().window().fullscreen();

        System.out.println("Sayfanin Pozisyonu"+driver.manage().window().getPosition());  // Browser in koordinatlarini verir
        System.out.println("Sayfanin Ölcüleri"+driver.manage().window().getSize());       // Browser in ölcülerini verir

         // Browser'i istenen ölcülere  tasir
        driver.manage().window().setSize(new Dimension(800, 600));
        // Browser'i istenen koordinata tasir
        driver.manage().window().setPosition(new Point(100, 100));

        // istenen sayfa acilincaya kadar maximum bekleme süresini belirtir
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

         driver.close(): Bu metot, sadece mevcut aktif pencereyi kapatır, yani sadece o anki pencereyi kapatırken, diğer açık pencereleri etkilemez.
                Yani, birden fazla pencere açılmışsa, close() çağrıldığında sadece o pencereyi kapatır ve diğer pencereler açık kalır.

        driver.quit(): Bu metot, tüm WebDriver oturumunu sonlandırır ve tüm açık pencereleri kapatır. Yani, quit() çağrıldığında, tarayıcı tamamen kapatılır
                ve tüm açık pencereler kapatılır. Oturumu tamamen sonlandırır ve tarayıcıyı kapatır.

         */

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
