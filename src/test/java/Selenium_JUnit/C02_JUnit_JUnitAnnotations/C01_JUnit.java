package Selenium_JUnit.C02_JUnit_JUnitAnnotations;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_JUnit {
    /*
******JUNIT*****
* * JUnit i nicin kullaniriz ihtiyacimiz var
* ANNOTATIONS lari ve Assertions lari kullanmak icin
* bunlar testlerimize öncelik verilmesi ve raporlar sunulmasini saglar
*
Java ile en temel framework JUNit ile oluşturulabilir.
* JUnit açık kaynaklı bir birim test aracıdır ve küçük/büyük kod birimlerini test etmek için kullanılır
* JUnit testini çalıştırmak için bir sınıf nesnesi oluşturmanız veya main method tanımlamanız gerekmez.
Developerlar da unit testleri calistirmak icin kullanirlar.
Biz testlerimizi yapmak icin JUnit'in ileri sürümü olduğundan TestNG framework oluşturup kullanacagiz
* JUnit ayrıca birden çok test senaryosuna sahip Otomasyon paketini çalıştırmak için kullanılır.
*
* Test dediğimizde tek bir method veya içinde birçok class ve package barındıran bir yapı olabilir.
*  Regression Test, Smoke Test vb.
* Testmethod'u ise @Test notasyonu kullanılarak oluşturulan ve bağımsız olarak çalıştırabileceğimiz en küçük test yapısıdır.
@Test annotation : Test methodu
*


/*
JUnit, Java dilinde yazılmış bir unit test çerçevesidir. "JUnit" adı, Java için "unit test" anlamına gelir ve bu çerçeve,
yazılım geliştirme sürecinde yazılım birimlerinin (genellikle metodların) doğru çalışıp çalışmadığını test etmek için kullanılır.
 */

/*
"Framework", yazılım geliştirme sürecinde kullanılan bir yapı veya çerçeve anlamına gelir. Bir framework, genellikle belirli
bir programlama dili veya teknoloji üzerinde çalışan, belirli bir amaca hizmet eden, tekrar kullanılabilir bileşenlerden oluşan bir yapıdır.
Bu bileşenler, genellikle belirli bir işlevi gerçekleştirmek için önceden tanımlanmış işlevselliğe, kütüphanelere,
standartlara ve tasarım kalıplarına sahiptir.
 */


    static WebDriver driver;

    @Test
    public void test01(){
        /*
         //Create chrome driver.
        WebDriver driver = new ChromeDriver();

        //Maximize the window.
        driver.manage().window().maximize();

        //Sayfanın load olması için tanınan max süre
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
         */

        //Open google home page https://www.google.com/
        driver.get("https://www.google.com/");
    }
    @Test
    public void test02(){

        driver.get("https://www.facebook.com/");
    }
    @Test
    public void test03(){

        driver.get("https://www.youtube.com/");
        System.out.println(driver.getTitle());
    }
    @BeforeEach
    public void before(){
        //Create chrome driver.
        //Create chrome driver.
        driver = new ChromeDriver();

        //Maximize the window.
        driver.manage().window().maximize();

        //Sayfanın load olması için tanınan max süre
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterEach
    public void after(){
        driver.quit();
    }



}
