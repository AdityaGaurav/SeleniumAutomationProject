package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

/**
 * Created by adityag on 4/2/2017.
 */
public class LoginPageTest extends BasePageTest {

    @Test
    public void verifyLoginPage() {
        boolean status = false;
        LoginPage loginPage = new LoginPage();
        System.out.println("after login page object creation....");
        loginPage.loginIntoApplication("Admin", "admin");
        System.out.println("Title of Home Page" + getTitleOfPage());
        if (getTitleOfPage().toLowerCase().contains("orangehrm")) {
            status = true;
        }
        Assert.assertTrue(status, "Login failed.");
    }
}
