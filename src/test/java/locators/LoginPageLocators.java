package locators;

import org.openqa.selenium.By;

/**
 * Created by adityag on 4/2/2017.
 */
public class LoginPageLocators {

    public static final By USERNAME_TEXTBOX = By.cssSelector(".textInputContainer #txtUsername");
    public static final By PASSWORD_TEXTBOX = By.cssSelector(".textInputContainer>#txtPassword");
    public static final By SUBMIT_BUTTON = By.cssSelector(".button");

    public static final By NAUKRI_LOGO = By.cssSelector("img[itemprop=\"logo\"]");
    public static final By LOGIN_LOCK_BUTTON = By.cssSelector("a[id=\"login_Layer\"]");
    public static final By REGISTER_WITH_US_BUTTON = By.cssSelector("bifurformurl=\"https://my.naukri.com/account/register/basicdetails\"");
    public static final By UPLOAD_CV = By.cssSelector("input[id=\"input_resumeParser\"]");
    public static final By EMAIL_ID= By.cssSelector("input[id=\"eLogin\"]");
    public static final By PASSWORD = By.cssSelector("[id=\"pLogin\"]");
    public static final By LOGIN_BUTTON =By.cssSelector("button[class=\"blueBtn\"][value=\"Login\"]");
}
