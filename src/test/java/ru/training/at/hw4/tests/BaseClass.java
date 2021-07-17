package ru.training.at.hw4.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import ru.training.at.hw2.data.TestData;
import ru.training.at.hw4.pages.DifferentElementsPage;
import ru.training.at.hw4.pages.HomePage;
import ru.training.at.hw4.pages.LoginPage;
import ru.training.at.hw4.projectUtils.BeforeClass;
import ru.training.at.hw4.tests.listeners.Listener;
import ru.training.at.hw4.tests.steps.HomePageSteps;
import ru.training.at.hw4.tests.steps.LoggedInHomePageSteps;


@Listeners({Listener.class})
@Feature("Base test for Exercise #1 and Exercise #2")
@Story("Testing Home page title logging of the user")
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
        HomePageSteps.checkHomePageWithCorrectTitle(homePage, ru.training.at.hw4.data.TestData.HOME_PAGE_TITLE);
    }

    public void performLogin() {
        loginPage = HomePageSteps.logIn(homePage);
    }

    public void assertUsername() {
        LoggedInHomePageSteps.checkUsernameWithCorrectText(loginPage, ru.training.at.hw4.data.TestData.USERNAME);
    }

    //12.Close Browser
    @AfterClass()
    public void clear() {
        webDriver.close();
    }
}
