package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends MainPage {

    private String username;

    @FindBy(css = "[name=username]") private WebElement userNameInput;
    @FindBy(css = "[name=password]") private WebElement passwordInput;
    @FindBy(css = ".login .button") private WebElement loginButton;
    @FindBy(xpath = "//a[contains(@href,'register.htm')]") private WebElement registerText;
    @FindBy(xpath = "//a[contains(@href,'lookup.htm')]") private WebElement forgotLoginButton;


    public IndexPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public IndexPage openParabank() {
        driver.get("http://parabank.parasoft.com");
        waitForJStoLoad();
        return this;
    }


    public IndexPage fillUsername(String username) {
        userNameInput.sendKeys(username);
        return this;
    }

    public IndexPage fillPassword(String password) {
        passwordInput.sendKeys(password);
        return this;

    }

    public AccountPage clickLogin() {
        loginButton.click();
        return new AccountPage(driver);
    }

    public RegistrationPage register() {
        registerText.click();
        return new RegistrationPage(driver);
    }

    public LookUpPage remindLoginInfo() {
        forgotLoginButton.click();
        return new LookUpPage(driver);
    }



}
