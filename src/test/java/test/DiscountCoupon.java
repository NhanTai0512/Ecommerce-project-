package test;

import driver.driverFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
@Test
public class DiscountCoupon {

    public static void test() {

        //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {

            driver.get("http://live.techpanda.org/");
            WebElement mobileButton =  driver.findElement(By.linkText("MOBILE"));
            mobileButton.click();
            boolean test= false;
            String testData = "GURU50";


            List<WebElement> liElements = driver.findElements(new By.ByClassName("product-info"));

            for (WebElement e : liElements){
                if(e.findElement(new By.ByClassName("product-name")).getText().equals("SONY XPERIA")){
                    e.click();
                    driver.findElement(By.id("coupon_code")).sendKeys(testData);
                    driver.findElement(By.xpath("//div[@class='button-wrapper']//button[@value='Apply']")).click();
                    float  total = Float.parseFloat(driver.findElement(By.xpath("//tfoot//tr//td[@class='a-right']//strong//span[@class='price']")).getText().substring(1));
                    float  sub = Float.parseFloat(driver.findElement(By.xpath("//tbody//tr//td[@class='a-right']//span[@class='price']")).getText().substring(1));
                    if (((sub * 95) / 100) == total) {
                        test = true;
                    }
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
