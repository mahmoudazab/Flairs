package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.JsonUtility;
import utilities.extractNumber;
public class AdminPage extends PageBase {

    private final By numberOfRecordLabel = By.xpath("(//span[@class='oxd-text oxd-text--span'])[1]");
    private final By addButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    private final By userRoleDropDown = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]");
    private final By adminOption = By.xpath("//div[@role='listbox']//span[text()='Admin']");
    private final By statusDropDown = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[2]");
    private final By statusOption = By.xpath("//div[@role='listbox']//span[text()='Enabled']");
    private final By employeeTextField = By.xpath("//input[@placeholder='Type for hints...']");
    private final By employeeOption = By.xpath("//div[@role='listbox']//span[text()='Odis  Adalwin']");
    private final By userNameTextField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private final By passwordTextField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]");
    private final By saveButton = By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary");
    private final By searchButton = By.cssSelector("button.oxd-button.oxd-button--medium[type='submit']");
    private final By createdUserInTable = By.xpath("(//div[@class='oxd-table-cell oxd-padding-cell'])[2]");
    private final By deleteButton = By.cssSelector(".oxd-icon.bi-trash");
    private final By deletePopUp = By.cssSelector(".oxd-text.oxd-text--p.oxd-text--card-body");
    private final By yesDeleteButton = By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--label-danger.orangehrm-button-margin");
    Faker faker = new Faker();
    String dataFile = "data.json";
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public void getNumberOfRecord() {
        String numberOfRecord = String.valueOf(extractNumber.extractNumber(getElementText(numberOfRecordLabel)));
        JsonUtility.updateJsonField("numberOfCurrentRecord", numberOfRecord, dataFile);
    }

    public AdminPage selectRoleFromDropDown() {
        clickOnElement(userRoleDropDown);
        clickOnElement(adminOption);
        return this;
    }

    public AdminPage selectStatusFromDropDown() {
        clickOnElement(statusDropDown);
        clickOnElement(statusOption);
        return this;

    }

    public AdminPage setEmployeeName() {
        setElementText(employeeTextField, JsonUtility.jsonReader("employeeName", dataFile));
        clickOnElement(employeeOption);

        return this;
    }

    public AdminPage enterUserName() {
        String username = faker.name().fullName();
        setElementText(userNameTextField, username);
        JsonUtility.updateJsonField("username", username, dataFile);
        return this;
    }

    public AdminPage enterUserNameInSearchBar() {
        setElementText(userNameTextField, JsonUtility.jsonReader("username", dataFile));
        return this;
    }

    public AdminPage enterPassword() {
        setElementText(passwordTextField, JsonUtility.jsonReader("password", dataFile));
        return this;
    }

    public void clickOnSearchButton() {
        clickOnElement(searchButton);
    }

    public void clickOnDeleteButton() {
        clickOnElement(deleteButton);
    }

    public void clickOnSaveButton() {
        clickOnElement(saveButton);
    }

    public void clickOnAddButton() {
        clickOnElement(addButton);
    }

    public AdminPage clickOnYesDeleteButton() {
        clickOnElement(yesDeleteButton);
        return this;
    }

    public void assertThatTheNumberOfRecordIncreasedBy1() {
        extractNumber.extractNumber(driver.findElement(numberOfRecordLabel).getText());
        int num = Integer.valueOf(JsonUtility.jsonReader("numberOfCurrentRecord", dataFile));
        num++;
        Assert.assertEquals(extractNumber.extractNumber(driver.findElement(numberOfRecordLabel).getText()), num);
    }

    public void assertThatCreatedUserIsDisplayedInTheTable() {
        Assert.assertEquals(driver.findElement(createdUserInTable).getText()
                , JsonUtility.jsonReader("username", dataFile));
    }

    public void assertThatTheDeletePopUpIsDisplayed() {
        assertElementIsDisplayed(deletePopUp);
    }

    public void assertThatTheNumberOfRecordDecreasedByOne() {
        Assert.assertEquals(String.valueOf(extractNumber.extractNumber(driver.findElement(numberOfRecordLabel).getText()))
                , JsonUtility.jsonReader("numberOfCurrentRecord", dataFile));
    }
}
