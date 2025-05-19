package web.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class WebDriverConfig {

    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "true"));
        // Set Chrome preferences
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false); // Disable credential service
        prefs.put("profile.password_manager_enabled", false); // Disable password manager
        prefs.put("safebrowsing.enabled", false); // Disable Safe Browsing (to avoid "Change your password" popup)

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        if (isHeadless) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-popup-blocking"); // help JS alerts show or behave correctly.
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito"); // Optional: start in incognito

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "true"));

        FirefoxOptions options = new FirefoxOptions();
        if (isHeadless) {
            options.addArguments("--headless"); // headless mode
        }
        options.addArguments("-private");

        // To disable some features, use preferences:
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("signon.rememberSignons", false);
        profile.setPreference("credentials_enable_service", false);
        profile.setPreference("dom.webnotifications.enabled", false);
        profile.setPreference("browser.safebrowsing.enabled", false);

        options.setProfile(profile);

        WebDriver driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public static WebDriver initEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "true"));
        EdgeOptions options = new EdgeOptions();
        if (isHeadless) {
            options.addArguments("--headless=new");
        }

        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-notifications");
        options.addArguments("--inprivate"); // Edge's incognito mode

        WebDriver driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
