package Selenium_JUnit;

import org.junit.jupiter.api.Test;
import utils.TestBase;
import org.openqa.selenium.WindowType;

public class C33_WindowHandle1 extends TestBase {
    // driver.getWindowHandle(); -> aktif olan pencere ve sekmemizin window handle (id) degerini bize verir. String döndürür
    // driver.getWindowHandles(); -> tum pencere ve sekmelerin window handle (id) lerini bir Set olarak bize dondurur.
    // driver.switchTo().window(id); -> window handle degeri id olan pencere veya sekmeye gecis yapmamizi saglar.

    // driver.switchTo().newWindow(WindowType.TAB); -> Yeni sekme olusturur.yada
    // driver.switchTo().newWindow(TAB); -> Yeni sekme olusturur.

    // driver.switchTo().newWindow(WindowType.WINDOW); -> Yeni pencere olusturur.
    // driver.switchTo().newWindow(WINDOW); -> Yeni pencere olusturur.


    //Open browser
    //Open https://www.amazon.com/ in the open tab
    //Create new tab
    //Open https://www.linkedin.com/ in the open tab
    //Create new window
    //Open https://opensource-demo.orangehrmlive.com/web/index.php/auth/login in the window that opens

    @Test
    public void test1() throws InterruptedException {

        //Open browser
        //Open https://www.amazon.com/ in the open tab
        driver.get("https://www.amazon.com/");

        //Create new tab
        driver.switchTo().newWindow(WindowType.TAB);

        //Open https://www.linkedin.com/ in the open tab
        driver.get("https://linkedin.com");

        //Create new window
        driver.switchTo().newWindow(WindowType.WINDOW);

        //Open https://opensource-demo.orangehrmlive.com/web/index.php/auth/login in the window that opens
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");




    }
}
