package Org.ADIB.Base;

import Org.ADIB.Factory.DriverManager;
import Org.ADIB.Reports.ExtentReport;
import Org.ADIB.Utils.TestUtils;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

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

    @Parameters({"Browser"})
    @BeforeTest
    public void beforeTest(String browser) {

        setBrowser(browser); //calling set browser method to set the browser value.

    }


    @AfterMethod
    public void quitDriver(ITestResult result) throws IOException {

        if(result.getStatus() == ITestResult.FAILURE){

            TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
            File file = takesScreenshot.getScreenshotAs(OutputType.FILE);

            String imagePath = "Screenshots" + File.separator + getBrowser() + "_" + getDateTime() + File.separator +
                    result.getTestClass().getRealClass().getSimpleName() + File.separator +
                    result.getMethod().getMethodName() + ".png";

             String completePath = System.getProperty("user.dir") + File.separator + imagePath;

            try {
                FileUtils.copyFile(file, new File(imagePath));
                Reporter.log("This is a sample screenshot");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                ExtentReport.getTest().fail("Testing Failed",
                        MediaEntityBuilder.createScreenCaptureFromPath(completePath).build());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ExtentReport.getTest().fail(result.getThrowable());
            
        }

        getDriver().quit();

    }


    TestUtils testUtils = new TestUtils();
    String DateTime = testUtils.dateTime();

    public String getDateTime() {

        return DateTime;
    }



}

