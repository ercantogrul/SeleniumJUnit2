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

import static org.junit.jupiter.api.Assertions.assertTrue;

public class task4_yy extends TestBase {
    @Test
    public void login() throws IOException, InterruptedException {
        //Goto page:https://www.saucedemo.com/inventory.html
        driver.navigate().to("https://www.saucedemo.com/inventory.html");
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

        List<String> usernames = new ArrayList<>(Arrays.asList("standard_user", "error_user", "visual_user"));
        List<String> titles = new ArrayList<>();
        int count = 0;
        for (String usernamefor : usernames) {
            WebElement username = driver.findElement(By.id("user-name"));
            WebElement password = driver.findElement(By.id("password"));
            username.sendKeys(usernamefor);
            password.sendKeys("secret_sauce");
            Thread.sleep(500);
            WebElement loginButton = driver.findElement(By.id("login-button"));

            JavascriptExecutor jsexecutor = ((JavascriptExecutor) driver);
            jsexecutor.executeScript("arguments[0].click();", loginButton);
            Thread.sleep(500);
            titles.add(driver.getTitle());
            System.out.println(driver.getTitle());
            count++;
            driver.navigate().back();
            if (count == 3) {
                driver.navigate().forward();
            }
        }


        //***************************************************
        //User Story 3: After login success verify: "Swag Labs" text
        for (int i = 0; i < 3; i++) {
            assertTrue(titles.get(i).equals("Swag Labs"));
        }

        //***************************************************
        //User Story 4: Select Right Menü Price low to highly verify cost order low to high
    /*Description: First test manually
                   Then create new excel sheet
                   Add new sheet name: Info1
                   After locate all cost and product name
                   Send Product name and Cost Excel sheet name : Info
                   Verify order is true
     */
        WebElement selection = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select = new Select(selection);
        select.selectByVisibleText("Price (low to high)");
        Thread.sleep(1000);

        List<String> productNames = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            productNames.add(driver.findElement(By.id("item_" + i + "_title_link")).getText());
        }

        List<Double> productCosts = new ArrayList<>();
        double cost = 0;
        for (int i = 1; i <= 6; i++) {
            String costS = (driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[" + i + "]")).getText());
            costS = costS.substring(1, costS.length() - 1);
            double cost1 = Double.parseDouble(costS);
            if (cost <= cost1) {
            } else System.out.println("Kucukten buyuge sirali degil");
            cost = cost1;
            productCosts.add(cost);

        }
        String path = System.getProperty("user.dir") + "\\src\\test\\resources\\codeChallenge.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sayfa1 = wb.createSheet("sayfa1");
        Sheet productNamesCosts = wb.createSheet("productNamesCosts");
        for (int i = 0; i < 2; i++) {
            Row row = productNamesCosts.createRow(i);
            if (i == 0) {
                for (int j = 0; j < productNames.size(); j++) {
                    productNamesCosts.getRow(i).createCell(j).setCellValue(productNames.get(j));
                }
            }
            if (i == 1) {
                for (int j = 0; j < productCosts.size(); j++) {
                    productNamesCosts.getRow(i).createCell(j).setCellValue(productCosts.get(j));
                }
            }
        }
        FileOutputStream fos = new FileOutputStream(path);
        wb.write(fos);
        fis.close();
        fos.close();


    }
    @Test
    public void addProduct() throws IOException, InterruptedException {
        //***************************************************
        //User Story 6: Select 2 product and click "add to chart" button after click verify
        //Button name turnTo remove
        driver.navigate().to("https://www.saucedemo.com/inventory.html");
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        Thread.sleep(500);
        WebElement loginButton = driver.findElement(By.id("login-button"));
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) driver);
        jsexecutor.executeScript("arguments[0].click();", loginButton);
        WebElement selection = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select = new Select(selection);
        select.selectByVisibleText("Price (low to high)");



        WebElement addProduct1 = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
        WebElement addProduct2 = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        actions
                .click(addProduct1)
                .click(addProduct2)
                .perform();

        WebElement verify1 = driver.findElement(By.id("remove-sauce-labs-onesie"));
        assertTrue(verify1.isDisplayed());
        WebElement verify2 = driver.findElement(By.id("remove-sauce-labs-bike-light"));
        assertTrue(verify2.isDisplayed());

        //***************************************************
        //User Story 7: Select 3 product and add to chart verify the right corner shopping cart image contains 3 number
        WebElement addProduct3 = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        addProduct3.click();
        WebElement verify3 = driver.findElement(By.className("shopping_cart_badge"));
        assertTrue(verify3.getText().contains("3"));
        //***************************************************
        //User Stroy 8: After select 2 product continue shooping enter information and continue to verify
        //Total cost true
        WebElement removeElement = driver.findElement(By.id("remove-sauce-labs-bike-light"));
//        jsexecutor = ((JavascriptExecutor) driver);
        jsexecutor.executeScript("arguments[0].click();", removeElement);
        verify3.click();

        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();

        WebElement firstName = driver.findElement(By.id("first-name"));

        actions
                .click(firstName)
                .sendKeys("Yasin")
                .sendKeys(Keys.TAB)
                .sendKeys("Celik")
                .sendKeys(Keys.TAB)
                .sendKeys("02")
                .perform();

        WebElement continues = driver.findElement(By.id("continue"));
        continues.click();
        driver.findElement(By.id("finish")).click();
        assertTrue(driver.findElement(By.className("complete-header")).getText().contains("Thank"));


        //"Thank you for your order!" text



    }

}
