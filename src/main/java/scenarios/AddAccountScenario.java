package scenarios;

import pages.AccountPage;
import pages.OpenAccountPage;

public class AddAccountScenario implements Scenario <AccountPage, OpenAccountPage> {

    private String type;
//    private String number;

    public AddAccountScenario(String type) {
        this.type = type;
//        this.number  = number;
    }

    public OpenAccountPage run(AccountPage entry) {

        return entry.openNewAccount()
                .selectType(type)
//                .selectAccount(number)
                .openNewAccount();

    }
}
