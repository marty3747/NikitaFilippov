package ru.training.at.hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.xml.crypto.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw2.BaseClass;
import ru.training.at.hw2.data.TestData;

public class TestEx1 extends BaseClass {

    @Test
    public void startAssertsForEx1() {
        //5.Assert that there are 4 items on the header section are displayed and they have proper texts
        List <WebElement> listHome = webDriver.findElements(By.xpath("//a[text() = 'Home']"));
        List <WebElement> listContact = webDriver.findElements(By.xpath("//a[text() = 'Contact form']"));
        List <WebElement> listService = webDriver.findElements(By.xpath("//a[@class='dropdown-toggle']"));
        List <WebElement> listMetals = webDriver.findElements(By.xpath("//a[text() = 'Metals & Colors']"));
        List<WebElement> webElementList = List.of(
            listHome.get(0), listContact.get(0), listService.get(0), listMetals.get(0)
        );
        for (WebElement webElement: webElementList) {
            Assert.assertTrue(webElement.isDisplayed());
        }

        String home = listHome.get(0).getText();
        String service = listService.get(0).getText();
        String contact = listContact.get(0).getText();
        String metals = listMetals.get(0).getText();

        Assert.assertEquals(home, "HOME");
        Assert.assertEquals(contact, "CONTACT FORM");
        Assert.assertEquals(service, "SERVICE");
        Assert.assertEquals(metals, "METALS & COLORS");

        //6.Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> listImages = webDriver.findElements(By.cssSelector("div.benefit-icon"));
        Assert.assertEquals(listImages.size(), TestData.NUMBER_OF_IMAGES);
        for (WebElement webElement: listImages) {
            Assert.assertTrue(webElement.isDisplayed());
        }

        //7.Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> webElementList1 = webDriver.findElements(By.cssSelector("span.benefit-txt"));
        List<String> stringList = new ArrayList<>();
        for (WebElement webElement: webElementList1) {
            stringList.add(webElement.getText());
        }
        Assert.assertEquals(stringList.size(), TestData.TEXT_UNDER_ICONS.size());


        //8.Assert that there is the iframe with “Frame Button” exist
        WebElement iFrameButton = webDriver.findElement(By.tagName("iframe"));
        Assert.assertTrue(iFrameButton.isDisplayed());

        //9.Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame("frame");
        WebElement webElement = webDriver.findElement(By.id("frame-button"));
        Assert.assertTrue(webElement.isDisplayed());

        //10.Switch to original window back
        webDriver.switchTo().defaultContent();
        String currentHandle = webDriver.getWindowHandle();
        Assert.assertEquals(currentHandle, originalHandle);

        //11.Assert that there are 5 items in the Left Section are displayed and they have proper text
        List <WebElement> leftSectionItems = webDriver.findElements(By.cssSelector("ul.sidebar-menu.left > li > a > span"));
        for (WebElement webElement1: leftSectionItems) {
            Assert.assertTrue(webElement1.isDisplayed());
        }
        Assert.assertEquals(leftSectionItems.get(0).getText(), TestData.LEFT_SECTION_ITEMS_TEXTS.get(0));
        Assert.assertEquals(leftSectionItems.get(1).getText(), TestData.LEFT_SECTION_ITEMS_TEXTS.get(1));
        Assert.assertEquals(leftSectionItems.get(2).getText(), TestData.LEFT_SECTION_ITEMS_TEXTS.get(2));
        Assert.assertEquals(leftSectionItems.get(3).getText(), TestData.LEFT_SECTION_ITEMS_TEXTS.get(3));
        Assert.assertEquals(leftSectionItems.get(4).getText(), TestData.LEFT_SECTION_ITEMS_TEXTS.get(4));

        //12.Close Browser
        webDriver.close();
    }
}
