package ru.training.at.hw5.pages;

import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DifferentElementsPage extends AbstractPage {

    private LogSection logSection;

    @FindBy(css = "input[type='checkbox']")
    public List<WebElement> listOfCheckboxes;

    @FindBy(css = "input[type = 'radio']")
    public List<WebElement> listOfRadioButtons;

    @FindBy(css = "select.uui-form-element")
    public WebElement dropdown;

    @FindBy(css = ".logs >li")
    public List<WebElement> listOfLogs;

    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
        logSection = new LogSection(webDriver);
    }

    public boolean checkWater(int number) {
        return listOfCheckboxes.get(number).isSelected();
    }

    public WebElement getCheckboxByText(String checkboxText) {
        for (WebElement element : listOfCheckboxes) {
            String text = element.getAccessibleName();
            if (text.equals(checkboxText)) {
                return element;
            }
        }
        throw new NoSuchElementException("Element \"" + checkboxText + "\" can not be found");
    }

    public void clickOnCheckbox(String checkboxText) {
        getCheckboxByText(checkboxText).click();
    }

    public boolean checkWind(int number) {
        return listOfCheckboxes.get(number).isSelected();
    }

    public WebElement getRadioByText(String radioText) {
        for (WebElement element : listOfRadioButtons) {
            String text = element.getAccessibleName();
            if (text.equals(radioText)) {
                return element;
            }
        }
        throw new NoSuchElementException("Element \"" + radioText + "\" can not be found");
    }

    public void clickOnWindCheckbox(int number) {
        listOfCheckboxes.get(number).click();
    }

    public boolean selenRadioButtonCheck(int number) {
        return listOfRadioButtons.get(number).isSelected();
    }

    public void clickSelenRadioButton(int number) {
        listOfRadioButtons.get(number).click();
    }

    public void selectColor(String color) {
        new Select(dropdown).selectByVisibleText(color);
    }

    public void clickOnRadioButton(String radioText) {
        getRadioByText(radioText).click();
    }

    public String getSelectedColor() {
        return new Select(dropdown).getFirstSelectedOption().getText();
    }

    public List<WebElement> getListOfLogs() {
        return listOfLogs;
    }

    public LogSection getLogSection() {
        return logSection;
    }
}
