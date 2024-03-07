package Selenium_JUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C31_Clear {
    //element.clear() ile texti silmedigi zaman sendKeys methodundan faydalanabilriz
    //bu durumda javanin dongulerinden yararlanilanarak text alani bosalana kadar BACKSPACE e tiklayabilirz

    static WebDriver driver;

    @BeforeAll
    public static void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().deleteAllCookies();
    }
    @AfterAll
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test() throws InterruptedException {
        //Go to URL: https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Verify the Bolded text contains “Editor”
        WebElement boldText = driver.findElement(By.tagName("h3"));
        assertTrue(boldText.getText().contains("Editor"));

        //Locate the text box
        driver.switchTo().frame("mce_0_ifr");
        WebElement textBox = driver.findElement(By.tagName("p"));

        //textBox webelemetine erismek icin iframe e switch yapmamiz gerekir, aksi takdirde NoSuchElementExcepion aliriz.

        //Delete the text in the text box
        //1.yöntem
        //textBox.clear(); //birinci yöntem

        //2.yöntem
        textBox.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE+"clear() calisiyoruz."); // ikinci yöntem
        Thread.sleep(3000);
        //textBox.sendKeys("clear() calisiyoruz."); // ikinci yöntemde

        //3.yöntem
        int times = textBox.getText().length();// ücüncü
        for (int i = 0; i < times; i++){
            textBox.sendKeys(Keys.BACK_SPACE);
            Thread.sleep(3000);
        }

    }
}