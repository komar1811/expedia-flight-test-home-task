package org.example.services;

import lombok.SneakyThrows;
import org.example.pageobject.pages.SearchedPage;
import org.example.utils.MyLogger;
import org.example.utils.SoftAssertion;
import org.example.utils.Wait;

import java.time.LocalDate;

import static org.hamcrest.Matchers.*;

public class SearchedPageService extends BaseService {

    private SearchedPage searchedPage = new SearchedPage(webDriver);

     public SearchedPageService filterResults(){
         MyLogger.logger.info("User clicks on a nonstop filter button");
         searchedPage.filterCards();
         return this;
     }

    @SneakyThrows
    public SearchedPageService verifyDepartureFlightResults(String departmentAirport, String destinationAirport, LocalDate departureDate, LocalDate returnDate, String flightMode) {
        Wait.forAjax();
        SoftAssertion.assertThat("Check if any result for Departure Flight is found", () -> searchedPage.getFirstSearchedCard().isDisplayed(), is(true));
        SoftAssertion.assertThat("Check if from airport for Departure Flight is appropriate", () -> searchedPage.getFirstSearchedCard().getDestinationAirportInfo(), containsStringIgnoringCase(destinationAirport));
        SoftAssertion.assertThat("Check if to airport for Departure Flight is appropriate", () -> searchedPage.getFirstSearchedCard().getDepartmentAirportInfo(), containsStringIgnoringCase(departmentAirport));
        String departureDateTime = departureDate.getMonth().toString().charAt(0) + departureDate.getMonth().toString().substring(1).toLowerCase() + " " + departureDate.getDayOfMonth();
        String returnDateTime = returnDate.getMonth().toString().charAt(0) + returnDate.getMonth().toString().substring(1).toLowerCase() + " " + returnDate.getDayOfMonth();
        SoftAssertion.assertThat("Check if from date for Departure Flight is appropriate", () -> searchedPage.getSelectedDate(), containsStringIgnoringCase(departureDateTime));
        SoftAssertion.assertThat("Check if to date for Departure Flight is appropriate", () -> searchedPage.getSelectedDate(), containsStringIgnoringCase(returnDateTime));
        SoftAssertion.assertThat("Check if flight for Departure Flight is nonstop", () -> searchedPage.getFirstSearchedCard().getJourneyDurationInfo(), containsStringIgnoringCase(flightMode));
        return this;
    }

    @SneakyThrows
    public SearchedPageService verifyReturnFlightResults(String departmentAirport, String destinationAirport, String flightMode) {
        Wait.forAjax();
        SoftAssertion.assertThat("Check if any result for Return Flight is found", () -> searchedPage.getFirstSearchedCard().isDisplayed(), is(true));
        SoftAssertion.assertThat("Check if from airport for Return Flight is appropriate", () -> searchedPage.getFirstSearchedCard().getDestinationAirportInfo(), containsStringIgnoringCase(destinationAirport));
        SoftAssertion.assertThat("Check if to airport for Return Flight is appropriate", () -> searchedPage.getFirstSearchedCard().getDepartmentAirportInfo(), containsStringIgnoringCase(departmentAirport));
        SoftAssertion.assertThat("Check if flight for Return Flight is nonstop", () -> searchedPage.getFirstSearchedCard().getJourneyDurationInfo(), containsStringIgnoringCase(flightMode));
        return this;
    }

    public SearchedPageService selectDepartureFlight() {
         MyLogger.logger.info("User clicks on a first flight offer result");
        searchedPage.selectFirstFlightCard();
        MyLogger.logger.info("User chooses fare");
        searchedPage.chooseFirstFare();
        return this;
    }

    public FlightDetailsPageService selectReturnFlight() {
         MyLogger.logger.info("User clicks on a first flight offer result");
        searchedPage.selectFirstFlightCard();
        MyLogger.logger.info("User chooses fare");
        searchedPage.chooseFirstFare();
        MyLogger.logger.info("User cancels recommendation offered");
        searchedPage.cancelRecommendation();
        MyLogger.logger.info("User goes to another tab");
        switchToTheSecondTab();
        return new FlightDetailsPageService();
    }

}
