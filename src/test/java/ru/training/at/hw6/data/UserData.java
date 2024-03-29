package ru.training.at.hw6.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class UserData {
    private static final String CONFIG_FILENAME = "src/test/resources/user.properties";

    public static Map<String, String> getConfigData() {
        Map<String, String> configData = new HashMap<>();
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(CONFIG_FILENAME));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            configData.put(key, String.valueOf(value));
        }
        return configData;
    }

    public static String getUsername() {
        return getConfigData().get("username");
    }

    public static String getPassword() {
        return getConfigData().get("password");
    }
}
