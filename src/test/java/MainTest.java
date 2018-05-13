import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.UUID;

public class MainTest {
    WebDriver driver;
    IndexPage indexPage;
    AccountPage accountPage;
    RegistrationPage registrationPage;
    LookUpPage lookUpPage;

    public RegistrationPage signIn(String name, String name2, String street, String city, String state, String postCode,
                                   String customerNumer, String username, String password, String repeatedPassword) {
        registrationPage.setFirstName(name);
        registrationPage.setLastName(name2);
        registrationPage.setStreet(street);
        registrationPage.setCity(city);
        registrationPage.setState(state);
        registrationPage.setZipCode(postCode);
        registrationPage.setSsn(customerNumer);
        registrationPage.setUsername(username);
        registrationPage.setPassword(password);
        registrationPage.setRepeatedPassword(repeatedPassword);
        return registrationPage;

    }


    public String generateRandomUsername() {
        String username = UUID.randomUUID().toString();
        return username.substring(0, 10);

    }

    public String generateRandomSsn() {
        String ssn = UUID.randomUUID().toString();
        return ssn.substring(0, 10);

    }


    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        indexPage = new IndexPage(driver);
        lookUpPage = new LookUpPage(driver);

    }

    @AfterMethod
    public void after() {
        driver.close();
    }


}
