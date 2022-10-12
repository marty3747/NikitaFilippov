package tests;

import data.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import pages.HomePage;
import pages.LoginPage;
import projectUtils.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.util.regex.Pattern;

public class BaseClass {

    private static final SoftAssert softAssert = new SoftAssert();
    protected WebDriver webDriver;
    protected LoginPage loginPage;
    protected String originalWindowHandle;
    protected HomePage homePage;

    @org.testng.annotations.BeforeClass
    public void beforeMethod() {

        //1.Start home page and initialize home page elements
        initializer();

        //2.Assert browser title
        assertBrowserTitle();

    }

    public void initializer() {
        webDriver = BeforeClass.createWebDriver();
        originalWindowHandle = webDriver.getWindowHandle();
        homePage = new HomePage(webDriver);
        homePage.openHomePage();
    }

    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    public void assertBrowserTitle() {
       softAssert.assertEquals(homePage.getTitle(), TestData.HOME_PAGE_TITLE);
    }

    //Close Browser
   /* @AfterClass()
    public void clear() {
        webDriver.close();
    }*/
}
