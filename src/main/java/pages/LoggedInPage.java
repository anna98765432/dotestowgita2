package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.ITestContext;

public class LoggedInPage extends MainPage {


    public MenuPage menu;

    public LoggedInPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        menu = new MenuPage(driver, context);    //odwołanie poprzez menu do dowolnego linku

    }





}
