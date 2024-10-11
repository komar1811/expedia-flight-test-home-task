package org.example.pageobject;

import org.example.pageobject.custom_selenium.MyPageFactory;
import org.openqa.selenium.WebDriver;

public class BasePage {


    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        MyPageFactory.initElements(webDriver, this);
    }

}
