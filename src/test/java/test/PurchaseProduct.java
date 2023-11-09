package test;

import driver.driverFactory;
import model.pages.CartPage;
import model.pages.CheckOutPage;
import model.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class PurchaseProduct {
    public static void testAccountForm() {

         //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("http://live.techpanda.org/");
            WebElement mobileButton =  driver.findElement(By.linkText("MOBILE"));
            mobileButton.click();

            boolean test = true;

            driver.findElement(By.linkText("ACCOUNT")).click();
            driver.findElement(By.linkText("Log In")).click();


            LoginPage loginPage = new LoginPage(driver);
            loginPage.inputEmail("AExample5@gmail.com");
            loginPage.inputPassword("123456");
            loginPage.clickLoginBtn();


            driver.findElement(By.linkText("MY WISHLIST")).click();
            driver.findElement(By.xpath("//div[@class='cart-cell']//button[@class='button btn-cart']")).click();
            CartPage c = new CartPage(driver);
            c.inputCountry("US");
            c.inputState("2");
            c.inputZip("3990");
            c.clickEstimateBtn();

            driver.findElement(By.xpath("//dd//ul//li//label[@for='s_method_flatrate_flatrate']")).click();
            driver.findElement(By.xpath("//button[@value='Update Total']")).click();


            float flat = Float.parseFloat(driver.findElement(By.xpath("//dd//ul//li//label[@for='s_method_flatrate_flatrate']//span[@class='price']")).getText().substring(1));
            float subtotal = Float.parseFloat(driver.findElement(By.xpath("//tbody//tr//td[@class='a-right']//span[@class='price']")).getText().substring(1));
            float  total = Float.parseFloat(driver.findElement(By.xpath("//tfoot//tr//td[@class='a-right']//strong//span[@class='price']")).getText().substring(1));

            if (subtotal+flat != total){
                test = false;
            }
            driver.findElement(By.xpath("//button[@class='button btn-proceed-checkout btn-checkout']")).click();

            CheckOutPage ch = new CheckOutPage(driver);
            ch.inputFirstName("Mac");
            ch.inputMiddleName("Tran Nhan");
            ch.inputLastName("Tai");
            ch.inputCompany("FPT");
            ch.inputAddress1("PLA");
            ch.inputAddress2("PLB");
            ch.inputCity("HCM");
            ch.inputState("2");
            ch.inputZip("3990");
            ch.inputCountry("US");
            ch.inputTelephone("0123456789");
            ch.inputFax("0123456789");
            ch.clickContinueBtn();



            Assertions.assertTrue(test);
            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
        }
        //7. Quit browser session
        driver.quit();
    }
}
