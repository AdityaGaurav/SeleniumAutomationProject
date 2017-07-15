package com.seleniumautomationproject.drivers;

import com.seleniumautomationproject.utilities.PropertiesFileOperator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by adityag on 3/12/17.
 */
final class LocalWebDriver implements WebDriverFactory {

    final static Logger lOGGER = LogManager.getLogger(LocalWebDriver.class);

    private WebDriver driver;
    private final String userDirectoryPath = new File(System.getProperty("user.dir")).getAbsolutePath();
    private String seperator = File.separator;
    private final String macWebDriverPath = userDirectoryPath + seperator + "src" + seperator + "main" + seperator + "resources" + seperator + "macWebDrivers" + seperator;
    private final String windowsWebDriverPath = userDirectoryPath + seperator + "src" + seperator + "main" + seperator + "resources" + seperator + "WindowsWebDrivers" + seperator;
    private final String osName = System.getProperty("os.name");
    private String firefoxBinaryPath;
    private String chormeBinaryPath;

    public WebDriver getWebDriver() {
        return this.setWebDriver();
    }


    private WebDriver setWebDriver() {
        String browserName = PropertiesFileOperator.getBrowserName();
        System.out.println("BrowserName:: " + browserName);
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
        if (osName.toLowerCase().contains("mac")) {
            firefoxBinaryPath = macWebDriverPath + seperator + "geckodriver";
        } else if (osName.toLowerCase().contains("window")) {
            System.out.println("=========browser=========");
            lOGGER.info("=========browser=========");
            firefoxBinaryPath = windowsWebDriverPath + seperator + "geckodriver.exe";
            lOGGER.info("=========GeckoDriver Has been initialised=========");
            System.out.println("=========browser=========");
        } else {
            System.out.println(osName + " is not list down here.");
        }
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

        if (osName.toLowerCase().contains("mac")) {
            chormeBinaryPath = macWebDriverPath + seperator + "chromedriver";
        } else if (osName.toLowerCase().contains("window")) {
            chormeBinaryPath = windowsWebDriverPath + seperator + "chromedriver.exe";
        } else {
            System.out.println(osName + " is not list down here.");
        }
        System.setProperty("webdriver.chrome.driver", chormeBinaryPath);
//        ChromeOptions options = new ChromeOptions();
////        options.setBinary(chormeBinaryPath);
////        options.addExtensions(new File(chormeBinaryPath));
        //DesiredCapabilities capability = new DesiredCapabilities();
//        driver = new ChromeDriver(options);
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        driver = new ChromeDriver(capability);
        return this.driver;
    }
}
