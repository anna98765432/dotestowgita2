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
    public void before() {
        beforeTest();
        randomUsername = generateRandomUsername();
        indexPage.run(new RegistrationScenario("Anna", "Dopowtorzenia", "Miarki", "Gliwice",
                "Slaskie", "44-100", "987654321", randomUsername, "barbara123",
                "barbara123"))
                .logOut();


    }

//    @BeforeTest
//    public void before1(){
//        beforeTest();
//        start = indexPage.run(new LoginScenario(randomUsername, "barbara123"));
//
//    }


    @Test
    public void shouldAddAccount() {
        indexPage.run(new LoginScenario(randomUsername, "barbara123"))
        .run(new AddAccountScenario("SAVINGS"))
                .newAccountAssertion.hasUserOpenedNewAccount();


    }


}
