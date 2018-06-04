package pages;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

public class MenuPage extends MainPage {


    @FindBy(css = "[href*='overview.htm']")
    private WebElement accountsOverviewLink;
    @FindBy(xpath = "//a[contains(@href,'openaccount.htm')]")
    private WebElement openAccountText;
    @FindBy(xpath = "//a[contains(@href,'logout.htm')]")
    private WebElement logoutText;
    @FindBy(xpath = "//a[contains(@href,'transfer.htm')]")
    private WebElement transferFundsText;
    @FindBy(xpath = "//a[contains(@href,'findtrans.htm')]")
    private WebElement findTransText;

    public MenuPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
    }

    public AccountPage clickAccountsOverview() {
        accountsOverviewLink.click();
        return new AccountPage(driver, getContext());
    }

    public OpenAccountPage openNewAccount() {
        openAccountText.click();
        return new OpenAccountPage(driver, getContext());
    }

    public IndexPage logOut() {
        logoutText.click();
        return new IndexPage(driver, getContext());
    }

    public TransferFundsPage transferFunds() {
        transferFundsText.click();
        return new TransferFundsPage(driver, getContext());

    }

    public FindTransactionsPage findTransfers() {
        findTransText.click();
        return new FindTransactionsPage(driver, getContext());

    }


}
