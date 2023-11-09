package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;
import java.util.List;

@Test
public class sortProductForm {
    public static void testSortForm() {

         //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("http://live.techpanda.org/");
            WebElement mobileButton =  driver.findElement(By.linkText("MOBILE"));
            mobileButton.click();


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("select"))));

            Select select = new Select(element);
            select.selectByVisibleText("Name");
            //test sort

            List<WebElement> liElements = driver.findElements(By.className("product-name"));
            boolean isSorted = true;

            for (int i = 0; i < liElements.size() - 1; i++) {
                String currentText = liElements.get(i).getText();
                String nextText = liElements.get(i + 1).getText();

                if (currentText.compareToIgnoreCase(nextText) > 0) {
                    isSorted = false;
                    break;
                }
            }
            Assertions.assertTrue(isSorted);






            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
        }
        //7. Quit browser session
        driver.quit();
    }
}
