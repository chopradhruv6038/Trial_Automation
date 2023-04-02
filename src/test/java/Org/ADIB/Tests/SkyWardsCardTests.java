package Org.ADIB.Tests;

import Org.ADIB.Base.BaseTest;
import Org.ADIB.POM.HomePage;
import Org.ADIB.POM.SkywardsCardsPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class SkyWardsCardTests extends BaseTest {

    HomePage homePage;
    SkywardsCardsPage skywardsCardsPage;

    Properties props;
    String propsLocation;
    InputStream configStream;

    @BeforeClass
    public void beforeClass() throws IOException {

        //Config properties initialization

        props = new Properties();

        propsLocation = "Data/config.properties";

        configStream = getClass().getClassLoader().getResourceAsStream(propsLocation);

        props.load(configStream);


    }

    @BeforeMethod
    public void BeforeMethod() {

        homePage = new HomePage(getDriver());
        skywardsCardsPage = new SkywardsCardsPage(getDriver());

    }


    @Test
    public void SkyWardsCardTest() throws InterruptedException {

        homePage.loadUrl(props.getProperty("url"));
        homePage.hoverPersonalMenu().hoverOverCardsMenu();

        skywardsCardsPage = homePage.clickSkywardsCards();
        skywardsCardsPage.validateSkywardsPageURL().validateSkywardsPageTitleIsDisplayed()
                .validateSkywardsPageTitleText().assertSkywardMainImageIsDisplayed()
                .validateBannerText().validateBannerTextIsDisplayed()
                .validateBannerSubTextIsDisplayed().validateSkywardsBannerSubTitle();


    }


}
