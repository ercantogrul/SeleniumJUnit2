package B_Training;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import utils.TestBase;

public class Accept_if extends TestBase {
    @Test
    public void test(){

        if (driver.findElement(By.xpath("//*[.='Accept all & visit the site']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[.='Accept all & visit the site']")).click();
        }

    }
}
