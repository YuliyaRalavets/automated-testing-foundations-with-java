package com.google.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YoupMailHomePage extends BasePage {

    private By generateRandomAddressField = By.xpath("//div[@class='flexcx']/a[@href='email-generator']");
    private final Logger logger = LogManager.getRootLogger();

    public YoupMailHomePage(WebDriver driver) {
        super(driver);
    }

    public YoupMailAddressPage generateRandomAddress() {
        findElementForClick(generateRandomAddressField).click();
        logger.info("Generated mailbox.");
        return new YoupMailAddressPage(driver);
    }
}
