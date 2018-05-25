package pages;

import assertions.NewAccountAssertion;
import com.gargoylesoftware.htmlunit.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import sun.applet.Main;

public class OpenAccountPage extends MainPage {

    @FindBy(xpath = "//a[contains(@href,'parabank/openaccount.htm')]")
    private WebElement openNewAccountText;
    @FindBy(xpath = "//input[@value='Open New Account']")
    private WebElement openNewAccountButton;
    public NewAccountAssertion newAccountAssertion;


    public OpenAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        newAccountAssertion = new NewAccountAssertion(driver);
    }

    public OpenAccountPage openNewAccount() {
        openNewAccountButton.click();
        return this;
    }

    public OpenAccountPage selectType(String type) {
        Select typeAccount = new Select(driver.findElement(By.xpath("//select[@id='type']")));
        typeAccount.selectByValue(type);
        return this;

    }

    public OpenAccountPage selectAccount(String number) {
        Select typeAccount = new Select(driver.findElement(By.xpath("//select[@id='fromAccountId']")));
        typeAccount.selectByValue(number);
        return this;


    }

}
