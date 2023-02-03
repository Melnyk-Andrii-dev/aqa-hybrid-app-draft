package org.example.tests;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import lombok.Getter;
import org.example.pages.BasePage;
import org.example.testUtils.SetupUtil;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
	private static final String SAUCELAB_ACCESS = "https://oauth-khiuhuvtt-81c5b:ce531912-9aff-4c40-811a-0e9f34df3019@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

	@Getter
	private AndroidDriver<AndroidElement> driver;

	private AndroidDriver<AndroidElement> inicializeDriver(String deviceName, String udid, String platformName, String platformVersion)
			throws MalformedURLException {
		DesiredCapabilities capabilities = SetupUtil.getCapabilities(deviceName, udid, platformName, platformVersion);
		return new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Parameters({"deviceName", "udid", "platformName", "platformVersion"})
	@BeforeMethod(alwaysRun = true)
	public void setup(String deviceName, String udid, String
			platformName, String platformVersion) throws MalformedURLException {
		driver = inicializeDriver(deviceName, udid, platformName, platformVersion);
		BasePage.setDriverThreadLocal(driver);
	}

	@AfterMethod
	public void closeDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
}
