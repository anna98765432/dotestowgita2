package scenarios;

import pages.AccountPage;
import pages.LoggedInPage;
import pages.MenuPage;
import pages.OpenAccountPage;

public class AddAccountScenario implements Scenario <MenuPage, OpenAccountPage> {

    private String type;
//    private String number;

    public AddAccountScenario(String type) {
        this.type = type;
//        this.number  = number;
    }

    public OpenAccountPage run(MenuPage entry) {

        return entry.openNewAccount()
                .selectType(type)
//                .selectAccount(number)
                .openNewAccount();

    }
}
