package tests;

import org.testng.annotations.Test;
import pages.AmazonLinkPage;
import test.BaseTest;

/**
 * Created by adityag on 4/28/2017.
 */
public class AmazonLinksPageTest extends BasePageTest {

    @Test
    public void countLinksOnPage()throws Exception{
        AmazonLinkPage amz= new AmazonLinkPage();
        amz.findWebElements();
    }
}
