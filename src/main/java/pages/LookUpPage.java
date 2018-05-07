package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

public class LookUpPage extends MainPage {


    public LookUpPage(WebDriver driver) {
        super(driver);
    }

    public void openLookUpPage() {
        driver.get("http://parabank.parasoft.com/parabank/lookup.htm");
    }

    public void fillInLoginInfo(String firstName, String lastName, String addressStreet, String adressCity, String adressState,
                                String zipCode, String SSN) {
        driver.findElement(By.cssSelector("input[id='firstName']")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input[id='lastName']")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input[id='address.street']")).sendKeys(addressStreet);
        driver.findElement(By.xpath("//input[@id='address.city']")).sendKeys(adressCity);
        driver.findElement(By.xpath("//input[@id='address.state']")).sendKeys(adressState);
        driver.findElement(By.xpath("//input[@id='address.zipCode']")).sendKeys(zipCode);
        driver.findElement(By.xpath("//input[@id='ssn']")).sendKeys(SSN);
    }

    public void clickFindLoginInfo() {
        driver.findElement(By.xpath("//input[@value='Find My Login Info']")).click();
    }

    public boolean hasPasswodBeenRecovered() {
        return driver.findElement(By.xpath("//div[@id='rightPanel']")).getText().contains("Password");
    }

    public boolean isUserMissingSSN() {
        return driver.findElement(By.xpath("//span[@id='ssn.errors']")).getText().contains("Social Security Number is required.");
    }

    public void fillRandomSSN(){
        driver.findElement(By.cssSelector("input[id='ssn']")).clear();
        String SSN1 = UUID.randomUUID().toString();
        this.SSN2 = SSN1.substring(0, 10);
        driver.findElement(By.cssSelector("input[id='ssn']")).sendKeys(SSN2);

    }

    public void repeatRandomSSN(){

        driver.findElement(By.cssSelector("input[id='ssn']")).clear();
        driver.findElement(By.cssSelector("input[id='ssn']")).sendKeys(MainPage.keepsSSN.toString());
    }


}
