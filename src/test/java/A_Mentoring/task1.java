package A_Mentoring;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class task1 extends TestBase {
    //Goto İkas Page: https://ikas.com/
//Handle Cookies
//Scroll down page (Use Javascript)
//Select Language Almanca
//Click "Devam" button
// Verify Title

    @Test
    public void test() throws IOException {
        driver.get("https://ikas.com/");
        if (driver.findElement(By.xpath("//*[.='Accept all cookies']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[.='Accept all cookies']")).click();
        }

        WebElement box = driver.findElement(By.xpath("//div[@class='sc-jOhDuK jcwFHU']"));
        box.click();
        WebElement sprachen = driver.findElement(By.xpath("//div[.='Englisch']"));
        sprachen.click();

        WebElement weiter = driver.findElement(By.xpath("//div[@class='sc-bUbCnL dhGkhX']"));
        weiter.click();
        System.out.println("driver.getTitle() = " + driver.getTitle());
        assertTrue(driver.getTitle().contains("ikas | New Generation E-Commerce"));
        driver.quit();

    }


}
