import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

public class LoginTest extends MainTest {
    String lvUserName;

    @BeforeClass
    @Parameters({"url"})
    public void before1(String url) {
        lvUserName = generateRandomUsername();
        beforeTest(url);
        indexPage.openParabank().register().setFirstName("Mariola").setLastName("Michalska").setStreet("Wiślana").setCity("Warszawa")
                .setState("Mazowieckie").setZipCode("31-122").setSsn("12345678").setUsername(lvUserName)
                .setPassword("barbara123").setRepeatedPassword("barbara123").clickRegister();
        driver.close();
    }


    @Test
    public void shouldLogin() {
        indexPage.openParabank()
                .fillUsername("John")
                .fillPassword("123123!$L")
                .clickLogin()
                .loginAssertion.isUserLoggedIn();
    }

    @Test
    public void shouldLoginMyUser() {
        indexPage.openParabank()
                .fillUsername(lvUserName)
                .fillPassword("barbara123")
                .clickLogin()
                .loginAssertion.isUserLoggedIn();

    }


    @Test
    public void shouldNotLoginBecauseOfWrongPassword() {
        indexPage.openParabank()
                .fillUsername(lvUserName)
                .fillPassword("barbara1234")
                .clickLogin()
                .loginAssertion.passwordAndUsernameAreNotVerified();

    }

}




