package model.pages;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.ui.Select;

public class CheckOutPage {
    private WebDriver driver;

    private By firstName= By.id("billing:firstname");
    private By middleName= By.id("billing:middlename");
    private By lastName = By.id("billing:lastname");
    private By company = By.id("billing:company");
    private By address1 = By.id("billing:street1");
    private By address2 = By.id("billing:street2");
    private By city = By.id("billing:city");
    private By state  = By.id("billing:region_id");
    private By zip = By.id("billing:postcode");
    private By country = By.id("billing:country_id");
    private By telephone = By.id("billing:telephone");
    private By fax = By.id("billing:fax");
    private By continueBtn = By.xpath("//div[@class='buttons-set']//button[@class='button']");

    public CheckOutPage(WebDriver driver) {
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
    public void inputCompany(String companies) {
        WebElement confirmPasswordElement = driver.findElement(company);
        confirmPasswordElement.sendKeys(companies);
    }
    public void inputAddress1(String address01) {
        WebElement confirmPasswordElement = driver.findElement(address1);
        confirmPasswordElement.sendKeys(address01);
    }
    public void inputAddress2(String address02) {
        WebElement confirmPasswordElement = driver.findElement(address2);
        confirmPasswordElement.sendKeys(address02);
    }
    public void inputCity(String cty) {
        WebElement confirmPasswordElement = driver.findElement(city);
        confirmPasswordElement.sendKeys(cty);
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
    public void inputCountry(String countries) {
        WebElement confirmPasswordElement = driver.findElement(country);
        Select s = new Select(confirmPasswordElement);
        s.selectByValue(countries);
    }
    public void inputTelephone(String tlephone) {
        WebElement confirmPasswordElement = driver.findElement(telephone);
        confirmPasswordElement.sendKeys(tlephone);
    }
    public void inputFax(String faxx) {
        WebElement confirmPasswordElement = driver.findElement(fax);
        confirmPasswordElement.sendKeys(faxx);
    }

    public void clickContinueBtn() {
        WebElement registerButtonElement = driver.findElement(continueBtn);
        registerButtonElement.click();
    }
}