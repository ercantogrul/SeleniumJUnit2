package Selenium_JUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.TestBase;

public class C43_JavascriptExecutor__2 extends TestBase {
    /*
JavascriptExecutor js = (JavascriptExecutor)driver;
JavascriptExecutor kullanmak için ilk adım olarak driver’ı JavascriptExecutor interface’sine cast etmektir.
Bu interface sayesinde sayfa kaydırma işlemi ve JavaScript komutları çalıştırılabilir
En yaygın kullanılan methodu, executescript() methodudur.

executeScript - ScrollBy () web sayfasını verilen piksel değeri kadar ileri gider.
executeScript("window.scrollBy(x-piksel,y-piksel)");  ya da js.executeScript("scroll(x,y);");
x-piksel x eksenindeki sayıdır, sayı pozitifse sola, sayı negatifse sağa hareket eder.
y-piksel y eksenindeki sayıdır, sayı pozitifse ise aşağı doğru,sayı negatif ise yukarı doğru hareket eder.
js.executeScript("window.scrollBy(0,1000));  Dikey olarak 1000 piksel aşağı kaydırır.

executeScript - ScrollTo () web sayfasını verilen piksel değerine götürür.
js.executeScript("window.scrollTo(0, 0)");  tarayıcının en üstüne kaydırma işlemi gerçekleştirir.
js.executeScript("window.scrollTo(0, document.body.scrollHeight)");  tarayıcının en altına kaydırma işlemi gerçekleştirir.
js.executeScript("arguments[0].click()", element);-> elemente click yapar*****************************
scrollIntoView () web sayfasındaki bir öğenin görünürlüğüne göre kaydırır.
js.executeScript("arguments[0].scrollIntoView();",WebElement);
*/

    //Go to URL: https://api.jquery.com/dblclick/
    //scroll to bottom
    //scroll to top
    //scroll to blue square and double click it.
    //Arama kutusuna "JavascriptExecutor çogğgğgğ iyi" yazdır
    //click the "Jquery in Action" book link at the bottom with javascriptexecutor
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://api.jquery.com/dblclick/");

        JavascriptExecutor js= (JavascriptExecutor) driver;

        //scroll to bottom
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); // sayfanin altina en asagi
        Thread.sleep(2000);

        //scroll to top
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)"); // sayfanin en yukarisina gidildi
        Thread.sleep(2000);

        //scroll to blue square and double click it.
        driver.switchTo().frame(0); // index i 0 olan iframe aldik
        WebElement blueSquare = driver.findElement(By.xpath("//body/div")); //

        js.executeScript("arguments[0].scrollIntoView();", blueSquare);
        Thread.sleep(2000);
        actions.doubleClick(blueSquare).perform();
        driver.switchTo().defaultContent();

        //Arama kutusuna "JavascriptExecutor çogğgğgğ iyi" yazdır
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)"); // sayfanin en yukarisina gidildi
        WebElement searcBox = driver.findElement(By.xpath("//*[@id=\"main\"]/form/input"));
        searcBox.sendKeys("JavascriptExecutor çogğgğgğ iyi");


        //click the "Jquery in Action" book link at the bottom with javascriptexecutor
        WebElement bookImage = driver.findElement(By.xpath("//img[starts-with(@alt,\"jQuery in\")]"));
        js.executeScript("arguments[0].click();", bookImage);

    }
}

