package googlecom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YupMailAddressPage {

    private WebDriver webDriver;
    private String childHandle;

    @FindBy(id = "egen")
    WebElement addressTextform;


    @FindBy(xpath = "//*[text()=\"Проверить почту\"]")
    WebElement checkMailBtn;


    public YupMailAddressPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public String getAddressText() {
        return addressTextform.getText();
    }

    public String getChildHandle() {
        return webDriver.getWindowHandle();
    }

    public YupMailAddressPageWithMail getMailPage() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(checkMailBtn)).click();
        return new YupMailAddressPageWithMail(webDriver);
    }


}
