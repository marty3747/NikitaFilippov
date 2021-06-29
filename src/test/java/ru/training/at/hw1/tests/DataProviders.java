package ru.training.at.hw1.tests;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "LongData")
    public static Object[][] longTestData() {
        return new Object[][] {
            {1L,2L},
            {321L, 432L},
            {43L, 43L},
            {0, 0},
            {-3L, -6L}
        };
    }

    @DataProvider(name = "DoubleData")
    public static Object[][] doubleTestData() {
        return new Object[][] {
            {342.3, 23.1},
            {54.1, 65.2},
            {65.4, 34.6},
            {0, 0},
            {-3,-5}
        };
    }

    @DataProvider(name = "DataForDivideByZero")
    public static Object[][] getDataForDivideZero() {
        return new Object[][] {
            {3,0},
            {2,0},
            {32,0},
            {234,0},
            {-12, 0}
        };
    }
}
