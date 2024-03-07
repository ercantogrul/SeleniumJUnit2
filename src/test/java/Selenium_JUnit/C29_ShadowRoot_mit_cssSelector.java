package Selenium_JUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C29_ShadowRoot_mit_cssSelector {
    //!!!!!!!!! Shadow DOM içerisinde sadece cssSelector çalışır !!!!!!!!!!!
    //!!!!!!!!! Shadow DOM içerisinde sadece cssSelector çalışır !!!!!!!!!!!
    /*
    Shadow DOM, web bileşenlerinin içeriğini ve stili kapsüllenmiş bir şekilde tutmak için kullanılan bir web standartıdır. Selenium ile Shadow DOM içindeki
    öğeleri bulmak ve etkileşimde bulunmak için, önce Shadow DOM'a erişmeniz gerekir. Bunun için JavaScriptExecutor kullanabilirsiniz. İşte bir örnek:

    **tek ShadowRoot
    WebElement tumunuKabulEt =driver.findElement(By.tagName("efilli-layout-dynamic")).getShadowRoot().
                             findElement(By.cssSelector("div[id='480698fc-e6ac-41bc-a722-51059b783200']"));
        tumunuKabulEt.click();

    **ic ice ShadowRoot
    WebElement target =driver.findElement(By.id("shadow_host")).  // ilk shadow_host u bulduk icine girdir (ilk shadow_host un dis cercevesi-baglanti noktasi)
                getShadowRoot(). //ilk shadow_host icindeki ShadowRoot a gidildi
                findElement(By.cssSelector("div[id='nested_shadow_host']")). // ve oranda ikinci shadow_host u bulduk ve icine girdik
                getShadowRoot(). // ikinci shadow_host un icindeki ShadowRoot a ulastik
                findElement(By.cssSelector("div>div")); // oaradanda istedigimiz elemana ulastik ve webelemana aktarildi.
                daha sonra bu webelementi istersek yazdirir istersek tiklariz

     */


    static WebDriver driver;

    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().deleteAllCookies();
        driver.get("http://watir.com/examples/shadow_dom.html");
    }
    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void withGetShadowRootMethod(){
        WebElement target =driver.findElement(By.id("shadow_host")).  // ilk shadow_host u bulduk icine girdir (ilk shadow_host un dis cercevesi-baglanti noktasi)
                getShadowRoot(). //ilk shadow_host icindeki ShadowRoot a gidildi
                findElement(By.cssSelector("div[id='nested_shadow_host']")). // ve oranda ikinci shadow_host u bulduk ve icine girdik
                getShadowRoot(). // ikinci shadow_host un icindeki ShadowRoot a ulastik
                findElement(By.cssSelector("div>div")); // oaradanda istedigimiz elemana ulastik ve webelemana aktarildi.
        System.out.println(target.getText());
    }
    @Test
    public void javascriptExecutor(){
        JavascriptExecutor js = (JavascriptExecutor)driver;

        //shadowRoot.querySelector().shadowRoot.querySelector()........ şeklinde istediğimiz nested shadow DOM'a ulaşabiliriz.
        //querySelector() metodu findElement() metodu gibi çalışır.
        //.shadowRoot komutu #shadowRoot yapısınaulaşmak için kullanılır.

        WebElement nestedText = (WebElement) js.executeScript("return document.querySelector(\"div[id='shadow_host']\")" +
                ".shadowRoot.querySelector(\"div[id='nested_shadow_host']\").shadowRoot.querySelector(\"div > div\")");
        System.out.println(nestedText.getText());


        WebElement someText = (WebElement) js.executeScript("return document.querySelector(\"div[id='shadow_host']\").shadowRoot.querySelector(\"span>span\")");
        WebElement someText1 = (WebElement) js.executeScript("return document.querySelector(\"div[id='shadow_host']\")"+"shadowRoot.querySelector(\"span>span\")"); //yukardaki ile ayni
        System.out.println(someText.getText());
    }

}