package pages;

import assertions.FindTransactionsAssertion;
import org.openqa.selenium.WebDriver;

public class FindTransactionResultPage extends LoggedInPage {

    public FindTransactionsAssertion transactionAssertion;

    public FindTransactionResultPage(WebDriver driver) {
        super(driver);
        transactionAssertion = new FindTransactionsAssertion(driver);
    }




}
