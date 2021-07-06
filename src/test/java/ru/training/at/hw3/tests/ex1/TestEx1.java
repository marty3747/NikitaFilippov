package ru.training.at.hw3.tests.ex1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import ru.training.at.hw2.data.TestData;
import ru.training.at.hw3.pages.DifferentElementsPage;
import ru.training.at.hw3.pages.HomePage;
import ru.training.at.hw3.pages.LoginPage;
import ru.training.at.hw3.projectUtils.BeforeClass;
import ru.training.at.hw3.tests.BaseClass;

public class TestEx1 extends BaseClass {

    private WebElement webElement;

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
        for (WebElement webElement: loginPage.getListOfHeaderElements()) {
            Assert.assertTrue(webElement.isDisplayed());
        }
        for (int i = 0; i < TestData.HEADER_ITEMS_TEXT.size(); i++) {
            Assert.assertEquals(loginPage.getListOfHeaderElements().get(i).getText(), TestData.HEADER_ITEMS_TEXT.get(i));
        }
    }

    public void testImageEquals() {
        for (WebElement webElement: loginPage.getListOfImages()) {
            Assert.assertTrue(webElement.isDisplayed());
        }
    }

    public void testTextUnderIcons() {
        for (int i = 0; i < TestData.TEXT_UNDER_ICONS.size(); i++) {
            Assert.assertEquals(loginPage.getListOfTextsWebElements().get(i).getText(), TestData.TEXT_UNDER_ICONS.get(i));
        }
    }


    public void testIframeButton() {
        Assert.assertTrue(loginPage.getIframe().isDisplayed());
    }


    public void testFrameButtonInIframe() {
        webDriver.switchTo().frame(loginPage.getIframe());
        webElement = loginPage.getFrameButton();
        Assert.assertTrue(webElement.isDisplayed());
        webDriver.switchTo().parentFrame();
    }

    public void checkOriginalWindow() {
        String currentHandle = webDriver.getWindowHandle();
        Assert.assertEquals(originalWindowHandle, currentHandle);
    }

    public void testLeftSectionItems(){
        for (int i = 0; i < TestData.LEFT_SECTION_ITEMS_TEXTS.size(); i++) {
            Assert.assertTrue(loginPage.getListOfLeftSectionButton().get(i).isDisplayed());
            Assert.assertEquals(loginPage.getListOfLeftSectionButton().get(i).getText(), TestData.LEFT_SECTION_ITEMS_TEXTS.get(i));
        }
    }
}
