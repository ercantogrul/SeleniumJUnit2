package Selenium_JUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class C44_RobotClass___3 extends TestBase {
    @Test
    public void RobotClassNot () throws AWTException {
        // Robot oluştur
        Robot robot = new Robot();

        // Fareyi belirli bir konuma taşıma
        robot.mouseMove(500, 500);

        // Fare sol tıklama
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        // Klavye girişi yapma (CTRL+SHIFT+T tuşlarına basma)
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_T);  // Tusa bas
        robot.keyRelease(KeyEvent.VK_T);  // tusu birak
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Klavye girişi yapma (Bir dizi tuşa basma)
        robot.keyPress(KeyEvent.VK_H);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_O);
        // Tuşları serbest bırakma
        robot.keyRelease(KeyEvent.VK_O);
        robot.keyRelease(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_E);
        robot.keyRelease(KeyEvent.VK_H);

        // Fare tekerleğini aşağı veya yukarı kaydırma
        robot.mouseWheel(3); // Aşağı doğru kaydırma
        robot.mouseWheel(-3); // Yukarı doğru kaydırma

        // Ekran görüntüsü almak
            /*Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage capture = robot.createScreenCapture(screenRect);
            ImageIO.write(capture, "png", new File("screenshot.png"));*/

        // Bekleme
        robot.delay(1000);

    }

   //soru
    //Go to URL: https://www.ebay.com/
    //Search for "Robot" by using RobotClass
    //scroll down to bottom
    //scroll up to top

    @Test
    public void test1() throws AWTException, InterruptedException {
        driver.get("https://www.ebay.com/");
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
        searchBox.click();

    //Search for "Robot" by using RobotClass

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_SHIFT);  //Robot sınıfı aracılığıyla klavyede "Shift" tuşuna basıldığını belirtir.
        //*** KeyEvent.VK_SHIFT ifadesi, Java'da Shift tuşunun bir sanal tuş kodunu temsil eder.
        //Bu satır, klavyede Shift tuşuna basıldığını belirtir, ancak tuş serbest bırakılmadığı sürece bu basma işlemi devam eder.

        robot.keyPress(KeyEvent.VK_R);  // Robot sınıfı aracılığıyla klavyede "R" tuşuna basıldığını belirtir.
        robot.keyRelease(KeyEvent.VK_R);  //Robot sınıfı aracılığıyla klavyede "R" tuşunun serbest bırakıldığını belirtir.
        robot.keyRelease(KeyEvent.VK_SHIFT); // "Shift" tuşu serbest birakildi

        robot.keyPress(KeyEvent.VK_O);  // ayni sey sirayla diger tuslar icin yapilir
        robot.keyRelease(KeyEvent.VK_O);

        robot.keyPress(KeyEvent.VK_B);
        robot.keyRelease(KeyEvent.VK_B);

        robot.keyPress(KeyEvent.VK_O);
        robot.keyRelease(KeyEvent.VK_O);

        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_T);

        robot.keyPress(KeyEvent.VK_ENTER); // Robot sınıfı aracılığıyla klavyede "ENTER" tuşuna basıldığını belirtir.
        robot.keyRelease(KeyEvent.VK_ENTER); //Robot sınıfı aracılığıyla klavyede "ENTER" tuşunun serbest bırakıldığını belirtir.
        Thread.sleep(5000);

    //scroll down to bottom
        robot.mouseWheel(200);  //Robot sınıfı aracılığıyla fare tekerleğini aşağı doğru 200 birim kaydıracaktır
        Thread.sleep(5000);
        robot.mouseWheel(-200); //Robot sınıfı aracılığıyla fare tekerleğini yukari doğru 200 birim kaydıracaktır


    }
}

