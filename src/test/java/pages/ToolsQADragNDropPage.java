package pages;

import com.seleniumautomationproject.basepage.BasePage;
import locators.ToolsQALocators;

import java.util.ArrayList;

import static locators.ToolsQALocators.DRAGGABLE_Element;
import static locators.ToolsQALocators.GRAG_ELEMENT_1_TO;

/**
 * Created by adityag on 4/28/2017.
 */
public class ToolsQADragNDropPage extends BasePage {

public void performDropAndDragElement(){
    clickOnElement(ToolsQALocators.DRAGGABLE_Element);
    dragNDropElement(ToolsQALocators.GRAG_ELEMENT_1_TO,ToolsQALocators.GRAG_ELEMENT_4_TO );
}

public void printAttributeText(){
    ArrayList<String> attributeValue = new ArrayList<String>();
//    attributeValue.add(getattributeValue(ToolsQALocators.GRAG_ELEMENT_1_TO));
//    attributeValue.add(getattributeValue(ToolsQALocators.GRAG_ELEMENT_2_TO));
//    attributeValue.add(getattributeValue(ToolsQALocators.GRAG_ELEMENT_3_TO));
//    attributeValue.add(getattributeValue(ToolsQALocators.GRAG_ELEMENT_4_TO));
//    attributeValue.add(getattributeValue(ToolsQALocators.GRAG_ELEMENT_5_TO));

    for(int i=0; i <attributeValue.size(); i++){
        System.out.println(attributeValue.get(i));
    }
}
}
