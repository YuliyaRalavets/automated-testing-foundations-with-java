package com.google.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchResultPage extends BasePage {

    private By searchElement = By.xpath("//div[@class='gs-title']/*[@data-ctorig='https://cloud.google.com/products/calculator']");
    private final Logger logger = LogManager.getRootLogger();

    public GoogleSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudCalculatorHomePage getCalculatorHomePage() {
        findElementForClick(searchElement).click();
        logger.info("Go to Calculator home page");
        return new GoogleCloudCalculatorHomePage(driver);
    }
}
