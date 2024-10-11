package org.example.utils;

import lombok.SneakyThrows;
import org.example.factory.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Wait {

    private static final int defaultWaitForElement = 10;

    public static WebElement forPresent(WebElement element){
        return new WebDriverWait(WebDriverFactory.getWebDriver(), ofSeconds(defaultWaitForElement)).until(visibilityOf(element));
    }

    public static void forAjax(){
        Wait.forMillis(4000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverFactory.getWebDriver();
        MyLogger.logger.info("Waits for AJAX");
        for(int i = 0; i < 50; i++){
            Boolean o = (Boolean) js.executeScript("return document.readyState == 'complete'");
            if(o) break;
            forMillis(200);
        }
    }


    @SneakyThrows
    public static void forMillis(int millis){
        Thread.sleep(millis);
    }

}
