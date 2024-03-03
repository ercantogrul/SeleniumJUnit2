package Selenium_JUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C43_JavascriptExecutor_Notlar {
    public static void main(String[] args) {
        // WebDriver'ı oluştur
        WebDriver driver = new ChromeDriver();

        // Sayfayı yükle
        driver.get("https://www.example.com");

        // JavaScriptExecutor'u WebDriver ile ilişkilendir
        JavascriptExecutor js = (JavascriptExecutor) driver;

 // Sayfa başlığını alma
        String title = (String) js.executeScript("return document.title;");
        System.out.println("Page Title: " + title);

 // Sayfa URL'sini alma
        String url = (String) js.executeScript("return document.URL;");
        System.out.println("Page URL: " + url);

 // Bir elementi JavaScript ile bulma
        WebElement element = (WebElement) js.executeScript("return document.getElementById('myElement');");

 // Elementin metin içeriğini almak
        String text = (String) js.executeScript("return arguments[0].textContent;", element);
        System.out.println("Element Text: " + text);

       // Elementin stilini değiştirmek
        js.executeScript("arguments[0].style.backgroundColor = 'yellow';", element);

        // Sayfayı kaydırmak**************************
 js.executeScript("window.scrollBy(0, 500);");

        // JavaScript fonksiyonunu çalıştırmak
        js.executeScript("function sayHello() { console.log('Hello from JavaScript'); }");
        js.executeScript("sayHello();");

        // Tarayıcıyı kapat
        driver.quit();
    }
}