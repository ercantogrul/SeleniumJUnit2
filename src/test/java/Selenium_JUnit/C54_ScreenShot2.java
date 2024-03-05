package Selenium_JUnit;



import org.junit.jupiter.api.Test;

import utils.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C54_ScreenShot2 extends TestBase {

    //Go to URL: https://opensource-demo.orangehrmlive.com/
    //Saving the image to  the path.
    //Getting screenshot of Orange HRM Logo.
    //Getting screenshot of  Orange HRM Page Section.

    @Test
    public void testScreenShot() throws IOException {
        //Go to URL: https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com/");
        //Saving the image to  the path.
        //Getting screenshot of Orange HRM Logo.
        //Getting screenshot of  Orange HRM Page Section.
    }
}

