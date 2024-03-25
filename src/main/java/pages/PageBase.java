package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PageBase {

    protected WebDriver driver;
    Select select;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnElement(By element) {
        driver.findElement(element).click();
    }
    public void setElementText(By element , String text) {
        driver.findElement(element).sendKeys(text);
    }
    public String getElementText(By element) {
        return driver.findElement(element).getText();
    }
    public void selectFromDropDown (By element , String text) {
        WebElement dropDown = driver.findElement(element);
        select = new Select(dropDown);
        select.selectByValue(text);
    }
    public void reloadPage() {
        driver.navigate().refresh();
    }
    public void clearTextField(By element) {
        driver.findElement(element).clear();
    }
    public void assertElementIsDisplayed(By element) {
        Assert.assertTrue(driver.findElement(element).isDisplayed(),"Element Not Displayed");
    }
    public void assertElementIsDeleted(By element) {
        Assert.assertFalse(driver.findElement(element).isDisplayed(),"Element Displayed");
    }
}
