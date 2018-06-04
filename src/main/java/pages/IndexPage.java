package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

public class IndexPage extends MainPage {

    private String url;

    @FindBy(css = "[name=username]") private WebElement userNameInput;
    @FindBy(css = "[name=password]") private WebElement passwordInput;
    @FindBy(css = ".login .button") private WebElement loginButton;
    @FindBy(xpath = "//a[contains(@href,'register.htm')]") private WebElement registerText;
    @FindBy(xpath = "//a[contains(@href,'lookup.htm')]") private WebElement forgotLoginButton;


    public IndexPage(WebDriver driver, ITestContext context, String url) {
        super(driver, context);
        PageFactory.initElements(driver, this);
        this.url = url;
    }


    public IndexPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
    }

    public IndexPage openParabank() {
        driver.get(url);
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
        return new AccountPage(driver,getContext());
    }

    public RegistrationPage register() {
        registerText.click();
        return new RegistrationPage(driver, getContext());
    }

    public LookUpPage remindLoginInfo() {
        forgotLoginButton.click();
        return new LookUpPage(driver, getContext());
    }



}
