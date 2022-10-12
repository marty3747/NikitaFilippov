package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.regex.Pattern;

public class LoginPage extends AbstractPage {

    @FindBy(id = "dataEmail")
    private WebElement email;

    @FindBy(id = "dataName")
    private WebElement name;

    @FindBy(id = "dataSend")
    private WebElement dataSendBtn;

    @FindBy(id = "emailFormatError")
    private WebElement alert;

    @FindBy(css = "select.uk-form-width-large")
    private WebElement dropdown;

    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> listOfCheckboxes;

    @FindBy(css = "input[type = 'radio']")
    private List<WebElement> listOfRadioButtons;

    @FindBy(xpath = "//tr/td")
    private List<WebElement> listOfLogs;

    @FindBy(xpath = "//div[contains(text(), 'Данные добавлены.')]")
    private WebElement modalDialog;

    @FindBy(xpath = "//button[contains(text(), 'Ok')]")
    private WebElement okBtn;

    public WebElement getOkBtn() {
        return okBtn;
    }

    public WebElement getDataSendBtn() {
        return dataSendBtn;
    }

    public WebElement getModalDialog() {
        return modalDialog;
    }

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectGender(String gender) {
        new Select(dropdown).selectByVisibleText(gender);
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getAuthBtn() {
        return dataSendBtn;
    }

    public WebElement getAlert() {
        return alert;
    }

    public WebElement getDropdown() {
        return dropdown;
    }

    public String getSelectedGender() {
        return new Select(dropdown).getFirstSelectedOption().getText();
    }

    public void clickOptionOnCheckBox(int number) {
        listOfCheckboxes.get(number).click();
    }

    public boolean checkOptionCheckBox(int number) {
        return listOfCheckboxes.get(number).isSelected();
    }

    public void clickOptionRadioButton(int number) {
        listOfRadioButtons.get(number).click();
    }

    public boolean radioButtonCheck(int number) {
        return listOfRadioButtons.get(number).isSelected();
    }

    public List<WebElement> getListOfCheckboxes() {
        return listOfCheckboxes;
    }

    public List<WebElement> getListOfRadioButtons() {
        return listOfRadioButtons;
    }

    public List<WebElement> getListOfLogs() {
        return listOfLogs;
    }

    public void clickDataSendButton() {
        dataSendBtn.click();
    }

}
