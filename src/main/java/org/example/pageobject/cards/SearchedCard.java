package org.example.pageobject.cards;

import org.example.pageobject.blocks.BaseBlock;
import org.example.pageobject.custom_selenium.CustomWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchedCard extends BaseBlock {

    @FindBy(xpath = "//div[@data-test-id=\"arrival-departure\"]")
    private CustomWebElement routeInfo;
    @FindBy(xpath = ".//div[@class=\"uitk-text uitk-type-200 uitk-text-emphasis-theme\"]")
    private CustomWebElement journeyDurationInfo;
    @FindBy(xpath = "//button[starts-with(@stid,\"FLIGHTS_DETAILS_AND_FARES\")]")
    private CustomWebElement cardButton;

    public void selectCard(){
        cardButton.click();
    }

    public String getDepartmentAirportInfo(){
        return routeInfo.getText().split(" - ")[0];
    }

    public String getDestinationAirportInfo(){
        return routeInfo.getText().split(" - ")[1];
    }

    public String getJourneyDurationInfo(){
        return journeyDurationInfo.getText();
    }

    public boolean isDisplayed(){
        return cardButton.isDisplayed();
    }

    public SearchedCard(By locator) {
        super(locator);
    }

    public SearchedCard(WebElement webElement) {
        super(webElement);
    }

    public SearchedCard(WebElement webElement, String blockName) {
        super(webElement, blockName);
    }
}
