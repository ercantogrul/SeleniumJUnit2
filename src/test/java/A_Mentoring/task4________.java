package A_Mentoring;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.TestBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class task4________ extends TestBase {
    @Test
    public void test() throws IOException, InterruptedException {
        //Goto page:https://www.saucedemo.com/inventory.html
        //User Story 1: Test Login Page with credentials (Positive Test)
        //******************************************************
        //- credential userName:    //-credential password:  secret_sauce
        // standard_user
        //error_user
        //visual_user
        //Test all user
        //******************************************************
        //- credential userName:      standard_user  //-credential password:  secret_sauce
        //User Story 2: Test Login Page with unvalid credential password and username( Negative Test)
        //***************************************************
        //User Story 3: After login success verify: "Swag Labs" text
        //***************************************************
        //User Story 4: Select Right Menü Price low to highly verify cost order low to high
    /*Description: First test manually
                   Then create new excel sheet
                   Add new sheet name: Info1
                   After locate all cost and product name
                   Send Product name and Cost Excel sheet name : Info
                   Verify order is true
*/   //***************************************************
        //User Story 5: Select Right Menü Price high to low verify cost order high to low
    /*Description: First test manually
                   Then create new excel sheet
                   Add new sheet name: Info2
                   After locate all cost and product name
                   Send Product name and Cost Excel sheet name : Info2
                   Verify order is true
*/   //***************************************************
        //User Story 6: Select 2 product and click "add to chart" button after click verify
        //Button name turnTo remove
        //***************************************************
        //User Story 7: Select 3 product and add to chart verify the right corner shopping cart image contains 3 number
        //***************************************************
        //User Stroy 8: After select 2 product continue shooping enter information and continue to verify
        //Total cost true
        //"Thank you for your order!" text

    }

    @Test
    public void test1() throws IOException, InterruptedException {

        //Goto page:https://www.saucedemo.com/inventory.html
        //User Story 1: Test Login Page with credentials (Positive Test)
        //******************************************************
        //- credential userName:    //-credential password:  secret_sauce
        // standard_user
        //error_user
        //visual_user
        //Test all user

        //Goto Page: https://www.saucedemo.com/inventory.html
        driver.navigate().to("https://www.saucedemo.com/inventory.html");

        List<String> userList = new ArrayList<>(Arrays.asList("standard_user", "error_user", "visual_user"));
        List<String> getTittel = new ArrayList<>();

        for (int i = 0; i < userList.size(); i++) {

            WebElement userName = driver.findElement(By.id("user-name"));
            userName.click();
            userName.sendKeys(userList.get(i));
            WebElement password = driver.findElement(By.id("password"));
            password.click();
            password.sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            String getTittel1 = driver.getTitle();
            assertEquals("Swag Labs", getTittel1);
            getTittel.add(getTittel1);
            driver.navigate().back();
        }
        System.out.println(getTittel);

    }

    @Test
    public void test2() throws IOException, InterruptedException {
        //- credential userName:      standard_user  //-credential password:  secret_sauce
        //User Story 2: Test Login Page with unvalid credential password and username( Negative Test)
        //not match any user in this service yazisini alarak
        driver.navigate().to("https://www.saucedemo.com/inventory.html");
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.click();
        userName.sendKeys("Ercan");
        WebElement password = driver.findElement(By.id("password"));
        password.click();
        password.sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        // Giriş yapılamadigini doğrulama
        WebElement ergebnis = driver.findElement(By.xpath("//h3[@data-test='error']"));
        assertTrue(ergebnis.getText().contains("Username and password do not match any user"));

    }
    @Test
    public void test3() throws IOException, InterruptedException {
        loginMethode();
        WebElement verifyProducts = driver.findElement(By.xpath("//*[.='Products']"));
        assertTrue(verifyProducts.isDisplayed());
    }

    @Test
    public void test4() throws IOException, InterruptedException {
//User Story 4: Select Right Menü Price low to highly verify cost order low to high
    /*Description: First test manually
                   Then create new excel sheet
                   Add new sheet name: Info1
                   After locate all cost and product name
                   Send Product name and Cost Excel sheet name : Info
                   Verify order is true
     */
        loginMethode();

        //User Story 4: Select Right Menü Price low to highly verify cost order low to high
        WebElement dropDown = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(dropDown);
        select.selectByValue("lohi");

        //Then create new excel sheet
        String path1 = System.getProperty("user.dir") + "\\src\\test\\resources\\Muhtesem e-tablo.xlsx";

        // Open the workbook using file input stream.
        FileInputStream fis = new FileInputStream(path1);
        Workbook wb = WorkbookFactory.create(fis);

        Sheet sheet2=wb.getSheet("Sayfa1");
        if (wb.getSheet("Info")==(null)) {
            sheet2 = wb.createSheet("First test manually");
            for (int i = 0; i < 6; i++) {
                Row row = sheet2.createRow(i);  // 6 tane satir crat edildi
            }
        }

        List<WebElement> titel = new ArrayList<>(driver.findElements(By.className("inventory_item_name"))); // ürün basliklarinmi liste ekledik
        List<WebElement> preis = new ArrayList<>(driver.findElements(By.xpath("//div[@class='inventory_item_price']"))); //// ürün fiyatlarini liste ekledik

        double ilkFiyat = Double.parseDouble(preis.get(0).getText().substring(1));

        for (int i = 0; i < titel.size(); i++) {
            sheet2.getRow(i).createCell(0).setCellValue(titel.get(i).getText());
            if (ilkFiyat<=Double.parseDouble(preis.get(i).getText().substring(1))){
                sheet2.getRow(i).createCell(1).setCellValue(preis.get(i).getText());
                ilkFiyat= Double.parseDouble(preis.get(i).getText().substring(1));
            }else {
                assertTrue(false);
            }

        }
        FileOutputStream fos = new FileOutputStream(path1);
        wb.write(fos);
        fis.close();
        fos.close();
    }

    @Test
    public void test5() throws IOException, InterruptedException {
        //User Story 5: Select Right Menü Price high to low verify cost order high to low
    /*Description: First test manually
                   Then create new excel sheet
                   Add new sheet name: Info2
                   After locate all cost and product name
                   Send Product name and Cost Excel sheet name : Info2
                   Verify order is true
     */
        loginMethode();
        WebElement dropDown = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(dropDown);
        select.selectByValue("hilo");
    }

    @Test
    public void test6() throws IOException, InterruptedException {
        //User Story 6: Select 2 product and click "add to chart" button after click verify
        //Button name turnTo remove
        loginMethode();

        //addProduct =
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        WebElement clickVerify = driver.findElement(By.className("shopping_cart_badge"));;
        assertEquals(clickVerify.getText(),"2");
        //
        WebElement removeverify1 = driver.findElement(By.id("remove-sauce-labs-fleece-jacket"));
        assertTrue(removeverify1.isDisplayed());
        WebElement removeverify2 = driver.findElement(By.id("remove-sauce-labs-backpack"));
        assertTrue(removeverify2.isDisplayed());
    }
    @Test
    public void test7() throws IOException, InterruptedException {
        //User Story 7: Select 3 product and add to chart verify the right corner shopping cart image contains 3 number
        loginMethode();

        //addProduct =
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        WebElement clickVerify = driver.findElement(By.className("shopping_cart_badge"));;
        assertEquals(clickVerify.getText(),"3");
    }
    @Test
    public void test8() throws IOException, InterruptedException {
        //User Stroy 8: After select 2 product continue shooping enter information and continue to verify
        //Total cost true
        //"Thank you for your order!" text
        loginMethode();

        //addProduct =
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        WebElement clickVerify = driver.findElement(By.className("shopping_cart_badge"));
        clickVerify.click();

        double sumPreis =0;

        for (int i = 0; i <= 1; i++) {
            String kostet = (driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText());
            kostet = kostet.substring(1, kostet.length() - 1);
            double dbKostet = Double.parseDouble(kostet);
            sumPreis+=dbKostet;
        }
        System.out.println("sumPreis = " + sumPreis);
        assertEquals(sumPreis,99.8);

        //======
        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();

        WebElement firstName = driver.findElement(By.id("first-name"));
        actions
                .click(firstName)
                .sendKeys("Ercan")
                .sendKeys(Keys.TAB)
                .sendKeys("Togrul")
                .sendKeys(Keys.TAB)
                .sendKeys("47608")
                .perform();

        WebElement continues = driver.findElement(By.id("continue"));
        continues.click();
        driver.findElement(By.id("finish")).click();
        WebElement endText = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2"));
        System.out.println("endText.getText() = " + endText.getText());
        assertEquals(endText.getText(),"Thank you for your order!");

    }

    private void loginMethode() {
        driver.navigate().to("https://www.saucedemo.com/inventory.html");
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.click();
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.click();
        password.sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

    }



}