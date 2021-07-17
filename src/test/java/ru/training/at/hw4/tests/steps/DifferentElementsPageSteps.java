package ru.training.at.hw4.tests.steps;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw2.data.TestData;
import ru.training.at.hw4.pages.AbstractPage;
import ru.training.at.hw4.pages.DifferentElementsPage;

public class DifferentElementsPageSteps {
    private static final SoftAssert softAssert = new SoftAssert();

    @Step("Check that Different Elements Page is opened")
    public static void checkDifferentElementsPageIsOpened(AbstractPage page, String expected) {
        softAssert.assertEquals(page.getTitle(), expected);
    }

    @Step("Check that water and wind checkboxes are unchecked")
    public static void checkCheckBoxesAreUnchecked(DifferentElementsPage page, int waterNumber, int windNumber) {
        softAssert.assertFalse(page.checkWater(waterNumber));
        softAssert.assertFalse(page.checkWind(windNumber));
        softAssert.assertAll();
    }

    @Step("Click to water and wind checkboxes")
    public static void selectCheckboxes(DifferentElementsPage page, int waterNumber, int windNumber) {
        page.clickOnWaterCheckbox(waterNumber);
        page.clickOnWindCheckbox(windNumber);
    }

    @Step("Check that water and wind checkboxes are unchecked")
    public static void checkCheckboxesAreChecked(DifferentElementsPage page, int waterNumber, int windNumber) {
        softAssert.assertTrue(page.checkWater(waterNumber));
        softAssert.assertTrue(page.checkWind(windNumber));
        softAssert.assertAll();
    }

    @Step("Click 'selen' radio")
    public static void selectRadioButton(DifferentElementsPage page, int selenNumber) {
        page.clickSelenRadioButton(selenNumber);
    }

    @Step("Check that 'selen' radio is selected")
    public static void checkRadioButtonIsSelected(DifferentElementsPage page, int selenNumber) {
        softAssert.assertTrue(page.selenRadioButtonCheck(selenNumber));
    }

    @Step("click 'Yellow' color in dropdown")
    public static void selectYellowColorInDropdown(DifferentElementsPage page, String color) {
        page.selectColor(color);
    }

    @Step("Check that 'Yellow' color is selected")
    public static void checkYellowColorIsSelected(DifferentElementsPage page, String color) {
        softAssert.assertEquals(page.getSelectedColor(), color);
    }

    @Step("Check that logs are displayed")
    public static void checkLogsAreDisplayed(DifferentElementsPage page, List<String> expectedTexts) {
        List<WebElement> listOfLogs = page.getListOfLogs();
        softAssert.assertEquals(listOfLogs.size(), expectedTexts.size());
        for (WebElement webElement : listOfLogs) {
            softAssert.assertTrue(webElement.isDisplayed());
        }
        softAssert.assertAll();
    }

    @Step("Check that logs have proper texts")
    public static void checkLogsWithProperTexts(DifferentElementsPage page) {
        for (int i = 0; i < TestData.TEXTS_OF_LOGS.size(); i++) {
            softAssert.assertEquals(page
                .getListOfLogs()
                .get(i)
                .getText()
                .substring(page.getListOfLogs().get(i).getText().lastIndexOf(':'))
                .replaceAll("[^a-zA-Z ]", "").trim(), TestData.TEXTS_OF_LOGS.get(i));
        }
    }
}
