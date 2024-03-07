package A_Hausaufgabe;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import utils.TestBase;

import java.awt.*;
import java.util.Set;

public class HW26_Cookies extends TestBase {
    /*
    Go to URL: http://facebook.com
    getCookies,
    addCookie,
    deleteCookieNamed,
    deleteAllCookies
 */

    @Test
    public void KeyboardActions() throws InterruptedException, AWTException {
        driver.get("http://facebook.com");
        if (driver.findElement(By.xpath("//button[@title='Tüm çerezlere izin ver']")).isDisplayed()) {
            driver.findElement(By.xpath("//button[@title='Tüm çerezlere izin ver']")).click();
        }

    //getCookies,
        System.out.println("__________________getCookies__________________________________________________");
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie);
        }
        System.out.println("cookies.size = " + cookies.size());

        System.out.println("__________________getCookies__________________________________________________");
        driver.manage().getCookies().forEach(t-> System.out.println(t));
        System.out.println("driver.manage().getCookies().size() = " + driver.manage().getCookies().size());

        System.out.println("_______________________Add Cookie____________________________________________");
        //Add Cookie.
        Cookie addCookie = new Cookie("Baum","Olivenbaum");
        driver.manage().addCookie(addCookie);

        Set<Cookie> cookies2 = driver.manage().getCookies();
        for (Cookie cookie : cookies2) {
            System.out.println(cookie);
        }

        //   Delete Cookie.
        System.out.println("_______________________Delete Cookie____________________________________________");
        driver.manage().deleteCookieNamed("Baum");
        Set<Cookie> cookies3 = driver.manage().getCookies();
        for (Cookie cookie : cookies3) {
            System.out.println(cookie);
        }

        //Delete All Cookies.
        System.out.println("_______________________Delete All Cookies____________________________________________");
        driver.manage().deleteAllCookies();
        Set<Cookie> cookies4 = driver.manage().getCookies();
        System.out.println("cookies4.size() = " + cookies4.size());

    }
}
