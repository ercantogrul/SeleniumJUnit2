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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HW15_dropDown_select {
//https://demoqa.com/select-menu
//Get all the options of the dropdown
//Options size
//Print all test
//Verify the dropdown has option "Black"
//Print FirstSelectedOptionTest
//Select option "Yellow"

  static WebDriver driver;
    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/select-menu");
        if (driver.findElement(By.xpath("//button[@aria-label='İzin ver']")).isDisplayed()) {
            driver.findElement(By.xpath("//button[@aria-label='İzin ver']")).click();
        }
    }

    @AfterAll
    public static void tearDown() {
       driver.quit();
    }

    @Test
    public void selectByIndex() throws InterruptedException {
        WebElement colorElement = driver.findElement(By.xpath("//div[@id='selectMenuContainer']//*[@id='oldSelectMenu']"));
        Select select = new Select(colorElement);
        System.out.println(select.getOptions().size());//eleman sayisi

        List<WebElement> optionList = select.getOptions();
        for (WebElement option : optionList) {
            System.out.println(option.getText());
        }
        Thread.sleep(2000);

        assertEquals(select.getOptions().get(5).getText(),"Black");
        Thread.sleep(2000);

        select.selectByVisibleText("Yellow");
        System.out.println(select.getFirstSelectedOption().getText());

    }



}
