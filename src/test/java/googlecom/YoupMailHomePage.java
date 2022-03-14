package googlecom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YoupMailHomePage {
    private WebDriver webDriver;

    @FindBy(xpath = "/html/body/div/div[2]/header/nav/div[2]/a[4]")
    WebElement generateRandomAddressField;

    public YoupMailHomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public YupMailAddressPage generateRandomAddress() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(generateRandomAddressField)).click();
        return new YupMailAddressPage(webDriver);
    }
}
