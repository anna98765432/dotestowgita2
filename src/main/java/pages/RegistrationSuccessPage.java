package pages;

import assertions.RegistrationAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationSuccessPage extends MainPage{

    public RegistrationAssertion registrationAssertion;

    @FindBy(xpath = "//a[contains(@href,'logout.htm')]") private WebElement logoutText;

    public RegistrationSuccessPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        registrationAssertion = new RegistrationAssertion(driver);
    }

    public IndexPage logOut() {
        logoutText.click();
        return new IndexPage(driver);
    }






}
