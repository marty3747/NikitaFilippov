package ru.training.at.hw5.pages;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTablePage extends AbstractPage {
    @FindBy(css = "td:nth-child(1)")
    private static List<WebElement> numbers;
    @FindBy(css = "#user-table select")
    private static List<WebElement> dropdowns;
    @FindBy(css = "#user-table a")
    private static List<WebElement> userNames;
    @FindBy(css = "#user-table .user-descr>span")
    private static List<WebElement> descriptions;
    @FindBy(css = "[type='checkbox']")
    private static List<WebElement> checkboxes;

    public UserTablePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public List<WebElement> getDropdowns() {
        return dropdowns;
    }

    public List<String> getUserNames() {
        return userNames.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getDescriptionsTexts() {
        return descriptions.stream()
                           .map(e -> e.getText().trim().replaceAll("\n", " "))
                           .collect(Collectors.toList());
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<String> getNumbers() {
        return numbers.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<WebElement> getDropdownOptionsForUser(String username) {
        return webDriver.findElements(By.xpath(
            "//a[text()='" + username
                + "']/parent::td//preceding-sibling::td/select/option"));
    }

    public List<String> getDropdownTextsForUser(String username) {
        return getDropdownOptionsForUser(username)
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());
    }

    public void clickCheckboxForUser(String username) {
        for (WebElement checkbox : checkboxes) {
            if (username.toLowerCase(Locale.ROOT)
                        .contains(checkbox.getAttribute("id")
                                          .toLowerCase(Locale.ROOT))) {
                checkbox.click();
            }
        }
    }
}
