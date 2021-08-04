package ru.training.at.hw5.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.utils.DriverManager;

public class CucumberHooks {
    @Before
    public void setUp() {
        TestContext
            .getInstance()
            .setDriver(DriverManager.createWebDriver());
    }

    @After
    public void tearDown() {
        TestContext
            .getInstance()
            .getDriver()
            .quit();
    }
}
