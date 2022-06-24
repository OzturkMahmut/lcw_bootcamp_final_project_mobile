package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.DriverFactory;

public class loginPageSteps {

    pages.loginPage loginPage = new pages.loginPage(DriverFactory.getDriver());




    @Then("User should see {string} text in {string} element in login page")
    public void shouldSeeTextInElement(String text, String elementName) {
        loginPage.checkElementText(text,elementName);

    }

    @When("User clicks {string} element in login page")
    public void clickElement(String elementName) {
        loginPage.clickElement(elementName);
    }


    @Then("User should see {string} element in login page")
    public void userShouldSeeElementInLoginPage(String elementName) {
        loginPage.checkElement(elementName);

    }



}
