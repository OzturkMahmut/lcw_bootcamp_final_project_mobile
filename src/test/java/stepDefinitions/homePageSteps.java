package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.DriverFactory;

public class homePageSteps {

    pages.homePage homePage = new pages.homePage(DriverFactory.getDriver());

    @Then("User should see {string} text in {string} element in homepage")
    public void shouldSeeTextInElement(String text, String elementName) {
        homePage.checkElementText(text,elementName);
    }

    @When("User clicks {string} bottom navigation button")
    public void clickBottomNavigationButton(String navBarButtonName) {
        homePage.clickNavBarButton(navBarButtonName);
    }

    @When("User should see {string} bottom navigation button")
    public void shouldSeeBottomNavigationButton(String navBarButtonName) {
        homePage.checkNavBarButton(navBarButtonName);
    }
}
