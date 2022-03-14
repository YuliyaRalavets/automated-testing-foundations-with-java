package pastebincom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinComPaste {
    WebDriver webDriver;

    @FindBy(xpath = "//*[@class='left']/*[@class='btn -small h_800']")
    WebElement highlightingSyntax;

    @FindBy(className = "textarea")
    WebElement rawPasteData;

    public PastebinComPaste(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public String textFromRawPasteData() {
        new WebDriverWait(webDriver,Duration.ofSeconds(20));
        return new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("textarea"))).getText();
    }

    public String textFromHighlightingSyntax() {
        return new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='left']/*[@class='btn -small h_800']"))).getText();
    }

    public String getTitleFromNewPastePage(){
        new WebDriverWait(webDriver,Duration.ofSeconds(10));
        return webDriver.getTitle().replaceAll(" - Pastebin.com","");
    }
}
