package ru.training.at.hw4.tests.steps;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw2.data.TestData;
import ru.training.at.hw4.pages.DifferentElementsPage;
import ru.training.at.hw4.pages.LoginPage;

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

    @Step("Navigate to different elements page")
    public static DifferentElementsPage navigateToDifferentElementsPage(LoginPage page) {
        return page.clickOnDifferentElementsItem();
    }
}
