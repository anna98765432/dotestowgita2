package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends MainPage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean passwordAndUsernameAreNotVerified(){
       return driver.findElement(By.xpath("//p[@class='error']")).getText().contains("The username and password could not be verified.");
    }




}
