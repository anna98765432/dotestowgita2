package pages;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends MainPage{

    @FindBy(css = "[href*='overwiev.htm']") private WebElement accountsOverviewLink;

    public MenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AccountPage clickAccountsOverview(){
        accountsOverviewLink.click();
        return new AccountPage(driver);
    }


}
