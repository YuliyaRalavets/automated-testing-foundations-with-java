package com.google.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement findElementForClick(By locator){
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement findElement(By locator){
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void sendTextInTextField(By locator, String text){
        findElement(locator).sendKeys(text);
    }

    public void switchToFrameWithNameOrId(String nameOrId){
        driver.switchTo().frame(nameOrId);
    }

    public void switchToFrameWithIndex(int index){
        driver.switchTo().frame(index);
    }

    public String getHandle(){
        return driver.getWindowHandle();
    }

    public void switchToNewTab(String url){
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(url);
    }
}
