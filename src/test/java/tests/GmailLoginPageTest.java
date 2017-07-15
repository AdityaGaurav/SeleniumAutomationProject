package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GmailLoginPage;

/**
 * Created by adityag on 7/15/2017.
 */
public class GmailLoginPageTest extends BasePageTest {

    @Test
    public void checkTitleOfPage()throws Exception{
        GmailLoginPage loginPage = new GmailLoginPage();
        String expectedTitle ="Gmail";
        String actualTitle = loginPage.getTitleOfCurrentPage();
        Thread.sleep(6000);
        Assert.assertEquals(actualTitle,expectedTitle,"Title of page is not matching. Expected title: "+expectedTitle);
    }
}
