package ru.training.at.hw2.ex2;

import io.github.bonigarcia.wdm.WebDriverManager;
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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.training.at.hw2.BaseClass;
import ru.training.at.hw2.data.TestData;

public class TestEx2 extends BaseClass {

    @Test
    public void startAssertsForEx2() {

        //5.Open through the header menu Service -> Different Elements Page. Assert for titles
        webDriver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
        webDriver.findElement(By.xpath("//a[text() = 'Different elements']")).click();
        Assert.assertEquals(webDriver.getTitle(), TestData.TITLE_OF_PAGE_DIFFERENT_ELEMENTS);

        //6.Assert for Water, Wind selected checkboxes
        List<WebElement> webElementList = webDriver.findElements(By.cssSelector("input[type='checkbox']"));
        WebElement water = webElementList.get(0);
        WebElement wind = webElementList.get(2);
        water.click();
        wind.click();
        Assert.assertTrue(water.isSelected());
        Assert.assertTrue(wind.isSelected());

        //7.Assert for Selen selected radiobutton
        List<WebElement> webElementList1 = webDriver.findElements(By.cssSelector("input[type = 'radio']"));
        WebElement selen = webElementList1.get(3);
        selen.click();
        Assert.assertTrue(selen.isSelected());

        //8.Assert for selected dropdown color 'Yellow'
        Select dropdown = new Select(webDriver.findElement(By.cssSelector("select.uui-form-element")));
        dropdown.selectByVisibleText(TestData.COLOR);
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), TestData.COLOR);

        //9.Assert that
        //•	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //•	for radio button there is a log row and value is corresponded to the status of radio button
        //•	for dropdown there is a log row and value is corresponded to the selected value.
        List<WebElement> logs = webDriver.findElements(By.cssSelector(".logs >li"));
        for (WebElement webElement: logs) {
            Assert.assertTrue(webElement.isDisplayed());
        }
        Assert.assertEquals(logs.get(0).getText().substring(logs.get(0).getText().lastIndexOf(':')).replaceAll("[^a-zA-Z ]", "").trim(), TestData.TEXTS_OF_LOGS.get(0));
        Assert.assertEquals(logs.get(1).getText().substring(logs.get(0).getText().lastIndexOf(':')).replaceAll("[^a-zA-Z ]", "").trim(), TestData.TEXTS_OF_LOGS.get(1));
        Assert.assertEquals(logs.get(2).getText().substring(logs.get(0).getText().lastIndexOf(':')).replaceAll("[^a-zA-Z ]", "").trim(), TestData.TEXTS_OF_LOGS.get(2));
        Assert.assertEquals(logs.get(3).getText().substring(logs.get(0).getText().lastIndexOf(':')).replaceAll("[^a-zA-Z ]", "").trim(), TestData.TEXTS_OF_LOGS.get(3));

        //10.Close Browser
        webDriver.close();
    }
}
