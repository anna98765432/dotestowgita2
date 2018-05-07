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


public class RegistrationTest {

    WebDriver driver;
    RegistrationPage registrationPage;
    IndexPage indexPage;


    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        registrationPage = new RegistrationPage(driver);
    }

    @AfterMethod
    public void after() {
        driver.close();
    }

    @Test
    public void shouldRegister() {
        registrationPage.openRegister();
        registrationPage.signIn("Barbara", "Rabarbar", "Mikołajska", "Warszawa", "Mazowieckie",
                "30-121", "12345678", "barbara123", "barbara123", "barbara123");
        registrationPage.fillRandomUsername();
        registrationPage.clickRegister();
        Assert.assertTrue(registrationPage.hasUserRegisteredAccount());
    }


    @Test
    public void shouldNotRegisterBecauseOfNotRepatingPassword() {
        registrationPage.openRegister();
        registrationPage.signIn("Jan", "Banan", "Aleje", "Kraków", "Małopolskie", "31-789",
                "98765432", "", "barbara123", "barbara12");
        registrationPage.fillRandomUsername();
        registrationPage.clickRegister();
        Assert.assertTrue(registrationPage.doesPasswordNotMatch());
    }

    @Test
    public void shouldNotRegisterBecauseOfNotGivingLastName() {
        registrationPage.openRegister();
        registrationPage.signIn("Alicja", "", "Nadwiślańska", "Wrocław", "Dolnośląskie", "44-789",
                "3467890", "", "alicja123", "alicja123");
        registrationPage.fillRandomUsername();
        registrationPage.clickRegister();
        Assert.assertTrue(registrationPage.isLastNameMissing());
    }


    @Test
    public void shouldNotRegisterBecauseOfRepeatingUserName() {
        indexPage = new IndexPage(driver);
        registrationPage.openRegister();
        registrationPage.signIn("Anna", "Dopowtorzenia", "Miarki", "Gliwice", "Slaskie",
                "44-100", "12345678", "", "barbara123", "barbara123");
        registrationPage.fillRandomUsername();
        registrationPage.clickRegister();
        registrationPage.logOut();
        indexPage.register();
        registrationPage.signIn("Anna", "Dopowtorzenia", "Miarki", "Gliwice", "Slaskie",
                "44-100", "12345678", "", "barbara123", "barbara123");
        registrationPage.repeatRandomUsername();
        registrationPage.clickRegister();
        registrationPage.waitForJStoLoad();
        Assert.assertTrue(registrationPage.repeatedUsername());
    }


}




