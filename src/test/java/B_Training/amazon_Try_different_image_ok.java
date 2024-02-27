package B_Training;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utils.TestBase;

public class amazon_Try_different_image_ok extends TestBase {
    @Test
    public void test1() throws InterruptedException {
        driver.findElement(By.xpath("//a[.='Try different image']")).click();
        Thread.sleep(3000);
    }


}
