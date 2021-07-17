package ru.training.at.hw4.tests;

import ru.training.at.hw4.data.FailTestData;
import ru.training.at.hw4.data.TestData;
import ru.training.at.hw4.tests.steps.HomePageSteps;

public class FailTest extends BaseClass{

    public void testWrongHomePageTitle() {
        HomePageSteps.checkHomePageWithCorrectTitle(homePage, FailTestData.WRONG_PAGE_TITLE);
    }
}
