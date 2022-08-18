package Steps;

import Config.OSConfiguration;
import Config.ReadPropFile;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SharedDriver {

    private static boolean initialized = false;

    private WebDriver driver;
    private static WebDriverWait wait;

    @Before
    public void setUp() throws Exception {

        if (!initialized) {

            String browser = ReadPropFile.ReadConfig("default.browser");
            String headLess = ReadPropFile.ReadConfig("headless.active");

            if (browser.equalsIgnoreCase("chrome") && headLess.equalsIgnoreCase("true")) {

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--no-sandbox");
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                options.addArguments("window-size=1920x1080");

                if (OSConfiguration.getOS() == OSConfiguration.OS.LINUX) {
                    options.setBinary("/usr/bin/google-chrome");
                } else {
                    options.setBinary("");
                }

                System.setProperty("webdriver.chrome.driver", ReadPropFile.ReadConfig("chrome.driver"));
                driver = new ChromeDriver(options);

            } else if (browser.equalsIgnoreCase("chrome") && headLess.equalsIgnoreCase("false")) {

                System.setProperty("webdriver.chrome.driver", ReadPropFile.ReadConfig("chrome.driver"));
                driver = new ChromeDriver();
                driver.manage().window().maximize();

            }

            initialized = true;
            wait = new WebDriverWait(driver, 60);
        }
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public WebDriver getDriver() {
        return driver;
    }

    @After
    public void afterScenario(Scenario scenario) {
        initialized = false;
        driver.quit();
    }
}
