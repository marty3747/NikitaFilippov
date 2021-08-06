package ru.training.at.hw4.tests.ex1;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw2.data.TestData;
import ru.training.at.hw4.tests.BaseClass;
import ru.training.at.hw4.tests.steps.LoggedInHomePageSteps;

@Feature("Tests for Exercise #1")
@Story("Testing elements of Home page")
public class TestEx1 extends BaseClass {

    private String originalPageHandle;

    @Test(priority = 1)
    public void runAllAssertsForEx1() {

        //5.Assert that there are 4 items on the header section are displayed and they have proper texts
        testHeaderItemsEquals();


        //6.Assert that there are 4 images on the Index Page and they are displayed
        testImageEquals();


        //7.Assert that there are 4 texts on the Index Page under icons and they have proper text
        testTextUnderIcons();


        //8.Assert that there is the iframe with “Frame Button” exist
        testIframeButton();


        //9.Switch to the iframe and check that there is “Frame Button” in the iframe
        testFrameButtonInIframe();

        //10.Switch to original window back
        checkOriginalWindow();

        //11.Assert that there are 5 items in the Left Section are displayed and they have proper text
        testLeftSectionItems();

    }

    public void testHeaderItemsEquals() {
        LoggedInHomePageSteps.checkHeaderItemsAreDisplayed(loginPage, TestData.HEADER_ITEMS_TEXT.size());
        LoggedInHomePageSteps.checkHeaderItemsWithCorrectTexts(loginPage, TestData.HEADER_ITEMS_TEXT);
    }

    public void testImageEquals() {
        LoggedInHomePageSteps.checkImagesAreDisplayed(loginPage, TestData.NUMBER_OF_IMAGES);
    }

    public void testTextUnderIcons() {
        LoggedInHomePageSteps.checkTextsUnderImagesAreProperTexts(loginPage);
    }

    public void testIframeButton() {
        LoggedInHomePageSteps.checkIframeIsDisplayed(loginPage);
        originalPageHandle = webDriver.getWindowHandle();
    }

    public void testFrameButtonInIframe() {
        webDriver.switchTo().frame(loginPage.getIframe());
        LoggedInHomePageSteps.checkIframeButtonIsDisplayed(loginPage);
        webDriver.switchTo().parentFrame();
    }

    public void checkOriginalWindow() {
        String currentHandle = webDriver.getWindowHandle();
        Assert.assertEquals(originalWindowHandle, currentHandle);
    }

    public void testLeftSectionItems(){
        LoggedInHomePageSteps.checkLeftSectionItemsAreDisplayed(loginPage, TestData.LEFT_SECTION_ITEMS_TEXTS.size());
        LoggedInHomePageSteps.checkLeftSectionItemsWithProperTexts(loginPage);
    }
}
