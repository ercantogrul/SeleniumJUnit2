package Selenium_JUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utils.TestBase;

import static org.openqa.selenium.WindowType.*;

public class C34_WindowHandle2 extends TestBase {
    // 1- browser ac
    // 2- yeni sekme olustur
    // 3- yeni pencere olustur
    // 4- 2. sekmede https://www.linkedin.com/ ac
    // 5- son pencerede https://opensource-demo.orangehrmlive.com/web/index.php/auth/login sitesini ac
    // 6- Ilk sekmede https://www.amazon.com/ ac

    @Test
    public void test1() throws InterruptedException {

        String mainHandel = driver.getWindowHandle();

        // 2- yeni sekme olustur
        driver.switchTo().newWindow(TAB);
        String handelTab = driver.getWindowHandle();

        // 3- yeni pencere olustur
        driver.switchTo().newWindow(WINDOW);
        String handelWindow = driver.getWindowHandle();

        // 4- 2. sekmede https://www.linkedin.com/ ac
        driver.switchTo().window(handelTab);
        driver.get("https://www.linkedin.com/");
        System.out.println(driver.getTitle());// sayfaya gittigini ispatlamak icin

        // 5- son pencerede https://opensource-demo.orangehrmlive.com/web/index.php/auth/login sitesini ac
        driver.switchTo().window(handelWindow);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println(driver.getTitle());

        // 6- Ilk sekmede https://www.amazon.com/ ac
        driver.switchTo().window(mainHandel);
        driver.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());
        System.out.println(mainHandel);
        System.out.println(handelTab);
        System.out.println(handelWindow);

    }
}
