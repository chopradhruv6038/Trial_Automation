package Org.Trial.Listeners;

import Org.Trial.Base.BaseTest;
import Org.Trial.Reports.ExtentReport;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.PrintWriter;
import java.io.StringWriter;

public class TestListener implements ITestListener {




    public void onTestFailure(ITestResult result) {

        if (result.getThrowable() != null) {

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            result.getThrowable().printStackTrace(pw);
            System.out.println(sw.toString());

        }


    }

    @Override
    public void onTestStart(ITestResult result) {
        BaseTest baseTest = new BaseTest();
        ExtentReport.startTest(result.getName(), result.getMethod().getDescription())
                .assignCategory(baseTest.getBrowser())
                //Assigning browser name left using getter method, still to do.
                .assignAuthor("Dhruv");
        //above line will start the test and will get the test name and method description.
        //calling methods from ExtentReports class.

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReport.getTest().log(Status.PASS, "Test Passed");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReport.getTest().log(Status.SKIP, "Test Skipped");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


    }

    @Override
    public void onStart(ITestContext context) {


    }

    @Override
    public void onFinish(ITestContext context) {

        ExtentReport.getReporter().flush(); //for flushing, this method writes all the information to the report, runs at last.
//can be added in all methods above flush code so that while running also you can view the report and details.
    }

}
