package pages;

import assertions.LoginAssertion;
import assertions.NewAccountAssertion;
import assertions.RegistrationAssertion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AccountPage extends MainPage{
    public LoginAssertion loginAssertion;
    public RegistrationAssertion registrationAssertion;

    @FindBy(xpath = "//a[contains(@href,'openaccount.htm')]") private WebElement openAccountText;

    public AccountPage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);
        loginAssertion = new LoginAssertion(driver);
        registrationAssertion = new RegistrationAssertion(driver);

    }

    public OpenAccountPage openNewAccount (){
        openAccountText.click();
        return new OpenAccountPage(driver);
    }






}
