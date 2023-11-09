package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    private WebDriver driver;

    private By firstName = By.id("firstname");
    private By middleName = By.id("middlename");
    private By lastName = By.id("lastname");
    private By emailAddress= By.id("email_address");
    private By password = By.id("password");
    private By confirmPassword = By.id("confirmation");
    private By registerBtn = By.xpath("//div[@class='buttons-set']//button[@class='button']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputFirstName(String fname) {
        WebElement usernameElement = driver.findElement(firstName);
        usernameElement.sendKeys(fname);
    }

    public void inputMiddleName(String mname) {
        WebElement passwordElement = driver.findElement(middleName);
        passwordElement.sendKeys(mname);
    }

    public void inputLastName(String lname) {
        WebElement confirmPasswordElement = driver.findElement(lastName);
        confirmPasswordElement.sendKeys(lname);
    }
    public void inputEmail(String email) {
        WebElement confirmPasswordElement = driver.findElement(emailAddress);
        confirmPasswordElement.sendKeys(email);
    }
    public void inputPassword(String pass) {
        WebElement confirmPasswordElement = driver.findElement(password);
        confirmPasswordElement.sendKeys(pass);
    }
    public void InputConfirmPassword(String cpass) {
        WebElement confirmPasswordElement = driver.findElement(confirmPassword);
        confirmPasswordElement.sendKeys(cpass);
    }

    public void clickRegisterBtn() {
        WebElement registerButtonElement = driver.findElement(registerBtn);
        registerButtonElement.click();
    }
}