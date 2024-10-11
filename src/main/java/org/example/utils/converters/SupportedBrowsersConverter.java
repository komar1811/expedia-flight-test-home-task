package org.example.utils.converters;

import org.example.factory.browsers.SupportedBrowsers;

public final class SupportedBrowsersConverter {
    public static SupportedBrowsers valueOfWebBrowser(String webBrowser) {
        return switch(webBrowser) {
            case "chrome" -> SupportedBrowsers.CHROME;
            case "firefox" -> SupportedBrowsers.FIREFOX;
            case "edge" -> SupportedBrowsers.EDGE;
            default -> throw new IllegalArgumentException("No appropriate browser found");
        };

    }
}
