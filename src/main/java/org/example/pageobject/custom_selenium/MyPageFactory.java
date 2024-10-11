package org.example.pageobject.custom_selenium;

import lombok.SneakyThrows;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Constructor;

public class MyPageFactory extends PageFactory {

    public static void initElements(SearchContext searchContext, Object page) {
        initElements(new CustomFieldDecorator(new CustomElementLocatorFactory(searchContext)), page);
    }

    public static <T> T initElements(SearchContext searchContext, Class<T> pageClassToProxy, String blockName) {
        T page = myInstantiatePage(searchContext, pageClassToProxy, blockName);
        initElements(searchContext, page);
        return page;
    }

    @SneakyThrows
    private static <T> T myInstantiatePage(SearchContext searchContext, Class<T> pageClassToProxy, String blockName) {
        try {
            Constructor<T> constructor = pageClassToProxy.getConstructor(WebElement.class, String.class);
            return constructor.newInstance(searchContext, blockName);
        } catch (NoSuchMethodException e) {
            return pageClassToProxy.getDeclaredConstructor().newInstance();
        }
    }
}
