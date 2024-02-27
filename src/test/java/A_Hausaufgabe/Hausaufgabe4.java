package A_Hausaufgabe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hausaufgabe4 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.facebook.com/");
        String word = "https://www.facebook.com/";
        String url = driver.getCurrentUrl();
        System.out.println(url.equals(word) ? "Passed" : "Failed");


        String titel = driver.getTitle();
        System.out.println(titel.contains("Facebook") ? "Passed" : "Failed");
    }
}



