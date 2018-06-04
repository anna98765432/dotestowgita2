package scenarios;

import pages.AccountPage;
import pages.IndexPage;

import java.security.AccessControlContext;

public class LoginScenario implements Scenario <IndexPage, AccountPage> {

    private String username;
    private String password;

    public LoginScenario(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public AccountPage run(IndexPage entry) {
        return entry.openParabank()
                .fillUsername(username)
                .fillPassword(password)
                .clickLogin();

    }
}
