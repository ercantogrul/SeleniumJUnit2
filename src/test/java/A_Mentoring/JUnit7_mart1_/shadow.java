package A_Mentoring.JUnit7_mart1_;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

public class shadow extends TestBase {
    //!!!!!!!!! Shadow DOM içerisinde sadece cssSelector çalışır !!!!!!!!!!!

    @Test
    public void withGetShadowRootMethod(){
        //Goto home https://www.n11.com/ //Locate "Tümünü kabul et"

        driver.get("https://www.n11.com/");

        WebElement element = driver.findElement(By.cssSelector("body > efilli-layout-dynamic")).
                getShadowRoot().findElement(By.cssSelector("div[id='480698fc-e6ac-41bc-a722-51059b783200"));

        element.click();

    }
}
