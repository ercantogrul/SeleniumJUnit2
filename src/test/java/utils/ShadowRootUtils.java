package utils;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ShadowRootUtils {
    static WebDriver driver;
    @BeforeAll
    public static void setDriver(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("http://watir.com/examples/shadow_dom.html");
    }
    public SearchContext expandRootElement (WebElement element) {
        SearchContext shadowRoot = (SearchContext) ((JavascriptExecutor) driver).executeScript (
                "return arguments[0].shadowRoot", element);
        return shadowRoot;
    }
    public String getSomeText (WebDriver driver) {
        return driver.findElement (By.cssSelector ("#shadow_content > span"))
                .getText ();
    }

    public String getShadowDomText () {
        WebElement shadowHost = driver.findElement (By.id ("shadow_host"));
        SearchContext shadowRoot = shadowHost.getShadowRoot ();
        String text = shadowRoot.findElement (By.cssSelector ("#shadow_content > span"))
                .getText ();
        return text;
    }

    public String getNestedShadowText () {
        WebElement shadowHost = driver.findElement (By.id ("shadow_host"));
        SearchContext shadowRoot = shadowHost.getShadowRoot ();
        WebElement shadowContent = shadowRoot.findElement (By.cssSelector ("#nested_shadow_host"));
        SearchContext shadowRootTwo = shadowContent.getShadowRoot ();
        String nestedText = shadowRootTwo.findElement (By.cssSelector ("#nested_shadow_content > div")).getText ();
        return nestedText;
    }

    public String getNestedText() {
        WebElement nestedText = driver.findElement (By.id ("shadow_host")).getShadowRoot ()
                .findElement (By.cssSelector ("#nested_shadow_host")).getShadowRoot ()
                .findElement (By.cssSelector ("#nested_shadow_content > div"));
        return nestedText.getText ();
    }

    public String getNestedTextUsingJSExecutor () {
        WebElement shadowHost = driver.findElement (By.id ("shadow_host"));
        SearchContext shadowRootOne = expandRootElement (shadowHost);
        WebElement nestedShadowHost = shadowRootOne.findElement (By.cssSelector ("#nested_shadow_host"));
        SearchContext shadowRootTwo = expandRootElement (nestedShadowHost);
        return shadowRootTwo.findElement (By.cssSelector ("#nested_shadow_content > div")).getText ();

    }
}
