package com.google.page;

import com.google.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleCloudCalculatorHomePage extends BasePage {

    private final Logger logger = LogManager.getRootLogger();

    private By computeEngine = By.xpath("//div[@class = 'tab-holder compute' and @title='Compute Engine']");
    private By numberOfInstance = By.id("input_80");
    private By formOperatingSystem = By.id("select_value_label_72");
    private By optionOperatingSystem = By.id("select_option_82");
    private By machineClassForm = By.id("select_value_label_73");
    private By machineClassOption = By.id("select_option_95");
    private By seriesForm = By.id("select_value_label_75");
    private By seriesOption = By.id("select_option_220");
    private By machineTypeForm = By.id("select_value_label_76");
    private By machineTypeOption = By.id("select_option_420");
    private By addGPUsBtn = By.xpath("//md-checkbox[@class='ng-pristine ng-untouched ng-valid ng-empty' and @aria-label='Add GPUs']");
    private By gpuTypeForm = By.id("select_456");
    private By gpuTypeOption = By.id("select_option_463");
    private By numberOfGPUsForm = By.id("select_458");
    private By numberOfGPUsOption = By.xpath("//*[@id='select_option_467' and @value='1']");
    private By localSSDForm = By.id("select_418");
    private By localSSDOption = By.xpath("//*[@id='select_option_444' and @value='2']");
    private By datacenterLocationForm = By.id("select_113");
    private By datacenterLocaOption = By.id("select_option_241");
    private By commitedUsageForm = By.id("select_120");
    private By commitedUsageOption = By.id("select_option_118");
    private By addToEstimateBtn = By.xpath("//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']");

    public GoogleCloudCalculatorHomePage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudCalculatorResultPage addToEstimate(User user) {
        this.switchToFrames();
        setCalculatorForm(user);
        findElementForClick(addToEstimateBtn).click();
        logger.info("Add to estimate");
        return new GoogleCloudCalculatorResultPage(driver);
    }

    public void switchToFrames(){
        switchToFrameWithIndex(0);
        switchToFrameWithNameOrId("myFrame");
    }

    public GoogleCloudCalculatorResultPage clickAddToEstimateBtn(){
        findElementForClick(addToEstimateBtn).click();
        return new GoogleCloudCalculatorResultPage(driver);
    }

    private void setCalculatorForm(User user) {
        setComputeEngine();
        setNumbersOfInstance(user);
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
    }

    public void setComputeEngine(){
        findElementForClick(computeEngine).click();
    }

    public void setNumbersOfInstance(User user){
        sendTextInTextField(numberOfInstance,user.getUserNumbersOfInstances());
    }

    public void setOperationSystem() {
        findElementForClick(formOperatingSystem).click();
        findElementForClick(optionOperatingSystem).click();
    }

    public void setMachineClass() {
        findElementForClick(machineClassForm).click();
        findElementForClick(machineClassOption).click();
    }

    public void setSeries() {
        findElementForClick(seriesForm).click();
        findElementForClick(seriesOption).click();
    }

    public void setMachineType() {
        findElementForClick(machineTypeForm).click();
        findElementForClick(machineTypeOption).click();
    }

    public void setAddGPUs() {
        findElementForClick(addGPUsBtn).click();
    }

    public void setGPUType() {
        findElementForClick(gpuTypeForm).click();
        findElementForClick(gpuTypeOption).click();
    }

    public void setNumberOfGPUs() {
        findElementForClick(numberOfGPUsForm).click();
        findElementForClick(numberOfGPUsOption).click();
    }

    public void setLocalSSD() {
        findElementForClick(localSSDForm).click();
        findElementForClick(localSSDOption).click();
    }

    public void setDatacenterLocation() {
        findElementForClick(datacenterLocationForm).click();
        findElementForClick(datacenterLocaOption).click();
    }

    public void setCommitedUsage() {
        findElementForClick(commitedUsageForm).click();
        findElementForClick(commitedUsageOption).click();
    }
}