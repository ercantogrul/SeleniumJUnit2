package A_Hausaufgabe;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HW19_GetShadowRoot {
    /*
Go to https://www.teknosa.com/
Accept cookies with javascriptexecutor and getShadowRoot() method separately.
Do it in two methods. One method for jsexecutor and the other for getShadowRoot() method.
Accept notification.
 */

    static WebDriver driver;
    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.teknosa.com/");


    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void shadowRoot(){
        WebElement element1 = driver.findElement(By.tagName("efilli-layout-dynamic")).
                getShadowRoot().findElement(By.cssSelector("div[id='b7bca45b-4b2f-4bf7-a04a-c5b0aec83d7e']"));//asagidaki ile ayni


        WebElement element = driver.findElement(By.cssSelector("body > efilli-layout-dynamic")).
                getShadowRoot().findElement(By.cssSelector("div[id='b7bca45b-4b2f-4bf7-a04a-c5b0aec83d7e']"));

        element.click();

    }
    @Test
    public void javascriptExecutor(){

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement element = (WebElement) js.executeScript("return document.querySelector(\"body > efilli-layout-dynamic\")." +
                "shadowRoot.querySelector(\"div[id='b7bca45b-4b2f-4bf7-a04a-c5b0aec83d7e']\")");
        element.click();

        WebElement tamam = driver.findElement(By.xpath("//div[@id='button-1580496494']/div[.='Tamam']"));
        tamam.click();

    }
}
