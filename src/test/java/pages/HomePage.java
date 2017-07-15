package pages;

import com.seleniumautomationproject.basepage.BasePage;
import locators.HomePageLocators;

/**
 * Created by adityag on 4/7/2017.
 */
public class HomePage extends BasePage {

    public void logoutFromApplication() {
        hoverOverElement(HomePageLocators.MY_NAUKRI_LOGO, HomePageLocators.LOGOUT_LINK);
    }
}
