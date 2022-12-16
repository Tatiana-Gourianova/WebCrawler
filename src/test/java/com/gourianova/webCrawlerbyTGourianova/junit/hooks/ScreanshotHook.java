package com.gourianova.webCrawlerbyTGourianova.junit.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class ScreanshotHook {
    public static final String PNG_FIL = "image/png";

    @After
    public void taskScreanshot(Scenario scenario) {
  /*   scenario.log(DriverManager.getDriver().getCurrentUrl());
        byte[] screanshot = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    scenario.attach(screanshot, PNG_FIL, scenario.getName());
    */
    }
}