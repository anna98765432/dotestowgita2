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
import org.testng.ITestContext;

import java.util.List;

public class AccountPage extends LoggedInPage{
    public LoginAssertion loginAssertion;
    public RegistrationAssertion registrationAssertion;

    @FindBy(css = "#accountTable a") private List<WebElement> accountsElements;
    @FindBy(xpath = "//a[contains(@href,'openaccount.htm')]") private WebElement openAccountText;

    public AccountPage(WebDriver driver, ITestContext context) {

        super(driver, context);
        PageFactory.initElements(driver, this);
        loginAssertion = new LoginAssertion(driver, context);
        registrationAssertion = new RegistrationAssertion(driver, context);

    }

    public AccountPage getAccountNumber(String accountKeyName){
        String accountValue = accountsElements.get(0).getText();
        setContextAttribute(accountKeyName, accountValue);
        return this;
    }



}
