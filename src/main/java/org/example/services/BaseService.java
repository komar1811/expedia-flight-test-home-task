package org.example.services;

import org.example.factory.WebDriverFactory;
import org.example.utils.SoftAssertion;
import org.openqa.selenium.WebDriver;

public class BaseService {

    protected final WebDriver webDriver = WebDriverFactory.getWebDriver();

    protected void switchToTheSecondTab(){
        webDriver.switchTo().window((String) webDriver.getWindowHandles().toArray()[1]);
    }

    protected void refreshPage(){
        webDriver.navigate().refresh();
    }

    protected void returnBack(){
        webDriver.navigate().back();
    }

    protected void goTo(String url){
        webDriver.navigate().to(url);
    }
}
