package org.example.pageobject.blocks.pop_ups;

import org.example.pageobject.blocks.BaseBlock;
import org.example.pageobject.custom_selenium.CustomWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TravelersPopUpBlock extends BaseBlock {

    @FindBy(xpath = ".//span[contains(text(), 'Adults')]/ancestor::label/following-sibling::div//input")
    private CustomWebElement adultsCounter;
    @FindBy(xpath = ".//span[contains(text(), 'Adults')]/ancestor::label/following-sibling::div//button[2]")
    private CustomWebElement increaseAdultsButton;
    @FindBy(xpath = ".//span[contains(text(), 'Adults')]/ancestor::label/following-sibling::div//button[1]")
    private CustomWebElement decreaseAdultsButton;
    @FindBy(xpath = ".//button[@id=\"travelers_selector_done_button\"]")
    private CustomWebElement doneButton;

    public TravelersPopUpBlock(By locator) {
        super(locator);
    }

    public TravelersPopUpBlock(WebElement webElement) {
        super(webElement);
    }

    public TravelersPopUpBlock(WebElement webElement, String blockName) {
        super(webElement, blockName);
    }

    public void setAdultsNumber(int number){
        while(!(Integer.parseInt(adultsCounter.getAttribute("value"))==number)){
            increaseAdultsButton.click();
            doneButton.click();
        }
    }
}
