package A_Mentoring.JUnit2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Example5_DropDown {
  //  https://formstone.it/components/dropdown/demo/

    static WebDriver driver;

    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://formstone.it/components/dropdown/demo/");
    }
    @AfterAll
    @Disabled
    public static void tearDown(){
        driver.quit();
    }//Close driver.

    @Test
    public void test() throws InterruptedException {
        WebElement label = driver.findElement(By.xpath("//*[@id='demo_label']"));
        Select select = new Select(label);

        select.selectByValue("CA");
        select.selectByIndex(4);
        select.selectByVisibleText("California");
        assertTrue(select.getFirstSelectedOption().getText().contains("California"));



        List<WebElement> options=select.getOptions();
        System.out.println("Options Size = " + options.size());

        for (WebElement each : options) {
            System.out.println("Option = " + each.getText());
        }
    }
    @Test
    public void test2()  {
        WebElement multi = driver.findElement(By.xpath("//*[@id='demo_multiple']"));
        Select select = new Select(multi);
        select.selectByIndex(2);
        assertTrue(select.getFirstSelectedOption().getText().contains("Three"));
    }

}
