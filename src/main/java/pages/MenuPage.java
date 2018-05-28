package pages;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends MainPage{



    @FindBy(css = "[href*='overwiev.htm']") private WebElement accountsOverviewLink;
    @FindBy(xpath = "//a[contains(@href,'openaccount.htm')]") private WebElement openAccountText;
    @FindBy(xpath = "//a[contains(@href,'logout.htm')]") private WebElement logoutText;
    @FindBy(xpath = "//a[contains(@href,'transfer.htm')]") private WebElement transferFundsText;
    @FindBy(xpath = "//a[contains(@href,'findtrans.htm')]") private WebElement findTransText;

    public MenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AccountPage clickAccountsOverview(){
        accountsOverviewLink.click();
        return new AccountPage(driver);
    }

    public OpenAccountPage openNewAccount (){
        openAccountText.click();
        return new OpenAccountPage(driver);
    }

    public IndexPage logOut() {
        logoutText.click();
        return new IndexPage(driver);
    }

    public TransferFundsPage transferFunds(){
        transferFundsText.click();
        return new TransferFundsPage(driver);

    }

    public FindTransactionsPage findTransfers(){
        findTransText.click();
        return new FindTransactionsPage(driver);

    }




}
