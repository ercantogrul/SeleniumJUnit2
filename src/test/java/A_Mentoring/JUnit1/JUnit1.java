package A_Mentoring.JUnit1;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JUnit1 {

    static WebDriver driver;
    /*
Go to youtube homepage
Do the following tasks by creating 4 different test methods.
*- Her test() methodundan önce "Test çalışıyor" yazdıralım
*- Her test() methodundan sonra "Test bitti" yazdıralım
3- Test if the currentURL contains "youtube"
4- Test if the title does not contain "Video".
5- Test if the URL contains "youtube".
6- Test if the sourcePage contains "youtube".
*/
    @BeforeAll // sadece bir kez calisir ve static olmak zorunda
    public static void beforAllTest(){
        driver=new ChromeDriver(); // her class dan önce bir drive obje olusturur.
        driver.manage().window().maximize();

    }
    @BeforeEach // her testten önce bir kez calisir
    public void beforTest(){
        System.out.println("Test Calisiyor");
    }
    @AfterEach // her testten sonra bir kez calisir
    public void afterTest(){
        System.out.println("Test bitti");
    }

    @Test
    public void test1Url(){
        driver.get("https://www.youtube.com/");
        String  expectedUrl ="youtube";  // beklenen , istenen
        String actual = driver.getCurrentUrl();// mevcutta olan
        System.out.println(driver.getCurrentUrl());

        if (actual.contains(expectedUrl)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

       // Assertions.assertEquals(expectedUrl,actual);

    }
    @Test @Disabled("Test 2 beklemeye alindi")  // @Disabled () icine aciklama yazinca ekrana geliyor
    public void test2Title(){
        driver.get("https://www.youtube.com/");
        String  expectedTitle ="video";  // beklenen , istenen
        String actualTitle = driver.getTitle();// mevcutta olan
        System.out.println(driver.getCurrentUrl());

        if (actualTitle.contains(expectedTitle)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        // Assertions.assertEquals(expectedUrl,actual);

    }


    @AfterAll
    public static void afterAllTest(){
        driver.quit();
        System.out.println("Test tamamen bitti");
    }


}
