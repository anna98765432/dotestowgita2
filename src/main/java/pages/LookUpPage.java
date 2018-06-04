package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Factory;

import java.util.UUID;

public class LookUpPage extends MainPage {
    @FindBy(css = "input[id='firstName']")
    private WebElement firstNameInput;
    @FindBy(css = "input[id='lastName']")
    private WebElement lastNameInput;
    @FindBy(css = "input[id='address.street']")
    private WebElement streetInput;
    @FindBy(xpath = "//input[@id='address.city']")
    private WebElement cityInput;
    @FindBy(xpath = "//input[@id='address.state']")
    private WebElement stateInput;
    @FindBy(xpath = "//input[@id='address.zipCode']")
    private WebElement zipCodeInput;
    @FindBy(xpath = "//input[@id='ssn']")
    private WebElement ssnInput;
    @FindBy(xpath = "//input[@value='Find My Login Info']")
    private WebElement findLoginInfoButton;






    public LookUpPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
    }


    public LookUpPage setFirstName(String firstname) {
        firstNameInput.sendKeys(firstname);
        return this;
    }

    public LookUpPage setLastName(String lastname) {
        lastNameInput.sendKeys(lastname);
        return this;
    }

    public LookUpPage setStreetInput(String street) {
        streetInput.sendKeys(street);
        return this;
    }

    public LookUpPage setCityInput(String city) {
        cityInput.sendKeys(city);
        return this;
    }

    public LookUpPage setStateInput(String state) {
        stateInput.sendKeys(state);
        return this;
    }

    public LookUpPage setZipCode(String zipCode) {
        zipCodeInput.sendKeys(zipCode);
        return this;
    }

    public LookUpPage setSsn(String ssn) {
        ssnInput.sendKeys(ssn);
        return this;
    }


    public LookUpPage clickFindLoginInfo() {
        findLoginInfoButton.click();
        return this;
    }

    public void passwordAndUsernameAreNotVerified() {
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='error']")).getText().contains("The username and password could not be verified."));


    }
    public boolean hasPasswodBeenRecovered() {
        return driver.findElement(By.xpath("//div[@id='rightPanel']")).getText().contains("Password");
    }

    public boolean isUserMissingSSN() {
        return driver.findElement(By.xpath("//span[@id='ssn.errors']")).getText().contains("Social Security Number is required.");
    }


}
