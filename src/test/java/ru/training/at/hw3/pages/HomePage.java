package ru.training.at.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.training.at.hw3.data.TestData;
import ru.training.at.hw3.projectUtils.CreateUser;
import ru.training.at.hw3.model.User;

public class HomePage extends AbstractPage {

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage openHomePage() {
        webDriver.get(TestData.URL);
        return this;
    }

    public LoginPage login() {
        User user = CreateUser.createUser();
        this.userIcon.click();
        this.username.sendKeys(user.getUsername());
        this.password.sendKeys(user.getPassword());
        this.loginButton.click();
        return new LoginPage(webDriver);
    }
}
