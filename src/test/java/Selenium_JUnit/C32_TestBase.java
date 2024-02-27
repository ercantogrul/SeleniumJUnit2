package Selenium_JUnit;

import org.junit.jupiter.api.Test;
import utils.TestBase;

public class C32_TestBase extends TestBase {

    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        System.out.println(driver.getTitle());
    }

    @Test
    public void test2(){
        driver.get("https://www.amazon.com./");
        System.out.println(driver.getTitle());
    }

    @Test
    public void test3(){
        driver.get("https://www.google.com./");
        System.out.println(driver.getTitle());
    }
}