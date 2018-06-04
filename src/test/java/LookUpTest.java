import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.IndexPage;
import pages.LookUpPage;
import pages.RegistrationPage;
import scenarios.FindUserInfoScenario;

public class LookUpTest extends MainTest {
    String lvRandomSSN;


    @BeforeClass
    @Parameters({"url"})
    public void beforeLookUp(String url) {
        lvRandomSSN = generateRandomSsn();
        beforeTest(context, url);
        indexPage.openParabank()
                .register()
                .setFirstName("Anna")
                .setLastName("Jarzyna")
                .setStreet("Malinowa")
                .setCity("Opole")
                .setState("Opolskie")
                .setZipCode("21-098")
                .setSsn(lvRandomSSN)
                .setUsername(generateRandomUsername())
                .setPassword("anna123")
                .setRepeatedPassword("anna123")
                .clickRegister()
                .menu.logOut();
        afterTest();

    }


    @Test
    public void shouldRecoverPassword() {

        indexPage.run(new FindUserInfoScenario("Anna", "Jarzyna", "Malinowa", "Opole", "Opolskie", "21-098", lvRandomSSN));
        Assert.assertTrue(lookUpPage.hasPasswodBeenRecovered());
    }

    @Test
    public void shouldNotRecoverPasswordBecauseOfNotProvidingSSN() {
        indexPage.openParabank()
                .remindLoginInfo()
                .setFirstName("Anna")
                .setLastName("Jarzyna")
                .setStreetInput("Malinowa")
                .setCityInput("Opole")
                .setStateInput("Opolskie")
                .setZipCode("21-098")
                .clickFindLoginInfo();
        Assert.assertTrue(lookUpPage.isUserMissingSSN());

    }

    @Test
    public void shouldNotRecoverPasswordBecauseUserDoesntExist() {
        indexPage.openParabank()
                .remindLoginInfo()
                .setFirstName("xyz")
                .setLastName("zzzzz")
                .setStreetInput("jfjkds")
                .setCityInput("mfkdsf")
                .setStateInput("fkdjls")
                .setZipCode("21-098")
                .clickFindLoginInfo();
        Assert.assertFalse(lookUpPage.hasPasswodBeenRecovered());
    }


}
