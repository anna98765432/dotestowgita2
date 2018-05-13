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
import sun.security.pkcs.SignerInfo;

import java.util.GregorianCalendar;
import java.util.UUID;


public class RegistrationTest extends MainTest {

    String randomUsername;


    @BeforeClass
    public void beforeRegistration() {
        super.before();
        randomUsername = generateRandomUsername();

        indexPage.openParabank().register().setFirstName("Anna").setLastName("Dopowtorzenia").
                setStreet("Miarki").setCity("Gliwice").setState("Slaskie").setZipCode("44-100").setSsn("12345678")
                .setUsername(randomUsername).setPassword("barbara123").setRepeatedPassword("barbara123").clickRegister()
                .logOut();
        after();
    }

    @Test
    public void shouldRegister() {
        indexPage.openParabank().register().setFirstName("Barbara").setLastName("Rabarbar").
                setStreet("Mikołajska").setCity("Warszawa").setState("Mazowieckie").setZipCode("30-121").setSsn("12345678").setUsername(generateRandomUsername())
                .setPassword("barbara123").setRepeatedPassword("barbara123").clickRegister().
                registrationAssertion.hasUserRegisteredAccount();
    }


    @Test
    public void shouldNotRegisterBecauseOfNotRepatingPassword() {
        indexPage.openParabank().register().setFirstName("Jan").setLastName("Banan").
                setStreet("Aleje").setCity("Kraków").setState("Małopolskie").setZipCode("30-908").setSsn("98765432").setUsername(generateRandomUsername())
                .setPassword("barbara123").setRepeatedPassword("barbara12").clickRegisterFail().
                registrationAssertion.doesPasswordNotMatch();
    }

    @Test
    public void shouldNotRegisterBecauseOfNotGivingLastName() {
        indexPage.openParabank().register().setFirstName("Alicja").setStreet("Nadwiślańska").setCity("Wrocław").setState("Dolnośląskie")
                .setZipCode("44-789").setSsn("98765432").setUsername(generateRandomUsername())
                .setPassword("alicja123").setRepeatedPassword("alicja123").clickRegisterFail()
                .registrationAssertion.isLastNameMissing();
    }


    @Test
    public void shouldNotRegisterBecauseOfRepeatingUserName() {

        indexPage.openParabank().register().setFirstName("Anna").setLastName("Dopowtorzenia").
                setStreet("Miarki").setCity("Gliwice").setState("Slaskie").setZipCode("44-100").setSsn("12345678")
                .setUsername(randomUsername).setPassword("barbara123").setRepeatedPassword("barbara123").clickRegisterFail()
                .registrationAssertion.repeatedUsername();
    }


}




