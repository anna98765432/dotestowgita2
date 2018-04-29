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
                       String customerNumer, String ania, String password, String repeatedPassword) {

        String username = UUID.randomUUID().toString();
        String username2 = username.substring(0, 10);

        driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys(name2);
        driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys(street);
        driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys(city);
        driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys(state);
        driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).sendKeys(postCode);
        driver.findElement(By.cssSelector("input[id='customer.ssn']")).sendKeys(customerNumer);
//        id$='customer.ssn'
        driver.findElement(By.cssSelector("input[id='customer.username']")).sendKeys(ania + username2);
        driver.findElement(By.cssSelector("input[id='customer.password']")).sendKeys(password);
        driver.findElement(By.cssSelector("input[id='repeatedPassword']")).sendKeys(repeatedPassword);

    }

}

