import org.testng.annotations.*;
import pages.AccountPage;
import pages.LoggedInPage;
import pages.MainPage;
import scenarios.AddAccountScenario;
import scenarios.LoginScenario;
import scenarios.RegistrationScenario;


public class AccountTest extends MainTest {

    private AccountPage start;
    private String randomUsername;

    @BeforeClass
    @Parameters({"url","firstName1"})
    public void before(String url, String firstName1) {
    beforeTest(url);
        randomUsername = generateRandomUsername();
        indexPage.run(new RegistrationScenario(firstName1, "Dopowtorzenia", "Miarki", "Gliwice",
                "Slaskie", "44-100", "987654321", randomUsername, "barbara123",
                "barbara123"))
                .menu.logOut();


    }

    @BeforeMethod
    public void prepare(){
        start = indexPage.run(new LoginScenario(randomUsername, "barbara123"));

    }



   @Test
    public void shouldAddAccount() {
        start.menu.run(new AddAccountScenario("SAVINGS"))
                .newAccountAssertion.hasUserOpenedNewAccount();


    }


}
