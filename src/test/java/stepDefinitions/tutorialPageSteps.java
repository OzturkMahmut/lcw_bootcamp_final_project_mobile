package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.DriverFactory;

public class tutorialPageSteps {

    pages.tutorialPage tutorialPage = new pages.tutorialPage(DriverFactory.getDriver());

    @Given("User opens LcWaikiki App")
    public void userOpensLcWaikikiApp() {
        tutorialPage.isAppOpen();
    }

    @Then("should see TvTutorials")
    public void userShouldSeeTvTutorials() {
        tutorialPage.checkTvTutorialsElement();
    }

    @Then("should see {string} text")
    public void userShouldSeeText(String text) {
        tutorialPage.checkText(text);
    }

    @Then("should see {string} title")
    public void userShouldSeeTitle(String title) {
        tutorialPage.checkTitle(title);
    }

    @Then("should see {string} title description")
    public void userShouldSeeTitleDescription(String titleDesc) {
        tutorialPage.checkTitleDescription(titleDesc);
    }

    @Then("should see {string} button")
    public void userShouldSeeButton() {
        tutorialPage.checkButton();
    }

    @When("drag and drop tutorial")
    public void dragAndDropTutorial() {
        tutorialPage.dragItem();
    }



    @When("User clicks {string} element in tutorial page")
    public void clickElement(String elementName) {
        tutorialPage.clickElement(elementName);
    }
}
