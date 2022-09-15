package ru.training.at.hw3_steps.tests.steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import ru.training.at.hw3_steps.pages.AbstractPage;
import ru.training.at.hw3_steps.pages.HomePage;
import ru.training.at.hw3_steps.pages.LoginPage;

public class HomePageSteps {

    @Step("Check 'HomePage' title")
    public static void checkHomePageWithCorrectTitle(AbstractPage homePage, String expected) {
        Assert.assertEquals(homePage.getTitle(), expected);
    }

    @Step("Log in user")
    public static LoginPage logIn(HomePage page) {
        return page.login();
    }
}
