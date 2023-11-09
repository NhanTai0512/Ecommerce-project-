package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    private By emailAddress= By.id("email");
    private By password = By.id("pass");
    private By loginBtn = By.xpath("//div[@class='buttons-set']//button[@class='button']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputEmail(String email) {
        WebElement confirmPasswordElement = driver.findElement(emailAddress);
        confirmPasswordElement.sendKeys(email);
    }
    public void inputPassword(String pass) {
        WebElement confirmPasswordElement = driver.findElement(password);
        confirmPasswordElement.sendKeys(pass);
    }

    public void clickLoginBtn() {
        WebElement registerButtonElement = driver.findElement(loginBtn);
        registerButtonElement.click();
    }
}
