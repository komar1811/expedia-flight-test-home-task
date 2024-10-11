package org.example.pageobject.blocks;

import org.example.pageobject.custom_selenium.CustomWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterBlock extends BaseBlock{

    @FindBy(xpath = ".//input[starts-with(@id,\"NUM_OF_STOPS-0\")]")
    private CustomWebElement nonstopFilterOption;

    public void applyNonstopFilter(){
        nonstopFilterOption.click();
    }


    public FilterBlock(By locator) {
        super(locator);
    }

    public FilterBlock(WebElement webElement) {
        super(webElement);
    }

    public FilterBlock(WebElement webElement, String blockName) {
        super(webElement, blockName);
    }
}
