package Selenium_JUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import utils.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C45_Cookies extends TestBase {
    //***Cookie cookie  = driver.manage().cookie-methods

    //Go to URL: https://kitchen.applitools.com/ingredients/cookie
    //Print all the cookies.
    //Get Cookie named protein.
    //Find the total number of cookies.
    //Add Cookie.
    //Edit Cookie.
    //Delete Cookie.
    //Delete All Cookies.
    @Test
    public void test1() {
        driver.get("https://kitchen.applitools.com/ingredients/cookie");

        //Print all the cookies.
        System.out.println("_________________//Print all the cookies._________________________");

        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie c : cookies) {
            System.out.println(c);
        }

        //Get Cookie named protein.  (ismini verdigimiz cookie yazdirildi
        System.out.println("__________________//Get Cookie named protein.____________________");
        System.out.println("driver.manage().getCookieNamed(\"protein\") = " + driver.manage().getCookieNamed("protein"));

        //Find the total number of cookies.
        System.out.println("_______________//Find the total number of cookies.______________");
        System.out.println("cerez sayisi = " + cookies.size());

        //Add Cookie.
        System.out.println("_______________//Add Cookie.______________");
        Cookie newCookie = new Cookie("vitamin","Dvit");
        driver.manage().addCookie(newCookie);

        Set<Cookie> cookies1 = driver.manage().getCookies();  // yeniden yazdirdik ve eklenmis
        for (Cookie c1 : cookies1) {
            System.out.println(c1);
        }

        //Edit Cookie.
        System.out.println("_____________________________//Edit Cookie.____________________________");
        Cookie editCookie = new Cookie("vegetable","cucumber");
        driver.manage().addCookie(editCookie);
        Set<Cookie> cookies2 = driver.manage().getCookies();  // yeniden yazdirdik ve eklenmis
        for (Cookie c1 : cookies2) {
            System.out.println(c1);
        }


        //Delete Cookie.
        System.out.println("_____________________________//Delete Cookie.____________________________");
        driver.manage().deleteCookieNamed("vegetable");

        Set<Cookie> cookies3 = driver.manage().getCookies();  // yeniden yazdirdik ve eklenmis
        for (Cookie c1 : cookies3) {
            System.out.println(c1);
        }

        //Delete All Cookies.
        driver.manage().deleteAllCookies();
        Set<Cookie> cookies4 = driver.manage().getCookies();
        System.out.println("cookies4.size() = " + cookies4.size());
    }
}

