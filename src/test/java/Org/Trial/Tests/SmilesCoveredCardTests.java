package Org.Trial.Tests;

import Org.Trial.Base.BaseTest;
import Org.Trial.POM.HomePage;
import Org.Trial.Utils.TestUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class SmilesCoveredCardTests extends BaseTest {

    Properties props;
    InputStream configData;
    InputStream jsonData;
    String pathToPros;
    String pathToJson;
    JSONTokener tokener;
    JSONObject jsonObject;

    HomePage homePage;
    TestUtils testUtils;

    @BeforeClass
    public void beforeClass() throws IOException {

        props = new Properties();
        pathToPros = "Data/config.properties";
        configData = getClass().getClassLoader().getResourceAsStream(pathToPros);
        props.load(configData);

        try {

            pathToJson = "Data/ExpectedText.json";
            jsonData = getClass().getClassLoader().getResourceAsStream(pathToJson);
            tokener = new JSONTokener(jsonData);
            jsonObject = new JSONObject(tokener);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jsonData != null) {
                jsonData.close();
            }
        }

    }

    @BeforeMethod
    public void beforeMethod(Method m) {

        homePage = new HomePage(getDriver());
        testUtils = new TestUtils();

        testUtils.log().info(m.getName());


    }

    @Test(description = "This test will navigate to smiles covered card page and validate the url, the presence of all page elements.")
    public void validateElementsOnSmilesCardsPage() {

        homePage.loadUrl(props.getProperty("url"));
        homePage.hoverPersonalMenu().hoverOverCardsMenu().clickSmilesCardPageLink()
                .validateSmilePageUrl(props.getProperty("smilesCardUrl"))
                .assertBannerHeaderSmilesCardIsDisplayed()
                .assertBannerTextIsCorrect(jsonObject.getJSONObject("SmilesCardData").getString("ExpectedHeaderText"))
                .verifyAdibSmilesSignatureCardIMGIsDisplayed()
                .assertAdibSmilesSignatureCardHeaderText(jsonObject.getJSONObject("SmilesCardData").getString("SmilesSignatureCardHeader"))
                .moveToApplyBtnForSmilesSignatureCard()
                .clickApplyBtnSmilesSignatureCard().verifySmilesSignatureCardApplyFrameIsDisplayed();

    }

}
