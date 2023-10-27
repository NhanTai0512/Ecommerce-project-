package test;

import driver.driverFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

@Test
public class cartForm {
    public static void testCart() {

         //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {

            driver.get("http://live.techpanda.org/");
            driver.findElement(By.xpath("//ol[@class='nav-primary']//li[@class='level0 nav-1 first active']")).click();

            List<WebElement> liElements = driver.findElements(new By.ByClassName("product-info"));
            boolean test = false;
            for (WebElement e : liElements){
                if(e.findElement(new By.ByClassName("product-name")).getText().equals("SONY XPERIA")){
                    e.click();
                    WebElement input = driver.findElement(By.xpath("//input[@class='input-text qty']"));
                    input.clear();
                    input.sendKeys("1000");
                    driver.findElement(By.xpath("//button[@class='button btn-update']")).click();
                    try {
                        driver.findElement(By.xpath("//p[@class='item-msg error']")).isDisplayed();
                        driver.findElement(By.xpath("//button[@class='button2 btn-empty']")).click();
                        driver.findElement(By.xpath("//div[@class='cart-empty']")).isDisplayed();
                        test = true;
                    }catch (Exception ignored){}
                    break;
                }

            }
            Assertions.assertTrue(test);


            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
        }
        //7. Quit browser session
        driver.quit();
    }

}
