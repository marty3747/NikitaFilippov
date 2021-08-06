package ru.training.at.hw5.pages;

import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(id = "user-name")
    private static WebElement username;
    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    private static WebElement serviceButton;
    @FindBy(xpath = "//a[text() = 'Different elements']")
    private static WebElement differentElementButton;
    @FindBy(css = ".dropdown>ul>li>a")
    private static List<WebElement> listOfHeaderElements;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getUsername() {
        return username.getText();
    }

    public void clickOnServiceButton(String linkText) {
        if (serviceButton.getText().equalsIgnoreCase(linkText)) {
            serviceButton.click();
        }
    }

    public DifferentElementsPage clickOnALinkInHeader(String linkText) {
        for (WebElement webElement : listOfHeaderElements) {
            if (webElement.getText().equalsIgnoreCase(linkText)) {
                webElement.click();
                return new DifferentElementsPage(webDriver);
            }
        }
        throw new NoSuchElementException("Element \"" + linkText + "\" not found");
    }
}
