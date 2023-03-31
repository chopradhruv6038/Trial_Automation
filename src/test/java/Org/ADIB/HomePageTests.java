package Org.ADIB;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HomePageTests {

    protected WebDriver driver;

    @Test
    public void homePageTesting() throws InterruptedException {

        WebDriverManager.chromedriver().cachePath("DriverChrome").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.adib.ae/en");


        By personalMenu = By.xpath("//ul[@id='tab_bar']//a[@href='/en/pages/Personal.aspx']");

        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(personalMenu)).perform();

        By Takaful = By.linkText("Takaful");

        actions.moveToElement(driver.findElement(Takaful)).perform();

        By MotoTakaful = By.xpath("//div[@class='main-menu-dropdown-sub']//a[normalize-space()='Motor Takaful']");

        driver.findElement(MotoTakaful).click();

        By MotoTakafulHeader = By.id("ctl00_ctl57_g_e4426261_e58b_4155_bf89_32800560785f_lblTitle");

        driver.findElement(MotoTakafulHeader).isDisplayed();


        //By applyNow = By.xpath("//h2[normalize-space()='Apply Now']");

        JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

       Thread.sleep(5000);

        driver.quit();


    }

}
