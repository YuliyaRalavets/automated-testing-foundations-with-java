package com.google.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YoupMailAddressPage extends BasePage {

    private By addressTextform = By.id("egen");
    private By checkMailBtn = By.xpath("//*[text()='Проверить почту']");

    public YoupMailAddressPage(WebDriver driver) {
        super(driver);
    }

    public String getAddressText() {
        return findElementForClick(addressTextform).getText();
    }

    public String getChildHandle() {
        return getHandle();
    }

    public YoupMailAddressPageWithMail getMailPage() {
        findElementForClick(checkMailBtn).click();
        return new YoupMailAddressPageWithMail(driver);
    }
}
