package pages;

import com.seleniumautomationproject.basepage.BasePage;
import locators.HomePageLocators;
import locators.LoginPageLocators;

/**
 * Created by adityag on 4/2/2017.
 */
public class LoginPage extends BasePage {

    public void loginIntoApplication(String userName, String password) {
        if (userName == null || userName.equals("")) {
            System.out.println("Invalid Username. Please provide the correct username" + userName + ".");
        }
        if (password == null || password.equals("")) {
            System.out.println("Invalid password. Please provide the correct password" + password + ".");
        }
//        waitTillVisibilityOfElement((LoginPageLocators.SUBMIT_BUTTON));
//        if (isElementVisible(LoginPageLocators.USERNAME_TEXTBOX)) {
        sendTextToElement(LoginPageLocators.USERNAME_TEXTBOX, userName);

        sendTextToElement(LoginPageLocators.PASSWORD_TEXTBOX, password);
        submitRequest(LoginPageLocators.SUBMIT_BUTTON);
        waitTillVisibilityOfElement(HomePageLocators.ORANGEBUZZ);
//        }
    }
}
