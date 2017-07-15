package pages;

import com.seleniumautomationproject.basepage.BasePage;
import com.seleniumautomationproject.drivers.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adityag on 4/28/2017.
 */
public class AmazonLinkPage extends BasePage {

    public void findWebElements() throws Exception{
        List<WebElement> links;
        links = findElementsOfPage(By.tagName(" "));
        System.out.println("Total availabe links at amazaon page: "+links.size());
        for(int i=0; i< links.size(); i++){
            System.out.println(links.get(i));
        }
    }
}
