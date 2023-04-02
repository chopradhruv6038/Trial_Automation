package Org.ADIB.Base;

import Org.ADIB.Factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

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

    @AfterMethod
    public void quitDriver() {

        getDriver().quit();

    }

   /* @BeforeTest
    public void getDateTime(){


    }*/


}
