package steps;

import connector.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage(Hooks.driver);

    @When("Click on login button.")
    public void clickOnLoginButton() {
        loginPage.clickOnLoginButton();
    }

    @Given("From Login Page, Enter username")
    public void fromLoginPageEnterUsername() {
        loginPage.enterUsername();
    }

    @And("Enter Password")
    public void enterPassword() {
        loginPage.enterPassword();
    }
}
