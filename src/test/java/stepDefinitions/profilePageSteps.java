package stepDefinitions;

import io.cucumber.java.en.Then;
import util.DriverFactory;

public class profilePageSteps {

    pages.profilePage profilePage = new pages.profilePage(DriverFactory.getDriver());

    @Then("User should see {string} text in {string} element in profile page")
    public void shouldSeeTextInElement(String text, String elementName) {
        profilePage.checkElementText(text,elementName);
    }

}
