package ru.training.at.hw5.pages;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogSection extends AbstractPage {
    @FindBy(css = ".logs >li")
    private static List<WebElement> logs;

    public LogSection(WebDriver driver) {
        super(driver);
    }

    public int getLogsSize() {
        return logs.size();
    }

    public List<String> getLogTexts() {
        return logs.stream()
                   .map(WebElement::getText)
                   .collect(Collectors.toList());
    }
}
