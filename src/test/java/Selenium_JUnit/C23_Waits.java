package Selenium_JUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class C23_Waits {
    // bazi siteler, islemeler arasında bekleme süreleri koyar. bundan dolayi bekleme methodlari kulaniriz
    // Selenium wait ler selenium icin kritik bir konsepttir. Senkronize bir sekilde elementleri bulmamizi
    // ve elementnotfound gibi hatalari almamizi engeller.

    // Implicit Wait    :tüm öğeleri kapsayan genel bir ayarlamadır. İstenilen işlemin gerçekleşmemesi durumunda exception
                        // fırlatmadan önce belirlenen süre kadar beklenilmek zorunda kalınır.
    // Explicit Wait * : tüm öğeleri kapsamayan, yalnızca belirli öğeler için kullanabildiğimiz bir wait türüdür
                       //WebDriver'a herhangi bir exception fırlatmadan önce ExpectedConditions'ları ve max sürenin aşılmasını beklemesini söylemek için kullanılır.
    // Fluent Wait  : element zaman asimina ugrayana kadar düzenli araliklarla tekrar tekrar kullanilir. belli bir süre icerisinde elemana gidip bakar,
    // yukardakiler seleniumdan geliyor
    //Thread.sleep()___ise javadan geliyor

    static WebDriver driver;
    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterAll
    public static void tearDown(){
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            System.out.println(e);
        }
        driver.quit();
    }//Close driver.

    @Test
    public void ImplicitWait () {
        driver.get("https://seleniumatfingertips.wordpress.com/");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        WebElement home = driver.findElement(By.xpath("//li[@id='menu-item-8']/a"));
//        WebElement jackin = driver.findElement(By.cssSelector("a.entry-author "));
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }
    @Test
    public void javaWait ()  {
        driver.get("https://seleniumatfingertips.wordpress.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement home = driver.findElement(By.xpath("//li[@id='menu-item-8']/a"));
        WebElement jackin = driver.findElement(By.cssSelector("a.entry-author "));
    }
    @Test
    public void pageLoadTimeOut ()  {
      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.MICROSECONDS);
        //30 sn suresince sayfanin yuklenmesini bekliyor, bu sureden sonra sayfa yuklenmezse timeOut duserek hata verir
        //sayfanin belirtilen sure kadar tamamen yuklenmesini bekler..

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @Test
    public void explicitlyWait()  {
      /*
        WebDriver'ın beklemesi gereken koşulu ve zamanı belirtir.
        Pratik olarak, WebDriverWait ve explicitly wait,
        tanımları ve kullanımları mükemmel bir şekilde eşleştiğinden eş anlamlıdır.
        //Explicit wait nasil kullanilir
        // 1- WebDriverWait objesi olustur
        // 2- wait objesinin until methoduna istedigin condition u sagla
        */

        driver.get("https://seleniumatfingertips.wordpress.com/");

       // WebElement home = driver.findElement(By.xpath("//li[@id='menu-item-8']/a"));
        WebElement seleniumDriver = driver.findElement(By.xpath("//*[@id='menu-item-738']/a"));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        //sadece sure tanimlandi, henuz aktif degil
        //15 saniye beklemek zorunda degil, eleman bulundugu anda isleme devam eder.

       // wait.until(ExpectedConditions.elementToBeClickable(home));
       // home.click();
        wait.until(ExpectedConditions.elementToBeClickable(seleniumDriver));
        seleniumDriver.click();
    }
    @Test
    public void fluentWait(){
        //neredeyse hic kullanilmaz..
        //elementleri belirlenen sure boyunca sarti saglayip saglamadigi kontrol edilir
        //sarti sagladigi anda devam edilir, saglamazsa exception firlatir..

        driver.get("https://seleniumatfingertips.wordpress.com/");
        WebElement home = driver.findElement(By.linkText("Home"));

        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))//toplam bekleme süresi sayfa ilk açıldığında
                .pollingEvery(Duration.ofSeconds(20))// YOKLAMA her 20 saniyede varlık kontrolü
                .ignoring(NoSuchElementException.class);// exceptionı görmezden gelir, veya engeller.
        //bir webelementin sayfada bulunabilmesi icin 10 sn bekle, her 20 milisanide bir varligini kontrol et
    }

}
