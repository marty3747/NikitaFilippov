package Steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;

public class BeforeStep {

    @Given("Открываем сайт {string}")
    public void openSite(String arg0) {
        Configuration.timeout = 6000;
        Selenide.open(arg0);
    }

}
