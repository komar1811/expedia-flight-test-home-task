package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.example.pageobject.cards.SelectedJourneyCard;
import org.example.utils.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class FlightDetailsPage extends BasePage {

    private List<SelectedJourneyCard> getSelectedJourneyCards() {
        Wait.forAjax();
        return webDriver.findElements(
                By.xpath("//div[@data-stid=\"selected-journey-card-no-fare\"]"))
                .stream().map(SelectedJourneyCard::new).toList();
    }

    public SelectedJourneyCard getJourneyCard(int index){
        return getSelectedJourneyCards().get(index);
    }

    public FlightDetailsPage(WebDriver webDriver) {
        super(webDriver);
    }
}
