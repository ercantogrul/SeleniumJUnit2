package Selenium_JUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C36_Actions_maus_KlavyeHareketleri extends TestBase {
        /*
Mouse Actions
click(): Geçerli konumu tıklamak için kullanılır.
doubleClick(): Fare konumuna çift tıklama gerçekleştirmek için kullanılır.
clickAndHold(): Fare tıklamasını serbest bırakmadan gerçekleştirmek için kullanılır.
contextClick(): Geçerli fare konumuna sağ fare tıklaması gerçekleştirmek için kullanılır.
moveToElement (WebElement target): Fare işaretçisini hedef konumun merkezine taşımak için kullanılır.***********
              // maus u elementin üzetinde tutuyor ama click yapmiyor
dragAndDrop(WebElement source, WebElement target): Öğeyi kaynaktan sürüklemek ve hedef konuma bırakmak için kullanılır.*********************
dragAndDropBy(source, xOffset, yOffset): Bu yöntem, kaynak öğeyi tıklar ve tutar ve belirli bir ofset kadar hareket eder, ardından fareyi serbest bırakır. Ofsetler x & y ile tanımlanır.(X = Yatay Kaydır, Y= Dikey Kaydır)
release(): Geçerli konumdaki sol fare düğmesini serbest bırakmak için kullanılır.
perform(): Bir eylemi yürütür. Bu, bir eylemi gerçekleştirmek için sonunda kullanılmalıdır.
perform() KULLANMAYI UNUTMAYIN!

*/
    //Go to URL: https://demoqa.com/buttons
    //Run the buttons on the page using the Actions Class.
    //Verify the texts that appear after the buttons are operated.

    @Test
    public void test(){
        driver.get("https://demoqa.com/buttons");
        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        WebElement clickMe = driver.findElement(By.xpath("//button[.='Click Me']"));


        //1.yöntem
        actions.doubleClick(doubleClickBtn).perform(); // perform ile islem yapiliyor run gibi
        actions.contextClick(rightClickBtn).perform();
        actions.click(clickMe).perform();

    }
    @Test
    public void test2(){ // tek satirda da yapabiliriz asagidaki gibi
        driver.get("https://demoqa.com/buttons");
        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        WebElement clickMe = driver.findElement(By.xpath("//button[.='Click Me']"));

        //2.yöntem en iyisi
//       actions.
//               doubleClick(doubleClickBtn).
//               contextClick(rightClickBtn).
//               click(clickMe).
//               perform();

        //3.yöntem
      // actions.moveToElement(doubleClickBtn).pause(Duration.ofSeconds(1)).doubleClick(doubleClickBtn).perform();

        //4.yöntem
        actions.doubleClick(doubleClickBtn);
        actions.contextClick(rightClickBtn);
        actions.click(clickMe);
        actions.perform();


    }
}
