package A_Mentoring;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class task3_moveToElement________ extends TestBase {
    @Test
    public void test() throws IOException, InterruptedException {
        //Goto Page: https://fmig-online.de/
        //Hower to " Unsere Mitglieder" menu
        //Click: Brot- & Backwaren link
        //Verify url:  "https://fmig-online.de/kategorie/brot-backwaren/"


        //Goto Page: https://fmig-online.de/
        driver.get("https://fmig-online.de/");
        String main = driver.getWindowHandle();

        if (driver.findElement(By.xpath("(//p[@class='_brlbs-accept'])[1]")).isDisplayed()) {
            driver.findElement(By.xpath("(//p[@class='_brlbs-accept'])[1]")).click();
        }
        Thread.sleep(2000);

        //Hower to " Unsere Mitglieder" menu
        WebElement unsereMitglieder = driver.findElement(By.id("our-members"));
        actions
                .moveToElement(unsereMitglieder).pause(2)
                .perform();

        //Click: Brot- & Backwaren link
        WebElement brot = driver.findElement(By.partialLinkText("Brot- & Backwaren"));
        brot.click();

        //Verify url:  "https://fmig-online.de/kategorie/brot-backwaren/"
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        assertTrue(driver.getTitle().contains("Food Made in Germany"));

    }
    @Test
    public void test1() throws InterruptedException {
        //Goto Page: https://fmig-online.de/
        driver.get("https://fmig-online.de/");
        driver.findElement(By.partialLinkText("Alle akzeptieren")).click();

        //Hower to " Unsere Mitglieder" menu
        Thread.sleep(2000);
        WebElement mitglieder = driver.findElement(By.id("our-members"));
        actions
                .moveToElement(mitglieder)
                .perform();

        //Click: Brot- & Backwaren link
        driver.findElement(By.partialLinkText("Brot- & Backwaren")).click();

        //Verify url:  "https://fmig-online.de/kategorie/brot-backwaren/"
        System.out.println(driver.getTitle());
        assertTrue(driver.getTitle().contains("Food"));
    }
}