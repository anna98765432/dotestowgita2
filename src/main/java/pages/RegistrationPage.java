package pages;

import assertions.LoginAssertion;
import assertions.RegistrationAssertion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.UUID;

public class RegistrationPage extends MainPage {

    public RegistrationAssertion registrationAssertion;

@FindBy(css = "input[value='Register']") private WebElement registerButton;

@FindBy(xpath = "//input[@id='customer.firstName']") private WebElement firstNameInput;
@FindBy(xpath = "//input[@id='customer.lastName']") private WebElement lastNameInput;
@FindBy(xpath = "//input[@id='customer.address.street']") private WebElement streetInput;
@FindBy(xpath = "//input[@id='customer.address.city']") private WebElement cityInput;
@FindBy(xpath = "//input[@id='customer.address.state']") private WebElement stateInput;
@FindBy(xpath = "//input[@id='customer.address.zipCode']") private WebElement zipCodeInput;
@FindBy(css = "input[id='customer.ssn']") private WebElement ssnInput;
@FindBy(css = "input[id='customer.username']") private WebElement usernameInput;
@FindBy(css = "input[id='customer.password']") private WebElement passwordInput;
@FindBy(css = "input[id='repeatedPassword']") private WebElement repeatedPasswordInput;




    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        registrationAssertion = new RegistrationAssertion(driver);
    }

    public RegistrationPage openRegister() {
        driver.get("http://parabank.parasoft.com/parabank/register.htm");
        return  this;
    } //to moze do zmiany wywalenia

    public RegistrationSuccessPage clickRegister() {
        registerButton.click();
        return new RegistrationSuccessPage(driver);

    }

    public RegistrationPage clickRegisterFail() {
        registerButton.click();
        return new RegistrationPage(driver);

    }


    public RegistrationPage setFirstName(String firstName){
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName){
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public RegistrationPage setStreet(String street){
        streetInput.sendKeys(street);
        return this;
    }

    public RegistrationPage setCity(String city){
        cityInput.sendKeys(city);
        return this;
    }


    public RegistrationPage setState(String state){
        stateInput.sendKeys(state);
        return this;
    }

    public RegistrationPage setZipCode(String zipCode){
        zipCodeInput.sendKeys(zipCode);
        return this;
    }

    public RegistrationPage setSsn(String ssn){
        ssnInput.sendKeys(ssn);
        return this;
    }

    public RegistrationPage setUsername(String username){
        usernameInput.sendKeys(username);
        return this;
    }

    public RegistrationPage setPassword(String password){
        passwordInput.sendKeys(password);
        return this;
    }

    public RegistrationPage setRepeatedPassword(String password){
        repeatedPasswordInput.sendKeys(password);
        return this;
    }






}

