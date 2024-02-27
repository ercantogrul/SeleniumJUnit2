package A_Mentoring.JUnit1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class JUnit4_AssertionMethods {
    //    Goto page https://testpages.herokuapp.com/styled/basic-html-form-test.html
//       Create webdriver object
//        1-Create BeforeAll, BeforeEach,AfterAll ,Test anotains
//        2-Test page title equal "Form"
//        3-Test url contain "Form"
//        4-Test page after refresh page driver notNull

    static WebDriver driver;
    @BeforeAll
    public static void beforAll(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
    }
    @AfterAll
    public static void afterAll(){
        driver.close();
    }
    @Test
    public void test01() {
        Assertions.assertEquals(driver.getTitle(),"Form");
    }
    @Test
    public void test02() {
        Assertions.assertTrue(driver.getCurrentUrl().contains("form"));
        driver.navigate().refresh();
    }
    @Test
    public void test03() {
       driver.navigate().refresh();
       assertNotNull(driver);

    }




}
