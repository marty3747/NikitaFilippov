package ru.training.at.hw1.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMultiply extends BeforeConditions{

    @Test(dataProvider = "LongData", dataProviderClass = DataProviders.class)
    public void testMultiply(long a, long b) {
        long expected = a * b;
        Assert.assertEquals(calculator.mult(a, b),expected);
    }
}
