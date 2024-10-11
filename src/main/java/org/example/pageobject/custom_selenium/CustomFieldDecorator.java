package org.example.pageobject.custom_selenium;

import org.example.pageobject.blocks.BaseBlock;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.FieldDecorator;
import org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler;
import org.openqa.selenium.support.pagefactory.internal.LocatingElementListHandler;

import java.lang.reflect.*;
import java.util.List;

public class CustomFieldDecorator implements FieldDecorator {

    protected CustomElementLocatorFactory factory;

    public CustomFieldDecorator(CustomElementLocatorFactory factory) {
        this.factory = factory;
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        if (!(WebElement.class.isAssignableFrom(field.getType())
                || isDecoratableList(field)
                || CustomWebElement.class.isAssignableFrom(field.getType())
                || BaseBlock.class.isAssignableFrom(field.getType())
                || field.getName().equals("blockName"))) {
            return null;
        }

        ElementLocator locator = factory.createLocator(field);

        if (BaseBlock.class.isAssignableFrom(field.getType())) {
            return MyPageFactory.initElements(factory.searchContext.findElement(new FindBy.FindByBuilder().buildIt(field.getAnnotation(FindBy.class), field)),field.getType(),field.getName());
        } else if (CustomWebElement.class.isAssignableFrom(field.getType())) {
            return proxyForCustomLocator(loader, locator);
        } else if (WebElement.class.isAssignableFrom(field.getType())) {
            return proxyForLocator(loader, locator);
        } else if (List.class.isAssignableFrom(field.getType())) {
            return proxyForListLocator(loader, locator);
        } else {
            return null;
        }
    }

    protected boolean isDecoratableList(Field field) {
        if (!List.class.isAssignableFrom(field.getType())) {
            return false;
        }

        Type genericType = field.getGenericType();
        if (!(genericType instanceof ParameterizedType)) {
            return false;
        }

        Type listType = ((ParameterizedType) genericType).getActualTypeArguments()[0];

        if (!WebElement.class.equals(listType)) {
            return false;
        }

        return field.getAnnotation(FindBy.class) != null ||
                field.getAnnotation(FindBys.class) != null ||
                field.getAnnotation(FindAll.class) != null;
    }

    protected WebElement proxyForLocator(ClassLoader loader, ElementLocator locator) {
        InvocationHandler handler = new LocatingElementHandler(locator);

        WebElement proxy;
        proxy = (WebElement) Proxy.newProxyInstance(
                loader, new Class[]{WebElement.class, WrapsElement.class, Locatable.class}, handler);
        return proxy;
    }

    protected CustomWebElement proxyForCustomLocator(ClassLoader loader, ElementLocator locator) {
        InvocationHandler handler = new LocatingElementHandler(locator);

        WebElement proxy;
        proxy = (WebElement) Proxy.newProxyInstance(
                loader, new Class[]{WebElement.class, WrapsElement.class, Locatable.class}, handler);
        return new CustomWebElement(proxy);
    }

    @SuppressWarnings("unchecked")
    protected List<CustomWebElement> proxyForListLocator(ClassLoader loader, ElementLocator locator) {
        InvocationHandler handler = new LocatingElementListHandler(locator);

        List<CustomWebElement> proxy;
        proxy = (List<CustomWebElement>) Proxy.newProxyInstance(
                loader, new Class[]{List.class}, handler);

        return proxy;
    }
}
