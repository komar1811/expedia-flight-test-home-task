package org.example.pageobject.cards;

import org.example.pageobject.blocks.BaseBlock;
import org.example.pageobject.custom_selenium.CustomWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectedJourneyCard extends BaseBlock {

    @FindBy(xpath = ".//div[@class=\"uitk-text truncate uitk-type-300 uitk-text-default-theme\"]")
    private CustomWebElement dateTimeInfo;
    @FindBy(xpath = ".//h2[@class=\"uitk-heading uitk-type-start uitk-heading-5 uitk-layout-grid-item uitk-layout-grid-item-has-column-start\"]")
    private CustomWebElement routeInfo;
    @FindBy(xpath = "//button[@class=\"uitk-link uitk-expando-link uitk-link-align-left uitk-link-layout-default uitk-link-medium\"]")
    private CustomWebElement expandButton;

    public String getDateTimeInfo(){
        return dateTimeInfo.getText().split(" • ")[1].split(", ")[1];
    }

    public String getDepartmentCityInfo(){
        return dateTimeInfo.getText().split(" to ")[0];
    }

    public String getDestinationCityInfo(){
        return dateTimeInfo.getText().split(" to ")[1];
    }

    public void expandCardInfo(){
        expandButton.click();
    }

    public String getDepartureAirport(){
        expandCardInfo();
        return this.getSelf().findElement(By.xpath(".//div[@data-stid=\"departure-coordinate-0\"]//p[@class=\"uitk-subheading uitk-spacing uitk-spacing-margin-blockstart-half uitk-spacing-padding-inlinestart-six\"]"))
                .getText();
    }

    public String getArrivalAirport(){
        expandCardInfo();
        return this.getSelf().findElement(By.xpath(".//div[@data-stid=\"arrival-coordinate-0\"]//p[@class=\"uitk-subheading uitk-spacing uitk-spacing-margin-blockstart-half uitk-spacing-padding-inlinestart-six\"]"))
                .getText();
    }

    public SelectedJourneyCard(By locator) {
        super(locator);
    }

    public SelectedJourneyCard(WebElement webElement) {
        super(webElement);
    }

    public SelectedJourneyCard(WebElement webElement, String blockName) {
        super(webElement, blockName);
    }
}
