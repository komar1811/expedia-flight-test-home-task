package org.example.utils;

import com.google.common.io.BaseEncoding;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.factory.WebDriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class MyLogger {

    public static final Logger logger = LogManager.getLogger();
    public static final Logger binary_data_logger = LogManager.getLogger("binary_data_logger");

    public static void takeScreenshot(String message){
        byte[] screenshot = ((TakesScreenshot) WebDriverFactory.getWebDriver())
                .getScreenshotAs(OutputType.BYTES);
        binary_data_logger.info("RP_MESSAGE#BASE64#{}#{}",
                BaseEncoding.base64().encode(screenshot), message);
    }

}
