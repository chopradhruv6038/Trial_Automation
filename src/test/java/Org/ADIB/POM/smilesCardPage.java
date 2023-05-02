package Org.ADIB.POM;

import Org.ADIB.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class smilesCardPage extends BasePage {

    public smilesCardPage(WebDriver driver) {
        super(driver);
    }


    By smilesCardBannerHeader = By.xpath("//span[@id=\"ctl00_ctl57_g_a970ec63_8a5f_47eb_9b99_2348d5dedc84_lblTitle\"]");
    By adicSmilesVisaSignatureCardIMG = By.xpath("(//div[@class='card-image text-center'])[1]");
    By adibSmilesSignatureCardHeader = By.xpath("(//h4[@class='card-title'])[2]");

    public smilesCardPage validateSmilePageUrl(String ExpectedUrl) {

        Assert.assertEquals(driver.getCurrentUrl(), ExpectedUrl);

        return this;

    }

    public String getBannerHeaderTextOnSmilesCard() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(smilesCardBannerHeader)).getText();
    }

    public smilesCardPage assertBannerHeaderSmilesCardIsDisplayed() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(smilesCardBannerHeader)).isDisplayed();

        return this;
    }

    public smilesCardPage assertBannerTextIsCorrect(String ExpectedHeader) {

        Assert.assertEquals(getBannerHeaderTextOnSmilesCard(), ExpectedHeader);

        return this;
    }


    public smilesCardPage verifyAdibSmilesSignatureCardIMGIsDisplayed() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(adicSmilesVisaSignatureCardIMG)).isDisplayed();

        return this;
    }

    public void verifyAdibSmilesSignatureDarHeaderIsDisplayed(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(adibSmilesSignatureCardHeader)).isDisplayed();

    }

    public String getHeaderTextAdibSmilesSignatureText(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(adibSmilesSignatureCardHeader)).getText();

    }

    public smilesCardPage assertAdibSmilesSignatureCardHeaderText(String ExpectedText){

        Assert.assertEquals(getHeaderTextAdibSmilesSignatureText(), ExpectedText);

        return this;
    }

}
