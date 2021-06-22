package ru.training.at.hw1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDivide extends BeforeConditions {

    @Test(dataProvider = "LongData", dataProviderClass = DataProviders.class)
    public void divideTest(long a, long b) {
        long expected = a / b;
        Assert.assertEquals(calculator.div(a, b), expected);
    }

    @Test(dataProvider = "DoubleData", dataProviderClass = DataProviders.class)
    public void divideTest(double a, double b) {
        double expected = a / b;
        Assert.assertEquals(calculator.div(a, b), expected);
    }

    @Test(dataProvider = "DataForDivideByZero",
          dataProviderClass = DataProviders.class,
          expectedExceptions = NumberFormatException.class)
    public void divideByZero(long a, long b) {
        calculator.div(a, b);
    }
}
