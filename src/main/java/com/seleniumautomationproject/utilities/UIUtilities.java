package com.seleniumautomationproject.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by adityag on 3/11/17.
 */
public class UIUtilities {

    private WebDriver driver;
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

//    public UIUtilities() {
//
//    }
//
//    public UIUtilities(WebDriver driver) {
//        this.driver = driver;
//    }

    public void setWebDriver(WebDriver driver){
        this.webDriver.set(driver);
    }

    public void sendTextToElement(By loc, String text) {
        System.out.print("locator: "+loc);
        waitTillVisibilityOfElement(loc);
        System.out.print("element is present...");
        System.out.print("webdriver: "+webDriver.get());
        if(webDriver.get() != null) {
            webDriver.get().findElement(loc).sendKeys(text);
            System.out.print("sent keys//...");
        }else {
            System.out.println("Driver is null"+webDriver.get());
        }
    }

    public void submitRequest(By loc) {
//        waitTillVisibilityOfElement(loc);

        webDriver.get().findElement(loc).click();
    }

    public String getTitleOfPage() {
        System.out.println("Title of the requested page is: "+webDriver.get().getTitle());
        return webDriver.get().getTitle();
    }

    public void waitTillVisibilityOfElement(By loc){
//        driver.toString();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver.get(),10);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(loc));

    }

    public boolean isElementVisible(By loc){
        return webDriver.get().findElement(loc).isDisplayed();
    }

}
