package Selenium_JUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.TestBase;

public class C42_ScrollActions___1 extends TestBase {
 //Go to URL: https://www.ebay.com/
//By using PAGE_UP, PAGE_DOWN, ARROW_UP, ARROW_DOWN Keys and moveToElement() method
//use actions scroll the page
//scroll down
//scroll up.

    @Test
    public void scrollPageUpDown() throws InterruptedException {
    driver.get("https://www.ebay.com/");
//        WebElement acceptAll = driver.findElement(By.xpath("//*[@id=\"gdpr-banner-accept\"]"));
//        acceptAll.click();

        actions.sendKeys(Keys.PAGE_DOWN).perform();  // sayfayi asaga sürükledik
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();  // sayfayi asaga sürükledik
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();  // sayfayi asaga sürükledik
        Thread.sleep(1000);

        actions.sendKeys(Keys.PAGE_UP).perform();  // sayfayi yukari sürükledik
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_UP).perform();  // sayfayi yukari sürükledik
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_UP).perform();  // sayfayi yukari sürükledik
        Thread.sleep(1000);

    }

    @Test
    public void scrollArrowUpDown() throws InterruptedException {
        driver.get("https://www.ebay.com/");
        actions.sendKeys(Keys.ARROW_DOWN).perform();  // ok tusuyla sayfayi asagi sürükledik
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();  //ok tusuyla sayfayi asagi sürükledik
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();  // ok tusuyla sayfayi asagi sürükledik
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();  // ok tusuyla sayfayi asagi sürükledik
        Thread.sleep(1000);

        actions.sendKeys(Keys.ARROW_UP).perform();  // ok tusuyla sayfayi yukari sürükledik
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_UP).perform();  // ok tusuyla sayfayi yukari sürükledik
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_UP).perform();  // ok tusuyla sayfayi yukari sürükledik
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_UP).perform();  // ok tusuyla sayfayi yukari sürükledik
        Thread.sleep(1000);

    }

    @Test
    public void scrollMoveToElement() throws InterruptedException {
        driver.get("https://www.ebay.com/");

        WebElement facebookIcon = driver.findElement(By.xpath("//a[@class='thrd gf-i']"));
        actions.moveToElement(facebookIcon).click(facebookIcon).perform();
    }
}
