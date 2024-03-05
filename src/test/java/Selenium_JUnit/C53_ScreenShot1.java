package Selenium_JUnit;



import org.junit.jupiter.api.Test;

import utils.TestBase;


import java.io.IOException;


public class C53_ScreenShot1 extends TestBase {
    // Go to amazon.com.
    // Take Page ScreenShot.
    // Spesific WebElement ScreenShot

    // Take Page ScreenShot.
    @Test
    public void takeFullPageScreenShot() throws IOException {
        driver.get("https://www.amazon.com/");

    }

    // Spesific WebElement ScreenShot
    @Test
    public void takeSpesificWEScreenShot() throws IOException, InterruptedException {
        driver.get("https://www.amazon.com./");

    }
}

