package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.MainPage;
import sun.applet.Main;

public class RegistrationAssertion extends MainPage {

    @FindBy(xpath = "//a[contains(@href,'logout.htm')]") private WebElement logoutButton;
    @FindBy(xpath = "//span[@id='repeatedPassword.errors']") private WebElement passwordError;
    @FindBy(xpath = "//span[@id='customer.lastName.errors']") private WebElement lastnameError;
    @FindBy(xpath = "//div[@id='rightPanel']/p") private WebElement rightPanelTest;
    @FindBy(xpath = "//span[@id='customer.username.errors']") private WebElement usernameErrors;

    public RegistrationAssertion(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void hasUserRegisteredAccount() {
        Assert.assertTrue(logoutButton.isDisplayed());

    }

    public void doesPasswordNotMatch() {
        Assert.assertTrue(passwordError.getText().contains("Passwords did not match."));
    }

    public void isLastNameMissing() {
        Assert.assertTrue(lastnameError.getText().contains("Last name is required."));
    }

    public void hasUserCreatedAccount() {
        Assert.assertTrue(rightPanelTest.getText().contains("Your account was created successfully."));
    }

    public void repeatedUsername() {
        Assert.assertTrue(usernameErrors.getText().contains("This username already exists."));
    }
}
