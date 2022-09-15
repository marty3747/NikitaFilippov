package ru.training.at.hw3_steps.tests.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3_steps.data.TestData;
import ru.training.at.hw3_steps.pages.DifferentElementsPage;
import ru.training.at.hw3_steps.pages.LoginPage;
import ru.training.at.hw3_steps.tests.BaseClass;

import java.util.List;
import java.util.Locale;

public class LoggedInHomePageSteps {

    private static final SoftAssert softAssert = new SoftAssert();

    @Step("Check that user name is correct")
    public static void checkUsernameWithCorrectText(LoginPage page, String expected) {
        Assert.assertEquals(page.getUsername(), expected);
    }

    @Step("Check that header links are displayed")
    public static void checkHeaderItemsAreDisplayed(LoginPage page, int expectedNumber) {
        List<WebElement> headerItemsList = page.getListOfHeaderElements();
        softAssert.assertEquals(headerItemsList.size(), expectedNumber);
        for(WebElement webElement: headerItemsList) {
            softAssert.assertTrue(webElement.isDisplayed());
        }
        softAssert.assertAll();
    }

    @Step("Check that header links have proper texts")
    public static void checkHeaderItemsWithCorrectTexts(LoginPage page, List<String> expectedTexts) {
        for (int i = 0; i < TestData.HEADER_ITEMS_TEXT.size(); i++) {
            Assert.assertEquals(page.getListOfHeaderElements().get(i).getText(), expectedTexts.get(i));
        }
    }

    @Step("Check that images are displayed")
    public static void checkImagesAreDisplayed(LoginPage page, int expectedNumberOfImages) {
        softAssert.assertEquals(page.getListOfImages().size(), expectedNumberOfImages);
        for (WebElement webElement: page.getListOfImages()) {
            softAssert.assertTrue(webElement.isDisplayed());
        }
        softAssert.assertAll();
    }

    @Step("Check that texts below images are displayed")
    public static void checkTextsUnderImagesAreProperTexts(LoginPage page) {
        for (int i = 0; i < TestData.TEXT_UNDER_ICONS.size(); i++) {
            softAssert.assertEquals(page.getListOfTextsWebElements().get(i).getText(), TestData.TEXT_UNDER_ICONS.get(i));
        }
    }

    @Step("Check that IFrame is displayed")
    public static void checkIframeIsDisplayed(LoginPage page) {
        softAssert.assertTrue(page.getIframe().isDisplayed());
    }


    @Step("Check that Iframe button is displayed")
    public static void checkIframeButtonIsDisplayed(LoginPage page) {
        softAssert.assertTrue(page.getFrameButton().isDisplayed());
    }


    @Step("Check that left section items are displayed")
    public static void checkLeftSectionItemsAreDisplayed(LoginPage page, int expectedNumberOfItems) {
        List<WebElement> leftSectionItems = page.getListOfLeftSectionButton();
        softAssert.assertEquals(leftSectionItems.size(), expectedNumberOfItems);
        for (int i = 0; i < TestData.LEFT_SECTION_ITEMS_TEXTS.size(); i++) {
            Assert.assertTrue(page.getListOfLeftSectionButton().get(i).isDisplayed());
        }
        softAssert.assertAll();
    }

    @Step("Check that left section items have proper texts")
    public static void checkLeftSectionItemsWithProperTexts(LoginPage page) {
        for (int i = 0; i < TestData.LEFT_SECTION_ITEMS_TEXTS.size(); i++) {
            Assert.assertEquals(page.getListOfLeftSectionButton().get(i).getText(), TestData.LEFT_SECTION_ITEMS_TEXTS.get(i));
        }
    }

    @Step("Check main title on the home page")
    public static void checkMainTitleOnTheHomePage(LoginPage page) {
        Assert.assertEquals(page.getMainTitleFromHomePage(), TestData.THE_MAIN_TITLE_OF_THE_PAGE.toUpperCase(Locale.ROOT));
        Assert.assertTrue(page.getMainTitleFromHomePageLikeWebElement().isDisplayed());
    }

    @Step("Check second title on the home page")
    public static void checkSecondTitleOnTheHomePage(LoginPage page) {
        Assert.assertEquals(page.getSecondTitleFromHomePage(), TestData.THE_SECOND_TITLE_OF_THE_PAGE.toUpperCase(Locale.ROOT));
    }

    @Step("Check frame card title")
    public static void checkFrameCardTitle(LoginPage page, WebDriver webDriver) {
        webDriver.switchTo().frame(page.getFrame());
        Assert.assertEquals(page.getFrameCardTitle(), TestData.FRAME_CARD_TITLE.toUpperCase(Locale.ROOT));
    }

    @Step("Check jdi title displayed")
    public static void checkJdiTitleDisplayed(LoginPage page) {
        List<WebElement> listOfJdiTitles = page.getListOfJdiTitle();
        for (WebElement webElement: listOfJdiTitles) {
            Assert.assertTrue(webElement.isDisplayed());
        }
    }

    @Step("Check frame card text displayed")
    public static void checkFrameCardTextDisplayed(LoginPage page, WebDriver webDriver) {
        Assert.assertTrue(page.getFrameCardText().isDisplayed());
        webDriver.switchTo().defaultContent();
    }

    @Step("Check frame button text displayed")
    public static void checkFrameButtonTextDisplayed(LoginPage page) {
        List<WebElement> listOfCardButtons = page.getFrameCardButtons();
        for (WebElement webElement: listOfCardButtons) {
            Assert.assertTrue(webElement.isDisplayed());
        }
    }

    @Step("Check image in frame displayed")
    public static void checkImgInFrameDisplayed(LoginPage page) {
        List<WebElement> listOfImg = page.getFrameImg();
        for (WebElement webElement: listOfImg) {
            Assert.assertTrue(webElement.isDisplayed());
        }
    }

    @Step("Check home page title in frame card")
    public static void checkHomePageTitleInFrameCard(LoginPage page) {
        List<WebElement> listOfHomePageTitle = page.getHomePageTitleFromFrameCard();
        for (WebElement webElement: listOfHomePageTitle) {
            Assert.assertTrue(webElement.isDisplayed());
        }
    }


    @Step("Check home page contact form in frame card")
    public static void checkHomePageContactFormInFrameCard(LoginPage page) {
        List<WebElement> listOfHomePageContactPage = page.getHomePageContactFormInFrameCard();
        for (WebElement webElement: listOfHomePageContactPage) {
            Assert.assertTrue(webElement.isDisplayed());
        }
    }

    @Step("Navigate to different elements page")
    public static DifferentElementsPage navigateToDifferentElementsPage(LoginPage page) {
        return page.clickOnDifferentElementsItem();
    }
}
