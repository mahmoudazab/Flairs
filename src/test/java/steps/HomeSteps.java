package steps;

import connector.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class HomeSteps {
    HomePage homePage = new HomePage(Hooks.driver);
    @Then("Verify that user landed to Home Page")
    public void verify_that_user_landed_to_home_page() {
        homePage.assertThatDashboardPageIsDisplayed();
    }

    @When("From Home Page, Click on Admin Button from left side menu")
    public void fromHomePageClickOnAdminButtonFromLeftSideMenu() {
        homePage.clickOnAdminButton();
    }
}
