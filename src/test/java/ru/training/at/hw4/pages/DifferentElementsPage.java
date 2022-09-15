package ru.training.at.hw4.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DifferentElementsPage extends AbstractPage {

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
    }

    public boolean checkWater(int number) {
        return listOfCheckboxes.get(number).isSelected();
    }

    public void clickOnWaterCheckbox(int number) {
        listOfCheckboxes.get(number).click();
    }

    public boolean checkWind(int number) {
        return listOfCheckboxes.get(number).isSelected();
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

    public String getSelectedColor() {
        return new Select(dropdown).getFirstSelectedOption().getText();
    }

    public List<WebElement> getListOfLogs() {
        return listOfLogs;
    }
}
