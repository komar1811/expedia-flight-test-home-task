package org.example.pageobject.blocks.pop_ups;

import org.example.pageobject.blocks.BaseBlock;
import org.example.pageobject.custom_selenium.CustomWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecomendationPopUpBlock extends BaseBlock {

    @FindBy(xpath = "//a[@data-test-id=\"forcedChoiceNoThanks\"]")
    CustomWebElement cancelButton;

    public void cancel(){
        cancelButton.click();
    }
    public RecomendationPopUpBlock(By locator) {
        super(locator);
    }

    public RecomendationPopUpBlock(WebElement webElement) {
        super(webElement);
    }

    public RecomendationPopUpBlock(WebElement webElement, String blockName) {
        super(webElement, blockName);
    }
}
