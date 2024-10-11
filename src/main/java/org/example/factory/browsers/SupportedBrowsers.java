package org.example.factory.browsers;

import org.example.invoker.WebDriverInvoker;
import org.example.invoker.implementations.ChromeDriverInvoker;
import org.example.invoker.implementations.EdgeDriverInvoker;
import org.example.invoker.implementations.FirefoxDriverInvoker;
import org.openqa.selenium.WebDriver;

public enum SupportedBrowsers {
    CHROME (new ChromeDriverInvoker()),
    FIREFOX (new FirefoxDriverInvoker()),
    EDGE (new EdgeDriverInvoker());

    private WebDriverInvoker webDriverInvoker;

    SupportedBrowsers(WebDriverInvoker webDriverInvoker){
        this.webDriverInvoker = webDriverInvoker;
    }

    public WebDriver getWebDriver(){
        return webDriverInvoker.invokeWebDriver();
    }
}