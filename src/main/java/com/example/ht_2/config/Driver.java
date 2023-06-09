package com.example.ht_2.config;


import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;

public class Driver {

    public static void initDriver() {
        TestConfig.initConfig();

        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.screenshots = false;

        Configuration.headless = TestConfig.isHeadless();

        switch (TestConfig.browser) {
            case "chrome" -> Configuration.browser = Browsers.CHROME;
            case "firefox" -> Configuration.browser = Browsers.FIREFOX;
            default -> Configuration.browser = Browsers.CHROME;
        }
    }

    public static WebDriver getWebDriver() {
        return WebDriverRunner.getWebDriver();
    }

    public static void open(String url) {
        Selenide.open(url);
    }

    public static void close() {
        getWebDriver().quit();
    }

    public static void clearCookies() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

}
