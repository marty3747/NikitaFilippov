package pages;

import data.TestData;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import projectUtils.CreateUser;

public class HomePage extends AbstractPage {

    @FindBy(id = "loginEmail")
    protected WebElement username;

    @FindBy(id = "loginPassword")
    protected WebElement password;

    @FindBy(id = "authButton")
    protected WebElement authBtn;

    @FindBy(id = "emailFormatError")
    protected WebElement alert;

    public WebElement getAlert() {
        return alert;
    }

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage openHomePage() {
        webDriver.get(TestData.URL);
        return this;
    }

    public LoginPage login() {
        User user = CreateUser.createUser();
        this.username.sendKeys(user.getUsername());
        this.password.sendKeys(user.getPassword());
        this.authBtn.click();
        return new LoginPage(webDriver);
    }

    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getAuthBtn() {
        return authBtn;
    }
}
