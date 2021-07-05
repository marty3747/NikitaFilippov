package ru.training.at.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import ru.training.at.hw2.data.TestData;

public class BaseClass {

    protected WebDriver webDriver;
    protected String originalHandle;

    @BeforeMethod
    public void beforeConditions() {

        //Initialize all utils
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.navigate().to(TestData.URL);
        originalHandle = webDriver.getWindowHandle();


        //2.Assert browser title
        Assert.assertEquals(webDriver.getTitle(), TestData.HOME_PAGE_TITLE);


        //3.Perform login for log in
        webDriver.findElement(By.id("user-icon")).click();
        webDriver.findElement(By.id("name")).sendKeys(TestData.LOGIN);
        webDriver.findElement(By.id("password")).sendKeys(TestData.PASSWORD);
        webDriver.findElement(By.id("login-button")).click();

        //4.Assert Username is logged
        String name = webDriver.findElement(By.id("user-name")).getText();
        Assert.assertEquals(name, TestData.USERNAME);
    }
}
