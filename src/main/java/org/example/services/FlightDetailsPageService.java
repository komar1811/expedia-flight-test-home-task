package org.example.services;

import lombok.SneakyThrows;
import org.example.pageobject.pages.FlightDetailsPage;
import org.example.utils.SoftAssertion;
import org.example.utils.Wait;

import java.time.LocalDate;

import static org.hamcrest.Matchers.*;

public class FlightDetailsPageService extends BaseService{

    private FlightDetailsPage flightDetailsPage = new FlightDetailsPage(webDriver);

    @SneakyThrows
    public FlightDetailsPageService verifyFlightDetails(String originCity, String destinationCity, String originAirport, String destinationAirport, LocalDate departureDate, LocalDate destinationDate){
        Wait.forAjax();
        String departureDateTime = departureDate.getMonth().toString().charAt(0) + departureDate.getMonth().toString().substring(1,2).toLowerCase() + " " + departureDate.getDayOfMonth();

        SoftAssertion.assertThat("Check if origin city at Departure Flight Details Page is appropriate", ()-> flightDetailsPage.getJourneyCard(0).getDepartmentCityInfo(), containsStringIgnoringCase(originCity));
        SoftAssertion.assertThat("Check if destination city at Departure Flight Details Page is appropriate", ()-> flightDetailsPage.getJourneyCard(0).getDestinationCityInfo(), containsStringIgnoringCase(destinationCity));
        SoftAssertion.assertThat("Check if origin airport at Departure Flight Details Page is appropriate", ()-> flightDetailsPage.getJourneyCard(0).getDepartureAirport(), containsStringIgnoringCase(originAirport));
        SoftAssertion.assertThat("Check if destination airport at Departure Flight Details Page is appropriate", ()-> flightDetailsPage.getJourneyCard(0).getArrivalAirport(), containsStringIgnoringCase(destinationAirport));
        SoftAssertion.assertThat("Check if date at Departure Flight Details Page is appropriate", ()-> flightDetailsPage.getJourneyCard(0).getDateTimeInfo(), containsString(departureDateTime));

        String destinationDateTime = destinationDate.getMonth().toString().charAt(0) + destinationDate.getMonth().toString().substring(1,2).toLowerCase() + " " + destinationDate.getDayOfMonth();

        SoftAssertion.assertThat("Check if origin city at Destination Flight Details Page is appropriate", ()-> flightDetailsPage.getJourneyCard(0).getDepartmentCityInfo(), containsStringIgnoringCase(destinationCity));
        SoftAssertion.assertThat("Check if destination city at Destination Flight Details Page is appropriate", ()-> flightDetailsPage.getJourneyCard(0).getDestinationCityInfo(), containsStringIgnoringCase(originCity));
        SoftAssertion.assertThat("Check if origin airport at Destination Flight Details Page is appropriate", ()-> flightDetailsPage.getJourneyCard(0).getDepartureAirport(), containsStringIgnoringCase(originAirport));
        SoftAssertion.assertThat("Check if destination airport at Destination Flight Details Page is appropriate", ()-> flightDetailsPage.getJourneyCard(0).getArrivalAirport(), containsStringIgnoringCase(destinationAirport));
        SoftAssertion.assertThat("Check if date at Destination Flight Details Page is appropriate", ()-> flightDetailsPage.getJourneyCard(0).getDateTimeInfo(), containsString(destinationDateTime));

        return this;
    }
}
