package com.pastebin.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinComPaste {
    private WebDriver webDriver;

    @FindBy(xpath = "//*[@class='left']/*[@class='btn -small h_800']")
    private WebElement highlightingSyntax;

    @FindBy(className = "textarea")
    private WebElement rawPasteData;

    public PastebinComPaste(WebDriver webDriver) {
        this.webDriver = webDriver;
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until((ExpectedCondition<Boolean>) driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        //PageFactory.initElements(webDriver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 15), this);
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    public String textFromRawPasteData() {
        return rawPasteData
                .getText();
    }

    public String textFromHighlightingSyntax() {
        return highlightingSyntax
                .getText();
    }

    public String getTitleFromNewPastePage() {
        return webDriver
                .getTitle()
                .replaceAll(" - Pastebin.com", "");
    }
}
