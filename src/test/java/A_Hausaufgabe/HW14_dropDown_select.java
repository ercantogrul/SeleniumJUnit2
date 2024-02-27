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

public class HW14_dropDown_select {
     /*
Go to URL: https://the-internet.herokuapp.com/dropdown
Create method selectByIndexTest and Select Option 1 using index .
Create method selectByValueTest Select Option 2 by value.
Create method selectByVisibleTextTest Select Option 1 value by visible text.
Create method printAllTest Print all dropdown value.
Verify the dropdown has Option 2 text.
Create method printFirstSelectedOptionTest Print first selected option.
Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
 */

    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void selectByIndex() throws InterruptedException {
        //Create method selectByIndexTest and Select Option 1 using index .
        WebElement element = driver.findElement(By.xpath("//div[@id='content']//select[@id='dropdown']"));
        Select select = new Select(element);
        select.selectByIndex(1);
        Thread.sleep(1000);
    }

    @Test
    public void selectByValue() throws InterruptedException {
        //Create method selectByValueTest Select Option 2 by value.
        WebElement element = driver.findElement(By.xpath("//div[@id='content']//select[@id='dropdown']"));
        Select select = new Select(element);
        select.selectByValue("2");
        Thread.sleep(1000);
    }

    @Test
    public void selectByVisibleText() throws InterruptedException {
        //Create method selectByVisibleTextTest Select Option 1 value by visible
        WebElement element = driver.findElement(By.xpath("//div[@id='content']//select[@id='dropdown']"));
        Select select = new Select(element);
        select.selectByVisibleText("Option 1");
        assertEquals(select.getFirstSelectedOption().getText(), "Option 1");
        // assertTrue(select.getFirstSelectedOption().getText().contains("Option 1"));
        Thread.sleep(1000);
    }

    @Test
    public void printAll() throws InterruptedException {
        //Create method printAllTest Print all dropdown value.
        WebElement element = driver.findElement(By.xpath("//div[@id='content']//select[@id='dropdown']"));
        Select select = new Select(element);
        select.getOptions();

        List<WebElement> optionsList = select.getOptions();
        System.out.println(optionsList.size());
        for (WebElement each : optionsList) {
            System.out.println("each.getText() = " + each.getText());
        }
        Thread.sleep(2000);
    }

    @Test
    public void Verify() throws InterruptedException {
        // Verify the dropdown has Option 2 text.
        WebElement element = driver.findElement(By.xpath("//div[@id='content']//select[@id='dropdown']"));
        Select select = new Select(element);
        select.selectByVisibleText("Option 2");
        assertEquals(select.getFirstSelectedOption().getText(), "Option 2");
        Thread.sleep(2000);
    }

    @Test
    public void printFirstSelectedOptionTest() throws InterruptedException {
     //Create method printFirstSelectedOptionTest Print first selected option.
        WebElement element = driver.findElement(By.xpath("//div[@id='content']//select[@id='dropdown']"));
        Select select = new Select(element);
        select.selectByIndex(1);
        printFirstSelectedOption(select); //methoda gönderildi
        Thread.sleep(2000);
    }

    private void printFirstSelectedOption(Select select) { //methoda gönderild
        select.selectByIndex(1);
        System.out.println("________"+select.getFirstSelectedOption().getText()); // sadece Option 1 yazdirildi

        List<WebElement> element =select.getOptions(); // bütün elemanlar yazdirildi
        for (WebElement sonuc : element) {
            System.out.println("element = " + sonuc.getText());
        }
    }
    @Test
    public void dropdown() throws InterruptedException {
        //Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
        WebElement element = driver.findElement(By.xpath("//div[@id='content']//select[@id='dropdown']"));
        Select select = new Select(element);
        System.out.println(select.getOptions().size());

        if (select.getOptions().size() != 3) {
            System.out.println("Expected Is Not Equal Actual");
        }else {
            System.out.println("Expected Is Equal");
        }
        Thread.sleep(2000);
    }


}