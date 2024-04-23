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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class C18_RadioButtons {
    /*
    Radyo düğmeleri (Radio Buttons) ve onay kutuları (Checkboxes), kullanıcıların seçenekleri belirlemesine ve
    belirli bir işlem yapmasına olanak tanıyan iki farklı form elemanıdır.
     İşlevsel olarak benzer gibi görünseler de, aralarında önemli farklar vardır:

Tek Seçim ve Çoklu Seçim:
Radyo düğmeleri, kullanıcının belirli bir listeden yalnızca bir seçeneği seçmesine izin verir.
Bir grup radyo düğmesi arasından sadece bir tanesi seçilebilir.

Onay kutuları ise kullanıcının birden fazla seçeneği işaretlemesine olanak tanır.
Birden çok onay kutusu işaretlenebilir veya işaretlenmemiş olabilir.

Görsel Temsil:
Radyo düğmeleri genellikle küçük daireler veya yuvarlaklar olarak gösterilir ve seçili olduklarında içlerine bir işaret konur.
Onay kutuları, genellikle bir kare kutu veya dikdörtgen olarak gösterilir ve işaretlendiğinde içlerine bir işaret (örneğin, onay işareti) konur.

Zorunluluk:
Radyo düğmeleri, kullanıcının bir seçim yapması gereken bir dizi seçenek sunmak için sıkça kullanılır. Genellikle bir seçenek zorunlu olmalıdır.
Onay kutuları, genellikle isteğe bağlı seçenekler için kullanılır. Kullanıcılar istedikleri seçenekleri işaretleyebilir veya işaretlemeyebilir.
Kullanım Alanı:

Radyo düğmeleri, belirli bir seçim yapılmadan önce kullanıcının diğer seçenekleri görmesi gereken durumlarda kullanılır. Örneğin, "Cinsiyet" seçimi gibi.
Onay kutuları, kullanıcının bir veya birden çok özelliği (tercihi) aktif veya pasif hale getirmesine olanak tanıyan durumlarda kullanılır.
Örneğin, bir bildirim aboneliğini etkinleştirme veya devre dışı bırakma.
     */
    /*
        Go to URL:  https://www.facebook.com/
        Click on Create an Account button.
        Then click on the radio buttons.

         */
    static WebDriver driver;

    @BeforeAll
    public static void setup() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-cookies");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebook.com/");
        if (driver.findElement(By.xpath("//button[@title='Tüm çerezlere izin ver']")).isDisplayed()) {
            driver.findElement(By.xpath("//button[@title='Tüm çerezlere izin ver']")).click();
        }
    }
    @AfterAll
    public static void tearDown(){
        driver.close();
    }//Close driver.
    @Test
    public void test() throws InterruptedException {
        WebElement newAccountButton = driver.findElement(By.xpath("//a[starts-with(@id,'u_')]"));
        newAccountButton.click();
        List<WebElement> radioButtonList = driver.findElements(By.xpath("//input[@type='radio']"));
        for (WebElement each : radioButtonList){
            if ( !each.isSelected()){
                each.click();
            }
            Thread.sleep(2000);
        }

    }

}
