package com.gourianova.webCrawlerbyTGourianova.pages;

import com.gourianova.webCrawlerbyTGourianova.junit.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.String.format;

public class WebCrawlerPage extends BasePage {
   private static final String WEB_CRAWLER_URL = "http://localhost:8080/views/jsp/file_load.jsp";
    private static final String MENU_LINK_PATTERN = "//*[contains(@class,'nav-link') and contains(text(),'%s')]";
    private static final String CHILD_MENU_LINK_PATTERN = "//*[contains(@class,'form-control')]//*[contains(@class,'language')]";

    public void openWebCrawlerWebsite() {
        DriverManager.getDriver().get(WEB_CRAWLER_URL);
    }

    public WebElement menuSection(String linkText) {
        return findElement(By.xpath(format(MENU_LINK_PATTERN, linkText)));
    }

    public List<String> getMenuChildItemTitles() {
        return getTextsFromWebElements(By.xpath(CHILD_MENU_LINK_PATTERN));
    }

    public boolean isPageWithTitleDisplayed(String pageTitle) {
        if (pageTitle.contains("collecting statistics page")) {
            return true;
        } else {
            return false;
        }
    }
}
