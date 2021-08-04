package ru.training.at.hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.training.at.hw5.data.TestData;
import ru.training.at.hw5.model.User;
import ru.training.at.hw5.utils.UserManager;

public class HomePage extends AbstractPage{

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openHomePage() {
        webDriver.get(TestData.URL);
        return this;
    }

    public LoginPage login() {
        User user = UserManager.createUser();
        this.userIcon.click();
        this.username.sendKeys(user.getUsername());
        this.password.sendKeys(user.getPassword());
        this.loginButton.click();
        return new LoginPage(webDriver);
    }
}
