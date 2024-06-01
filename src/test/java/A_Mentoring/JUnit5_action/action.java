package A_Mentoring.JUnit5_action;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

public class action extends TestBase {
    // Goto https://selenium08.blogspot.com/2020/01/click-and-hold.html
    //Click and hold C letter (C harfine tıklayıp basılı tutun)
    //Locate Search Box click and hold after release()
    @Test
    public void test(){
        driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");


        WebElement anladim = driver.findElement(By.xpath("//*[@id=\"cookieChoiceDismiss\"]"));
        anladim.click();

        WebElement c = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[3]"));
       actions.clickAndHold(c).pause(3).release().perform();

        WebElement searchBox = driver.findElement(By.xpath("//div[@class='search-expand-text']"));
        actions.clickAndHold(searchBox).release().perform();




    }

}
