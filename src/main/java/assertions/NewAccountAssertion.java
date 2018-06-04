package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import pages.MainPage;

public class NewAccountAssertion extends MainPage{

    @FindBy(xpath = "//div[@id='rightPanel']/p[text()='Congratulations, your account is now open.']")
    WebElement messageSuccessful;
    @FindBy(xpath = "//div[@id='rightPanel']/p")
    WebElement messageUnsuccessfulFindingTransaction;

    public NewAccountAssertion(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver,this);
    }

    public void hasUserOpenedNewAccount(){
        Assert.assertTrue(messageUnsuccessfulFindingTransaction.getText().contains("No transactions found."));
    }

}
