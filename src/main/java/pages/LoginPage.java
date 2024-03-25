package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.JsonUtility;

public class LoginPage extends PageBase {

    private final By usernameTxtField = By.cssSelector("input.oxd-input[name='username']");
    private final By passwordTxtField = By.cssSelector("input.oxd-input[name='password']");
    private final By loginButton = By.cssSelector(".oxd-button");
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void enterUsername() {
        setElementText(usernameTxtField, JsonUtility.jsonReader("username","LoginCredentials.json"));
    }
    public void enterPassword() {
        setElementText(passwordTxtField,JsonUtility.jsonReader("password","LoginCredentials.json"));
    }
    public void clickOnLoginButton()  {
        clickOnElement(loginButton);
    }
}
