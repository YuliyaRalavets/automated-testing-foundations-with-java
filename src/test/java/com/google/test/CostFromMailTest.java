package com.google.test;

import com.google.page.GoogleCloudHomePage;
import com.google.page.YoupMailAddressPage;
import com.google.page.YoupMailAddressPageWithMail;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CostFromMailTest extends BaseTest {

    @BeforeClass
    public void getResultCalculatorPage() {
        page = new GoogleCloudHomePage(driver)
                .open()
                .getResultSearchPage()
                .getCalculatorHomePage()
                .addToEstimate(testUser);
    }

    @Test
    public void checkTotalEstimatedMonthlyCostIsTheSameThatInCalculator() {
        String parentHandle = page.getParentHandle();
        String priceFromCalculator = page.getPricePerMonth();
        System.out.println(priceFromCalculator);
        YoupMailAddressPage yupMailAddressPage = page.getYoupMailHomePage()
                .generateRandomAddress();
        String mail = yupMailAddressPage.getAddressText();
        String childHandle = yupMailAddressPage.getChildHandle();
        driver.switchTo().window(parentHandle);
        page.sendMail(mail);
        driver.switchTo().window(childHandle);
        YoupMailAddressPageWithMail pageWithMail = yupMailAddressPage.getMailPage();
        String fromMail = pageWithMail.getTotalEstimateMonthlyCost();
        driver.switchTo().window(parentHandle);
        Assert.assertTrue(priceFromCalculator.contains(fromMail));
    }
}
