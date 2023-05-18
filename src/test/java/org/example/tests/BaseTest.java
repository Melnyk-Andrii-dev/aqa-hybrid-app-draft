package org.example.tests;

import io.appium.java_client.AppiumDriver;
import org.example.screens.AbstractScreen;
import org.example.testUtils.DriverUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class BaseTest {

    private AppiumDriver driver;

    private void setBrowserstackRunResult(ITestResult testResult) {
        JavascriptExecutor jse = (JavascriptExecutor) AbstractScreen.getDriver();
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionName\", \"arguments\": {\"name\":\"" + testResult.getTestName() + "->" + testResult.getMethod().getDescription() + " \" }}");
        if (testResult.getStatus() == ITestResult.SUCCESS) {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"This is good\"}}");
        } else {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"This is bad\"}}");
        }
    }

    @Parameters({"deviceName", "udid", "platformName", "platformVersion", "isBrowserstackRun"})
    @BeforeMethod(alwaysRun = true)
    public void setup(String deviceName, @Optional String udid, String
            platformName, String platformVersion, boolean isBrowserstackRun) throws MalformedURLException {
        driver = DriverUtils.inicializeDriver(deviceName, udid, platformName, platformVersion, isBrowserstackRun);
        AbstractScreen.setDriverThreadLocal(driver);
    }

    @Parameters({"isBrowserstackRun"})
    @AfterMethod
    public void closeDriver(boolean isBrowserstackRun, ITestResult testResult) {

        if (isBrowserstackRun) {
            setBrowserstackRunResult(testResult);
        }

        if (driver != null) {
            driver.quit();
        }
    }

}