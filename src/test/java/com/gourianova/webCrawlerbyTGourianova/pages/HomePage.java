package com.gourianova.webCrawlerbyTGourianova.pages;

import com.gourianova.webCrawlerbyTGourianova.junit.driver.DriverManager;
//import com.cucumber.junit.driver.DriverManager;
import static java.lang.String.format;

public class HomePage extends BasePage {
    private static final String INDEX_PAGE_URL = "http://localhost:8060/";
    private static final String TEXT_PATTERN = "Webcrawler";


    public void the_user_opens_index_page() {
        try {
            DriverManager.getDriver().get(INDEX_PAGE_URL);
        }
        catch (io.cucumber.java.PendingException e) {
            throw new io.cucumber.java.PendingException();
        }
    }

    public boolean isPageWithTitleDisplayed(String pageTitle) {
        if (pageTitle.contains("Webcrawler")) {
            return true;
        } else {
            return false;
        }
    }
}