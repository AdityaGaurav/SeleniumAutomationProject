package tests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

/**
 * Created by adityag on 4/2/2017.
 */
public class LoginPageTest extends BasePageTest {

    final static Logger logger = LogManager.getLogger(LoginPageTest.class);

    @Test
    public void verifyLoginPage() {
        String homepageUrlElement = "homepage";
        String logoutUrlElement = "looogout";
        boolean status = false;
        LoginPage loginPage = new LoginPage();
        logger.info("LoginPage object created");
        loginPage.loginIntoApplication("aditya.smit@gmail.com", "@Aditya9389@");
        System.out.println("Title of Home Page" + getTitleOfPage());
        if (getCurrentUrl().toLowerCase().contains(homepageUrlElement)) {
            status = true;
        }
//        Assert.assertTrue(status, "Login failed.");
        HomePage homePage = new HomePage();
        homePage.logoutFromApplication();
        if (getCurrentUrl().toLowerCase().contains(logoutUrlElement)) {
            status = true;
        }
        Assert.assertTrue(status, "Logout failed.");
    }
}
