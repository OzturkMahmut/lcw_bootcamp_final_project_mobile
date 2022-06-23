package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.DriverFactory;

public class signUpPageSteps {

    pages.signUpPage signUpPage = new pages.signUpPage(DriverFactory.getDriver());

    @Then("User should see {string} text in {string} element in sign-up page")
    public void shouldSeeTextInElement(String text , String elementName) {
        signUpPage.checkElementText(text,elementName);

    }


    @Then("User should see {string} element in sign-up page")
    public void shouldSeeElement(String elementName) {
        signUpPage.checkElement(elementName);
    }
}
