package Selenium_JUnit.C05_xpath;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Xpath {
    //  format : //tagName[@attribute = 'value']
    // amazon.com sayfasında xpath practise yapıyoruz.
    /*
    Xpath, Absolute ve Relative olarak 2 türe ayrılır. Absolute, bir öğeyi doğrudan ve kolay bir şekilde bulabileceğiniz yoldur.
    Devtools'dan almak istediğiniz verinin copy full xpath ile yolunu alabilirsiniz.
    Absolute için tek önemli nokta, alacağınız verinin web sitesi üzerinde değişmeyecek olması.
    Relative ise DOM içerisinde almak istediğiniz veriyi tümüyle aramanızı sağlar.
    Absolute haricinde bu yol için Devtools’tan copy xpath üzerinden erişim sağlayabilirsiniz.
     */

    // /html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input
    // copy full xpath kullanmayiz cünkü bu bir elementin bir soy icerisindeki yerini verir ama Developer arada yenilik yapip araya bir element ekleye bilir

    // //*[@id="twotabsearchtextbox"]  ama bu id ile direk elementi bulmamizi saglar
    // * tagi her ne olursa olsun demek
    // id attribute ismi
    // "twotabsearchtextbox" attribute Value

    static WebDriver driver;

    @BeforeAll
    public static void beforeAll(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
        if (driver.findElement(By.xpath("//*[.='Try different image']")).isDisplayed()){  // kapca cikiyorsa "Try different image" bu ikona tikla
            driver.findElement(By.xpath("//*[.='Try different image']")).click();
        }
        // Try different image bu bilgiyi ise sayfa acilinca incele tusuna basarak "dom " ekraninda element sekmesi icerisinde buluyoruz

    }
    @AfterAll
    public static void afterAll() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void test1(){
        WebElement amzonLogo1 = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
        // tag'i a olan id attribute degeri 'nav-logo-sprites' olan webelement bul
        amzonLogo1.click();

    }

    @Test
    public void test2(){
        WebElement amzonLogo2 = driver.findElement(By.xpath("//a[@aria-label='Amazon']"));
        // tag'i a olan aria-label attribute degeri 'Amazon' olan webelement bul
        amzonLogo2.click();


    }
    @Test
    public void test3(){
        WebElement amzonLogo3 = driver.findElement(By.xpath("//a[@class='nav-logo-link nav-progressive-attribute']"));
        // tag'i a olan class attribute degeri 'nav-logo-link nav-progressive-attribute' olan webelement bul
        amzonLogo3.click();


    }
    @Test
    public void test4(){
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='field-keywords']"));
        // tag'i input olan name attribute degeri 'field-keywords' olan webelement bul

        searchBox.sendKeys("smart watch"+Keys.ENTER); // icine smart watch yaz ve enter yap
       // searchBox.submit();  // yukarda +Keys.ENTER ayni isi yapiyor


    }




}

