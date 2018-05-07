package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountPage extends MainPage{

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserLoggedIn(){
        return driver.findElement(By.cssSelector("[href$='logout.htm']")).isDisplayed();
    }


}
