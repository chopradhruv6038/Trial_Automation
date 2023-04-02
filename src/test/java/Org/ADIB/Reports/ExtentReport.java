package Org.ADIB.Reports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.HashMap;
import java.util.Map;

public class ExtentReport {

    static com.aventstack.extentreports.ExtentReports extent; //creating a variable extent of type extent reports.
    final static String filePath = "Extent.html";
    static Map <Integer, ExtentTest> extentTestMap = new HashMap();

    public synchronized static com.aventstack.extentreports.ExtentReports getReporter() { //in this method we are checking if the variable is null
        // and only if it is null we are creating a new instance of the extent reports.
        //NOTE: We should only be creating only one instance of the extent reports
        //NOTE: if you want to generate one single report for the entire automation.

        if (extent == null) {



            //Since we will use html reporter so we will create a new instance of html reporter.
            ExtentHtmlReporter html = new ExtentHtmlReporter("Extent Reports/Extent.html");
            html.config().setDocumentTitle("Selenium Framework for ADIB"); //config
            html.config().setReportName("ADIB Automated Tests"); //config
            html.config().setTheme(Theme.DARK);
            extent = new com.aventstack.extentreports.ExtentReports(); //creating new instance of Extent report.
            extent.attachReporter(html); //attaching the html reporter to the extent reports variable.
        }
        return extent; //returning the extent object as the method is of type extent reports which returns extent reports variable.
    }

    public static synchronized ExtentTest getTest(){ //getting the test object in this method by reading the hashmap and we are retrieving the
        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

//Below method is start test and it actually starts our test case, and it takes the test case name and description as the argument

    public static synchronized ExtentTest startTest(String testName, String desc){
        ExtentTest test = getReporter().createTest(testName, desc); //calling the get reporter method. also creating the test object here. and also creating the test case.
        extentTestMap.put((int) (long)(Thread.currentThread().getId()), test); //using the hashmap, we are creating one entry and what we are getting the id of the current thread that is executing and also mapping the id with the test object.
        return test;
    }

}
