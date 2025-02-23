import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.*;

public class AndersenPageCucumber {

    private AndersenPage andersenPage = new AndersenPage();

    @Given("I navigate to the Andersen website")
    public void iNavigateToTheAndersenWebsite() {
        andersenPage.openAndersenPage();
    }

    @Then("the website should be open")
    public void theWebsiteShouldBeOpen() {
    }

    @Then("I should see the email field")
    public void iShouldSeeTheEmailField() {
        assertTrue(andersenPage.visibilityOfEmail());
    }

    @Then("I should see the password field")
    public void iShouldSeeThePasswordField() {
        assertTrue(andersenPage.visibilityOfPassword());
    }

    @Given("I enter the email {string}")
    public void iEnterTheEmail(String email) {
        andersenPage.setEmail(email);
    }

    @Given("I enter the password {string}")
    public void iEnterThePassword(String password) {
        andersenPage.setPassword(password);
    }

    @Then("I should be signed in successfully")
    public void iShouldBeSignedInSuccessfully() {
    }
}