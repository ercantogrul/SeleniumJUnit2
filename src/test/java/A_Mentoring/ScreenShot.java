package A_Mentoring;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot extends TestBase {
    @Test
    public void testScreenShot () throws IOException {
        //Create methods in TestBase class
        //getFullscreenShoot
        //getSpecificScreenShoot
        //Get Clarus page full screen shoot
        //Get Specific Web Element scrren Shoot




        driver.get("https://clarusway.com/");
        getFullscreenShoot(driver);

        WebElement element= driver.findElement(By.xpath("(//div[@class='elementor-widget-wrap'])[1]"));
        getSpecificScreenShoot(element);









    }
}
