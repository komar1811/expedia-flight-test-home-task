package org.example.factory;


import org.example.factory.browsers.SupportedBrowsers;
import org.example.utils.converters.SupportedBrowsersConverter;
import org.example.utils.properties.PropertiesReader;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    private static WebDriver webDriver;

    private static SupportedBrowsers getBrowser() {
        return SupportedBrowsersConverter.valueOfWebBrowser(PropertiesReader.readProperty("browser"));
    }

    public static WebDriver getWebDriver() {
        if(WebDriverFactory.webDriver != null){
            return WebDriverFactory.webDriver;
        } else {
            WebDriverFactory.webDriver = getBrowser().getWebDriver();
            return WebDriverFactory.webDriver;
        }
    }

}