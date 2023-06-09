package com.example.ht_2.config;

public class TestConfig {

    public static String browser;
    public static String DEFAULT_BROWSER = "chrome";
    public static String headless = "0";

    public static void initConfig() {

        browser = System.getProperty("browser") == null ? DEFAULT_BROWSER : System.getProperty("browser");
        headless = System.getProperty("headless") == null ? "0" : System.getProperty("headless");
    }

    public static boolean isHeadless() {
        return headless.contains("1");
    }
}
