package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.DriverFactory;

public class productPageSteps {

    pages.productPage productPage = new pages.productPage(DriverFactory.getDriver());

    @Then("User should see {string} element in product page")
    public void shouldSeeElement(String elementName) {
        productPage.checkElement(elementName);
    }


    @When("User clicks the {string} element in product page")
    public void clickElement(String elementName) {
        productPage.clickElement(elementName);
    }

    @When("User chooses {string} size in product page")
    public void choosesSize(String size) {
        productPage.chooseSize(size);
    }
}
