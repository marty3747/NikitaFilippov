package ru.training.at.hw3_steps.tests.ex2;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import ru.training.at.hw3_steps.data.TestData;
import ru.training.at.hw3_steps.pages.DifferentElementsPage;
import ru.training.at.hw3_steps.tests.BaseClass;
import ru.training.at.hw3_steps.tests.steps.DifferentElementsPageSteps;
import ru.training.at.hw3_steps.tests.steps.LoggedInHomePageSteps;

@Feature("Tests for Different elements page")
@Story("Testing elements of Different elements page")
public class TestEx2 extends BaseClass {

    private DifferentElementsPage differentElementsPage;

    @Test(priority = 1)
    public void runAllAssertsForEx2() {

        //8.Open through the header menu Service -> Different Elements Page. Assert for titles
        testPageServiceOpen();

        //9.Assert for Water, Wind selected checkboxes
        testSelectCheckBoxes();

        //10.Assert for Selen selected radiobutton
        testSelectRadioButton();

        //11.Assert for selected dropdown color 'Yellow'
        testYellowColorSelected();

        //12.Assert that
        //•	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //•	for radio button there is a log row and value is corresponded to the status of radio button
        //•	for dropdown there is a log row and value is corresponded to the selected value.
        testLogs();
    }

    public void testPageServiceOpen() {
        differentElementsPage = LoggedInHomePageSteps.navigateToDifferentElementsPage(loginPage);
        DifferentElementsPageSteps.checkDifferentElementsPageIsOpened(differentElementsPage, TestData.TITLE_OF_PAGE_DIFFERENT_ELEMENTS);
    }

    public void testSelectCheckBoxes() {
        DifferentElementsPageSteps.checkCheckBoxesAreUnchecked(differentElementsPage,
            ru.training.at.hw4.data.TestData.WATER_LIST_NUMBER,
            ru.training.at.hw4.data.TestData.WIND_LIST_NUMBER);

        DifferentElementsPageSteps.selectCheckboxes(differentElementsPage,
            ru.training.at.hw4.data.TestData.WATER_LIST_NUMBER,
            ru.training.at.hw4.data.TestData.WIND_LIST_NUMBER);

        DifferentElementsPageSteps.checkCheckboxesAreChecked(differentElementsPage,
            ru.training.at.hw4.data.TestData.WATER_LIST_NUMBER,
            ru.training.at.hw4.data.TestData.WIND_LIST_NUMBER);
    }

    public void testSelectRadioButton() {
        DifferentElementsPageSteps.selectRadioButton(differentElementsPage,
            ru.training.at.hw4.data.TestData.SELEN_LIST_NUMBER);

        DifferentElementsPageSteps.checkRadioButtonIsSelected(differentElementsPage,
            ru.training.at.hw4.data.TestData.SELEN_LIST_NUMBER);
    }

    public void testYellowColorSelected() {
        DifferentElementsPageSteps.selectYellowColorInDropdown(differentElementsPage,
            ru.training.at.hw4.data.TestData.COLOR);

        DifferentElementsPageSteps.checkYellowColorIsSelected(differentElementsPage,
            ru.training.at.hw4.data.TestData.COLOR);
    }

    public void testLogs() {
        DifferentElementsPageSteps.checkLogsAreDisplayed(differentElementsPage, TestData.TEXTS_OF_LOGS);
        DifferentElementsPageSteps.checkLogsWithProperTexts(differentElementsPage);
    }


    //10.Close Browser
    @AfterClass
    public void clear() {
        webDriver.close();
    }
}
