package org.example.pageobject.blocks.pop_ups;

import org.example.pageobject.blocks.BaseBlock;
import org.example.pageobject.cards.FareCard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FareSelectionPopUpBlock extends BaseBlock {

    private List<FareCard> getFaresCards() {
        return this.getSelf().getWrappedElement().findElements(By.xpath("//div[@class=\"uitk-card-content-section uitk-card-content-section-padded\"]"))
                .stream().map(FareCard::new).toList();
    }

    public void chooseFirstFare(){
        getFaresCards().getFirst().selectFare();
    }

    public FareSelectionPopUpBlock(By locator) {
        super(locator);
    }

    public FareSelectionPopUpBlock(WebElement webElement) {
        super(webElement);
    }

    public FareSelectionPopUpBlock(WebElement webElement, String blockName) {
        super(webElement, blockName);
    }
}
