package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.example.pageobject.blocks.pop_ups.CalendarPopUpBlock;
import org.example.pageobject.blocks.pop_ups.SearchCityPopUpBlock;
import org.example.pageobject.blocks.pop_ups.TravelersPopUpBlock;
import org.example.pageobject.custom_selenium.CustomWebElement;
import org.example.utils.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;

public class MainPage extends BasePage {

    @FindBy(xpath = "//label[contains(text(), \"Leaving from\")]/following-sibling::button")
    private CustomWebElement departureAirportButton;
    @FindBy(xpath = "//label[contains(text(), \"Going to\")]/following-sibling::button")
    private CustomWebElement destinationAirportButton;
    @FindBy(xpath = "//button[@id=\"date_form_field-btn\"]")
    private CustomWebElement calendarButton;
    @FindBy(xpath = "//button[@data-stid=\"open-room-picker\"]")
    private CustomWebElement travelersCounterButton;
    @FindBy(xpath = "//button[@id=\"search_button\"]")
    private CustomWebElement searchButton;

    public void chooseDepartureAirport(String airport) {
        departureAirportButton.click();
        SearchCityPopUpBlock searchCityPopUpBlock = new SearchCityPopUpBlock(By.xpath("//div[@class=\"uitk-sheet-content\"]"));
        searchCityPopUpBlock.chooseCityAirport(airport);
    }

    public void chooseDestinationAirport(String airport) {
        destinationAirportButton.click();
        SearchCityPopUpBlock searchCityPopUpBlock = new SearchCityPopUpBlock(By.xpath("//div[@class=\"uitk-sheet-content\"]"));
        searchCityPopUpBlock.chooseCityAirport(airport);
    }

    public void chooseDates(LocalDate startDate, LocalDate returnDate) {
        calendarButton.click();
        CalendarPopUpBlock calendarPopUpBlock = new CalendarPopUpBlock(By.xpath("//div[@class=\"uitk-date-picker date-picker-menu\"]"));
        calendarPopUpBlock.setDates(startDate, returnDate);
    }

    public void setAdultsAmount(int number) {
        travelersCounterButton.click();
        TravelersPopUpBlock travelersCounterBlock = new TravelersPopUpBlock(By.xpath("//div[@data-stid=\"basic-traveler-selector-menu-container\"]"));
        travelersCounterBlock.setAdultsNumber(number);
    }

    public void search(){
        searchButton.click();
    }

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }
}
