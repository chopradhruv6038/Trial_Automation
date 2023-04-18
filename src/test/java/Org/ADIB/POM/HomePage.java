package Org.ADIB.POM;

import Org.ADIB.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {

        super(driver);
    }

    Actions actions = new Actions(driver);

    By PersonalMenu = By.xpath("//ul[@id='tab_bar']//a[normalize-space()='Personal']");
    By CardsMenu = By.linkText("Cards");
    By skywardsCardsLink = By.cssSelector("div[class='main-menu-dropdown-sub'] li:nth-child(1) a:nth-child(1)");

    public synchronized void loadUrl(String url) {

        driver.get(url);

    }

    public synchronized HomePage hoverPersonalMenu() {

        actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(PersonalMenu))).perform();

        return this;

    }

    public synchronized HomePage hoverOverCardsMenu() {

        actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(CardsMenu))).perform();

        return this;
    }

    public synchronized SkywardsCardsPage clickSkywardsCards() {

        actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(skywardsCardsLink))).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(skywardsCardsLink)).click();

        return new SkywardsCardsPage(driver);

    }



}
