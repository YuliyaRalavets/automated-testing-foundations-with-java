package googlecom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchResultPage {
    private WebDriver webDriver;

    //@FindBy(xpath = "//*[text()='Google Cloud Pricing Calculator']")
    @FindBy(xpath = "//div[@class='gs-title']/*[@data-ctorig='https://cloud.google.com/products/calculator']")
    WebElement searchElement;

    public GoogleSearchResultPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public GoogleCloudCalculatorHomePage getCalculatorHomePage() {
        new WebDriverWait(webDriver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(searchElement)).click();
        return new GoogleCloudCalculatorHomePage(webDriver);
    }
}
