package com.gourianova.webCrawlerbyTGourianova.pages;

import com.gourianova.webCrawlerbyTGourianova.junit.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.util.stream.Collectors.toList;

public abstract class BasePage {

    public WebElement findElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return DriverManager.getDriver().findElements(by);
    }

    public List<String> getTextsFromWebElements(By by) {
        return findElements(by).stream().map(WebElement::getText).collect(toList());
    }
}
