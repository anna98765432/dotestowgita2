package pages;

import assertions.RegistrationAssertion;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

public class SuccessfulTransferPage extends LoggedInPage {

//    public TransferAssertion transferAssertion;

    public SuccessfulTransferPage(WebDriver driver, ITestContext context) {
        super(driver, context);
//        transferAssertion = new TransferAssertion(driver);
    }
}
