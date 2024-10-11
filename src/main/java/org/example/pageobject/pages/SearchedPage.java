package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.example.pageobject.blocks.pop_ups.CalendarPopUpBlock;
import org.example.pageobject.blocks.pop_ups.FareSelectionPopUpBlock;
import org.example.pageobject.blocks.FilterBlock;
import org.example.pageobject.blocks.pop_ups.RecomendationPopUpBlock;
import org.example.pageobject.cards.SearchedCard;
import org.example.pageobject.custom_selenium.CustomWebElement;
import org.example.utils.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.util.List;

public class SearchedPage extends BasePage {

    @FindBy(xpath = "//button[@data-name=\"startDate\"]")
    private CustomWebElement fromDate;
    @FindBy(xpath = "//button[@data-name=\"endDate\"]")
    private CustomWebElement endDate;


    public FilterBlock getFilterBlock(){
        Wait.forAjax();
        return new FilterBlock(webDriver.findElement(By.xpath("//div[@data-test-id=\"filter-container\"]")));
    }

    private List<SearchedCard> getSearchedCards() {
        Wait.forAjax();
        return webDriver.findElements(By.xpath("//div[@class=\"uitk-card-content-section uitk-card-content-section-padded\"]"))
                .stream().map(SearchedCard::new).toList();
    }

    public SearchedCard getFirstSearchedCard(){
        return getSearchedCards().getFirst();
    }

    public void chooseDates(LocalDate startDate, LocalDate returnDate) {
        fromDate.click();
        CalendarPopUpBlock calendarPopUpBlock = new CalendarPopUpBlock(By.xpath("//div[@class=\"uitk-date-picker date-picker-menu\"]"));
        calendarPopUpBlock.setDates(startDate, returnDate);
    }

    public String getStartDate(){
        return fromDate.getText();
    }

    public String getEndDate(){
        return endDate.getText();
    }

    public void filterCards(){
        getFilterBlock().applyNonstopFilter();
    }

    public void cancelRecommendation(){
        RecomendationPopUpBlock recomendationPopUpBlock = new RecomendationPopUpBlock(
                By.xpath("//section[@class=\"uitk-centered-sheet uitk-dialog uitk-dialog-sheet uitk-spacing uitk-spacing-padding-inline-two uitk-spacing-padding-block-two uitk-sheet uitk-centered-sheet-small\"]"));
        recomendationPopUpBlock.cancel();
    }

    public void chooseFirstFare(){
        FareSelectionPopUpBlock fareSelectionPopUpBlock = new FareSelectionPopUpBlock(
                By.xpath("//section[@class=\"uitk-side-sheet uitk-side-sheet-position-trailing uitk-side-sheet-columns-6 uitk-sheet\"]"));
        fareSelectionPopUpBlock.chooseFirstFare();
    }

    public void selectFirstFlightCard() {
        getSearchedCards().getFirst().selectCard();
    }

    public SearchedPage(WebDriver webDriver) {
        super(webDriver);
    }
}
