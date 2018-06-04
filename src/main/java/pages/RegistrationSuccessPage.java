package pages;

import assertions.RegistrationAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

public class RegistrationSuccessPage extends LoggedInPage{

    public RegistrationAssertion registrationAssertion;



    public RegistrationSuccessPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
        registrationAssertion = new RegistrationAssertion(driver, context);
    }








}
