package A_Mentoring;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WindowType;
import utils.TestBase;

import java.util.Iterator;
import java.util.Set;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.WindowType.*;

public class WindowHandle03__ extends TestBase {
    /*
    //Open 3 window
//Every window have to 2 tabs
//get urls: https://www.tkmaxx.com/LandingPage/
            https://ikea.com
            https://facebook.com
            https://google.com
            https://linked.com
            https://flipgrid.com/

// In the Set print window handles
//Use for each loop  if title contains ikea switch to this page
     */
    @Test
    public void withGetShadowRootMethod(){

        driver.get("https://www.tkmaxx.com/LandingPage/");
        String ersteWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(TAB);
        driver.get("https://ikea.com");

        driver.switchTo().newWindow(WINDOW);
        String zweiteWindow = driver.getWindowHandle();
        driver.switchTo().window(zweiteWindow);
        driver.get("https://facebook.com");
        if (driver.findElement(By.xpath("//button[@title='Tüm çerezlere izin ver']")).isDisplayed()) {
            driver.findElement(By.xpath("//button[@title='Tüm çerezlere izin ver']")).click();
        }
        driver.switchTo().newWindow(TAB);
        String zweiteTab = driver.getWindowHandle();
        if (driver.switchTo().window(zweiteTab).getWindowHandle().equals(zweiteTab)){
            driver.switchTo().window(zweiteTab);
            driver.get("https://google.com");
            System.out.println("esit");
        }else {
            System.out.println("esit degil");
        }


        driver.switchTo().newWindow(WINDOW);
        String dritteWindow = driver.getWindowHandle();
        driver.get("https://linked.com");
        driver.switchTo().newWindow(TAB);
        driver.get("https://flipgrid.com/");
        driver.switchTo().defaultContent();


        Set<String> windowHandleSet = driver.getWindowHandles();
        for (String currentHandle : windowHandleSet) {
            System.out.println(currentHandle);
            if (driver.getTitle().toLowerCase().contains("ikea")){
                driver.switchTo().window(currentHandle);
            }
        }



    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.tkmaxx.com/LandingPage/");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://ikea.com");
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://facebook.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://google.com");
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://linked.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://flipgrid.com/");
        Set<String> setHandleList = driver.getWindowHandles();
        Iterator<String> handleList = setHandleList.iterator();
        while (handleList.hasNext()) {
            String currantHandle=handleList.next();
            System.out.println(currantHandle);
        }
        for (String s : setHandleList) {
            if(driver.switchTo().window(s).getTitle().toLowerCase().contains("ikea")){
                driver.switchTo().window(s);
                break;
            }
        }

}}

