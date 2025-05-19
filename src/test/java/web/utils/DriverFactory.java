package web.utils;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "edge":
                    driver = WebDriverConfig.initEdgeDriver();
                    break;
                case "firefox":
                    driver = WebDriverConfig.initFirefoxDriver();
                    break;
                case "chrome":
                default:
                    driver = WebDriverConfig.initChromeDriver();
                    break;
            }

        }
        return driver;
    }

    public static WebDriver getDriver() {
        String browser = System.getProperty("browser", "firefox");
        return getDriver(browser);
    }


    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
