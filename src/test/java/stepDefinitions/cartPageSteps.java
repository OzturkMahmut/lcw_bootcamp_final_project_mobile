package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.DriverFactory;

public class cartPageSteps {

    pages.cartPage cartPage = new pages.cartPage(DriverFactory.getDriver());


    @Then("User should see {string} element in cart page")
    public void shouldSeeElement(String elementName) {
        cartPage.checkElement(elementName);
    }


    @When("User clicks {string} element in cart page")
    public void clickElement(String elementName) {
        cartPage.clickElement(elementName);
    }

    @Then("User should see {string} text in {string} element in cart page")
    public void shouldSeeTextInElement(String text, String elementName) {
        cartPage.checkElementText(text,elementName);
    }
}
