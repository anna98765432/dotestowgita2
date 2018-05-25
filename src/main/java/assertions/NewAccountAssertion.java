package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.MainPage;

public class NewAccountAssertion extends MainPage{

    @FindBy(xpath = "//div[@id='rightPanel']/p[text()='Congratulations, your account is now open.']")
    WebElement messageSuccessful;

    public NewAccountAssertion(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void hasUserOpenedNewAccount(){
        Assert.assertTrue(messageSuccessful.getText().contains("Congratulations, your account is now open."));
    }

}
