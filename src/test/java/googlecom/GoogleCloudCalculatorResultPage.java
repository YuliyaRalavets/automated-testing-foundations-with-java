package googlecom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudCalculatorResultPage {
    private WebDriver webDriver;
    private String parentHandle;

    //@FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[4]/div")
    @FindBy(xpath = "//*[@class='md-1-line md-no-proxy ng-scope' and @ng-if='item.items.editHook && item.items.editHook.initialInputs.class']")
    WebElement vmClassField;

    @FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[5]/div[1]")
    WebElement machineTypeField;

    @FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[1]/div")
    WebElement regionField;

    @FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[7]/div[1]")
    WebElement localSSDField;

    @FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[3]/div")
    WebElement commitmentTermField;

    @FindBy(xpath = "//*[@id=\"resultBlock\"]/md-card/md-card-content/div/div/div/h2/b")
    WebElement pricePerMonth;

    @FindBy(id = "email_quote")
    WebElement emailEstimateBtn;

    public GoogleCloudCalculatorResultPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        parentHandle = webDriver.getWindowHandle();
    }

    public String getVMClassFieldText() {
        return vmClassField.getText().replaceAll("VM class: ", "");
    }

    public String getMachineTypeFieldText() {
        return machineTypeField.getText().split("\n")[0].replaceAll("Instance type: ", "");
    }

    public String getRegionFormText() {
        return regionField.getText().replaceAll("Region: ", "");
    }

    public String getLocalSSDFormText() {
        return localSSDField.getText().split("\n")[0].replaceAll("Local SSD: ", "");
    }

    public String getCommitmentTermFormText() {
        return commitmentTermField.getText().replaceAll("Commitment term: ", "");
    }

    public String getPricePerMonth() {
        return pricePerMonth.getText().replaceAll("Total Estimated Cost: USD ", "").replaceAll(" per 1 month", "");
    }

    public YoupMailHomePage getYoupMailHomePage() {
        webDriver.switchTo().newWindow(WindowType.TAB);
        webDriver.get("https://yopmail.com/");
        return new YoupMailHomePage(webDriver);
    }

    public String getParentHandle() {
        return webDriver.getWindowHandle();
    }

    public GoogleCloudCalculatorResultPage sendMail(String mailAddress) {
        webDriver.switchTo().frame(0);
        webDriver.switchTo().frame("myFrame");
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("email_quote"))).click();
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("input_534"))).sendKeys(mailAddress);
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Send Email']"))).click();
        return this;
    }
}
