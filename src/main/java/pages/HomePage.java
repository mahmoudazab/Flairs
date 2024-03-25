package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class HomePage extends PageBase{
    private final By pageTitle = By.cssSelector(".oxd-topbar-header-title");
    private final By adminButton = By.xpath("(//a[@class='oxd-main-menu-item'])[1]");
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void clickOnAdminButton() {
        clickOnElement(adminButton);
    }

    public void assertThatDashboardPageIsDisplayed() {
        assertElementIsDisplayed(pageTitle);
    }

}
