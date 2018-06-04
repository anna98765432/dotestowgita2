package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import pages.MainPage;

public class FindTransactionsAssertion extends MainPage {

    @FindBy(css = "table[id='transactionTable']") private WebElement transactionTable;


    public FindTransactionsAssertion(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
    }

    public void hasAnyTransactionBeenFound(){
        Assert.assertTrue(transactionTable.isDisplayed());
    }

    public void hasNotAnyTransactionBeenFound(){
        Assert.assertTrue(!transactionTable.isDisplayed());
    }


}