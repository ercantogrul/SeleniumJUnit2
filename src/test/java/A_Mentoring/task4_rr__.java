package A_Mentoring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class task4_rr__ extends TestBase {
    private static final Logger logger = LogManager.getLogger();
    @Test
    public void test() throws InterruptedException, IOException {
        driver.navigate().to("https://www.saucedemo.com/inventory.html");

        //User Story 1: Test Login Page with credentials (Positive Test)
        //******************************************************
        //- credential userName:    //-credential password:  secret_sauce
        // standard_user
        //error_user
        //visual_user
        //Test all user
        //******************************************************

        List<String> userNameList = new ArrayList<>(Arrays.asList("standard_user", "error_user", "visual_user"));
        for (String s : userNameList) {
            WebElement userName = driver.findElement(By.id("user-name"));
            WebElement loginButton = driver.findElement(By.id("login-button"));
            actions
                    .click(userName)
                    .sendKeys(s, Keys.TAB)
                    .sendKeys("secret_sauce")
                    .click(loginButton)
                    .pause(3)
                    .perform();

            WebElement verifyProducts = driver.findElement(By.xpath("//*[.='Products']"));

            //verify yapiliyor(giris basarili  mi?)
            assertTrue(verifyProducts.isDisplayed());
            Thread.sleep(3000);
            driver.navigate().back();
        }

        //User Story 2: Test Login Page with invalid credential password and username( Negative Test)
        //***************************************************
        WebElement userName = driver.findElement(By.id("user-name"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        actions
                .click(userName)
                .sendKeys("Rasit", Keys.TAB)
                .sendKeys("1234")
                .click(loginButton)
                .pause(3)
                .perform();


        try {
            WebElement verifyProducts = driver.findElement(By.xpath("//*[.='Products']"));
            assertTrue(verifyProducts.isDisplayed());
        } catch (NoSuchElementException e) {
            logger.info("Kullanici adi ve sifresi hatali");
        }

        //User Story 3: After login success verify: "Swag Labs" text
        //***************************************************
        userName.clear();
        loginMethod();
        WebElement passWord = driver.findElement(By.id("password"));
        passWord.clear();
        actions
                .click(userName)
                .sendKeys("standard_user", Keys.TAB)
                .sendKeys("secret_sauce")
                .click(loginButton)
                .pause(3)
                .perform();
        WebElement verifyProducts = driver.findElement(By.xpath("//*[.='Products']"));
        assertTrue(verifyProducts.isDisplayed());


        //***************************************************
        //User Story 4: Select Right Menü Price low to highly verify cost order low to high
        /*Description: First test manually
                   Then create new excel sheet
                   Add new sheet name: Info1
                   After locate all cost and product name
                   Send Product name and Cost Excel sheet name : Info
                   Verify order is true*/
        // Add the excel file on the resources folder.
        // Open the file.
    }

    @Test
    public void testExell() throws IOException {
        loginMethod();
        String path = System.getProperty("user.dir") + "\\src\\test\\resources\\CodeFreitag.xlsx";

        // Open the workbook using file input stream.
        FileInputStream fis = new FileInputStream(path);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet2;
        if (wb.getSheet("Sayfa2") == null) {
            sheet2 = wb.createSheet("Sayfa2");// burada yeni sayfa creat ediliyor
        } else {
            sheet2 = wb.getSheet("Sayfa2");// burada yeni sayfa creat ediliyor
        }

        List<WebElement> itemList = new ArrayList<>(driver.findElements(By.xpath("//div[@class='inventory_list']/div")));
        List<WebElement> preisList = new ArrayList<>(driver.findElements(By.xpath("//div[@class='inventory_item_price']")));

        for (int r = 0; r < itemList.size(); r++) {
            Row row = sheet2.createRow(r);
            row.createCell(0).setCellValue(itemList.get(r).getText().substring(0,30));
            row.createCell(1).setCellValue(preisList.get(r).getText());
        }

        FileOutputStream fos = new FileOutputStream(path);
        wb.write(fos);
        fis.close();
        fos.close();

        //User Story 6: Select 2 product and click "add to chart" button after click verify

        //***************************************************
        List<WebElement> addToCart = new ArrayList<>(driver.findElements(By.xpath("//button[.='Add to cart']")));
        for (int i = 0; i < 2; i++) {
            addToCart.get(i).click();

        }
        //Button name turnTo remove
        WebElement remove = driver.findElement(By.id("remove-sauce-labs-backpack"));
        assertEquals("Remove", remove.getText());

        //Casse da kayitli mi
        WebElement casse = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
       // getScreenShotMethod(casse);




        //User Story 7: Select 3 product and add to chart verify the right corner shopping cart image contains 3 number
        //***************************************************


        //User Stroy 8: After select 2 product continue shooping enter information and continue to verify
        WebElement goToCard = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        goToCard.click();
        WebElement contunieSchopping = driver.findElement(By.id("continue-shopping"));
        contunieSchopping.click();
        logger.info("Elhamdulillah bitti");

        // log4g kullanabiliriz
        //Total cost true
        //"Thank you for your order!" text

    }

    private void loginMethod() {
        driver.get("https://www.saucedemo.com/inventory.html");
        WebElement userName = driver.findElement(By.id("user-name"));
        WebElement passWord = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        passWord.clear();
        actions
                .click(userName)
                .sendKeys("standard_user", Keys.TAB)
                .sendKeys("secret_sauce")
                .click(loginButton)
                .pause(3)
                .perform();
    }
}
