package Org.ADIB.Factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

public class DriverManager {

    protected WebDriver driver;

    @Parameters({"Browser"})
    public WebDriver initializeDriver(String Browser) {

        switch (Browser) {

            case "chrome":

                WebDriverManager.chromedriver().cachePath("ChromDriver").setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().cachePath("FirefoxDriver").setup();
                driver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException("Browser not Known" + Browser);

        }

        driver.manage().window().maximize();

        return driver;


    }


}
