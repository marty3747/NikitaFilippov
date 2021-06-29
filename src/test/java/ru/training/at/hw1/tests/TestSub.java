package ru.training.at.hw1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSub extends BeforeConditions {

    @Test(dataProvider = "LongData", dataProviderClass = DataProviders.class)
    public void subTest(long a, long b) {
        long expected = a - b;
        Assert.assertEquals(calculator.sub(a, b), expected);
    }

    @Test(dataProvider = "DoubleData", dataProviderClass = DataProviders.class)
    public void subTest(double a, double b) {
        double expected = a - b;
        Assert.assertEquals(calculator.sub(a, b), expected);
    }
}
