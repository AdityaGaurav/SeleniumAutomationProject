package com.seleniumautomationproject.basepage;

import com.seleniumautomationproject.drivers.WebDriverHandler;
import com.seleniumautomationproject.utilities.ProjectUtilities;
import com.seleniumautomationproject.utilities.UIUtilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

/**
 * Created by adityag on 3/6/17.
 */
public class BasePage extends UIUtilities {
    private WebDriver driver;


    @BeforeSuite(alwaysRun = true)
    protected void setBrowser() {
        System.out.println("=====BeforeSuite=====");
        this.driver = WebDriverHandler.getWebDriverHost();
        System.out.println(" Browser" + this.driver);
    }

    @BeforeClass
    protected void setConfiguration() {
        try {
//            this.driver = WebDriverHandler.getWebDriverHost();
            String URL = ProjectUtilities.getURLName();
            System.out.println("URL: " + URL);
            setWebDriver(driver);
            this.driver.get(URL);
            this.driver.manage().window().maximize();
            this.driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    protected void tearDown(){
        System.out.println("=====Close the driver=====");
        driver.quit();
    }

    @BeforeMethod
    protected void beforeMethod(){
        System.out.println("=======BeforeMethod=====");
    }



}
