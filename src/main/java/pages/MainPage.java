package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    protected WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    //    public IndexPage(WebDriver driverFromTest) {
//        driver = driverFromTest; //instancja obiaktu w ktorym jestesmy
//    }

    public boolean waitForJStoLoad() {


        WebDriverWait wait = new WebDriverWait(driver, 30);
        try {
            Thread.sleep(100);  //sleep 100ms to be sure there is no delay in browser befor kicking of jquery or js
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }


}
