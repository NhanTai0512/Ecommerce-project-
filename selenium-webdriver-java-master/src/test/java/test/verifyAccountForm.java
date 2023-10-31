package test;

import driver.driverFactory;
import model.pages.RegisterPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

@Test
public class verifyAccountForm {
    public static void testAccountForm() {

         //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {

            driver.get("http://live.techpanda.org/");
            WebElement mobileButton =  driver.findElement(By.linkText("MOBILE"));
            mobileButton.click();
            boolean test = false;

            driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//a[@Class='skip-link skip-account']")).click();
            driver.findElement(By.xpath("//div[@class='links']//ul/li[@class='first']")).click();
            driver.findElement(By.xpath("//div[@class='buttons-set']//a[@class='button']")).click();

            RegisterPage registerPage = new RegisterPage(driver);
            registerPage.inputFirstName("Mac");
            registerPage.inputMiddleName("Tran Nhan");
            registerPage.inputLastName("Tai");
            registerPage.inputEmail("AExample5@gmail.com");
            registerPage.inputPassword("123456");
            registerPage.InputConfirmPassword("123456");
            registerPage.clickRegisterBtn();
            try {
                driver.findElement(By.className("my-account"));
                driver.findElement(By.xpath("//ol[@class='nav-primary']//li[@class='level0 nav-2 last']")).click();
                driver.findElement(By.className("link-wishlist")).click();
                driver.findElement(By.xpath("//button[@class='button btn-share']")).click();
                driver.findElement(By.id("email_address")).sendKeys("AExample5@gmail.com");
                driver.findElement(By.id("message")).sendKeys("wish");
                driver.findElement(By.xpath("//div[@class='buttons-set form-buttons']//button[@class='button']")).click();
                driver.findElement(By.className("success-msg"));
                test=true;
            }catch (Exception ignored){}

            Assertions.assertTrue(test);
            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
        }
        //7. Quit browser session
        driver.quit();
    }
}
