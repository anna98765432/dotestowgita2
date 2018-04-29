import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.IndexPage;

public class LoginTest {
    WebDriver driver;
    IndexPage indexPage;
    AccountPage accountPage;

    @BeforeMethod
    public void before(){
        driver = new ChromeDriver();
        indexPage = new IndexPage(driver);
        accountPage = new AccountPage(driver);

    }

    @Test
    public void shouldLogin() {
        indexPage.openParabank();
        indexPage.fillUsername("John");
        indexPage.fillPassword("123123!$L");
        indexPage.clickLogin();
        Assert.assertTrue(accountPage.isUserLoggedIn());
    }



}
