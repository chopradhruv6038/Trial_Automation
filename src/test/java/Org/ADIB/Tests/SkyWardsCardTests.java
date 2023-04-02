package Org.ADIB.Tests;

import Org.ADIB.Base.BaseTest;
import Org.ADIB.POM.HomePage;
import Org.ADIB.POM.SkywardsCardsPage;
import Org.ADIB.Utils.TestUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;


public class SkyWardsCardTests extends BaseTest {

    HomePage homePage;
    SkywardsCardsPage skywardsCardsPage;
    TestUtils testUtils;

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
    public void BeforeMethod(Method m) {

        homePage = new HomePage(getDriver());
        skywardsCardsPage = new SkywardsCardsPage(getDriver());
        testUtils = new TestUtils();

        testUtils.log().info(m.getName());

    }


    @Test(description = "verify that user is able to navigate to skywards card page and validate that all elements are displayed plus all text displayed is correct")
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
