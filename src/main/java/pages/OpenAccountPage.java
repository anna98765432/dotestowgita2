package pages;

import assertions.NewAccountAssertion;
import com.gargoylesoftware.htmlunit.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;
import sun.applet.Main;

public class OpenAccountPage extends LoggedInPage {

    @FindBy(xpath = "//input[@value='Open New Account']")
    private WebElement openNewAccountButton;
    @FindBy(xpath = "//select[@id='type']")
    private WebElement accountType;
    @FindBy(xpath = "//select[@id='fromAccountId']")
    private WebElement accountNumber;

    public NewAccountAssertion newAccountAssertion;


    public OpenAccountPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
        newAccountAssertion = new NewAccountAssertion(driver, context);
    }

    public OpenAccountPage openNewAccount() {
        openNewAccountButton.click();
        return this;
    }

    public OpenAccountPage selectType(String type) {
        Select typeAccount = new Select(accountType);
        typeAccount.selectByValue(type);
        return this;
    }

    public OpenAccountPage selectAccount(String number) {
        Select typeAccount = new Select(accountNumber);
        typeAccount.selectByValue(getContextAttribute(number));
        return this;
    }


    public OpenAccountPage selectAccountByValue(int number) {
        Select accountId = new Select(accountNumber);
        accountId.selectByIndex(number);
        return this;
    }

}
