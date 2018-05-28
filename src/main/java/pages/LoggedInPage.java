package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedInPage extends MainPage {


    public MenuPage menu;

    public LoggedInPage(WebDriver driver) {
        super(driver);
        menu = new MenuPage(driver);    //odwołanie poprzez menu do dowolnego linku
    }





}
