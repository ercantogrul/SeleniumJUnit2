package A_Mentoring.JUnit6_Cookies;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.util.Set;

public class cookies extends TestBase {
    //https://www.rossmann.de/de/
    // GEt cookies
    // Find the total number
    // Add Cookies
    // Edit Cookies
    // Delete Cookies
    // Delete All Cookies

    @Test
    public void withGetShadowRootMethod(){
        //Goto home https://www.rossmann.de/de/

        driver.get("https://www.rossmann.de/de/");
        WebElement akzeptieren = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
        akzeptieren.click();

        Set<Cookie> cookies2 = driver.manage().getCookies();
        for (Cookie c1 : cookies2) {
            System.out.println(c1);
        }

        // Find the total number
        System.out.println("cookies2.size() = " + cookies2.size());


        //Add Cookie.
        System.out.println("_______________//Add Cookie.______________");
        Cookie newCookie = new Cookie("Deutsch","Rossman");
        driver.manage().addCookie(newCookie);
        System.out.println("*************************************");// for euch ile

        for (Cookie cookie : driver.manage().getCookies()) {
            System.out.println(cookie);
        }
        System.out.println("*********************************");// lambda ile
        driver.manage().getCookies().forEach(t-> System.out.println(t));
        System.out.println("***************************************");
        Set<Cookie> cookies1 = driver.manage().getCookies();
        for (Cookie c1 : cookies1) {
            System.out.println(c1);
        }

        //Edit Cookie.
        System.out.println("_____________________________//Edit Cookie.____________________________");
        Cookie editCookie = new Cookie("ROUTE","NEU");
        driver.manage().addCookie(editCookie);
        Set<Cookie> cookies3 = driver.manage().getCookies();  // yeniden yazdirdik ve eklenmis
        for (Cookie c1 : cookies2) {
            System.out.println(c1);
        }

        //Delete Cookie.
        System.out.println("_____________________________//Delete Cookie.____________________________");
        driver.manage().deleteCookieNamed("OptanonConsent");

        Set<Cookie> cookies4 = driver.manage().getCookies();
        for (Cookie c1 : cookies4) {
            System.out.println(c1);
        }

        //Delete All Cookies.
        System.out.println("____//Delete All Cookies.______");
        driver.manage().deleteAllCookies();
        Set<Cookie> cookies5 = driver.manage().getCookies();
        System.out.println("deleteAll = " + cookies5.size());




    }
}
