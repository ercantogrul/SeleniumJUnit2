package A_Mentoring;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utils.TestBase;

import java.util.Set;


public class WindowHandle02_ extends TestBase {
    //Goto page: https://www.tkmaxx.com/LandingPage/
//After goto page locate : TK Maxx Deutschland
//Click link goto new page
//Get current url
//after get curret url back to home page
//Open new Window
//And open Deutcland url(get the before)

    @Test
    public void withGetShadowRootMethod(){
        driver.get("https://www.tkmaxx.com/LandingPage/");
        String main = driver.getWindowHandle();

        //After goto page locate : TK Maxx Deutschland
        WebElement TkMaxxDeut = driver.findElement(By.xpath("(//li[@class='store-item col col-md-6'])[2]"));
        //Click link goto new page
        TkMaxxDeut.click();

        WebElement akzeptieren = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
        akzeptieren.click();

        Set<String> windowHandleSet = driver.getWindowHandles();
        for (String currentHandle : windowHandleSet) {
            System.out.println(currentHandle);
            if (!currentHandle.equals(main)){
                driver.switchTo().window(currentHandle);
            }
        }
        //Get current url
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        String deut= driver.getWindowHandle();
        //after get curret url back to home page
        driver.navigate().back();
        System.out.println("driver.getCurrentUrl() back = " + driver.getCurrentUrl());

        //Open new Window
        driver.switchTo().newWindow(WindowType.WINDOW);

        //And open Deutcland url(get the before)
        driver.switchTo().window(deut);
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());


    }
}
