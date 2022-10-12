package tests.ex1;

import data.TestData;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.BaseClass;

public class TestEx1 extends BaseClass {

    private static final SoftAssert softAssert = new SoftAssert();

    @Test()
    public void runAllAssertsForEx1() {
        //3. Assert that there are 2 input text are displayed and they have proper text
        testTwoInputText();

        //4. Assert that Button are displayed
        testButtonAreDisplayed();

        //5. Assert that warning alert are displayed
        testWarningAlert();
    }

    public void testTwoInputText() {
        softAssert.assertTrue(homePage.getUsername().isDisplayed());
        softAssert.assertTrue(homePage.getPassword().isDisplayed());
        softAssert.assertEquals(homePage.getUsername().getText(), TestData.LOGIN);
        softAssert.assertEquals(homePage.getPassword().getText(), TestData.PASSWORD);
    }

    public void testButtonAreDisplayed() {
        softAssert.assertTrue(homePage.getAuthBtn().isDisplayed());
    }

    public void testWarningAlert() {
        homePage.getUsername().sendKeys(TestData.INCORRECT_EMAIL);
        homePage.getPassword().sendKeys(TestData.INCORRECT_PASSWORD);
        homePage.getAuthBtn().click();
        softAssert.assertTrue(homePage.getAlert().isDisplayed());
    }
}
