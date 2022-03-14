package googlecom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudCalculatorHomePage {
    private WebDriver webDriver;

    @FindBy(xpath = "//div[@class = 'tab-holder compute' and @title='Compute Engine']")
    WebElement computeEngine;

    @FindBy(id = "input_80")
    WebElement numberOfInstance;

    @FindBy(id = "select_value_label_72")
    WebElement formOperatingSystem;

    @FindBy(id = "select_option_82")
    WebElement optionOperatingSystem;

    @FindBy(id = "select_value_label_73")
    WebElement machineClassForm;

    @FindBy(id = "select_option_95")
    WebElement machineClassOption;

    @FindBy(id = "select_value_label_75")
    WebElement seriesForm;

    @FindBy(id = "select_option_220")
    WebElement seriesOption;

    @FindBy(id = "select_value_label_76")
    WebElement machineTypeForm;

    @FindBy(id = "select_option_420")
    WebElement machineTypeOption;

    @FindBy(xpath = "//md-checkbox[@class='ng-pristine ng-untouched ng-valid ng-empty' and @aria-label='Add GPUs']")
    WebElement addGPUsBtn;

    @FindBy(id = "select_456")
    WebElement gpuTypeForm;

    @FindBy(id = "select_option_463")
    WebElement gpuTypeOption;

    @FindBy(id = "select_458")
    WebElement numberOfGPUsForm;

    @FindBy(id = "select_option_467")
    WebElement numberOfGPUsOption;

    @FindBy(id = "select_418")
    WebElement localSSDForm;

    @FindBy(id = "select_option_444")

    WebElement localSSDOption;

    @FindBy(id = "select_113")
    WebElement datacenterLocationForm;

    @FindBy(id = "select_option_241")
    WebElement datacenterLocaOption;

    @FindBy(id = "select_120")
    WebElement commitedUsageForm;

    @FindBy(id = "select_option_118")
    WebElement commitedUsageOption;

    @FindBy(xpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple' and @ng-click=\"listingCtrl.addComputeServer(ComputeEngineForm);\"]")
    WebElement addToEstimateBtn;


    public GoogleCloudCalculatorHomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public GoogleCloudCalculatorHomePage setCalculatorForm() {
        computeEngine.click();
        numberOfInstance.sendKeys("4");
        setOperationSystem();
        setMachineClass();
        setSeries();
        setMachineType();
        setAddGPUs();
        setGPUType();
        setNumberOfGPUs();
        setLocalSSD();
        setDatacenterLocation();
        setCommitedUsage();
        return this;
    }

    private void setOperationSystem() {
        formOperatingSystem.click();
        optionOperatingSystem.click();
    }

    private void setMachineClass() {
        machineClassForm.click();
        machineClassOption.click();
    }

    private void setSeries() {
        seriesForm.click();
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(seriesOption)).click();
    }

    private void setMachineType() {
        machineTypeForm.click();
        machineTypeOption.click();
    }

    private void setAddGPUs() {
        if (addGPUsBtn.getAttribute("aria-checked").equals("false"))
            addGPUsBtn.click();
    }

    private void setGPUType() {
        gpuTypeForm.click();
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(gpuTypeOption)).click();
    }

    private void setNumberOfGPUs() {
        numberOfGPUsForm.click();
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(numberOfGPUsOption)).click();
    }

    private void setLocalSSD() {
        localSSDForm.click();
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(localSSDOption)).click();
    }

    private void setDatacenterLocation() {
        datacenterLocationForm.click();
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(datacenterLocaOption)).click();
    }

    private void setCommitedUsage() {
        commitedUsageForm.click();
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(commitedUsageOption)).click();
    }

    public GoogleCloudCalculatorResultPage addToEstimate() {
        webDriver.switchTo().frame(0);
        webDriver.switchTo().frame("myFrame");
        setCalculatorForm();
        addToEstimateBtn.click();
        return new GoogleCloudCalculatorResultPage(webDriver);
    }
}