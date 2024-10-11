package org.example.pageobject.custom_selenium;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.pagefactory.DefaultElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;

public final class CustomElementLocatorFactory implements ElementLocatorFactory {

    public final SearchContext searchContext;

    public CustomElementLocatorFactory(SearchContext searchContext) {
        this.searchContext = searchContext;
    }

    @Override
    public ElementLocator createLocator(Field field) {
        return new DefaultElementLocator(searchContext, field);
    }
}
