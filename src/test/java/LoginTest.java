import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class LoginTest {
    WebDriver driver;
    IndexPage indexPage;
    AccountPage accountPage;
    RegistrationPage registrationPage;
    LoginPage loginPage;

    @BeforeClass
    public void before1() {
        driver = new ChromeDriver();
        registrationPage = new RegistrationPage(driver);
        registrationPage.openRegister();
        registrationPage.signIn("Mariola", "Michalska", "Wislana", "Warszawa", "Mazowieckie",
                "30-121", "12345678", "barbara123", "barbara123", "barbara123");
        registrationPage.fillRandomUsername();
        registrationPage.clickRegister();

    }

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        indexPage = new IndexPage(driver);
        accountPage = new AccountPage(driver);
        loginPage = new LoginPage(driver);

    }

    @AfterMethod
    public void after() {
        driver.close();
    }

    @Test
    public void shouldLogin() {
        indexPage.openParabank();
        indexPage.fillUsername("John");
        indexPage.fillPassword("123123!$L");
        indexPage.clickLogin();
        Assert.assertTrue(accountPage.isUserLoggedIn());
    }

    @Test
    public void shouldLoginMyUser() {
        indexPage.openParabank();
        indexPage.fillUsername(MainPage.keepsUsername.toString());
        indexPage.fillPassword("barbara123");
        indexPage.clickLogin();
        Assert.assertTrue(accountPage.isUserLoggedIn());
    }


    @Test
    public void shouldNotLoginBecauseOfWrongPassword() {
        indexPage.openParabank();
        indexPage.fillUsername(MainPage.keepsUsername.toString());
        indexPage.fillPassword("barbara1234");
        indexPage.clickLogin();
        Assert.assertTrue(loginPage.passwordAndUsernameAreNotVerified());
    }

}




