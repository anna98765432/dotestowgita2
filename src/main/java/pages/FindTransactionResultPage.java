package pages;

import assertions.FindTransactionsAssertion;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

public class FindTransactionResultPage extends LoggedInPage {

    public FindTransactionsAssertion transactionAssertion;

    public FindTransactionResultPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        transactionAssertion = new FindTransactionsAssertion(driver, context);
    }




}
