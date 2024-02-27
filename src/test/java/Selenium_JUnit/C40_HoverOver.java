
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.TestBase;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C40_HoverOver extends TestBase {
    //Go to URL: https://www.amazon.com/
    //Click on “Hello, Sign in Account & Lists” link.
    //Click on Orders page.
    //Verify the page title contains “Amazon”.

    @Test
    public void hoverOver(){
        driver.get("https://www.amazon.com/");

    }
}
