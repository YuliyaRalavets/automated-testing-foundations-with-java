package test;

import googlecom.GoogleCloudCalculatorResultPage;
import googlecom.GoogleCloudHomePage;
import googlecom.GoogleSearchResultPage;
import googlecom.YupMailAddressPage;
import googlecom.YupMailAddressPageWithMail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleCalculatorTest {
    private WebDriver webDriver;
    GoogleCloudCalculatorResultPage googleCloudCalculatorResultPage;

    @BeforeTest
    public void sutUp() {
        webDriver = new ChromeDriver();
        webDriver.get("https://cloud.google.com/");
        webDriver.manage().window().maximize();
    }

    @BeforeClass
    public void getResultPage() {
        GoogleSearchResultPage page = new GoogleCloudHomePage(webDriver)
                .getResultSearchPage("Calculator");
        googleCloudCalculatorResultPage = page.getCalculatorHomePage().addToEstimate();
    }

    @Test(priority = 1)
    public void checkVMClassField() {
        Assert.assertEquals(googleCloudCalculatorResultPage.getVMClassFieldText(), "regular");
    }

    @Test(priority = 1)
    public void checkInstanceTypeField() {
        Assert.assertEquals(googleCloudCalculatorResultPage.getMachineTypeFieldText(), "n1-standard-1");
    }

    @Test(priority = 1)
    public void checkRegionField() {
        Assert.assertEquals(googleCloudCalculatorResultPage.getRegionFormText(), "Frankfurt");
    }

    @Test(priority = 1)
    public void checkLocalSSDField() {
        Assert.assertEquals(googleCloudCalculatorResultPage.getLocalSSDFormText(), "2x375 GiB");
    }

    @Test(priority = 1)
    public void checkCommitmentTermField() {
        Assert.assertEquals(googleCloudCalculatorResultPage.getCommitmentTermFormText(), "1 Year");
    }

    @Test(priority = 1)
    public void checkEstimatedCostPerMonth() {
        Assert.assertEquals(googleCloudCalculatorResultPage.getPricePerMonth(), "295.48");
    }

    @Test(priority = 2)
    public void checkTotalEstimatedMonthlyCostIsTheSameThatInCalculator() {
        String parentHandle = googleCloudCalculatorResultPage.getParentHandle();
        String priceFromCalculator = googleCloudCalculatorResultPage.getPricePerMonth();
        YupMailAddressPage yupMailAddressPage = googleCloudCalculatorResultPage.getYoupMailHomePage().generateRandomAddress();
        String mail = yupMailAddressPage.getAddressText();
        String childHandle = yupMailAddressPage.getChildHandle();
        webDriver.switchTo().window(parentHandle);
        googleCloudCalculatorResultPage.sendMail(mail);
        webDriver.switchTo().window(childHandle);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        YupMailAddressPageWithMail pageWithMail = yupMailAddressPage.getMailPage();
        String fromMail = pageWithMail.getTotalEstimateMonthlyCost();
        webDriver.switchTo().window(parentHandle);
        Assert.assertEquals(fromMail, priceFromCalculator);
    }
}
