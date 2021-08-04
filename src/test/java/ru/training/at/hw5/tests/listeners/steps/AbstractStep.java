package ru.training.at.hw5.tests.listeners.steps;

import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.pages.DifferentElementsPage;
import ru.training.at.hw5.pages.HomePage;
import ru.training.at.hw5.pages.LoginPage;
import ru.training.at.hw5.pages.UserTablePage;

public class AbstractStep {

    protected HomePage homePage;
    protected LoginPage loggedInHomePage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;


    protected AbstractStep() {
        loggedInHomePage = new LoginPage(TestContext.getInstance().getDriver());
        differentElementsPage = new DifferentElementsPage(TestContext.getInstance().getDriver());
        userTablePage = new UserTablePage(TestContext.getInstance().getDriver());
    }
}
