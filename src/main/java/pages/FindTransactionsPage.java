package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;

public class FindTransactionsPage extends LoggedInPage {

    @FindBy(css = "select[id='accountId']")
    private WebElement accountId;
    @FindBy(css = "input[id='criteria.transactionId']")
    private WebElement transactionIdInput;
    @FindBy(css = "button[value='ID']")
    private WebElement findTransactionByIdButton;
    @FindBy(css = "input[id='criteria.onDate']")
    private WebElement transactionDateInput;
    @FindBy(css = "button[value='DATE']")
    private WebElement findTransactionByDateButton;
    @FindBy(css = "input[id='criteria.fromDate']")
    private WebElement transactionDateRangeFromInput;
    @FindBy(css = "input[id='criteria.toDate']")
    private WebElement transactionDateRangeToInput;
    @FindBy(css = "button[value='DATE_RANGE']")
    private WebElement findTransactionByDateRangeButton;
    @FindBy(css = "input[id='criteria.amount']")
    private WebElement transactionAmountInput;
    @FindBy(css = "button[value='AMOUNT']")
    private WebElement findTransactionByAmountButton;


    public FindTransactionsPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
    }

    public FindTransactionsPage selectAccountId(int number) {
        Select accountId1 = new Select(accountId);
        accountId1.selectByIndex(number);
        return this;
    }

    public FindTransactionsPage sendTransactionIdToFind(String number) {
        transactionIdInput.sendKeys(number);
        return this;
    }

    public FindTransactionResultPage findTransactionById() {
        findTransactionByIdButton.click();
        return new FindTransactionResultPage(driver, getContext());
    }

    public FindTransactionsPage sendDateToFind(String data) {
        transactionDateInput.sendKeys(data);
        return this;
    }

    public FindTransactionResultPage findTransactionByDate() {
        findTransactionByDateButton.click();
        return new FindTransactionResultPage(driver, getContext());
    }

    public FindTransactionsPage sendDateToFindByRangeFrom(String data) {
        transactionDateRangeFromInput.sendKeys(data);
        return this;
    }

    public FindTransactionsPage sendDateToFindByRangeTo(String data) {
        transactionDateRangeToInput.sendKeys(data);
        return this;
    }

    public FindTransactionResultPage findTransactionByDateRange() {
        findTransactionByDateButton.click();
        return new FindTransactionResultPage(driver, getContext());
    }

    public FindTransactionsPage sendAmountToFind(String amount) {
        transactionAmountInput.sendKeys(amount);
        return this;
    }

    public FindTransactionResultPage findTransactionByAmount() {
        findTransactionByAmountButton.click();
        return new FindTransactionResultPage(driver, getContext());
    }


}
