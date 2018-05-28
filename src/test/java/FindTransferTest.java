import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import scenarios.AddAccountScenario;
import scenarios.LoginScenario;
import scenarios.RegistrationScenario;
import scenarios.TransferFundsScenario;

public class FindTransferTest extends MainTest {

    String randomUsername;

    @BeforeClass
    @Parameters({"url","firstName1"})
    public void beforeTransfer(String url, String firstName1) {

        randomUsername = generateRandomUsername();
        beforeTest(url);
        indexPage.run(new RegistrationScenario(firstName1, "Dopowtorzenia", "Miarki", "Gliwice",
                "Slaskie", "44-100", "987654321", randomUsername, "barbara123",
                "barbara123"))
                .menu.run(new AddAccountScenario("SAVINGS"))
                .menu.run(new AddAccountScenario("SAVINGS"))
                .menu.run(new AddAccountScenario("SAVINGS"))
                .menu.run(new TransferFundsScenario("150", 1, 3))
                .menu.run(new TransferFundsScenario("120",2,3))
                .menu.logOut();
        afterTest();

    }

    @Test
    public void shouldFindTransfer() {
        indexPage.run(new LoginScenario(randomUsername, "barbara123"))
                .menu.findTransfers()
                .selectAccountId(3)
                .sendAmountToFind("120")
                .findTransactionByAmount()
                .transactionAssertion.hasAnyTransactionBeenFound();
    }

    @Test
    public void shouldNotFindTransferBecauseOfIncorrectDate() {
        indexPage.run(new LoginScenario(randomUsername, "barbara123"))
                .menu.findTransfers()
                .selectAccountId(3)
                .sendDateToFind("03-03-2018")
                .findTransactionByDate()
                .transactionAssertion.hasNotAnyTransactionBeenFound();
    }




}
