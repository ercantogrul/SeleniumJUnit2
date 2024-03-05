package A_Mentoring.JUnit7_mart1_;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.TestBase;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Keys_TAB_actions extends TestBase {
    /*sendKeys(): Sends a series of keys to the element
    keyUp(): Performs key release
    keyDown(): Performs keypress without release*/
    //Goto page:https://www.calculator.de/bmi-rechner.html
    //Locate:
    //Größe:168
    //Gewicht:65
    //Alter:34
    //Geschlecht:Frau
    //Click BERECHNEN
    //Verify :"Ihr BMI liegt bei 23,0 kg/m²" text
    @Test
    public void test2(){

        driver.get("https://www.calculator.de/bmi-rechner.html");
        WebElement grose = driver.findElement(By.xpath("//*[@id=\"height\"]"));
        actions
                .click(grose).sendKeys("182")
                .sendKeys(Keys.TAB)
                .sendKeys("90")
                .sendKeys(Keys.TAB)
                .sendKeys("46")
                .sendKeys(Keys.TAB)
                .sendKeys("Mann")
                .sendKeys(Keys.TAB,Keys.ENTER)
                .perform();


        WebElement verify = driver.findElement(By.xpath("//p[text()='Ihr BMI liegt bei ']"));

        String actual = verify.getText();
        String expected = "Ihr BMI liegt bei 27,2 kg/m²";

        assertTrue(actual.contains(expected));


    }
    @Test
    public void test3(){
        driver.get("https://www.calculator.de/bmi-rechner.html");
        WebElement height = driver.findElement(By.xpath("//input[@placeholder='cm']"));
        actions
                .click(height)
                .sendKeys("168")
                .perform();
        WebElement weight = driver.findElement(By.xpath("//input[@placeholder='kg']"));
        actions
                .click(weight)
                .sendKeys("65")
                .perform();
        WebElement age = driver.findElement(By.xpath("//input[@placeholder='Jahre']"));
        actions
                .click(age)
                .sendKeys("34")
                .perform();

        WebElement cinsiyet = driver.findElement(By.xpath("//select[@class='select-css']"));
        Select select = new Select(cinsiyet);
        select.selectByVisibleText("Frau");

        WebElement berechnen = driver.findElement(By.xpath("//button[@type='submit']"));
        actions
                .click(berechnen)
                .perform();

        WebElement text = driver.findElement(By.xpath("//div[@class='contentlefto']"));
        String textA= text.getText();
        assertTrue(textA.contains("Ihr"));

    }
    @Test
    public void test(){
        driver.get("https://www.calculator.de/bmi-rechner.html");

        WebElement grosse= driver.findElement(By.id("height"));
        actions.click(grosse).sendKeys("168").perform();
        //actions.sendKeys("168", Keys.ENTER);

        WebElement gewicht= driver.findElement(By.id("weight"));
        // gewicht.sendKeys("65");
        actions.click(gewicht).sendKeys("65").perform();

        WebElement alter= driver.findElement(By.id("alter"));
        // alter.sendKeys("34");
        actions.click(alter).sendKeys("34").perform();

        WebElement geschlect= driver.findElement(By.name("geschlecht"));
        Select select =new Select(geschlect);
        select.selectByVisibleText("Frau");

        WebElement berechnen= driver.findElement(By.xpath("//button[.='Berechnen']"));
        berechnen.click();

        WebElement verify= driver.findElement(By.xpath("//div[@class='contentlefto']/p[@class='text-size'] "));
        assertTrue(verify.getText().contains("Ihr BMI liegt bei "));


    }
}
