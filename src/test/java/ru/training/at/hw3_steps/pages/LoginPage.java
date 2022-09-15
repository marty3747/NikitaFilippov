package ru.training.at.hw3_steps.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "user-name")
    private static WebElement username;

    @FindBy(xpath = "//h3[contains(@name, 'main-title')]")
    private WebElement mainTitleHomePage;

    @FindBy(xpath = "//p[contains(@name, 'jdi-text')]")
    private WebElement secondTitleHomePage;

    @FindBy(xpath = "//h5[contains(@class, 'card-title')]")
    private WebElement frameCardTitle;

    @FindBy(xpath = "//p[contains(@class, 'card-text')]")
    private WebElement frameCardText;

    @FindBy(css = ".nav > li > a")
    private static List<WebElement> listOfHeaderElements;

    @FindBy(css = "div.benefit-icon")
    private static List<WebElement> listOfImages;

    @FindBy(css = "span.benefit-txt")
    private static List<WebElement> listOfTextsWebElements;

    @FindBy(tagName = "iframe")
    private static WebElement iframe;

    @FindBy(id = "frame")
    private static WebElement frame;

    @FindBy(id = "frame-button")
    private static WebElement frameButton;

    @FindBy(id = "//a[contains(@target, '_blank')]")
    private static List<WebElement> listOfJdiTitle;

    @FindBy(css = "ul.sidebar-menu.left > li > a > span")
    private static List<WebElement> listOfLeftSectionButton;

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    private static WebElement serviceButton;

    @FindBy(xpath = "//a[text() = 'Different elements']")
    private static WebElement differentElementButton;

    @FindBy(xpath = "//input[@id = 'frame-button']")
    private static List<WebElement> frameCardButtons;

    @FindBy(xpath = "//img[contains(@style, '-webkit-user-select: none;')]")
    private static List<WebElement> imgInFrameCard;

    @FindBy(xpath = "//li[contains(@ui, 'label')]//a[contains(@href, 'index.html')]")
    private static List<WebElement> homePageTitleFromFrameCard;

    @FindBy(xpath = "//li[contains(@ui, 'label')]//a[contains(@href, 'contacts.html')]")
    private static List<WebElement> homePageContactFormInFrameCard;

    @FindBy(xpath = "//div[contains(@class, 'benefit-icon')]//span[contains(@class, 'benefit-txt')]")
    private static List<WebElement> homePageTextInTheFooter;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getUsername() {
        return username.getText();
    }

    public String getMainTitleFromHomePage() {
        return mainTitleHomePage.getText();
    }

    public WebElement getMainTitleFromHomePageLikeWebElement() {
        return mainTitleHomePage;
    }

    public String getSecondTitleFromHomePage() {
        return secondTitleHomePage.getText();
    }

    public String getFrameCardTitle() {
        return frameCardTitle.getText();
    }

    public List<WebElement> getListOfJdiTitle() {
        return listOfJdiTitle;
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

    public WebElement getFrame() {
        return frame;
    }

    public WebElement getFrameButton() {
        return frameButton;
    }

    public WebElement getFrameCardText() {
        return frameCardText;
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

    public List<WebElement> getFrameCardButtons() {
        return frameCardButtons;
    }

    public List<WebElement> getFrameImg() {
        return imgInFrameCard;
    }

    public List<WebElement> getHomePageTitleFromFrameCard() {
        return homePageTitleFromFrameCard;
    }

    public List<WebElement> getHomePageContactFormInFrameCard() {
        return homePageContactFormInFrameCard;
    }

    public List<WebElement> getHomePageTextInTheFooter() {
        return homePageTitleFromFrameCard;
    }
}
