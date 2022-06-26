package stepDefinitions;

import io.cucumber.java.en.Then;
import util.DriverFactory;

public class checkOutPageSteps {

    pages.checkOutPage checkOutPage = new pages.checkOutPage(DriverFactory.getDriver());

    @Then("User should see {string} element in checkout page")
    public void shouldSeeElement(String elementName) {
        checkOutPage.checkElement(elementName);
    }

}
