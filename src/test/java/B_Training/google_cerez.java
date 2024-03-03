package B_Training;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utils.TestBase;

public class google_cerez extends TestBase {

    @Test
    public void test1() throws InterruptedException {
        if (driver.findElement(By.xpath("//div[.='Tümünü kabul et']")).isDisplayed()) {
            driver.findElement(By.xpath("//div[.='Tümünü kabul et']")).click();
        }
    }
}
