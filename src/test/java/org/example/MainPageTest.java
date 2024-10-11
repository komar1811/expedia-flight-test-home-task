package org.example;

import org.example.services.MainPageService;
import org.example.utils.SoftAssertion;
import org.example.utils.properties.PropertiesReader;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class MainPageTest extends BaseTest {

    @Test
    public void test() {
        MainPageService mainPageService = new MainPageService();

        mainPageService
                .searchFlights(
                        PropertiesReader.readProperty("origin-city-airport"),
                        PropertiesReader.readProperty("destination-city-airport"),
                        LocalDate.now().plusDays(PropertiesReader.readNumberProperty("days-after-now-departure")),
                        LocalDate.now().plusDays(PropertiesReader.readNumberProperty("days-after-now-return")),
                        PropertiesReader.readNumberProperty("adult-travelers-number"))

                .verifyFlightDatesResults(LocalDate.now().plusDays(PropertiesReader.readNumberProperty("days-after-now-departure")),
                        LocalDate.now().plusDays(PropertiesReader.readNumberProperty("days-after-now-return")))

                .filterResults()
                .verifyDepartureFlightResults(PropertiesReader.readProperty("origin-airport"),
                        PropertiesReader.readProperty("destination-airport"),
                        PropertiesReader.readProperty("filter"))
                .selectDepartureFlight()

                .filterResults()
                .verifyReturnFlightResults(PropertiesReader.readProperty("origin-airport"),
                        PropertiesReader.readProperty("destination-airport"),
                        PropertiesReader.readProperty("filter"))
                .selectReturnFlight()

                .verifyDepartureFlightDetails(PropertiesReader.readProperty("origin-city"),
                        PropertiesReader.readProperty("destination-city"),
                        PropertiesReader.readProperty("origin-airport"),
                        PropertiesReader.readProperty("destination-airport"),
                        LocalDate.now().plusDays(PropertiesReader.readNumberProperty("days-after-now-departure")),
                        LocalDate.now().plusDays(PropertiesReader.readNumberProperty("days-after-now-return")))
                .verifyDestinationFlightDetails(PropertiesReader.readProperty("destination-city"),
                        PropertiesReader.readProperty("origin-city"),
                        PropertiesReader.readProperty("destination-airport"),
                        PropertiesReader.readProperty("origin-airport"),
                        LocalDate.now().plusDays(PropertiesReader.readNumberProperty("days-after-now-departure")),
                        LocalDate.now().plusDays(PropertiesReader.readNumberProperty("days-after-now-return")));

        SoftAssertion.assertAll();
    }
}
