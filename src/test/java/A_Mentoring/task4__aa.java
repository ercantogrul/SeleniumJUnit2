package A_Mentoring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.TestBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class task4__aa extends TestBase {
    private static final Logger logger = LogManager.getLogger();
    @Test

    public void t04verifyTag() throws IOException {
        loginMethod();
        String path1 = "C:\\Users\\zeyno\\Clarus\\JunitSDET3\\src\\main\\resources\\Proje3.xlsx";
        // Open the workbook using file input stream.
        FileInputStream fis = new FileInputStream(path1);
        // Create WorkBook excel
        Workbook wb = WorkbookFactory.create(fis);
        //Info1 sayfasına ulaşıldı
        Sheet info1 = wb.getSheet("Info1");
        //Sağ üst köşeden drop menu seçildi
        WebElement dropMenu = driver.findElement(By.cssSelector("select[class='product_sort_container']"));
        dropMenu.click();
        //Select class oluşturuldu
        Select select = new Select(dropMenu);
        select.selectByValue("lohi");
        //Ürünlerin listesi
        List<WebElement> productName = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
        System.out.println("productName.size() = " + productName.size());
        int count = 0;
        //Alınan her bir ürün  info 1 sayfasının  ilk (0) hücresine yerleştirildi
        for (WebElement element : productName) {
            System.out.println("element.getText() = " + element.getText());
            info1.getRow(count).createCell(0).setCellValue(element.getText());
            count++;
        }

        //Alınan her bir ürün fiyatı  info 1 sayfasının  ikinci (1) hücresine yerleştirildi
        List<WebElement> productCost = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        System.out.println("productCost.size() = " + productCost.size());

        //Ürünlerin fiyatlarının doğru sıralandığını test etmek için double değerine çevrildi
        double first = Double.parseDouble(productCost.get(0).getText().substring(1));
        count = 0;

        for (WebElement element : productCost) {

            System.out.println("element.getText() = " + element.getText());
            if (first <= Double.parseDouble(element.getText().substring(1))) {
                first = Double.parseDouble(element.getText().substring(1));
                info1.getRow(count).createCell(1).setCellValue(first);
                count++;

            } else {
                Assertions.assertTrue(false);
            }
            FileOutputStream fos = new FileOutputStream(path1);
            wb.write(fos);
            // screenShotFull(driver);
        }
    }

    @Test
    public void writeExcel() throws IOException {

        String path1 = "C:\\Users\\zeyno\\Clarus\\JunitSDET3\\src\\main\\resources\\Proje3.xlsx";

        // Open the workbook using file input stream.
        FileInputStream fis = new FileInputStream(path1);

        Workbook wb = WorkbookFactory.create(fis);

        Sheet credentials = wb.createSheet("Info1");
        for (int i = 0; i < 6; i++) {
            Row row = credentials.createRow(i);
        }
        FileOutputStream fos = new FileOutputStream(path1);
        wb.write(fos);

    }

    //User Story 6: Select 2 product and click "add to chart" button after click verify
    //Button name turnTo remove

    @Test
    public void removeButton() {
        loginMethod();
        WebElement button1 = driver.findElement(By.xpath("//button[contains (@id, 'labs-backpack')]"));
        String beforeClick = button1.getText();
        button1.click();
        button1 = driver.findElement(By.xpath("//button[contains (@id, 'labs-backpack')]"));
        String afterClick = button1.getText();
        Assertions.assertEquals("Add to cart", beforeClick);
        Assertions.assertEquals("Remove", afterClick);

    }

    //User Story 7: Select 6 product and add to chart verify the right corner shopping cart image contains 6 number
    //Take screen shoot shopping cart element
    @Test
    public void shoppingChart() {
        loginMethod();

        List<WebElement> addButtons = driver.findElements(By.xpath("//button[contains(@id,'add-to-cart')]"));
        for (WebElement addButton : addButtons) {
            addButton.click();
        }
        WebElement shoopingCart = driver.findElement(By.xpath("//a//span[@class='shopping_cart_badge']"));
        int shoopingCartValue = Integer.parseInt(shoopingCart.getText());

        Assertions.assertEquals(shoopingCartValue, addButtons.size());


    }


    //User Stroy 8: After select 2 product continue shooping enter information and continue to verify
    //Total cost true
    //"Thank you for your order!" text
    @Test
    public void shopping() {
        logger.info("Go to URL");
        loginMethod();
        logger.info("Website is opened: " + driver.getTitle());

        List<WebElement> addButtons = driver.findElements(By.xpath("//button[contains(@id,'add-to-cart')]"));
        List<WebElement> productName = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
        List<WebElement> productCost = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        for (int i = 0; i < 2; i++) {
            addButtons.get(i).click();
            logger.info(productName.get(i).getText() + " seçildi.");
            logger.info(productCost.get(i).getText() + " fiat bilgisi alındı.");
        }
        WebElement shoopingCart = driver.findElement(By.xpath("//a//span[@class='shopping_cart_badge']"));
        int shoopingCartValue = Integer.parseInt(shoopingCart.getText());
        logger.info(shoopingCartValue+ "adet ürün sepet ikonunda göründü");


    }


    public void loginMethod() {
        driver.get("https://www.saucedemo.com/inventory.html");
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

}
