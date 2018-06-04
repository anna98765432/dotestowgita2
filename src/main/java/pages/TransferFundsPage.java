package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;

public class TransferFundsPage extends LoggedInPage {
    @FindBy (css= "input[id='amount']") private WebElement amountInput;
    @FindBy (css= "select[id='fromAccountId']") private WebElement accountFromSelect;
    @FindBy (css= "select[id='toAccountId']") private WebElement accountToSelect;
    @FindBy (css= "input[value='Transfer']") private WebElement transferButton;



    public TransferFundsPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
    }

    public TransferFundsPage insertAmount(String amount){
        amountInput.sendKeys(amount);
        return this;
    }

    public TransferFundsPage selectAccountFrom(int number){
        Select accountId = new Select(accountFromSelect);
        accountId.selectByIndex(number);
        return this;
    }

    public TransferFundsPage selectAccountTo(int number){
        Select accountId = new Select(accountToSelect);
        accountId.selectByIndex(number);
        return this;
    }

    public SuccessfulTransferPage transferFundsSuccess(){
        transferButton.click();
        return new SuccessfulTransferPage(driver, getContext());

    }






}
