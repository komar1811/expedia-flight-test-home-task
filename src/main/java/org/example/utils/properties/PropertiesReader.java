package org.example.utils.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private static final Properties properties = new Properties();

    private PropertiesReader() {
    }

    public static String readProperty(String propertyName) {
        if (properties.isEmpty()) {
            try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/test_config.properties")) {
                properties.load(fileInputStream);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return properties.getProperty(propertyName);
    }

    public static Integer readNumberProperty(String propertyName) {
        if (properties.isEmpty()) {
            try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/test_config.properties")) {
                properties.load(fileInputStream);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(properties.getProperty(propertyName));
    }
}