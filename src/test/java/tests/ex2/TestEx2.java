package tests.ex2;

import data.TestData;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.BaseClass;

import java.util.List;

public class TestEx2 extends BaseClass {

    private static final SoftAssert softAssert = new SoftAssert();

    @Test()
    public void runAllAssertsForEx2() {
        //6. Perform login
        performLogin();

        //7. Assert that there are 2 input text are displayed and they have proper text
        testTwoInputText();

        //8. Select gender and Assert that selected gender have proper text
        testSelectingGender();

        //9.Assert Option1, Option2 checkboxes can be selected
        testSelectCheckBoxes();

        //10.Assert Option1, Option2, Option3 can be selected
        testSelectRadioButton();

        //11.Assert that button 'Add' are displayed and Assert that
        //•	list of logs are displayed
        //•	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //• for each gender there is an individual log row and value is corresponded to the status of gender
        //•	for each radio button there is a log row and value is corresponded to the status of radio button and
        //•	email and name match logs
        testLogs();

        //12. Assert that modal dialog screen is displayed and have proper text
        testModalDialog();

        //13. Assert that
        testModalDialog();

        //14. Assert that email input have a correct text
        testEmailValidation();

        //15. Assert that warning alert for email input are displayed
        testWarningAlertLoginPage();
    }

    private void testTwoInputText() {
        loginPage.getEmail().sendKeys(TestData.LOGIN);
        loginPage.getName().sendKeys(TestData.NAME);
        softAssert.assertTrue(loginPage.getEmail().isDisplayed());
        softAssert.assertTrue(loginPage.getName().isDisplayed());
        softAssert.assertEquals(loginPage.getEmail().getText(), TestData.LOGIN);
        softAssert.assertEquals(loginPage.getName().getText(), TestData.PASSWORD);
    }

    private void testSelectingGender() {
        loginPage.selectGender(TestData.GENDER_FEMALE);
        softAssert.assertEquals(loginPage.getSelectedGender(), TestData.GENDER_FEMALE);
        loginPage.selectGender(TestData.GENDER_MALE);
        softAssert.assertEquals(loginPage.getSelectedGender(), TestData.GENDER_MALE);
        softAssert.assertTrue(loginPage.getDropdown().isDisplayed());
    }

    public void performLogin() {
        loginPage = homePage.login();
    }

    public void testSelectCheckBoxes() {
        loginPage.clickOptionOnCheckBox(TestData.OPTION_ONE_CHECKBOX_LIST_NUMBER);
        loginPage.clickOptionRadioButton(TestData.OPTION_TWO_CHECKBOX_LIST_NUMBER);
        softAssert.assertTrue(loginPage.checkOptionCheckBox(TestData.OPTION_ONE_CHECKBOX_LIST_NUMBER));
        softAssert.assertTrue(loginPage.checkOptionCheckBox(TestData.OPTION_TWO_CHECKBOX_LIST_NUMBER));
    }

    public void testSelectRadioButton() {
        loginPage.clickOptionRadioButton(TestData.OPTION_ONE_ON_CHECKBOX);
        softAssert.assertTrue(loginPage.radioButtonCheck(TestData.OPTION_ONE_ON_CHECKBOX));

        loginPage.clickOptionRadioButton(TestData.OPTION_TWO_ON_CHECKBOX);
        softAssert.assertTrue(loginPage.radioButtonCheck(TestData.OPTION_TWO_ON_CHECKBOX));

        loginPage.clickOptionRadioButton(TestData.OPTION_THREE_ON_CHECKBOX);
        softAssert.assertTrue(loginPage.radioButtonCheck(TestData.OPTION_THREE_ON_CHECKBOX));
    }

    public void testLogs() {
        loginPage.clickDataSendButton();
        List<WebElement> listOfCheckLogs = loginPage.getListOfLogs();
        for (WebElement webElement: listOfCheckLogs) {
            Assert.assertTrue(webElement.isDisplayed());
        }

        for (int i = 0; i < TestData.TEXTS_OF_LOGS.size(); i++) {
            softAssert.assertEquals(loginPage
                    .getListOfLogs()
                    .get(i)
                    .getText(), TestData.TEXTS_OF_LOGS.get(i));
        }
    }

    public void testModalDialog() {
        softAssert.assertTrue(loginPage.getModalDialog().isDisplayed());
        softAssert.assertEquals(loginPage.getModalDialog().getText(), TestData.MODAL_DIALOG_TEXT);
        loginPage.getOkBtn().click();
    }

    public void testEmailValidation() {
        String emailAddress = TestData.LOGIN;
        String regexPattern = TestData.REGEX_FOR_EMAIL;
        softAssert.assertTrue(BaseClass.patternMatches(emailAddress, regexPattern));
    }

    public void testWarningAlertLoginPage() {
        loginPage.getEmail().clear();
        loginPage.getEmail().sendKeys(TestData.INCORRECT_EMAIL);
        loginPage.getName().sendKeys(TestData.INCORRECT_NAME);
        loginPage.getDataSendBtn().click();
        softAssert.assertTrue(loginPage.getAlert().isDisplayed());
    }
}
