package A_Mentoring.JUnit2;

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

import static org.junit.jupiter.api.Assertions.*;

public class Example3_RadioButton {
    /*
    //Goto https://practice.expandtesting.com/checkboxes
1-İlk checkbox ceçili değil ise seçelim
2-İkinci chekbox seçili iken seçimi kaldıralım.Seçilimi olmadığını test edelim.
3-Bu menüde toplam kaç tane check box var sayısını yazdıralım
4-En sonda tüm chekboxların seçili olduğunu for döngüsü ile kontrol edelilm.

     */
    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-cookies");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://practice.expandtesting.com/checkboxes");

    }

    @AfterAll
    public static void tearDown() {
        driver.close();
    }//Close driver.

    @Test
    public void test1() throws InterruptedException {
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='checkbox1']"));
        if (!checkbox1.isDisplayed()) {
            checkbox1.click();//sec
            assertTrue(checkbox1.isSelected());//secili mi
            Thread.sleep(3000);
        }

    }

    @Test
    public void test2() throws InterruptedException {
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@id='checkbox2']"));
        if (checkbox2.isDisplayed()) {
            checkbox2.click();//secimi kaldir
            assertFalse(checkbox2.isSelected());//bos mu
            Thread.sleep(3000);
        }
        if (!checkbox2.isSelected()) { // veya assertFalse(checkbox2.isSelected()) yerine böyle yazabiliriz
            System.out.println("CheckBox2 secili degil");
        }
    }

    @Test
    public void test3() throws InterruptedException {
        List<WebElement> boxes = driver.findElements(By.xpath("//input[@class='form-check-input']"));
        System.out.println("Toplam checkbox sayisi" + boxes.size());

        for (WebElement each : boxes) {
            if (!each.isSelected()) {
                each.click();
                assertTrue(each.isSelected());
                Thread.sleep(1000);
            }
        }
    }


}
