package A_Hausaufgabe;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class not {

    /*
    Arkadaşlar ödevleri yaparken karşınıza çıkan pop up mesajlar ve çerezleri aşağıdaki yapıyla handle etmeye çalışabilirsiniz.
     */
    static WebDriver driver;

    @BeforeAll
    public static void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--accept-cookies");//çerezlerei kabul etmek için
        options.addArguments("--disable-popup-blocking");//Pop-up pencereleri engellemek için
        driver = new ChromeDriver(options);// ChromeOptions'u driver'ımıza tanıtıyoruz.
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
}
