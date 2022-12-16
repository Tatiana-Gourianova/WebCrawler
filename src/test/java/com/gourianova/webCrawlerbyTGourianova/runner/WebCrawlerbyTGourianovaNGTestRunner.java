package com.gourianova.webCrawlerbyTGourianova.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = "pretty",
        //import com.cucumber.junit.driver.DriverManager;  !!!
       /* {"pretty","html",
                "json:CucumberTests.json",
                "junit:CucumberTests.xml"
        },*/

        monochrome = true,
        tags = "@smoke",
        glue = "com.gourianova.webCrawlerbyTGourianova",
        features = "src/test/resources/features")
public class WebCrawlerbyTGourianovaNGTestRunner extends AbstractTestNGCucumberTests {
}
