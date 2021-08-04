package ru.training.at.hw5.tests.listeners.steps;

import io.cucumber.java.en.When;
import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.pages.DifferentElementsPage;
import ru.training.at.hw5.pages.LoginPage;
import ru.training.at.hw5.pages.UserTablePage;

public class WhenSteps {

    LoginPage loggedInHomePage = new LoginPage(TestContext.getInstance().getDriver());
    DifferentElementsPage differentElementsPage = new DifferentElementsPage(TestContext.getInstance().getDriver());
    UserTablePage userTablePage = new UserTablePage(TestContext.getInstance().getDriver());

    @When("I click on {string} button in Header")
    public void click_on_button_in_Header(String linkText) {
        loggedInHomePage.clickOnServiceButton(linkText);
    }

    @When("I click on {string} button in Service dropdown")
    public void clickOnButtonInServiceDropdown(String itemInDropdown) {
        loggedInHomePage.clickOnALinkInHeader(itemInDropdown);
    }

    @When("I select {string} checkbox on Different Elements Page")
    public void selectCheckboxOnDifferentElementsPage(
        String checkboxText) {
        differentElementsPage.clickOnCheckbox(checkboxText);
    }

    @When("I select {string} radio on Different Elements Page")
    public void selectRadioOnDifferentElementsPage(String radioText) {
        differentElementsPage.clickOnRadioButton(radioText);
    }

    @When("I select {string} color in dropdown on Different Elements Page")
    public void selectColorInDropdownOnTheDifferentElementsPage(String color) {
        differentElementsPage.selectColor(color);
    }

    @When("I select 'vip' checkbox for {string}")
    public void selectVipCheckboxForUserOnUserTablePage(String user) {
        userTablePage.clickCheckboxForUser(user);
    }
}
