package tests;

import org.testng.annotations.Test;
import pages.ToolsQADragNDropPage;

/**
 * Created by adityag on 4/28/2017.
 */
public class ToolsQADragNDropPageTest extends BasePageTest {

    @Test
    public void verifyDragNDropTest(){
        ToolsQADragNDropPage tools = new ToolsQADragNDropPage();
        tools.performDropAndDragElement();
        tools.printAttributeText();

    }
}
