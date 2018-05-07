package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.UUID;

public class RegistrationPage extends MainPage {


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void openRegister() {
        driver.get("http://parabank.parasoft.com/parabank/register.htm");
    }

    public void clickRegister() {
        driver.findElement(By.cssSelector("input[value='Register']")).click();

    }

    public boolean hasUserRegisteredAccount() {
        return driver.findElement(By.cssSelector("[href$='logout.htm']")).isDisplayed();

    }

    public boolean doesPasswordNotMatch() {
        WebElement text1 = driver.findElement(By.xpath("//span[@id='repeatedPassword.errors']"));
        return text1.getText().contains("Passwords did not match.");
    }

    public boolean isLastNameMissing() {
        WebElement text1 = driver.findElement(By.xpath("//span[@id='customer.lastName.errors']"));
        return text1.getText().contains("Last name is required.");
    }

    public boolean hasUserCreatedAccount() {
        WebElement text1 = driver.findElement(By.xpath("//div[@id='rightPanel']/p"));
        return driver.findElement(By.xpath("//div[@id='rightPanel']/p")).getText().contains("Your account was created successfully.");
    }

    public boolean repeatedUsername() {
        return driver.findElement(By.xpath("//span[@id='customer.username.errors']")).getText().contains("This username already exists.");
    }


    public void signIn(String name, String name2, String street, String city, String state, String postCode,
                       String customerNumer, String username, String password, String repeatedPassword) {

        driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys(name2);
        driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys(street);
        driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys(city);
        driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys(state);
        driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).sendKeys(postCode);
        driver.findElement(By.cssSelector("input[id='customer.ssn']")).sendKeys(customerNumer);
        driver.findElement(By.cssSelector("input[id='customer.username']")).sendKeys(username);
        driver.findElement(By.cssSelector("input[id='customer.password']")).sendKeys(password);
        driver.findElement(By.cssSelector("input[id='repeatedPassword']")).sendKeys(repeatedPassword);

    }


    public void fillRandomSSN() {
        driver.findElement(By.cssSelector("input[id='customer.ssn']")).clear();
        String SSN1 = UUID.randomUUID().toString();
        this.SSN2 = SSN1.substring(0, 10);
        driver.findElement(By.cssSelector("input[id='customer.ssn']")).sendKeys(SSN2);
        MainPage.keepsSSN = SSN2;

    }


    public void fillRandomUsername() {
        driver.findElement(By.cssSelector("input[id='customer.username']")).clear();
        String username = UUID.randomUUID().toString();
        this.username2 = username.substring(0, 10);
        driver.findElement(By.cssSelector("input[id='customer.username']")).sendKeys(username2);
        MainPage.keepsUsername = username2;

    }


    public void repeatRandomUsername() {
        driver.findElement(By.cssSelector("input[id='customer.username']")).clear();
        driver.findElement(By.cssSelector("input[id='customer.username']")).sendKeys(MainPage.keepsUsername.toString());

    }

    public void logOut() {
        driver.findElement(By.xpath("//a[contains(@href,'logout.htm')]")).click();
    }



}

