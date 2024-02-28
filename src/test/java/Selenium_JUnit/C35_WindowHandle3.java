package Selenium_JUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;
import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.WindowType.TAB;
import static org.openqa.selenium.WindowType.WINDOW;

public class C35_WindowHandle3 extends TestBase {
    // 1- browser ac
    // 2- acilan sekmede https://www.amazon.com/ ac
    // 3- yeni sekme olustur
    // 4- acilan sekmede https://www.linkedin.com/ ac
    // 5- yeni pencere olustur
    // 6- acilan pencerede https://opensource-demo.orangehrmlive.com/web/index.php/auth/login sitesini ac
    // 7- amazon sekmesine gecerek arama kismina 'Amazon sekmesini buldun' yaz

    @Test
    public void test1() throws InterruptedException {
        String mainHandle = driver.getWindowHandle();

        // 2- acilan sekmede https://www.amazon.com/ ac
        driver.get("https://www.amazon.com/");
        driver.findElement(By.xpath("//a[.='Try different image']")).click();
        Thread.sleep(3000);

        // 3- yeni sekme olustur
        driver.switchTo().newWindow(TAB);
        String handleTab = driver.getWindowHandle();

        // 4- acilan sekmede https://www.linkedin.com/ ac
        driver.get("https://www.linkedin.com/");

        // 5- yeni pencere olustur
        driver.switchTo().newWindow(WINDOW);
        String handleWindow = driver.getWindowHandle();

        // 6- acilan pencerede https://opensource-demo.orangehrmlive.com/web/index.php/auth/login sitesini ac
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // 7- amazon sekmesine gecerek arama kismina 'Amazon sekmesini buldun' yaz
        driver.switchTo().window(mainHandle);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Amazon sekmesini buldun");
    }
    @Test
    public void test2() throws InterruptedException {
        // 2- acilan sekmede https://www.amazon.com/ ac
        driver.get("https://www.amazon.com/");
        driver.findElement(By.xpath("//a[.='Try different image']")).click();
        Thread.sleep(3000);

        // 3- yeni sekme olustur
        driver.switchTo().newWindow(TAB);

        // 4- acilan sekmede https://www.linkedin.com/ ac
        driver.get("https://www.linkedin.com/");

        // 5- yeni pencere olustur
        driver.switchTo().newWindow(WINDOW);

        // 6- acilan pencerede https://opensource-demo.orangehrmlive.com/web/index.php/auth/login sitesini ac
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // 7- amazon sekmesine gecerek arama kismina 'Amazon sekmesini buldun' yaz

        //window handle ler arasi gecis yapmamiz gerek
        //set objesi olusturmaliyiz.
        Set<String> windowHanhleSet = driver.getWindowHandles();// getWindowHandles komutu "Set" döndürdüğü için Set'e atıyoruz.

        Iterator<String> i = windowHanhleSet.iterator();//Set'in içinde gezinebilmek için iterator object oluşturuyoruz.

        while (i.hasNext()){//i.hasNext() ifadesi , i isimli bir nesnenin bir sonraki elemani olup olmadigini kontrol eder
            String currentHandle = i.next();//i.next() ifadesi , i isimli bir nesnenin bir sonraki elemani bu degiskene atamaktadir.
            driver.switchTo().window(currentHandle);//sırayla tüm windowHandle değerlerini kullanarak sekme ve pencerelerde dolaşıyoruz.

            if(driver.getTitle().contains("Amazon")){//bu şart sağlanıyorsa Amazon sayfasının olduğu penceredeyiz demektir.
                WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
                searchBox.sendKeys("Amazon sekmesini buldun BRAVO !!!");
                break;//Amazon sayfasını bulduğunda diğer pencerelere gitmemesi için döngüyü kırıyoruz.
            }
        }
    }

}
