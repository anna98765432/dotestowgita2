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

public class LookUpTest extends MainTest {
    String lvRandomSSN;


    @BeforeClass
    public void beforeLookUp() {
        lvRandomSSN = generateRandomSsn();
        beforeTest();
        indexPage.openParabank().register().setFirstName("Anna").setLastName("Jarzyna").setStreet("Malinowa")
                .setCity("Opole").setState("Opolskie").setZipCode("21-098").setSsn(lvRandomSSN).setUsername(generateRandomUsername())
                .setPassword("anna123").setRepeatedPassword("anna123").clickRegister().logOut();
        afterTest();

    }


    @Test
    public void shouldRecoverPassword() {

        indexPage.openParabank();
        indexPage.remindLoginInfo();
        lookUpPage.fillInLoginInfo("Anna", "Jarzyna", "Malinowa", "Opole", "Opolskie",
                "21-098", lvRandomSSN);
        lookUpPage.clickFindLoginInfo();
        Assert.assertTrue(lookUpPage.hasPasswodBeenRecovered());
    }

    @Test
    public void shouldNotRecoverPasswordBecauseOfNotProvidingSSN() {
        indexPage.openParabank();
        indexPage.remindLoginInfo();
        lookUpPage.openLookUpPage();
        lookUpPage.fillInLoginInfo("Anna", "Jarzyna", "Malinowa", "Opole", "Opolskie",
                "21-098", "");
        lookUpPage.clickFindLoginInfo();
        Assert.assertTrue(lookUpPage.isUserMissingSSN());

    }

    @Test
    public void shouldNotRecoverPasswordBecauseUserDoesntExist() {
        indexPage.openParabank();
        indexPage.remindLoginInfo();
        lookUpPage.openLookUpPage();
        lookUpPage.fillInLoginInfo("xyz", "xyz", "XXX", "TYR", "XZY",
                "456", "09876543");
        lookUpPage.clickFindLoginInfo();
        Assert.assertFalse(lookUpPage.hasPasswodBeenRecovered());
    }


}
