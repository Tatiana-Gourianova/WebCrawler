package com.gourianova.webCrawlerbyTGourianova.runner;

import com.gourianova.webCrawlerbyTGourianova.junit.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class WebCrawlerbyTGourianovaHook {
    @Before
    public void setupDriver() {
        DriverManager.setupDriver();
    }

    @After
    public void quitDriver() {
        DriverManager.quitDriver();
    }
}
