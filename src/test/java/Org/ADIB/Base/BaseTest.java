package Org.ADIB.Base;

import Org.ADIB.Factory.DriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class BaseTest {

    protected static ThreadLocal<String> browserName = new ThreadLocal<String>(); //converting global parameters to thread local object just like we do for web driver;

    ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void setDriver(WebDriver driver) {

        this.driver.set(driver);

    }

    public WebDriver getDriver() {

        return this.driver.get();
    }


    @Parameters({"Browser"})
    @BeforeMethod
    public void startDriver(String Browser) {


        setDriver(new DriverManager().initializeDriver(Browser));


    }


    public String getBrowser() {

        return browserName.get();
    }

    public void setBrowser(String browser) {

        browserName.set(browser);

    }


    @AfterMethod
    public void quitDriver() {

        getDriver().quit();

    }

    @Parameters({"Browser"})
    @BeforeTest
    public void beforeTest(String browser) {

        setBrowser(browser);

    }


}
