package A_Mentoring.JUnit2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Example1 {
/*
* Examples of common Chrome options:

headless: Launches Chrome in the background without a visible window.
incognito: Launches Chrome in incognito mode, preventing browsing history and cookies from being saved.
disable_extensions: Disables all existing Chrome extensions.
add_extension: Adds a specific Chrome extension from a CRX file.
user_data_dir: Specifies a custom user profile directory for Chrome.
arguments: Allows passing additional command-line arguments to Chrome.*/

    //Example-1
    //1-Goto IKEA home page with incognito mode
    //2-
   static WebDriver driver;

@BeforeAll
    public static void setUp(){
    ChromeOptions options=new ChromeOptions();
    options.addArguments("start-maximized");
    options.addArguments("incognito");
    options.addArguments("disabled-extension");
    options.addArguments("disable-popup-blocking");
    driver=new ChromeDriver(options);

}

@Test
    public void ikeaPage1(){

     driver.get("https://www.ikea.com.tr/");
}




}
