package Org.ADIB.Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.PrintWriter;
import java.io.StringWriter;

public class TestListeners implements ITestListener {

    public void onTestFailure(ITestResult result) {

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        result.getThrowable().printStackTrace(pw);
        System.out.println(sw.toString());


    }

}
