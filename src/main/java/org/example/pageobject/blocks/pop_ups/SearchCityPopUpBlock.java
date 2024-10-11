package org.example.pageobject.blocks.pop_ups;

import lombok.SneakyThrows;
import org.example.pageobject.blocks.BaseBlock;
import org.example.pageobject.custom_selenium.CustomWebElement;
import org.example.utils.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchCityPopUpBlock extends BaseBlock {

    @FindBy(xpath = ".//div[@id=\"search-location-input-field\"]//input")
    CustomWebElement searchCityInput;
    @FindBy(xpath = ".//ul[@class=\"uitk-action-list\"]/div[1]//button//following-sibling::div//span[not(starts-with(text(), \"Search\"))]//ancestor::strong//ancestor::div[4]/button")
    CustomWebElement searchedAirport;


    public SearchCityPopUpBlock(By locator) {
        super(locator);
    }

    public SearchCityPopUpBlock(WebElement webElement) {
        super(webElement);
    }

    public SearchCityPopUpBlock(WebElement webElement, String blockName) {
        super(webElement, blockName);
    }

    @SneakyThrows
    public void chooseCityAirport(String airport) {
        searchCityInput.sendKeys(airport);
        Wait.forMillis(2000);
        searchedAirport.click();
    }
}
