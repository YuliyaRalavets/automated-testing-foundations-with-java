package com.google.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleCloudCalculatorResultPage extends BasePage {

    private final Logger logger = LogManager.getRootLogger();

    private By vmClassField = By.xpath("//*[@class='md-1-line md-no-proxy ng-scope' and @ng-if='item.items.editHook && item.items.editHook.initialInputs.class']");
    private By machineTypeField = By.xpath("//*[@class=\"md-list-item-text ng-binding cpc-cart-multiline flex\" and @ng-class=\"item.items.sustainedUse || item.items.isInstanceCommitted ? 'cpc-cart-multiline' : ''\"]");
    private By regionField = By.xpath("//*[@class=\"cartitem ng-scope\"]/md-list-item[@class=\"md-1-line md-no-proxy\"]/div[@class='md-list-item-text ng-binding']");
    private By localSSDField = By.xpath("//*[@class=\"md-list-item-text ng-binding cpc-cart-multiline flex\" and @ng-class=\"item.items.isSsdCommitted ? 'cpc-cart-multiline' : ''\"]");
    private By commitmentTermField = By.xpath("//*[@class=\"md-1-line md-no-proxy ng-scope\" and @ng-if=\"item.items.termText && item.items.termText.length != 0\"]");
    private By pricePerMonth = By.xpath("//h2[@class='md-title']/b[@class='ng-binding']");
    private By emailEstimateBtn = By.id("email_quote");
    private By emailInputField = By.id("input_534");
    private By sendEmailBtn = By.xpath("//button[@aria-label='Send Email']");

    public GoogleCloudCalculatorResultPage(WebDriver driver) {
        super(driver);
    }

    public String getVMClassFieldText() {
        return findElement(vmClassField).getText();
    }

    public String getMachineTypeFieldText() {
        return findElement(machineTypeField).getText();
    }

    public String getRegionFormText() {
        return findElement(regionField).getText();
    }

    public String getLocalSSDFormText() {
        return findElement(localSSDField).getText();
    }

    public String getCommitmentTermFormText() {
        return findElement(commitmentTermField).getText();
    }

    public String getPricePerMonth() {
        return findElement(pricePerMonth).getText();
    }

    public YoupMailHomePage getYoupMailHomePage() {
        switchToNewTab("https://yopmail.com/");
        logger.info("Went to page for generate mail.");
        return new YoupMailHomePage(driver);
    }

    public String getParentHandle() {
        return getHandle();
    }

    public void sendMail(String mailAddress) {
        this.switchToFrames();
        findElementForClick(emailEstimateBtn).click();
        sendTextInTextField(emailInputField, mailAddress);
        findElementForClick(sendEmailBtn).click();
        logger.info("Sent email to generated mailbox email to generated mailbox");
    }

    private void switchToFrames(){
        switchToFrameWithIndex(0);
        switchToFrameWithNameOrId("myFrame");
    }
}
