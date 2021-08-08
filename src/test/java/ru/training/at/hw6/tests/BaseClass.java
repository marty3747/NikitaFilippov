package ru.training.at.hw6.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import ru.training.at.hw6.data.TestData;
import ru.training.at.hw6.pages.DifferentElementsPage;
import ru.training.at.hw6.pages.HomePage;
import ru.training.at.hw6.pages.LoginPage;
import ru.training.at.hw6.projectUtils.BeforeClass;

public class BaseClass {

    protected WebDriver webDriver;
    protected LoginPage loginPage;
    protected String originalWindowHandle;
    protected DifferentElementsPage differentElementsPage;
    protected HomePage homePage;

    @org.testng.annotations.BeforeClass
    public void beforeMethod() {

        //1.Start home page and initialize home page elements
        initializer();

        //2.Assert browser title
        assertBrowserTitle();

        //3.Perform login for log in
        performLogin();

        //4.Assert Username is logged
        assertUsername();
    }

    public void initializer() {
        webDriver = BeforeClass.createWebDriver();
        originalWindowHandle = webDriver.getWindowHandle();
        homePage = new HomePage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
        homePage.openHomePage();
    }

    public void assertBrowserTitle() {
        Assert.assertEquals(homePage.getTitle(), TestData.HOME_PAGE_TITLE);
    }

    public void performLogin() {
        loginPage = homePage.login();
    }

    public void assertUsername() {
        Assert.assertEquals(loginPage.getUsername(), TestData.USERNAME);
    }

    //12.Close Browser
    @AfterClass()
    public void clear() {
        webDriver.close();
    }
}
