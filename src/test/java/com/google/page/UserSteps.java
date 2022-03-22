/*
package com.google.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserSteps {
    private WebDriver webDriver;
    private GoogleCloudHomePage googleCloudHomePage;
    private GoogleCloudCalculatorHomePage googleCloudCalculatorHomePage;
    private GoogleCloudCalculatorResultPage googleCloudCalculatorResultPage;
    private YoupMailHomePage youpMailHomePage;
    private YoupMailAddressPage youpMailAddressPage;
    private YoupMailAddressPageWithMail youpMailAddressPageWithMail;

    public UserSteps (){
        webDriver = new ChromeDriver();
        googleCloudHomePage = new GoogleCloudHomePage(webDriver);
    }

    public void openGoogle(){
        webDriver.get("https://cloud.google.com/");
        webDriver.manage().window().maximize();
    }

    public GoogleCloudCalculatorResultPage addToEstimate() {
        googleCloudCalculatorHomePage = findCalculatorPage();
        googleCloudCalculatorHomePage.switchToFrames();
        googleCloudCalculatorHomePage.setComputeEngine();
        googleCloudCalculatorHomePage.setNumbersOfInstance();
        googleCloudCalculatorHomePage.setOperationSystem();
        googleCloudCalculatorHomePage.setMachineClass();
        googleCloudCalculatorHomePage.setSeries();
        googleCloudCalculatorHomePage.setMachineType();
        googleCloudCalculatorHomePage.setAddGPUs();
        googleCloudCalculatorHomePage.setGPUType();
        googleCloudCalculatorHomePage.setNumberOfGPUs();
        googleCloudCalculatorHomePage.setLocalSSD();
        googleCloudCalculatorHomePage.setDatacenterLocation();
        googleCloudCalculatorHomePage.setCommitedUsage();
        return googleCloudCalculatorHomePage.clickAddToEstimateBtn();
    }

    private GoogleCloudCalculatorHomePage findCalculatorPage() {
        return googleCloudHomePage
                .getResultSearchPage("Calculator")
                .getCalculatorHomePage();
    }

    public String textFromInstance(){
        return addToEstimate().getMachineTypeFieldText();
    }
}
*/
