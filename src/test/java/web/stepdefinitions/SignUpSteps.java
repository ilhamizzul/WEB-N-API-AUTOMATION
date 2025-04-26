package web.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.pages.MainPage;
import web.utils.GlobalFunction;

public class SignUpSteps {
    MainPage mainPage = new MainPage();

    @Given("the user is on the main page")
    public void theUserIsOnTheMainPage() {
        mainPage.navigateToMainPage();
        mainPage.verifyPageLoaded();
    }

    @When("the user click sign up")
    public void theUserClickSignUp() {
        mainPage.clickOpenModalSignupButton();
    }

    @And("the user enters {string} username {string} and password {string}")
    public void enterCredentials(String testType, String username, String password) {
        if (testType.equals("invalid")) {
            mainPage.fillUsernameSignupModal(username);
            mainPage.fillPasswordSignupModal(password);
        } else {
            mainPage.fillUsernameSignupModal(new GlobalFunction().GenerateRandomUsername());
            mainPage.fillPasswordSignupModal(password);
        }

    }


    @And("clicks the sign up button")
    public void clicksTheSignUpButton() {
        mainPage.clickSignupButton();
    }

    @Then("the error message {string} should be displayed")
    public void theErrorMessageShouldBeDisplayed(String message) {
        mainPage.verifyAlertMessage(message);
    }

    @Then("sign up modal will be shown")
    public void signUpModalWillBeShown() {
        mainPage.verifySignupModalLoaded();
    }
}
