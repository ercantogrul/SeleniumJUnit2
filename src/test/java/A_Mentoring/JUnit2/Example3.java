package A_Mentoring.JUnit2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Example3 {
    static WebDriver driver;

    @BeforeAll
    public static void setUP(){
        driver=new ChromeDriver();
        driver.get("https://practice.expandtesting.com/checkboxes");
        driver.manage().window().maximize();
    }

    @Test

    public void test1(){
        //
        WebElement c1= driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement c2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        //Eğer seçili değil ise seçtik
        if(!c1.isSelected()) {
            c1.click();
            Assertions.assertTrue(c1.isSelected());
        }

        //Seçili ise kaldırmak için tekrar clic()
        if(c2.isSelected()) { //seçili
            c2.click();//seçimi kaldırdık
            Assertions.assertFalse(c2.isSelected());//boşmu
        }

        List<WebElement> boxes=driver.findElements(By.xpath("(//input[@type='checkbox'])"));
        System.out.println(boxes.size()); //Lİste boyutu ile

        for (WebElement box : boxes) {
            if(!box.isSelected()){
                box.click();
            }
        }
        for (WebElement box : boxes) {
            if(!box.isSelected()){
               Assertions.assertTrue(false);
            }
        }




    }
    @BeforeAll
    public static void tearDown(){
        driver.quit();
    }


}

