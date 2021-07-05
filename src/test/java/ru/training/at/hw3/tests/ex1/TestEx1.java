package ru.training.at.hw3.tests.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.training.at.hw2.data.TestData;
import ru.training.at.hw3.pages.DifferentElementsPage;
import ru.training.at.hw3.pages.HomePage;
import ru.training.at.hw3.pages.LoginPage;
import ru.training.at.hw3.projectUtils.BeforeConditions;

public class TestEx1 extends TestData {

    private WebDriverWait webDriverWait;
    private WebDriver webDriver;
    private LoginPage loginPage;
    private WebElement webElement;
    private String originalWindowHandle;
    private DifferentElementsPage differentElementsPage;
    private HomePage homePage;

    //1.Start home page and initialize home page elements
    @BeforeClass(alwaysRun = true)
    public void beforeConditions() {
        webDriver = BeforeConditions.createWebDriver();
        originalWindowHandle = webDriver.getWindowHandle();
        homePage = new HomePage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
        homePage.openHomePage();
    }

    //2.Assert browser title
    @Test(priority = 1)
    public void testPageTitle() {
        Assert.assertEquals(homePage.getTitle(), TestData.HOME_PAGE_TITLE);
    }

    //3.Perform login for log in
    @Test(priority = 2)
    public void testLogin() {
        loginPage = homePage.login();
    }

    //4.Assert Username is logged
    @Test(priority = 3)
    public void testUsernameEquals() {
        Assert.assertEquals(loginPage.getUsername(), TestData.USERNAME);
    }

    //5.Assert that there are 4 items on the header section are displayed and they have proper texts
    @Test(priority = 4)
    public void testHeaderItemsEquals() {
        for (WebElement webElement: loginPage.getListOfHeaderElements()) {
            Assert.assertTrue(webElement.isDisplayed());
        }
        for (int i = 0; i < TestData.HEADER_ITEMS_TEXT.size(); i++) {
            Assert.assertEquals(loginPage.getListOfHeaderElements().get(i).getText(), TestData.HEADER_ITEMS_TEXT.get(i));
        }
    }

    //6.Assert that there are 4 images on the Index Page and they are displayed
    @Test(priority = 5)
    public void testImageEquals() {
        for (WebElement webElement: loginPage.getListOfImages()) {
            Assert.assertTrue(webElement.isDisplayed());
        }
    }
    //7.Assert that there are 4 texts on the Index Page under icons and they have proper text
    @Test(priority = 6)
    public void testTextUnderIcons() {
        for (int i = 0; i < TestData.TEXT_UNDER_ICONS.size(); i++) {
            Assert.assertEquals(loginPage.getListOfTextsWebElements().get(i).getText(), TestData.TEXT_UNDER_ICONS.get(i));
        }
    }
    //8.Assert that there is the iframe with “Frame Button” exist
    @Test(priority = 7)
    public void testIframeButton() {
        Assert.assertTrue(loginPage.getIframe().isDisplayed());
    }
    //9.Switch to the iframe and check that there is “Frame Button” in the iframe
    @Test(priority = 8)
    public void testFrameButtonInIframe() {
        webDriver.switchTo().frame(loginPage.getIframe());
        webElement = loginPage.getFrameButton();
        Assert.assertTrue(webElement.isDisplayed());
        webDriver.switchTo().parentFrame();
    }
    //10.Switch to original window back
    @Test(priority = 9)
    public void checkOriginalWindow() {
        String currentHandle = webDriver.getWindowHandle();
        Assert.assertEquals(originalWindowHandle, currentHandle);
    }
    //11.Assert that there are 5 items in the Left Section are displayed and they have proper text
    @Test(priority = 10)
    public void testLeftSectionItems(){
        for (int i = 0; i < TestData.LEFT_SECTION_ITEMS_TEXTS.size(); i++) {
            Assert.assertTrue(loginPage.getListOfLeftSectionButton().get(i).isDisplayed());
            Assert.assertEquals(loginPage.getListOfLeftSectionButton().get(i).getText(), TestData.LEFT_SECTION_ITEMS_TEXTS.get(i));
        }
    }

    //12.Close Browser
    @AfterClass()
    public void clear() {
        webDriver.close();
    }
}
