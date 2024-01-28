package com.steam.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriver {
    public static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public static void configure() {
        Configuration.baseUrl = WebDriver.config.getBaseUrl();
        Configuration.browser = WebDriver.config.getBrowserName();
        Configuration.browserVersion = WebDriver.config.getBrowserVersion();
        Configuration.browserSize = WebDriver.config.getBrowserSize();
        Configuration.pageLoadStrategy = "eager";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=en-en");
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        String remoteUrl = WebDriver.config.getRemoteUrl();
        if (remoteUrl != null) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = WebDriver.config.getRemoteUrl();
        }

        Configuration.browserCapabilities = capabilities;
    }
}