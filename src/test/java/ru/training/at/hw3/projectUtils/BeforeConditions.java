package ru.training.at.hw3.projectUtils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import ru.training.at.hw3.data.TestData;

public class BeforeConditions {

    private static WebDriver webDriver;

    public static WebDriver createWebDriver() {
        System.setProperty(ru.training.at.hw3.data.TestData.WEB_DRIVER_NAME, ru.training.at.hw3.data.TestData.PATH_TO_THE_CHROME_DRIVER);
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        return webDriver;
    }
}
