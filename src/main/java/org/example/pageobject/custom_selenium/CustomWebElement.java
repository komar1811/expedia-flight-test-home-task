package org.example.pageobject.custom_selenium;

import lombok.ToString;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

@ToString
public class CustomWebElement extends RemoteWebElement {

    private final WebElement wrappedElement;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof CustomWebElement customWebElement) {
            return this.wrappedElement.equals(customWebElement.getWrappedElement());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    public CustomWebElement(WebElement element) {

        this.wrappedElement = element;
    }

    public WebElement getWrappedElement() {
        return wrappedElement;
    }

    @Override
    public void click(){
        wrappedElement.click();
    }

    @Override
    public void submit() {
        wrappedElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend){
        wrappedElement.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        wrappedElement.clear();
    }

    @Override
    public String getTagName() {
        return wrappedElement.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return wrappedElement.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return wrappedElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return wrappedElement.isEnabled();
    }

    @Override
    public String getText() {
        return wrappedElement.getText();
    }

    @Override
    public boolean isDisplayed() {
        try {
            return wrappedElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
