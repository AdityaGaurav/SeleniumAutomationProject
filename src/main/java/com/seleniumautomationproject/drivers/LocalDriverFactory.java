package com.seleniumautomationproject.drivers;

import com.seleniumautomationproject.utilities.ProjectUtilities;
import org.openqa.selenium.WebDriver;

/**
 * Created by adityag on 3/12/17.
 */
abstract class LocalDriverFactory implements WebDriverFactory {
    private WebDriver driver;


    public abstract WebDriver setWebDriver();

    public WebDriver getWebDriver() {
        return this.setWebDriver();
    }


    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }
}
