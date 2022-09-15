package ru.training.at.hw3_steps.tests.ex1;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw3_steps.data.TestData;
import ru.training.at.hw3_steps.tests.BaseClass;
import ru.training.at.hw3_steps.tests.steps.LoggedInHomePageSteps;

@Feature("Tests for Home page")
@Story("Testing elements of Home page")
public class TestEx1 extends BaseClass {

    private String originalPageHandle;

    @Test(priority = 1)
    public void runAllAssertsForEx1() {

        //1.Assert that there are 4 items on the header section are displayed and they have proper texts
        testHeaderItemsEquals();

        //2.Assert that there are 4 images on the Index Page and they are displayed
        testImageEquals();

        //3.Assert that there are 4 texts on the Index Page under icons and they have proper text
        testTextUnderIcons();

        //4.Assert that there is the iframe with “Frame Button” exist
        testIframeButton();

        //5.Switch to the iframe and check that there is “Frame Button” in the iframe
        testFrameButtonInIframe();

        //6.Switch to original window back
        checkOriginalWindow();

        //7.Assert that there are 5 items in the Left Section are displayed and they have proper text
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
