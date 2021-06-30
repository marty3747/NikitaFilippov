package ru.training.at.hw2.ex1;

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
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw2.data.TestData;

public class TestEx1 extends TestData {

    private WebDriverWait webDriverWait;
    private WebDriver webDriver;
    private WebElement webElement;
    private String originalHandle;

    //1.Before settings and conditions
    @BeforeClass
    public void beforeConditions() {
        System.setProperty("webdriver.chrome.driver", "C:/WebDrivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.navigate().to(TestData.URL);
        originalHandle = webDriver.getWindowHandle();
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

    //5.Assert that there are 4 items on the header section are displayed and they have proper texts
    @Test(priority = 4)
    public void testHeaderItemsEquals() {
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
    }

    //6.Assert that there are 4 images on the Index Page and they are displayed
    @Test(priority = 5)
    public void testImageEquals() {
        List<WebElement> listImages = webDriver.findElements(By.cssSelector("div.benefit-icon"));
        Assert.assertEquals(listImages.size(), TestData.NUMBER_OF_IMAGES);
        for (WebElement webElement: listImages) {
            Assert.assertTrue(webElement.isDisplayed());
        }
    }
    //7.Assert that there are 4 texts on the Index Page under icons and they have proper text
    @Test(priority = 6)
    public void testTextUnderIcons() {
        List<WebElement> webElementList = webDriver.findElements(By.cssSelector("span.benefit-txt"));
        List<String> stringList = new ArrayList<>();
        for (WebElement webElement: webElementList) {
            stringList.add(webElement.getText());
        }
        Assert.assertEquals(stringList.size(), TestData.TEXT_UNDER_ICONS.size());
    }
    //8.Assert that there is the iframe with “Frame Button” exist
    @Test(priority = 7)
    public void testIframeButton() {
        WebElement iFrameButton = webDriver.findElement(By.tagName("iframe"));
        Assert.assertTrue(iFrameButton.isDisplayed());
    }
    //9.Switch to the iframe and check that there is “Frame Button” in the iframe
    @Test(priority = 8)
    public void testFrameButtonInIframe() {
        webDriver.switchTo().frame("frame");
        webElement = webDriver.findElement(By.id("frame-button"));
        Assert.assertTrue(webElement.isDisplayed());
    }
    //10.Switch to original window back
    @Test(priority = 9)
    public void checkOriginalWindow() {
        webDriver.switchTo().defaultContent();
        Assert.assertEquals(webDriver.getWindowHandle(), originalHandle);
    }
    //11.Assert that there are 5 items in the Left Section are displayed and they have proper text
    @Test(priority = 10)
    public void testLeftSectionItems(){
        List <WebElement> leftSectionItems = webDriver.findElements(By.cssSelector("ul.sidebar-menu.left > li > a > span"));
        for (WebElement webElement: leftSectionItems) {
            Assert.assertTrue(webElement.isDisplayed());
        }
        Assert.assertEquals(leftSectionItems.get(0).getText(), TestData.LEFT_SECTION_ITEMS_TEXTS.get(0));
        Assert.assertEquals(leftSectionItems.get(1).getText(), TestData.LEFT_SECTION_ITEMS_TEXTS.get(1));
        Assert.assertEquals(leftSectionItems.get(2).getText(), TestData.LEFT_SECTION_ITEMS_TEXTS.get(2));
        Assert.assertEquals(leftSectionItems.get(3).getText(), TestData.LEFT_SECTION_ITEMS_TEXTS.get(3));
        Assert.assertEquals(leftSectionItems.get(4).getText(), TestData.LEFT_SECTION_ITEMS_TEXTS.get(4));
    }
    //12.Close Browser
    @AfterClass()
    public void clear() {
        webDriver.close();
    }
}
