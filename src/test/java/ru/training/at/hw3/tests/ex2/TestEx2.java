package ru.training.at.hw3.tests.ex2;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.training.at.hw2.data.TestData;
import ru.training.at.hw3.pages.DifferentElementsPage;
import ru.training.at.hw3.pages.HomePage;
import ru.training.at.hw3.pages.LoginPage;
import ru.training.at.hw3.projectUtils.BeforeClass;
import ru.training.at.hw3.tests.BaseClass;

public class TestEx2 extends BaseClass {

    private DifferentElementsPage differentElementsPage;

    @Test(priority = 1)
    public void runAllAssertsForEx2() {

        //5.Open through the header menu Service -> Different Elements Page. Assert for titles
        testPageServiceOpen();

        //6.Assert for Water, Wind selected checkboxes
        testSelectCheckBoxes();

        //7.Assert for Selen selected radiobutton
        testSelectRadioButton();

        //8.Assert for selected dropdown color 'Yellow'
        testYellowColorSelected();

        //9.Assert that
        //•	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //•	for radio button there is a log row and value is corresponded to the status of radio button
        //•	for dropdown there is a log row and value is corresponded to the selected value.
        testLogs();
    }

    public void testPageServiceOpen() {
        differentElementsPage = loginPage.clickOnDifferentElementsItem();
        Assert.assertEquals(differentElementsPage.getTitle(), TestData.TITLE_OF_PAGE_DIFFERENT_ELEMENTS);
    }

    public void testSelectCheckBoxes() {
        differentElementsPage.clickOnWaterCheckbox(ru.training.at.hw3.data.TestData.WATER_LIST_NUMBER);
        differentElementsPage.clickOnWindCheckbox(ru.training.at.hw3.data.TestData.WIND_LIST_NUMBER);
        Assert.assertTrue(differentElementsPage.checkWater(ru.training.at.hw3.data.TestData.WATER_LIST_NUMBER));
        Assert.assertTrue(differentElementsPage.checkWind(ru.training.at.hw3.data.TestData.WIND_LIST_NUMBER));
    }

    public void testSelectRadioButton() {
        differentElementsPage.clickSelenRadioButton(ru.training.at.hw3.data.TestData.SELEN_LIST_NUMBER);
        Assert.assertTrue(differentElementsPage.selenRadioButtonCheck(ru.training.at.hw3.data.TestData.SELEN_LIST_NUMBER));
    }

    public void testYellowColorSelected() {
        differentElementsPage.selectColor(TestData.COLOR);
        Assert.assertEquals(differentElementsPage.getSelectedColor(), TestData.COLOR);
    }

    public void testLogs() {
        List<WebElement> listOfCheckLogs = differentElementsPage.getListOfLogs();
        for (WebElement webElement: listOfCheckLogs) {
            Assert.assertTrue(webElement.isDisplayed());
        }
        for (int i = 0; i < TestData.TEXTS_OF_LOGS.size(); i++) {
            Assert.assertEquals(differentElementsPage
                    .getListOfLogs()
                    .get(i)
                    .getText()
                    .substring(differentElementsPage.getListOfLogs().get(i).getText().lastIndexOf(':'))
                    .replaceAll("[^a-zA-Z ]", "").trim(), TestData.TEXTS_OF_LOGS.get(i));
        }
    }

    //10.Close Browser
    @AfterClass
    public void clear() {
        webDriver.close();
    }
}
