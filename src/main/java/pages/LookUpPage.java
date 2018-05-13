package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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


    public LookUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openLookUpPage() {
        driver.get("http://parabank.parasoft.com/parabank/lookup.htm");
    }

    public void setFirstName(String firstname) {
        firstNameInput.sendKeys(firstname);
    }

    public void lastFirstName(String lastname) {
        lastNameInput.sendKeys(lastname);
    }

    public void setStreetInput(String street) {
        streetInput.sendKeys(street);
    }

    public void setCityInput(String city) {
        cityInput.sendKeys(city);
    }

    public void setStateInput(String state) {
        stateInput.sendKeys(state);
    }

    public void setZipCode(String zipCode) {
        zipCodeInput.sendKeys(zipCode);
    }

    public void setSsn(String ssn) {
        ssnInput.sendKeys(ssn);
    }

    public void fillInLoginInfo(String firstName, String lastName, String addressStreet, String adressCity, String adressState,
                                String zipCode, String SSN) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        streetInput.sendKeys(addressStreet);
        cityInput.sendKeys(adressCity);
        stateInput.sendKeys(adressState);
        zipCodeInput.sendKeys(zipCode);
        ssnInput.sendKeys(SSN);
    }

    public void clickFindLoginInfo() {
        driver.findElement(By.xpath("//input[@value='Find My Login Info']")).click();
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
