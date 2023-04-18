package Org.ADIB.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtils {

   protected WebDriver driver;

    public String dateTime() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        return dateFormat.format(date);

    }

    public Logger log() {

        return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
    }

    public WebDriver getdDriver(){

        return driver;
    }


}
