package pages;


import org.openqa.selenium.WebDriver;

public class LoggedInPage extends MainPage {

    public MenuPage menu;

    public LoggedInPage(WebDriver driver) {
        super(driver);
        menu = new MenuPage(driver);    //odwołanie poprzez menu do dowolnego linku
    }



}
