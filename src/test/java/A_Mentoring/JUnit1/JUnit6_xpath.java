package A_Mentoring.JUnit1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnit6_xpath {
    //    Test Case 1: Register User
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'  Pass
//3. Verify that home page is visible successfully    Pass
//4. Click on 'Signup / Login' button                 Pass
////5. Verify 'New User Signup!' is visible             Pass
//6. Enter name and email address                     Pass
//7. Click 'Signup' button                            Pass
//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible     Pass
//9. Fill details: Title, Name, Email, Password, Date of birth
//10. Select checkbox 'Sign up for our newsletter!'
//11. Select checkbox 'Receive special offers from our partners!'
//12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
//13. Click 'Create Account button'
//14. Verify that 'ACCOUNT CREATED!' is visible
//15. Click 'Continue' button
//16. Verify that 'Logged in as username' is visible
//17. Click 'Delete Account' button
//18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

    static WebDriver driver;
    @BeforeAll
    public static void beforAll(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("http://automationexercise.com");
    }
    @AfterAll
    public static void afterAll(){
        driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
      String url = driver.getCurrentUrl();
       assertEquals(driver.getCurrentUrl(),"http://automationexercise.com");

    }
    @Test
    public void test02() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        loginButton.click();

        WebElement userSignUp = driver.findElement(By.xpath("//div[@class='signup-form']"));
        Assertions.assertTrue(userSignUp.isDisplayed());


    }

}
