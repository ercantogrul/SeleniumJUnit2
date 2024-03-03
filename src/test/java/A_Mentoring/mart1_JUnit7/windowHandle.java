package A_Mentoring.mart1_JUnit7;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestBase;

import java.time.Duration;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class windowHandle extends TestBase {
    //Goto website:https://koch-mit.de/
    //Click MediaMarket Link
    //Verify new tab open
    //Get WindowHandles
    //In the mediamarket website input "Samsung"
    //Click Enter verfiy: "Samsung bei MediaMarkt" text include
    //Go Back Koch website input text box pizza
    //187 Suchergebnisse gefunden für "Pizza".
    @Test
    public void test1(){
        driver.get("https://koch-mit.de/");
        WebElement alleakzeptieren = driver.findElement(By.xpath("(//p[@class='_brlbs-accept']/a[@role='button'])[1]"));
        alleakzeptieren.click();
        String main = driver.getWindowHandle();

        WebElement mediaMarkt = driver.findElement(By.xpath("(//a[@class='powered-by']/span[.='powered by MediaMarkt/Saturn'])[1]"));
        mediaMarkt.click();

        Set<String> windowHandleSet = driver.getWindowHandles();
        for (String currentHandle : windowHandleSet) {
            System.out.println(currentHandle);
            if (!currentHandle.equals(main)){
                driver.switchTo().window(currentHandle);
                WebElement mediaakzeptieren = driver.findElement(By.xpath("//*[@id=\"pwa-consent-layer-accept-all-button\"]"));
                mediaakzeptieren.click();
                WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"search-form\"]"));
                searchBox.click();
                searchBox.sendKeys("Samsung", Keys.ENTER);

                WebElement text = driver.findElement(By.xpath("//*[@color='#000000'][.='Samsung bei MediaMarkt']"));
                System.out.println("text.getText() = " + text.getText());
                assertEquals ("Samsung bei MediaMarkt",text.getText());

            }
        }

        driver.switchTo().window(main);
        System.out.println("driver.getTitle() = " + driver.getTitle());
        WebElement searchBoxKoch = driver.findElement(By.xpath("(//*[@id='q'])[2]"));
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) driver);
        jsexecutor.executeScript("arguments[0].click();", searchBoxKoch);

        searchBoxKoch.sendKeys("Pizza",Keys.ENTER);
        WebElement textPizza = driver.findElement(By.xpath(" //*[@class='col-xs-12 col-md-8']/h1"));
        String text = textPizza.getText();
        System.out.println("textPizza.getText() = " + textPizza.getText());
        assertTrue(text.contains("187 Suchergebnisse gefunden"));


    }

}
