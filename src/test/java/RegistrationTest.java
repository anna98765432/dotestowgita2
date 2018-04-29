import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import sun.security.pkcs.SignerInfo;

import java.util.GregorianCalendar;
import java.util.UUID;


public class RegistrationTest {

    WebDriver driver;
    RegistrationPage registrationPage;


    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        registrationPage = new RegistrationPage(driver);
    }

    @AfterMethod
    public void after() {
        driver.close();
    }

    @Test
    public void shouldRegister() {
        registrationPage.openRegister();
        registrationPage.signIn("Barbara", "Rabarbar", "Mikołajska", "Warszawa", "Mazowieckie",
                "30-121", "12345678", "ania", "barbara123", "barbara123");
        registrationPage.clickRegister();
        Assert.assertTrue(registrationPage.hasUserRegisteredAccount());
    }


    @Test
    public void shouldNotRegisterBecauseOfNotRepatingPassword() {
        registrationPage.openRegister();
        registrationPage.signIn("Jan", "Banan", "Aleje", "Kraków", "Małopolskie", "31-789",
                "98765432", "beata", "barbara123", "barbara12");
        registrationPage.clickRegister();
        Assert.assertTrue(registrationPage.doesPasswordNotMatch());
    }

    @Test
    public void shouldNotRegisterBecauseOfNotGivingLastName() {
        registrationPage.openRegister();
        registrationPage.signIn("Alicja", "", "Nadwiślańska", "Wrocław", "Dolnośląskie", "44-789",
                "3467890", "alicja", "alicja123", "alicja123");
        registrationPage.clickRegister();
        Assert.assertTrue(registrationPage.isLastNameMissing());
    }

    @Test
    public void shouldNotRegisterBecauseOfRepeatingUser() {
        registrationPage.openRegister();
        registrationPage.signIn("Anna", "Michalska", "Piłsudskiego", "Gdańsk", "Pomorskie", "34-123",
                "34567890", "AnnaEMIN", "anna1234", "anna1234");
        registrationPage.clickRegister();

        if (driver.findElement(By.xpath("//div[@id='rightPanel']/p")).getText().contains("Your account was created successfully.")) {
            registrationPage.openRegister();
            registrationPage.signIn("Anna", "Michalska", "Piłsudskiego", "Gdańsk", "Pomorskie", "34-123",
                    "34567890", "AnnaEMIN", "anna1234", "anna1234");
            registrationPage.clickRegister();

        } else {
            Assert.assertTrue(registrationPage.repeatedUsername());
        }


    }


}


