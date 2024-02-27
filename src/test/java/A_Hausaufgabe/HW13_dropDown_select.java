package A_Hausaufgabe;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HW13_dropDown_select {
          /*
    Launch the browser.
    Open "https://demoqa.com/select-menu".
    Select the Standard Multi-Select using the element id.
    Verifying that the element is multi-select.
    Select 'Opel' using the index and deselect the same using index.
    Select 'Saab' using value and deselect the same using value.
    Deselect all the options.
    Close the browser.
     */
          static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/select-menu");
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }//Close driver.

    @Test
    public void test1() throws InterruptedException {
        WebElement colorElement = driver.findElement(By.xpath("//div[@id='selectMenuContainer']//*[@id='oldSelectMenu']"));
        Select select = new Select(colorElement);
        assertTrue(select.isMultiple());
        select.selectByValue("red");
        Thread.sleep(2000);
        select.selectByValue("1");
        Thread.sleep(2000);
        select.selectByValue("2");
        Thread.sleep(2000);
        select.selectByIndex(4);
        select.selectByIndex(5);
        select.selectByVisibleText("White");
        select.selectByVisibleText("Voilet");

    }

    @Test
    public void test2() throws InterruptedException {
        WebElement autoElement = driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-12']//*[@id='cars']"));
        Select select = new Select(autoElement);
        assertTrue(select.isMultiple());
        select.selectByValue("opel");
        Thread.sleep(3000);
        select.deselectByValue("opel");
        Thread.sleep(3000);
        select.selectByValue("saab");
        Thread.sleep(3000);
        select.deselectByValue("saab");
        Thread.sleep(3000);
        select.deselectAll();
        Thread.sleep(3000);
    }

}
