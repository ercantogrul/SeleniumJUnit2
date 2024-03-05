package Selenium_JUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C13_DynamicXpath {
     /*
    interview larda dinamik eleman nedir ? ne nasıl bulursunuz ?
   Sayfa yenilendiğinde id ler veya locator lar değişiyorsa buna dinamik eleman denir.
   Aşağıdaki fonksiyonlar ile bulunur.

   Özet Bilgi
    u_0_f7
    u_1_f7
    u_2_f7
    u_3_f7
    u_4_f7
    u_6_f7

    u_ başlıyor
    _f7 bitiyor

    a[id^='u_'][id$='_f7']


    CSS de
    ^ -> ile başlayan
    $ -> ile biten
    * -> içinde geçen

    cssSelector("input[id^='u_'][id$='_b2']   cssSelector("input[id^='u_'][id$='_Wd']

    Xpath
    //a[starts-with(@id,'u_')] -> ile başlayan
    //a[ends-with(@id,'_f7')]    -> ile biten
    //a[contains(@id,'u_')]    -> içinde geçen

    text element
    //tagname[.='textmetin']
    //*[.='textmetin']
    //*[text()='textmetin']
    //*[contains(text()='textmetin')]

     */

    static WebDriver driver;

    @BeforeAll
    public static void setup() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--accept-cookies");//çerezlerei kabul etmek için
        options.addArguments("--disable-popup-blocking");//Pop-up pencereleri engellemek için
        driver = new ChromeDriver(options);// ChromeOptions'u driver'ımıza tanıtıyoruz.

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);
    }
    @AfterAll
    public static void tearDown(){
        driver.close();
    }//Close driver.
    @Test
    public void test(){
        WebElement usernameBox = driver.findElement(By.xpath("//input[starts-with(@placeholder,'E-posta')]"));
        usernameBox.sendKeys("abc@gmail.com");

        WebElement passwordBox = driver.findElement(By.xpath("//input[contains(@data-testid,'pass')]"));
        passwordBox.sendKeys("abc123");

        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Yap')]"));
        loginButton.click();



    }
    @Test
    public void test2(){
        WebElement usernameBox = driver.findElement(By.xpath("//form[starts-with(@id,'u_')]//input[contains(@placeholder,'Telefon')]"));
        // burada / (isareti) birinci derece cocuk demek__ // (isareti) alt soydaki bütün cocuklari ifade eder
        //parentdan asagi dogru inerek child bir elementi 1 of 1 olarak bulmak
        usernameBox.sendKeys("abc@gmail.com");

        WebElement passwordBox = driver.findElement(By.xpath("//div[@id='reg_pages_msg']/preceding-sibling::div//input[@id='pass']"));
        //cocuktan atasina yukyri giderek___yukari giderken / veya // ile birinci veya bütün atalari ifade eder"/preceding-sibling::div" bu syntax kullanilir
        // bu syntax kullanilmaz ise alt soyu ifade eder
        passwordBox.sendKeys("abc123");

        WebElement loginButton = driver.findElement(By.xpath("//*[@class='_6ltg']/button[@type='submit']"));
        ////div[@class='_6luv _52jv']//button[@name='login']
        loginButton.click();






    }

}
