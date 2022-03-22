package com.pastebin.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PastebinComHome {
    private WebDriver webDriver;

    @FindBy(id = "postform-text")
    private WebElement code;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpirationContainer;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement pasteExpirationIn10minutes;

    @FindBy(className = "toggle__control")
    private WebElement syntaxHighlightingBtn;

    @FindBy(xpath = "//*[@class=\"select2-selection select2-selection--single\"]/*[@id=\"select2-postform-format-container\"]")
    private WebElement syntaxHighlightingContainer;

    @FindBy(xpath = "//li[text()='Bash']")
    private WebElement syntaxHighlightingBash;

    @FindBy(id = "postform-name")
    private WebElement pasteName;

    @FindBy(xpath = "//*[@id=\"w0\"]/div[5]/div[1]/div[8]/button")
    private WebElement createNewPasteBtn;

    public PastebinComHome(WebDriver webDriver) {
        this.webDriver = webDriver;
        //PageFactory.initElements(webDriver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver,10),this);
    }

    public PastebinComHome setPasteFields(String codeText, String pasteNameText) {
        code.sendKeys(codeText);
        setSyntaxHighlighting();
        setPasteExpiration();
        setTextInPasteName(pasteNameText);
        return this;
    }

    private PastebinComHome setPasteExpiration() {
        pasteExpirationContainer.click();
        pasteExpirationIn10minutes.click();
        return this;
    }

    private PastebinComHome setSyntaxHighlighting() {
        syntaxHighlightingContainer.click();
        syntaxHighlightingBash.click();
        syntaxHighlightingBtn.click();
        return this;
    }

    private PastebinComHome setTextInPasteName(String text) {
        pasteName.sendKeys(text);
        return this;
    }

    public PastebinComPaste createNewPaste(String codeText, String pasteNameText) {
        setPasteFields(codeText, pasteNameText);
        createNewPasteBtn.click();
        return new PastebinComPaste(webDriver);
    }

}
