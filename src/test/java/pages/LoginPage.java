package pages;

import com.seleniumautomationproject.basepage.BasePage;
import locators.HomePageLocators;
import locators.LoginPageLocators;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tests.LoginPageTest;

/**
 * Created by adityag on 4/2/2017.
 */
public class LoginPage extends BasePage {
    final static Logger logger = LogManager.getLogger("LoginPage");

    public void loginIntoApplication(String userName, String password) {
        if (userName == null || userName.equals("")) {
            System.out.println("Invalid Username. Please provide the correct username" + userName + ".");
            throw new IllegalArgumentException("");
        }
        if (password == null || password.equals("")) {
            System.out.println("Invalid password. Please provide the correct password" + password + ".");
        }
        clickOnElement(LoginPageLocators.LOGIN_LOCK_BUTTON);
        logger.info("Inside loginIntoApplication");
        sendTextToElement(LoginPageLocators.EMAIL_ID, userName);
        logger.info("User name entered");
        sendTextToElement(LoginPageLocators.PASSWORD, password);
        logger.info("Password entered");
        clickOnElement(LoginPageLocators.LOGIN_BUTTON);
        logger.info("Submit button clicked");
        waitTillVisibilityOfElement(HomePageLocators.PROFILE_PIC);

    }
}
