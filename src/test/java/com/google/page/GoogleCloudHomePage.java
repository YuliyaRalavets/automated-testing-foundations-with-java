package com.google.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class GoogleCloudHomePage extends BasePage {

    private By searchBox = By.name("q");
    private final Logger logger = LogManager.getRootLogger();

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudHomePage open(){
        driver.get("https://cloud.google.com/");
        logger.info("Google cloud page opened");
        return this;
    }

    public GoogleSearchResultPage getResultSearchPage() {
        sendTextInTextField(searchBox,"calculator" + Keys.ENTER);
        logger.info("Search for calculator performed");
        return new GoogleSearchResultPage(driver);
    }
}
