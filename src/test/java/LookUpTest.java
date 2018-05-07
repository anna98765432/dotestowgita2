import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.LookUpPage;
import pages.RegistrationPage;

public class LookUpTest {
    WebDriver driver;
    LookUpPage lookUpPage;
    RegistrationPage registrationPage;
    IndexPage indexPage;


    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        lookUpPage = new LookUpPage(driver);
        indexPage = new IndexPage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @AfterMethod
    public void after() {
        driver.close();
    }

    @Test
    public void shouldRecoverPassword() {

        registrationPage.openRegister();
        registrationPage.signIn("Anna", "Jarzyna", "Malinowa", "Zakopane", "Opolskie", "2",
                "", "", "jarzyna123", "jarzyna123");
        registrationPage.fillRandomUsername();
        registrationPage.fillRandomSSN();
        registrationPage.clickRegister();
        registrationPage.logOut();
        indexPage.waitForJStoLoad();
        indexPage.remindLoginInfo();
        lookUpPage.fillInLoginInfo("Anna", "Jarzyna", "Malinowa", "Zakopane", "Opolskie",
                "2", "");
        lookUpPage.repeatRandomSSN();
        lookUpPage.clickFindLoginInfo();
        Assert.assertTrue(lookUpPage.hasPasswodBeenRecovered());
    }

    @Test
    public void shouldNotRecoverPasswordBecauseOfNotProvidingSSN() {
        lookUpPage.openLookUpPage();
        lookUpPage.fillInLoginInfo("Anna", "Jarzyna", "Malinowa", "Zakopane", "Opolskie",
                "2", "");
        lookUpPage.clickFindLoginInfo();
        Assert.assertTrue(lookUpPage.isUserMissingSSN());

    }

    @Test
    public void shouldNotRecoverPasswordBecauseUserDoesntExist() {
        lookUpPage.openLookUpPage();
        lookUpPage.fillInLoginInfo("xyz", "xyz", "XXX", "TYR", "XZY",
                "456", "09876543");
        lookUpPage.clickFindLoginInfo();
        Assert.assertFalse(lookUpPage.hasPasswodBeenRecovered());
    }


}
