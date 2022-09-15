package ru.training.at.hw3.tests.ex3;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw3.data.TestData;
import ru.training.at.hw3.tests.BaseClass;

import java.util.List;
import java.util.Locale;

@Feature("Tests for Exercise #3")
@Story("Testing elements of Home page")
public class TestEx3 extends BaseClass {
    @Test(priority = 1)
    public void runAllAssertsForEx3() {

        //13.Assert for test main title on the HomePage
        testMainTitleOnTheHomePage();

        //14.Assert for test second title on the HomePage
        testSecondTitleOnTheHomePage();

        //15.Assert for test frame card title
        testFrameCardTitle();

        //16.Assert for test jdi title displayed
        testJdiTitleDisplayed();

        //17.Assert for test frame card text displayed
        testFrameCardTextDisplayed();

        //18.Assert for test frame button text displayed
        testFrameButtonTextDisplayed();

        //19.Assert for test img in frame displayed
        testImgInFrameDisplayed();

        //20.Assert for test HomePage title in FrameCard
        testHomePageTitleInFrameCard();

        //21.Assert for test HomePageContactForm in FrameCard
        testHomePageContactFormInFrameCard();
    }

    public void testMainTitleOnTheHomePage() {
        Assert.assertEquals(loginPage.getMainTitleFromHomePage(), TestData.THE_MAIN_TITLE_OF_THE_PAGE.toUpperCase(Locale.ROOT));
        Assert.assertTrue(loginPage.getMainTitleFromHomePageLikeWebElement().isDisplayed());
    }

    public void testSecondTitleOnTheHomePage() {
        Assert.assertEquals(loginPage.getSecondTitleFromHomePage(), TestData.THE_SECOND_TITLE_OF_THE_PAGE.toUpperCase(Locale.ROOT));
    }

    public void testFrameCardTitle() {
        webDriver.switchTo().frame(loginPage.getFrame());
        Assert.assertEquals(loginPage.getFrameCardTitle(), TestData.FRAME_CARD_TITLE.toUpperCase(Locale.ROOT));
    }

    public void testJdiTitleDisplayed() {
        List<WebElement> listOfJdiTitles = loginPage.getListOfJdiTitle();
        for (WebElement webElement: listOfJdiTitles) {
            Assert.assertTrue(webElement.isDisplayed());
        }
    }

    public void testFrameCardTextDisplayed() {
        Assert.assertTrue(loginPage.getFrameCardText().isDisplayed());
        webDriver.switchTo().defaultContent();
    }

    public void testFrameButtonTextDisplayed() {
        List<WebElement> listOfCardButtons = loginPage.getFrameCardButtons();
        for (WebElement webElement: listOfCardButtons) {
            Assert.assertTrue(webElement.isDisplayed());
        }
    }


    public void testImgInFrameDisplayed() {
        List<WebElement> listOfImg = loginPage.getFrameImg();
        for (WebElement webElement: listOfImg) {
            Assert.assertTrue(webElement.isDisplayed());
        }
    }

    public void testHomePageTitleInFrameCard() {
        List<WebElement> listOfHomePageTitle = loginPage.getHomePageTitleFromFrameCard();
        for (WebElement webElement: listOfHomePageTitle) {
            Assert.assertTrue(webElement.isDisplayed());
        }
    }

    public void testHomePageContactFormInFrameCard() {
        List<WebElement> listOfHomePageContactPage = loginPage.getHomePageContactFormInFrameCard();
        for (WebElement webElement: listOfHomePageContactPage) {
            Assert.assertTrue(webElement.isDisplayed());
        }
    }
}