package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.DriverFactory;

public class productListPageSteps {

    pages.productListPage productListPage = new pages.productListPage(DriverFactory.getDriver());


    @Then("User should see {string} text in {string} element in productList page")
    public void shouldSeeTextInElement(String text, String elementName) {
        productListPage.checkElementText(text,elementName);
    }

    @When("User clicks {string} element in productList page")
    public void clickElement(String elementName) {
        productListPage.clickElement(elementName);
    }

    @When("User filters {string} of the products by {string} in productList page")
    public void filterProductBy(String filterType, String filterValue) {
        productListPage.filterProductBy(filterType,filterValue);
    }
}
