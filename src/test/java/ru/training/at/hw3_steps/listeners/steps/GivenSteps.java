package ru.training.at.hw3_steps.listeners.steps;

import io.cucumber.java.en.Given;
import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.pages.HomePage;

public class GivenSteps {

    HomePage homePage = new HomePage(TestContext.getInstance().getDriver());

    @Given("I open JDI GitHub site on {string}")
    public void openJdiGitHubSite(String expectedTitle) {
        homePage.openHomePage();
    }

    @Given("I login as user Roman Iovlev")
    public void loginAsUser() {
        homePage.login();
    }

}
