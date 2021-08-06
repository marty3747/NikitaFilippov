package ru.training.at.hw4.tests.steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import ru.training.at.hw4.pages.AbstractPage;
import ru.training.at.hw4.pages.HomePage;
import ru.training.at.hw4.pages.LoginPage;

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
