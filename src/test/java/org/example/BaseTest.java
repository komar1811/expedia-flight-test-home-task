package org.example;


import org.example.factory.WebDriverFactory;
import org.example.utils.properties.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {

    private static final WebDriver webDriver = WebDriverFactory.getWebDriver();

    @BeforeMethod
    protected void openExpedia(){
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get(PropertiesReader.readProperty("baseUrl"));
    }

    @AfterMethod
    protected void closeBrowser(){
        webDriver.manage().deleteAllCookies();
    }

    @AfterTest
    protected void quit(){
        webDriver.quit();
    }

}