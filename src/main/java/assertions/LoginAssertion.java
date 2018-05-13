package assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.MainPage;

public class LoginAssertion extends MainPage {

    @FindBy(css = "[href$='logout.htm']") private WebElement logOutButton;
    @FindBy(xpath = "//p[@class='error']") private WebElement errorUser;


    public LoginAssertion(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void isUserLoggedIn() {
        Assert.assertTrue(logOutButton.isDisplayed());
    }


    public void passwordAndUsernameAreNotVerified() {
        Assert.assertTrue(errorUser.getText().contains("The username and password could not be verified."));


    }
}

