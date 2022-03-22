package com.google.test;

import com.google.page.GoogleCloudHomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UsersFieldsCheckTests extends BaseTest {

    @BeforeClass
    public void getResultCalculatorPage() {
        page = new GoogleCloudHomePage(driver)
                .open()
                .getResultSearchPage()
                .getCalculatorHomePage()
                .addToEstimate(testUser);
    }

    @Test
    public void checkVMClassField() {
        Assert.assertTrue(page.getVMClassFieldText().contains(testUser.getUserVMClass()));
    }

    @Test
    public void checkInstanceTypeField() {
        Assert.assertTrue(page.getMachineTypeFieldText().contains(testUser.getUserInstanceType()));
    }

    @Test
    public void checkRegionField() {
        Assert.assertTrue(page.getRegionFormText().contains(testUser.getUserRegion()));
    }

    @Test
    public void checkLocalSSDField() {
        Assert.assertTrue(page.getLocalSSDFormText().contains(testUser.getUserLocalSsd()));
    }

    @Test(priority = 1)
    public void checkCommitmentTermField() {
        Assert.assertTrue(page.getCommitmentTermFormText().contains(testUser.getUserCommitmentTerm()));
    }
}
