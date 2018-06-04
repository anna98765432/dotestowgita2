import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.IndexPage;
import pages.RegistrationPage;
import scenarios.LoginScenario;
import scenarios.RegistrationScenario;
import sun.security.pkcs.SignerInfo;

import java.util.GregorianCalendar;
import java.util.UUID;


public class RegistrationTest extends MainTest {

    String randomUsername;


    @BeforeClass
    @Parameters({"url","firstName1","street"})
    public void beforeRegistration(String url, String firstName1, String street) {
        beforeTest(context, url);
        randomUsername = generateRandomUsername();
        indexPage.run(new RegistrationScenario(firstName1,"Dopowtorzenia",street,"Gliwice",
                "Slaskie","44-100","987654321",randomUsername,"barbara123",
                "barbara123"))
                .menu.logOut();
        afterTest();
    }

    @Test
    @Parameters({"firstName1","street"})
    public void shouldRegister(String firstName1, String street) {
        indexPage.run(new RegistrationScenario(firstName1,"Rabarbar",street,"Warszawa",
                "Mazowieckie","30-120","12345678",generateRandomUsername(),"barbara123",
                "barbara123"))
                .registrationAssertion.hasUserRegisteredAccount();
    }


    @Test
    @Parameters({"firstName1","street"})
    public void shouldNotRegisterBecauseOfNotRepatingPassword(String firstName1, String street) {
        indexPage.openParabank()
                .register()
                .setFirstName(firstName1)
                .setLastName("Banan")
                .setStreet(street)
                .setCity("Kraków")
                .setState("Małopolskie")
                .setZipCode("30-908")
                .setSsn("98765432")
                .setUsername(generateRandomUsername())
                .setPassword("barbara123")
                .setRepeatedPassword("barbara12")
                .clickRegisterFail().
                registrationAssertion.doesPasswordNotMatch();
    }

    @Test
    @Parameters({"firstName1","street"})
    public void shouldNotRegisterBecauseOfNotGivingLastName(String firstName1, String street) {
        indexPage.openParabank()
                .register()
                .setFirstName(firstName1)
                .setStreet(street)
                .setCity("Wrocław")
                .setState("Dolnośląskie")
                .setZipCode("44-789")
                .setSsn("98765432")
                .setUsername(generateRandomUsername())
                .setPassword("alicja123")
                .setRepeatedPassword("alicja123")
                .clickRegisterFail()
                .registrationAssertion.isLastNameMissing();
    }


    @Test
    public void shouldNotRegisterBecauseOfRepeatingUserName() {

        indexPage.openParabank()
                .register()
                .setFirstName("Anna")
                .setLastName("Dopowtorzenia")
                .setStreet("Miarki")
                .setCity("Gliwice")
                .setState("Slaskie")
                .setZipCode("44-100")
                .setSsn("12345678")
                .setUsername(randomUsername)
                .setPassword("barbara123")
                .setRepeatedPassword("barbara123")
                .clickRegisterFail()
                .registrationAssertion.repeatedUsername();
    }


}




