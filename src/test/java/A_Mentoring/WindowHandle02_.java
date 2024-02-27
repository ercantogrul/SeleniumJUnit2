package A_Mentoring;

import org.junit.jupiter.api.Test;
import utils.TestBase;


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


    }
}
