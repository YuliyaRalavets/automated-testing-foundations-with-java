package com.google.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YoupMailAddressPageWithMail extends BasePage {

    private By totalEstimateMonthlyCostField = By.xpath("//*[@id='mail']/descendant-or-self::h3[2]");
    private By mailCount = By.id("nbmail");
    private final Logger logger = LogManager.getRootLogger();

    public YoupMailAddressPageWithMail(WebDriver driver) {
        super(driver);
    }

    public String getTotalEstimateMonthlyCost() {
        while (findElement(mailCount).getText().equals("0 mail"))
            driver.navigate().refresh();
        switchToFrameWithNameOrId("ifmail");
        logger.info("Check mail in generated mailbox.");
        return findElement(totalEstimateMonthlyCostField).getText();
    }
}
