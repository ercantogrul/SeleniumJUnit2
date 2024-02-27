package A_Mentoring.JUnit1;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JUnit2 {
    /*
Go to google homepage
Do the following tasks by creating 3 different test methods.
*- Tüm test() methodları çalışmadan önce "Testler çalışmaya başlıyor" yazdıralım
*- Tüm test() methodları çalıştıktan sonra "Testlerin çalışması bitti" yazdıralım
3- Test if the title is the same when the page window is maximize and minimize
4- Test if the title does not contain "Video" when the page window is fullscreen
5- Test if the URL contains "google".
*/
    static WebDriver driver;
    @BeforeAll // sadece bir kez calisir ve static olmak zorunda
    public static void beforAllTest(){
        driver=new ChromeDriver(); // her class dan önce bir drive obje olusturur.
    }
    @BeforeEach // her testten önce bir kez calisir
    public void beforTest(){
        System.out.println("Test Calisiyor.");
    }

    @Test
    public void testTitle(){
        driver.manage().window().maximize();
        String maxTitle = driver.getTitle(); // windows un max oldugu durumda elde edilen title
        driver.manage().window().minimize();
        String minTitle = driver.getTitle();
        Assertions.assertEquals(maxTitle,minTitle);



    }

    @AfterEach // her testten sonra bir kez calisir
    public void afterTest(){
        System.out.println("Test bitti");
    }


    @AfterAll
    public static void afterAllTest(){
        driver.quit();
        System.out.println("Test tamamen bitti");
    }

}
