package org.example.pageobject.blocks;

import lombok.Getter;
import org.example.factory.WebDriverFactory;
import org.example.pageobject.custom_selenium.CustomWebElement;
import org.example.pageobject.custom_selenium.MyPageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Optional;

@Getter
public abstract class BaseBlock {
    private final By locator;
    private final Optional<WebElement> self;
    private final String blockName;

    public CustomWebElement getSelf() {
        if (self.get() != null) {
            return new CustomWebElement(self.get());
        }
        return new CustomWebElement(WebDriverFactory.getWebDriver().findElement(locator));
    }

    public BaseBlock(By locator) {
        this.locator = locator;
        this.self = Optional.ofNullable(WebDriverFactory.getWebDriver().findElement(locator));
        MyPageFactory.initElements(this.self.get(), this);
        blockName = null;
    }

    public BaseBlock(WebElement webElement) {
        this.self = Optional.of(webElement);
        this.locator = null;
        this.blockName = null;
        MyPageFactory.initElements(webElement, this);
    }

    public BaseBlock(WebElement webElement, String blockName){
        this.self = Optional.of(webElement);
        this.locator = null;
        this.blockName = blockName;
    }

}


