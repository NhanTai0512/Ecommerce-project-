package test;

import driver.driverFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Test
public class compareProductForm {
    public static void testCompareProductForm() {

         //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {

            driver.get("http://live.techpanda.org/");
            driver.findElement(By.xpath("//ol[@class='nav-primary']//li[@class='level0 nav-1 first active']")).click();


            List<WebElement> liElements = driver.findElements(new By.ByClassName("product-info"));
            String p1 = "SONY XPERIA";
            String p2 = "IPHONE";
            boolean test = false;
            for (WebElement e : liElements){

                if(e.findElement(By.className("product-name")).getText().equals(p1)) {
                    e.findElement(By.className("link-compare")).click();
                    break;
                }
            }
            liElements = driver.findElements(new By.ByClassName("product-info"));
            for (WebElement e : liElements){

                if(e.findElement(By.className("product-name")).getText().equals(p2)) {
                   e.findElement(By.className("link-compare")).click();
                    break;
                }
            }
            driver.findElement(By.xpath("//div[@class='actions']//button[@class='button']")).click();

            List<String> windowIds = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(windowIds.get(1));
            List<WebElement> liP = driver.findElements(new By.ByClassName("product-name"));
            if(liP.get(0).getText().equals(p1) && liP.get(1).getText().equals(p2)) {
                test = true;
            }
            driver.findElement(By.xpath("//div[@class='buttons-set']//button[@class='button']")).click();

            Assertions.assertTrue(test);


            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
        }
        //7. Quit browser session
        driver.quit();
    }

}
