package steps;

import connector.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AdminPage;

public class AdminSteps {
    AdminPage adminPage = new AdminPage(Hooks.driver);
    @And("Get the number of records")
    public void getTheNumberOfRecords() {
        adminPage.getNumberOfRecord();
    }

    @When("From Admin page, Click on Add button")
    public void fromAdminPageClickOnAddButton() {
        adminPage.clickOnAddButton();
    }

    @And("Fill all required fields")
    public void fillAllRequiredFields() {
        adminPage.selectRoleFromDropDown()
              .setEmployeeName()
                .selectStatusFromDropDown()
                .enterUserName()
                .enterPassword()
               .enterPassword();
    }

    @And("Click on Save button")
    public void clickOnSaveButton() {
        adminPage.clickOnSaveButton();
    }
    @Then("Verify that number of records increased by one")
    public void verifyThatNumberOfRecordsIncreasedByOne() {
        adminPage.assertThatTheNumberOfRecordIncreasedBy1();
    }

    @When("From User Management Page, Search for Created User")
    public void fromUserManagementPageSearchForCreatedUser() {
        adminPage.enterUserNameInSearchBar()
                .clickOnSearchButton();
    }

    @Then("Verify that the user is displayed")
    public void verifyThatTheUserIsDisplayed() {
        adminPage.assertThatCreatedUserIsDisplayedInTheTable();
    }

    @When("From User Management Page, Delete created user")
    public void fromUserManagementPageDeleteCreatedUser() {
        adminPage.clickOnDeleteButton();
    }

    @Then("Verify that the delete pop is Displayed")
    public void verifyThatTheDeletePopIsDisplayed() {
        adminPage.assertThatTheDeletePopUpIsDisplayed();
    }

    @When("From Delete pop up, Click on Yes Button")
    public void fromDeletePopUpClickOnYesButton() {
        adminPage.clickOnYesDeleteButton()
                .reloadPage();
    }

    @Then("Verify that the number of Users decreased by one")
    public void verifyThatTheNumberOfUsersDecreasedByOne() {
        adminPage.assertThatTheNumberOfRecordDecreasedByOne();
    }
}
