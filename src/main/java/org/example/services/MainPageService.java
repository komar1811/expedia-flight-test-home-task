package org.example.services;

import org.example.pageobject.pages.MainPage;
import org.example.pageobject.pages.SearchedPage;
import org.example.utils.MyLogger;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

public class MainPageService extends BaseService{

    private MainPage mainPage = new MainPage(webDriver);

    public SearchedPageService searchFlights(String departmentCityAirport, String destinationCityAirport, LocalDate departureDate, LocalDate returnDate, Integer numberOfTravelers){
        MyLogger.logger.info("User types departure city and airport");
        mainPage.chooseDepartureAirport(departmentCityAirport);
        MyLogger.logger.info("User types destination city and airport");
        mainPage.chooseDestinationAirport(destinationCityAirport);
        MyLogger.logger.info("User types departure and return dates");
        mainPage.chooseDates(departureDate, returnDate);
        MyLogger.logger.info("User types number of travelers");
        mainPage.setAdultsAmount(numberOfTravelers);
        MyLogger.logger.info("User clicks on a search button");
        mainPage.search();
        return new SearchedPageService();
    }
}
