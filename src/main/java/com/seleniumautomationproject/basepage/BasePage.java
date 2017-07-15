package com.seleniumautomationproject.basepage;

import com.seleniumautomationproject.drivers.WebDriverHandler;
import com.seleniumautomationproject.utilities.PropertiesFileOperator;
import com.seleniumautomationproject.utilities.UIUtilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

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

    @BeforeTest
    protected void setConfiguration() {
        try {
//            this.driver = WebDriverHandler.getWebDriverHost();
           final String URL = PropertiesFileOperator.getURLName();
            System.out.println("URL: " + URL);
            if(driver != null) {
                setWebDriver(driver);
                openURL(URL);
//                this.driver.get(URL);
            }else {
                System.out.println("WeDriver is not created.");
            }
//            this.driver.manage().window().maximize();
//            this.driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//
//    @AfterClass
//    protected void tearDown(){
//        if(driver !=null)
//        driver.quit();
//        System.out.println("=====Close the driver=====");
//    }

//    @BeforeMethod
//    protected void beforeMethod(){
//        System.out.println("=======BeforeMethod=====");
//    }



}
