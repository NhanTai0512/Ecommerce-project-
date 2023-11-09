package test;

import driver.driverFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;


import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import java.io.File;
import java.io.IOException;


@Test
public class ScreenshotCapture {

    public static void test() {

        //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {

            driver.get("http://live.techpanda.org/index.php/backendlogin");
            boolean test= false;

            try {

                driver.findElement(By.id("username")).sendKeys("user01");
                driver.findElement(By.id("login")).sendKeys("guru99com");
                driver.findElement(By.xpath("//div[@class='form-buttons']//input[@class='form-button']")).click();
                driver.findElement(By.xpath("//div[@class='message-popup-head']//a[@title='close']")).click();
                driver.findElement(By.linkText("Sales")).click();
                driver.findElement(By.linkText("Orders")).click();


                driver.findElement(By.id("sales_order_grid_filter_real_order_id")).sendKeys("100021293");
                driver.findElement(By.name("created_at[from]")).sendKeys("01/01/2020");
                driver.findElement(By.name("created_at[to]")).sendKeys("01/01/2024");
                driver.findElement(By.xpath("//button[@title='Search']")).click();

                Thread.sleep(5000);

                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String screenshotLocation = "./src/screenshot/screenshot.png";
                FileUtils.copyFile(screenshotFile, new File(screenshotLocation));
                System.out.println("Screenshot captured and saved to: " + screenshotLocation);

                test= true;
            }
            catch (Exception ignored){}



            Assertions.assertTrue(test);


            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
        }
        //7. Quit browser session
        driver.quit();
    }
}
