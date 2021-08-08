package ru.training.at.hw6.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "user-name")
    private static WebElement username;

    @FindBy(css = ".nav > li > a")
    private static List<WebElement> listOfHeaderElements;

    @FindBy(css = "div.benefit-icon")
    private static List<WebElement> listOfImages;

    @FindBy(css = "span.benefit-txt")
    private static List<WebElement> listOfTextsWebElements;

    @FindBy(tagName = "iframe")
    private static WebElement iframe;

    @FindBy(id = "frame-button")
    private static WebElement frameButton;

    @FindBy(css = "ul.sidebar-menu.left > li > a > span")
    private static List<WebElement> listOfLeftSectionButton;


    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    private static WebElement serviceButton;

    @FindBy(xpath = "//a[text() = 'Different elements']")
    private static WebElement differentElementButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getUsername() {
        return username.getText();
    }

    public List<WebElement> getListOfHeaderElements() {
        return listOfHeaderElements;
    }

    public List<WebElement> getListOfImages() {
        return listOfImages;
    }

    public List<WebElement> getListOfTextsWebElements() {
        return listOfTextsWebElements;
    }

    public WebElement getIframe() {
        return iframe;
    }

    public WebElement getFrameButton() {
        return frameButton;
    }

    public List<WebElement> getListOfLeftSectionButton() {
        return listOfLeftSectionButton;
    }

    public DifferentElementsPage clickDifferentPageItem() {
        serviceButton.click();
        differentElementButton.click();
        return new DifferentElementsPage(webDriver);
    }


    public DifferentElementsPage clickOnDifferentElementsItem() {
        return clickDifferentPageItem();
    }
}
