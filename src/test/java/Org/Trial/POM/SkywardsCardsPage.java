package Org.Trial.POM;

import Org.Trial.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SkywardsCardsPage extends BasePage {

    public SkywardsCardsPage(WebDriver driver) {
        super(driver);
    }

    private final By skywardsPageTitle = By.xpath("//span[normalize-space()='ADIB Emirate Skywards Cards']");
    private final By skywardsPageMainIMG = By.id("ctl00_ctl57_g_d47a3ea7_34d6_4dcf_b487_cd85a6e29136_bannerDiv");
    private final By skywardsBannerTitle = By.id("ctl00_ctl57_g_d47a3ea7_34d6_4dcf_b487_cd85a6e29136_lblTitle");
    private final By skywardsBannerSubTitle = By.id("ctl00_ctl57_g_d47a3ea7_34d6_4dcf_b487_cd85a6e29136_bannerText");


    public synchronized SkywardsCardsPage validateSkywardsPageURL() {

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.adib.ae/en/pages/adib-emirates-skywards-cards.aspx");

        return this;
    }

    public synchronized SkywardsCardsPage validateSkywardsPageTitleIsDisplayed() {

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(skywardsPageTitle)).isDisplayed());

        return this;
    }

    public synchronized String getSkywardsPageTitle() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(skywardsPageTitle)).getText();
    }


    public synchronized SkywardsCardsPage validateSkywardsPageTitleText() {

        Assert.assertEquals(getSkywardsPageTitle(), "ADIB Emirate Skywards Cards");

        return this;
    }

public SkywardsCardsPage assertSkywardMainImageIsDisplayed(){

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(skywardsPageMainIMG)).isDisplayed());

        return this;
}

public String skywardPageBannerActualText(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(skywardsBannerTitle)).getText();

}

public SkywardsCardsPage validateBannerText(){

        Assert.assertEquals(skywardPageBannerActualText(),"ADIB Emirates Skywards Cards");

        return this;

}

public SkywardsCardsPage validateBannerTextIsDisplayed(){

      Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(skywardsBannerTitle)).isDisplayed());


        return this;
}

public SkywardsCardsPage validateBannerSubTextIsDisplayed(){

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(skywardsBannerSubTitle)).isDisplayed());

        return this;

}

public String getActualBannerSubTitle(){


        return wait.until(ExpectedConditions.visibilityOfElementLocated(skywardsBannerSubTitle)).getText();

}

public SkywardsCardsPage validateSkywardsBannerSubTitle(){

        Assert.assertEquals(getActualBannerSubTitle(),"The highest welcome bonus of any travel card in the Middle East!");

        return this;
}


}
