package com.seleniumautomationproject.drivers;

import com.seleniumautomationproject.utilities.ProjectUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by adityag on 3/12/17.
 */
final class WebDriverType extends LocalDriverFactory {

    private WebDriver driver;
    private final String userDirectoryPath = new File(System.getProperty("user.dir")).getAbsolutePath();
    private String seperator = File.separator;
    private final String macWebDriverPath = userDirectoryPath + seperator + "src" + seperator + "main" + seperator + "resources" + seperator + "macWebDrivers" + seperator;


    @Override
    public WebDriver setWebDriver() {
        String browserName = ProjectUtilities.getBrowserName();
        System.out.println("BrowserName:: " +browserName);
        switch (browserName) {
            case "FIREFOX":
                return setFirefoxWebDriver();
            case "CHROME":
                return setChromeWebDriver();
            default:
                System.out.println("As we didn't get correct request. So by default \"Firefox Driver\" is launching");
                return setFirefoxWebDriver();
        }
    }

    private WebDriver setFirefoxWebDriver() {
        final String firefoxBinaryPath = macWebDriverPath + seperator + "geckodriver";
        System.setProperty("webdriver.gecko.driver", firefoxBinaryPath);
//        FirefoxBinary binary = new FirefoxBinary(new File(firefoxBinaryPath));
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("webdriver.gecko.driver", firefoxBinaryPath);
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        this.driver = new FirefoxDriver(profile);
        return this.driver;
    }

    private WebDriver setChromeWebDriver() {
        String chormeBinaryPath = "/Users/adityag/Projects/ImagineaProject/SeleniumAutomationProject/src/main/resources/macWebDrivers/chromedriver";
        ChromeOptions options = new ChromeOptions();
        options.setBinary(chormeBinaryPath);
        return driver;
    }
}
