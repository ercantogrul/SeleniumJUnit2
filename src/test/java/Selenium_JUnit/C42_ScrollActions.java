
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utils.TestBase;

public class C42_ScrollActions extends TestBase {
    //Go to URL: https://www.amazon.com/
    //By using PAGE_UP, PAGE_DOWN, ARROW_UP, ARROW_DOWN
    //use actions scroll the page
    //scroll down
    //scroll up.

    @Test
    public void scrollPageUpDown() throws InterruptedException {
    driver.get("https://www.amazon.com/");

    }

    @Test
    public void scrollArrowUpDown() throws InterruptedException {
        driver.get("https://www.amazon.com/");

    }
}
