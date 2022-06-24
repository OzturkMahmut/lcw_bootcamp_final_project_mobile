package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.DriverFactory;

public class categoriesPageSteps {

    pages.categoriesPage categoriesPage = new pages.categoriesPage(DriverFactory.getDriver());

    @When("User clicks {string} element in categories page")
    public void clickElement(String elementName) {
        categoriesPage.clickElement(elementName);
    }

    @When("User clicks {string} subcategory in {string} category in categories page")
    public void clickSubcategoryInCategory(String subCategory, String category) {
        categoriesPage.clickElement(category);
        categoriesPage.clickElement(subCategory);
    }

    @Then("User should see {string} text in {string} element in categories page")
    public void shouldSeeTextInElement(String text, String elementName) {
        categoriesPage.checkElementText(text,elementName);
    }


}
