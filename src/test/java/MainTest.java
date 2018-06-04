import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

public class MainTest {
    WebDriver driver;
    IndexPage indexPage;
    RegistrationPage registrationPage;
    LookUpPage lookUpPage;
    protected ITestContext context;




    public String generateRandomUsername() {
        String username = UUID.randomUUID().toString();
        return username.substring(0, 10);

    }

    public String generateRandomSsn() {
        String ssn = UUID.randomUUID().toString();
        return ssn.substring(0, 10);

    }


    @BeforeMethod
    @Parameters({"url"})


    public void beforeTest(ITestContext context, String url) {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        capabilities.setCapability("version","16");
//        capabilities.setCapability("platform", Platform.WINDOWS);

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        indexPage = new IndexPage(driver, context, url);
        this.context = context;

    }

    @AfterMethod
    public void afterTest() {
        driver.close();
    }


}
