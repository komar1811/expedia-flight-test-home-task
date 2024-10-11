package org.example.pageobject.cards;

import org.example.pageobject.blocks.BaseBlock;
import org.example.pageobject.custom_selenium.CustomWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FareCard extends BaseBlock {

    @FindBy(xpath = "//button[@data-test-id=\"select-button\"]")
    private CustomWebElement selectButton;

    public void selectFare(){
        selectButton.click();
    }

    public FareCard(By locator) {
        super(locator);
    }

    public FareCard(WebElement webElement) {
        super(webElement);
    }

    public FareCard(WebElement webElement, String blockName) {
        super(webElement, blockName);
    }
}
