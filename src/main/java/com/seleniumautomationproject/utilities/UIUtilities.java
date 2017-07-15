package com.seleniumautomationproject.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/**
 * Created by adityag on 3/11/17.
 */
public class UIUtilities {

    //    private WebDriver driver;
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    //    public UIUtilities() {
//
//    }
//
//    public UIUtilities(WebDriver driver) {
//        this.driver = driver;
//    }
    protected void setWebDriver(WebDriver driver) {
        if (driver != null) {
            this.webDriver.set(driver);
        }
    }

    /**
     * Create a named Level with a given integer value and a
     * given localization resource name.
     * <p>
     * @param url  the name of the Level, for example "SEVERE".
     *    localizing the given name. If the resourceBundleName is null
     *    or an empty string, it is ignored.
     * @throws NullPointerException if the name is null
     */
    protected void openURL(String url) {
        if (url != null || url.length() != 0) {
            System.out.println("Given url inside method: "+url);
            webDriver.get().get(url);
            webDriver.get().manage().window().maximize();
            webDriver.get().manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        } else {
            System.out.println("Not A valid URL.");
        }
    }

    protected void sendTextToElement(By loc, String text) {
        if(loc == null){
            throw new RuntimeException("Element not present");
        }
//        System.out.print("locator: " + loc);
        try {
            waitTillVisibilityOfElement(loc);
//            System.out.print("element is present...");
//            System.out.print("webdriver: " + webDriver.get());
            if (webDriver.get() != null) {
                webDriver.get().findElement(loc).sendKeys(text);
//                System.out.print("sent keys//...");
            } else {
                System.out.println("Driver is null" + webDriver.get());
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    protected void clickOnElement(By loc) {
//        waitTillVisibilityOfElement(loc);
        webDriver.get().findElement(loc).click();
    }

    protected String getTitleOfPage() {
        System.out.println("Title of the requested page is: " + webDriver.get().getTitle());

        return webDriver.get().getTitle();
    }

    protected String getCurrentUrl() {
        return webDriver.get().getCurrentUrl();
    }

    protected void hoverOverElement(By parentElement, By childElement) {
        Actions actions = new Actions(webDriver.get());
        try {
            waitTillVisibilityOfElement(parentElement);
            WebElement webElement = webDriver.get().findElement(parentElement);
//            waitTillVisibilityOfElement(childElement);
            WebElement element = webDriver.get().findElement(childElement);
            System.out.print("Hover over element");
            actions.moveToElement(webElement).moveToElement(element).click().build().perform();
            System.out.print("Hover Done");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    protected void waitTillVisibilityOfElement(By loc) {
//        driver.toString();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver.get(), 10);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(loc));
    }

    protected boolean isElementVisible(By loc) {
        return webDriver.get().findElement(loc).isDisplayed();
    }

    protected WebElement findEleMentInPage(By loc) {
        return webDriver.get().findElement(loc);
    }

    protected void dragNDropElement(By to, By from) {
        Actions builder = new Actions(webDriver.get());
        Action dragAndDrop = builder.clickAndHold(findEleMentInPage(from))
                .moveToElement(findEleMentInPage(to))
                .release(findEleMentInPage(to))
                .build();
        dragAndDrop.perform();
    }

    protected String getAttributeValue(By loc) {
        return findEleMentInPage(loc).getText();
    }

    protected List<WebElement> findElementsOfPage(By loc) throws Exception {
        if (loc != null) {
            return webDriver.get().findElements(loc);
        } else {
            throw new Exception(loc + " is not a valid selector");
        }
    }

    protected String titleOfPage(){
        return webDriver.get().getTitle();
    }

    protected void setLogLevel(Level level){
    }
}
