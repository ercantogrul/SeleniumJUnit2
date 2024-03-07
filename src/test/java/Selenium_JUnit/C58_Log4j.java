package Selenium_JUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

public class C58_Log4j extends TestBase {

    //Go to URL: https://healthunify.com/bmicalculator/
    //Entring weight
    //Selecting kilograms
    //Selecting height in feet
    //Selecting height in inchs
    //Clicking on calculate
    //Getting SIUnit value
    //Getting USUnit value
    //Getting UKUnit value
    //Getting overall description

    private static final Logger logger = LogManager.getLogger(C58_Log4j.class);

    public void test() {
        logger.info("Go to URL");
        driver.get("https://healthunify.com/bmicalculator/");
        logger.info("Website is opened");

        logger.info("Entering weight");
        WebElement weight = driver.findElement(By.xpath("//input[@name='wg']"));
        weight.sendKeys("84");

        logger.info("Selecting kilograms");
        driver.findElement(By.name("opt1")).sendKeys("kilograms");

        logger.info("Selecting height in feet");
        driver.findElement(By.name("opt2")).sendKeys("5");

        logger.info("Selecting height in inches");
        driver.findElement(By.name("opt3")).sendKeys("6");

        logger.info("Clicking on calculate button");
        driver.findElement(By.xpath("//input[@name='cc']")).click();

        logger.info("Getting SIUnit value");
        String SIUNIT = driver.findElement(By.name("si")).getAttribute("value");
        System.out.println("SIUNIT = " + SIUNIT);

        logger.info("Getting USunit value");
        String USUNIT = driver.findElement(By.name("us")).getAttribute("value");
        System.out.println("USUNIT = " + USUNIT);

        logger.info("Getting UKunit value");
        String UKUNIT = driver.findElement(By.name("uk")).getAttribute("value");
        System.out.println("UKUNIT = " + UKUNIT);

        logger.info("Getting overall description");
        String desc = driver.findElement(By.name("desc")).getAttribute("value");
        System.out.println("desc = " + desc);

        logger.info("Test is ending");
        logger.error("Categories Dropdown sayfa ilk yüklenirken sikinti cikariyor, o yüzden bir kere refresh yapmak gerekir. Eger yinede ...vb");

    }

}

