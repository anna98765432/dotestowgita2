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
    @Parameters({"url"})
    public void beforeRegistration(String url) {
        randomUsername = generateRandomUsername();
        indexPage.run(new RegistrationScenario("Anna","Dopowtorzenia","Miarki","Gliwice",
                "Slaskie","44-100","987654321",randomUsername,"barbara123",
                "barbara123"))
                .menu.logOut();
        afterTest();
    }

    @Test
    public void shouldRegister() {
        indexPage.run(new RegistrationScenario("Barbara","Rabarbar","Mikołajska","Warszawa",
                "Mazowieckie","30-120","12345678",generateRandomUsername(),"barbara123",
                "barbara123"))
                .registrationAssertion.hasUserRegisteredAccount();
    }


    @Test
    public void shouldNotRegisterBecauseOfNotRepatingPassword() {
        indexPage.openParabank()
                .register()
                .setFirstName("Jan")
                .setLastName("Banan")
                .setStreet("Aleje")
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
    public void shouldNotRegisterBecauseOfNotGivingLastName() {
        indexPage.openParabank()
                .register()
                .setFirstName("Alicja")
                .setStreet("Nadwiślańska")
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




