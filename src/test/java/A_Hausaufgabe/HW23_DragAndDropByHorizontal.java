package A_Hausaufgabe;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

public class HW23_DragAndDropByHorizontal extends TestBase {
    /*
Go to URL: http://demo.guru99.com/test/drag_drop.html
Drag and drop the BANK button to the Account section in DEBIT SIDE
Drag and drop the SALES button to the Account section in CREDIT SIDE
Drag and drop the 5000 button to the Amount section in DEBIT SIDE
Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
Verify the visibility of Perfect text.
*/
    @Test
    public void javascriptExecutor() {
        //  Go to URL: http://demo.guru99.com/test/drag_drop.html
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        // iframe de bulunan cerezler handle edildi
        WebElement iframe = driver.findElement(By.xpath("//*[@id=\"gdpr-consent-notice\"]"));
        driver.switchTo().frame(iframe);
        if (driver.findElement(By.xpath("//*[@id=\"save\"]/span[1]/div/span")).isDisplayed()) {
            driver.findElement(By.xpath("//*[@id=\"save\"]/span[1]/div/span")).click();

        }

        //Drag and drop the BANK button to the Account section in DEBIT SIDE
        WebElement bankaBox = driver.findElement(By.xpath("//*[@id=\"credit2\"]/a"));
        WebElement bankaBoxneuerOrt = driver.findElement(By.xpath("//*[@id=\"bank\"]/li"));
        actions.dragAndDrop(bankaBox, bankaBoxneuerOrt).perform();

        //Drag and drop the SALES button to the Account section in CREDIT SIDE
        WebElement salesBox = driver.findElement(By.xpath("//*[@id=\"credit1\"]/a"));
        WebElement salesBoxneuerOrt = driver.findElement(By.xpath("//*[@id=\"loan\"]/li"));
        actions.dragAndDrop(salesBox, salesBoxneuerOrt).perform();

       // Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        WebElement funfTBox = driver.findElement(By.xpath("(//*[@id=\"fourth\"]/a)[1]"));
        WebElement funfTBoxneuerOrt = driver.findElement(By.xpath("//*[@id=\"amt7\"]/li"));
        actions.dragAndDrop(funfTBox, funfTBoxneuerOrt).perform();

      //  Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
        WebElement funfTBox2 = driver.findElement(By.xpath("(//*[@id=\"fourth\"]/a)[2]"));
        WebElement funfTBox2neuerOrt = driver.findElement(By.xpath("//*[@id=\"amt8\"]/li"));
        actions.dragAndDrop(funfTBox2, funfTBox2neuerOrt).perform();


       // Verify the visibility of Perfect text.
        WebElement perfectText = driver.findElement(By.xpath("(//*[@id=\"equal\"]/a)[1]"));
        System.out.println("perfectText.getText() = " + perfectText.getText());


    }
}