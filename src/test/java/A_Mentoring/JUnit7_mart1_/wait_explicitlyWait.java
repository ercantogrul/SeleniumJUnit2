package A_Mentoring.JUnit7_mart1_;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestBase;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class wait_explicitlyWait extends TestBase {
  /*
  1) Open the browser
  2) Enter the URL “https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html”
  3)1 + 3
  4) ... should be 4, wait for it
   */
    @Test
    public void test1() throws InterruptedException {

        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));

        WebElement button= driver.findElement(By.xpath("//span[.='1']"));
        wait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();

        WebElement buttonplus= driver.findElement(By.xpath("//span[.='+']"));
        wait.until(ExpectedConditions.elementToBeClickable(buttonplus));
        buttonplus.click();

        WebElement buttonthree= driver.findElement(By.xpath("//span[.='3']"));
        wait.until(ExpectedConditions.elementToBeClickable(buttonthree));
        buttonthree.click();

        WebElement buttonEqual= driver.findElement(By.xpath("//span[.='=']"));
        wait.until(ExpectedConditions.elementToBeClickable(buttonEqual));
        buttonEqual.click();

        WebElement screen= driver.findElement(By.xpath("//div[@class='screen']"));
        wait.until(ExpectedConditions.visibilityOf(screen));
        System.out.println("screen.getText() = " + screen.getText());

    }
    @Test
    public void test3(){
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        // 1 + 3
        int a= (int) Math.random()+9;
        int b= (int) Math.random()+9;
        driver.findElement(By.xpath("//span[text()='"+a+"']")).click();
        driver.findElement(By.xpath("//span[text()='+']")).click();
        driver.findElement(By.xpath("//span[text()='"+b+"']")).click();
        driver.findElement(By.xpath("//span[text()='=']")).click();

        // ... should be 4, wait for it
//        driver.findElement(By.id("delay")).clear();
//        driver.findElement(By.id("delay")).sendKeys("5");// siteye bekleme kazandırmak
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));// elementi görebilmek
        wait.until(ExpectedConditions.textToBe(By.className("screen"), String.valueOf((a+b))));

    }
    @Test
    public void impiliciteWait() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));

        WebElement eins = driver.findElement(By.xpath("(//span[@class='btn btn-outline-primary'])[7]"));
        wait.until(ExpectedConditions.elementToBeClickable(eins)); // bir elementini bulana kadar 4 saniye icinde bekle
        eins.click();


        WebElement plus = driver.findElement(By.xpath("(//span[@class='operator btn btn-outline-success'])[4]"));
        wait.until(ExpectedConditions.elementToBeClickable(plus));
        plus.click();

        WebElement drei = driver.findElement(By.xpath("//span[.='3']"));
        wait.until(ExpectedConditions.elementToBeClickable(drei));
        drei.click();

        WebElement equals = driver.findElement(By.xpath("//span[.='=']"));
        wait.until(ExpectedConditions.elementToBeClickable(drei));
        equals.click();

        driver.quit();
    }
}
