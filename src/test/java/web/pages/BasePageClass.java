package web.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.utils.DriverFactory;

import java.time.Duration;

public class BasePageClass {
    protected WebDriver driver = DriverFactory.getDriver();
    private final WebDriverWait wait;

    public BasePageClass() {
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    protected WebElement find(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Method to check visibility of multiple elements
    public boolean verifyElementsAreVisible(By... elements) {
        for (By element : elements) {
            WebElement webElement = find(element);
            if (!webElement.isDisplayed()) {
                throw new AssertionError("Element visible: " + element.toString());
            }
        }
        return true;
    }

    public boolean verifyElementsAreNotVisible(By... elements) {
        boolean allNotVisible = true;

        for (By element : elements) {
            try {
                WebElement webElement = find(element);
                if (webElement.isDisplayed()) {
                    System.out.println("Element is visible: " + element.toString());
                    allNotVisible = false;
                }
            } catch (NoSuchElementException e) {
                // If element is not found, it's considered "not visible" — this is fine
            }
        }

        return allNotVisible;
    }

    public void scrollByPixel(WebDriver driver, int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy({ top: arguments[0], behavior: 'smooth' })", pixels);
    }

    protected void click(By locator) {
        find(locator).click();
    }

    protected String GetText(By locator) {
        return find(locator).getText().trim();
    }

    protected void type(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected void navigateToPage(String url) {
        driver.get(url);
    }
}
