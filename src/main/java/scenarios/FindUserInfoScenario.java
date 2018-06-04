package scenarios;

import pages.IndexPage;
import pages.LookUpPage;
import pages.MenuPage;

public class FindUserInfoScenario implements Scenario <IndexPage, LookUpPage> {

    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String code;
    private String SSN;

    public FindUserInfoScenario(String firstName, String lastName, String street, String city, String state, String code, String SSN) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.code = code;
        this.SSN = SSN;
    }

    public LookUpPage run(IndexPage entry) {

        return entry.openParabank()
                .remindLoginInfo()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setStreetInput(street)
                .setCityInput(city)
                .setStateInput(state)
                .setZipCode(code)
                .setSsn(SSN)
                .clickFindLoginInfo();

    }
}
