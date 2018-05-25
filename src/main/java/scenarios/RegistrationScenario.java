package scenarios;

import pages.AccountPage;
import pages.IndexPage;
import pages.RegistrationSuccessPage;

public class RegistrationScenario implements Scenario <IndexPage, RegistrationSuccessPage> {

    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String code;
    private String SSN;
    private String username;
    private String password1;
    private String password2;

    public RegistrationScenario(String firstName, String lastName, String street, String city, String state, String code,
                                String SSN, String username, String password1, String password2) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.code = code;
        this.SSN = SSN;
        this.username = username;
        this.password1 = password1;
        this.password2 = password2;
    }


    public RegistrationSuccessPage run (IndexPage entry){
        return entry.openParabank()
                .register()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setStreet(street)
                .setCity(city)
                .setState(state)
                .setZipCode(code)
                .setSsn(SSN)
                .setUsername(username)
                .setPassword(password1)
                .setRepeatedPassword(password2)
                .clickRegister();

    }

}
