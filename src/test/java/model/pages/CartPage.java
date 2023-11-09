package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class CartPage {
    private WebDriver driver;

    private By country= By.xpath("//li[@class='shipping-country']//div[@class='input-box']//select[@id='country']");
    private By state = By.xpath ("//li[@class='shipping-region']//div[@class='input-box']//select[@id='region_id']");
    private By zip = By.id("postcode");
    private By estimateBtn = By.xpath("//div[@class='buttons-set']//button[@class='button2']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputCountry(String countries) {
        WebElement confirmPasswordElement = driver.findElement(country);
        Select s = new Select(confirmPasswordElement);
        s.selectByValue(countries);
    }
    public void inputState(String states) {
        WebElement confirmPasswordElement = driver.findElement(state);
        Select s = new Select(confirmPasswordElement);
        s.selectByValue(states);
    }
    public void inputZip(String zips) {
        WebElement confirmPasswordElement = driver.findElement(zip);
        confirmPasswordElement.sendKeys(zips);
    }
    public void clickEstimateBtn() {
        WebElement registerButtonElement = driver.findElement(estimateBtn);
        registerButtonElement.click();
    }

}