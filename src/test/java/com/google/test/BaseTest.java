package com.google.test;

import com.google.driver.DriverSingleton;
import com.google.model.User;
import com.google.page.GoogleCloudCalculatorResultPage;
import com.google.service.UserCreator;
import com.google.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class BaseTest {
    protected WebDriver driver;
    protected GoogleCloudCalculatorResultPage page;
    protected User testUser = UserCreator.withCredentialsFromProperty();

    @BeforeClass
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterClass(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}


