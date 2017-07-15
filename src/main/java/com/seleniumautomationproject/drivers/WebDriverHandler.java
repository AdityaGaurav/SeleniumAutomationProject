package com.seleniumautomationproject.drivers;

import com.seleniumautomationproject.utilities.PropertiesFileOperator;
import org.openqa.selenium.WebDriver;

/**
 * Created by adityag on 3/13/17.
 */
public class WebDriverHandler {
    private static WebDriverFactory webDriverFactory;
    private static WebDriver driver;
//    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    public static WebDriver getWebDriverHost() {
        String host = PropertiesFileOperator.getHostName();
        if (host.contains("localHost")) {
            webDriverFactory = new LocalWebDriver();
            driver = webDriverFactory.getWebDriver();
        } else {

        }
        System.out.println("Driver setup is done.....");
        return driver;
    }
}



