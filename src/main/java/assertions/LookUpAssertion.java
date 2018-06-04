package assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import pages.MainPage;

public class LookUpAssertion extends MainPage{

    @FindBy(xpath = "//p[@class='error']") private WebElement errorUser;
    @FindBy(xpath = "//div[@id='rightPanel']") private WebElement rightPanel;
    @FindBy(xpath = "//span[@id='ssn.errors']") private WebElement errorSSN;


    public LookUpAssertion(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
    }

    public void passwordAndUsernameAreNotVerified() {
        Assert.assertTrue(errorUser.getText().contains("The username and password could not be verified."));


    }
    public void hasPasswodBeenRecovered() {
        Assert.assertTrue(rightPanel.getText().contains("Password"));
    }

    public void isUserMissingSSN() {
        Assert.assertTrue(errorSSN.getText().contains("Social Security Number is required."));
    }


}
