package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.DriverFactory;

public class tutorialPageSteps {

    pages.tutorialPage tutorialPage = new pages.tutorialPage(DriverFactory.getDriver());

    @Given("User opens LcWaikiki App")
    public void userOpensLcWaikikiApp() {
        tutorialPage.isAppOpen();
    }

    @When("User clicks {string} element in tutorial page")
    public void clickElement(String elementName) {
        tutorialPage.clickElement(elementName);
    }

    @When("User should see {string} element in tutorial page")
    public void shouldSeeElement(String elementName) {
        tutorialPage.checkElement(elementName);
    }
}
