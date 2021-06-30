package ru.training.at.hw2.ex2;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.training.at.hw2.data.TestData;

public class TestEx2 {

    private WebDriver webDriver;

    //1.Before settings and conditions
    @BeforeClass
    public void beforeConditions() {
        System.setProperty("webdriver.chrome.driver", "C:/WebDrivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.navigate().to(TestData.URL);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    //2.Assert browser title
    @Test(priority = 1)
    public void testPageTitle() {
        Assert.assertEquals(webDriver.getTitle(), TestData.HOME_PAGE_TITLE);
    }

    //3.Perform login for log in
    @Test(priority = 2)
    public void testLogin() {
        webDriver.findElement(By.id("user-icon")).click();
        webDriver.findElement(By.id("name")).sendKeys(TestData.LOGIN);
        webDriver.findElement(By.id("password")).sendKeys(TestData.PASSWORD);
        webDriver.findElement(By.id("login-button")).click();
    }

    //4.Assert Username is logged
    @Test(priority = 3)
    public void testUsernameEquals() {
        String name = webDriver.findElement(By.id("user-name")).getText();
        Assert.assertEquals(name, TestData.USERNAME);
    }

    //5.Open through the header menu Service -> Different Elements Page. Assert for titles
    @Test(priority = 4)
    public void testPageServiceOpen() {
        webDriver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
        webDriver.findElement(By.xpath("//a[text() = 'Different elements']")).click();
        Assert.assertEquals(webDriver.getTitle(), TestData.TITLE_OF_PAGE_DIFFERENT_ELEMENTS);
    }

    //6.Assert for Water, Wind selected checkboxes
    @Test(priority = 5)
    public void testSelectCheckBoxes() {
        List<WebElement> webElementList = webDriver.findElements(By.cssSelector("input[type='checkbox']"));
        WebElement water = webElementList.get(0);
        WebElement wind = webElementList.get(2);
        water.click();
        wind.click();
        Assert.assertTrue(water.isSelected());
        Assert.assertTrue(wind.isSelected());
    }

    //7.Assert for Selen selected radiobutton
    @Test(priority = 6)
    public void testSelectRadioButton() {
        List<WebElement> webElementList = webDriver.findElements(By.cssSelector("input[type = 'radio']"));
        WebElement selen = webElementList.get(3);
        selen.click();
        Assert.assertTrue(selen.isSelected());
    }

    //8.Assert for selected dropdown color 'Yellow'
    @Test(priority = 7)
    public void testYellowColorSelected() {
        Select dropdown = new Select(webDriver.findElement(By.cssSelector("select.uui-form-element")));
        dropdown.selectByVisibleText(TestData.COLOR);
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), TestData.COLOR);
    }

    //9.Assert that
    //•	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
    //•	for radio button there is a log row and value is corresponded to the status of radio button
    //•	for dropdown there is a log row and value is corresponded to the selected value.
    @Test(priority = 8)
    public void testLogs() {
        List<WebElement> logs = webDriver.findElements(By.cssSelector(".logs >li"));
        for (WebElement webElement: logs) {
            Assert.assertTrue(webElement.isDisplayed());
        }
        Assert.assertEquals(logs.get(0).getText().substring(logs.get(0).getText().lastIndexOf(':')).replaceAll("[^a-zA-Z ]", "").trim(), TestData.TEXTS_OF_LOGS.get(0));
        Assert.assertEquals(logs.get(1).getText().substring(logs.get(0).getText().lastIndexOf(':')).replaceAll("[^a-zA-Z ]", "").trim(), TestData.TEXTS_OF_LOGS.get(1));
        Assert.assertEquals(logs.get(2).getText().substring(logs.get(0).getText().lastIndexOf(':')).replaceAll("[^a-zA-Z ]", "").trim(), TestData.TEXTS_OF_LOGS.get(2));
        Assert.assertEquals(logs.get(3).getText().substring(logs.get(0).getText().lastIndexOf(':')).replaceAll("[^a-zA-Z ]", "").trim(), TestData.TEXTS_OF_LOGS.get(3));
    }

    //10.Close Browser
    @AfterClass()
    public void clear() {
        webDriver.close();
    }
}
