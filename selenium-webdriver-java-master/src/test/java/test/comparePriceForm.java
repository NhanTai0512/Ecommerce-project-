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
public class comparePriceForm {
    public static void testComparePriceForm() {

         //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {

            driver.get("http://live.techpanda.org/");
            driver.findElement(By.xpath("//ol[@class='nav-primary']//li[@class='level0 nav-1 first active']")).click();


            List<WebElement> liElements = driver.findElements(new By.ByClassName("product-info"));
            boolean test = false;
            for (WebElement e : liElements){
                WebElement p11 = e.findElement(new By.ByClassName("product-name"));
                if(p11.getText().equals("SONY XPERIA")){
                    WebElement p2 = e.findElement(By.className("price"));
                    String price = p2.getText();
                    p11.click();
                    if (price.equals(driver.findElement(By.className("price")).getText())){
                        test=true;
                        break;
                    }
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
