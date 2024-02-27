package A_Mentoring.JUnit2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Example10_Iframe {
    //Goto page:  https://demo.automationtesting.in/Frames.html
//Verify :iFrame Demo text

    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demo.automationtesting.in/Frames.html");
        if (driver.findElement(By.xpath("//*[.='Consent']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[.='Consent']")).click();
        }
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        WebElement iframe = driver.findElement(By.xpath("//*[@id='singleframe']"));
        driver.switchTo().frame(iframe);
        WebElement textBox = driver.findElement(By.xpath("(//h5[text()='iFrame Demo'])[1]"));
        System.out.println("textBox.getText() = " + textBox.getText());
        Thread.sleep(2000);

        WebElement textBox2 = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        textBox2.sendKeys("Hello");
        Thread.sleep(2000);


    }

    @Test
    public void test2() throws InterruptedException {

        driver.switchTo().defaultContent(); // driver  default a geri getirildi

        WebElement iframeBox = driver.findElement(By.xpath("(//a[@class='analystic'])[2]")); // ikinci kutu bulundu ve click yapildi
        iframeBox.click();
        Thread.sleep(2000);

        WebElement iframe2 = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']")); //iframe locater i bulundu elemente aktarildi
        driver.switchTo().frame(iframe2); // driver iframe de konumlandirildi ve element buradaki driver a gönderildi
        Thread.sleep(2000);

        WebElement text = driver.findElement(By.xpath("(//h5[.='Nested iFrames'])")); //Nested iFrames text in locater i bulundu elemente aktarildi
        text.getText().contains("Nested iFrames"); // text okundu ve icerisinde Nested iFrames varmi diye kontrol edildi


    }

}

