package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.DriverFactory;

public class signUpPageSteps {

    pages.signUpPage signUpPage = new pages.signUpPage(DriverFactory.getDriver());

    @Then("User should see {string} text in {string} element in sign-up page")
    public void shouldSeeTextInElement(String text, String elementName) {
        signUpPage.checkElementText(text, elementName);

    }


    @Then("User should see {string} element in sign-up page")
    public void shouldSeeElement(String elementName) {
        signUpPage.checkElement(elementName);
    }

    @When("User fills out the {string} input container with  {string} in sign up page")
    public void fillOutInputContainer(String container, String input) {
        signUpPage.fillOutInputContainer(container, input);
    }

    @When("User checks {string} checkbox in sign-up page")
    public void checkCheckbox(String checkboxName) {
        signUpPage.checkCheckbox(checkboxName);
    }

    @When("User clicks  {string} element in sign-up page")
    public void clickElement(String elementName) {
        signUpPage.clickElement(elementName);
    }
}