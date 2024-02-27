package A_Mentoring;

import org.junit.jupiter.api.Test;
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
      //  System.out.println(ersteWindow);
        driver.switchTo().newWindow(TAB);
        driver.get("https://ikea.com");

        driver.switchTo().newWindow(WINDOW);
        String zweiteWindow = driver.getWindowHandle();
       // System.out.println(zweiteWindow);
        driver.get("https://facebook.com");
        driver.switchTo().newWindow(TAB);
        driver.get("https://google.com");

        driver.switchTo().newWindow(WINDOW);
        String dritteWindow = driver.getWindowHandle();
       // System.out.println(dritteWindow);
        driver.get("https://linked.com");
        driver.switchTo().newWindow(TAB);
        driver.get("https://flipgrid.com/");


        Set<String> windowHandleSet = driver.getWindowHandles();

        for (String currentHandle : windowHandleSet) {
            System.out.println(currentHandle);
            if (driver.getTitle().contains("ikea")){
                driver.switchTo().window(currentHandle);
                System.out.println("Im Titel steht IKA");
                assertTrue((BooleanSupplier) driver.switchTo().window(currentHandle ));
            }
        }





    }

}
