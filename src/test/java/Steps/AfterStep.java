package Steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;

public class AfterStep {

    @After
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }

    @io.cucumber.java.AfterStep
    public void takeScreenShot() {
        Selenide.screenshot(System.currentTimeMillis() + "step");
    }
}
