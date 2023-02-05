package org.example.tests;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.example.screens.AbstractScreen;
import org.example.testUtils.SetupUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
	private static final String SAUCELAB_ACCESS = "https://oauth-khiuhuvtt-81c5b:ce531912-9aff-4c40-811a-0e9f34df3019@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
	
	private AppiumDriver driver;

	private AppiumDriver inicializeDriver(String deviceName, String udid, String platformName, String platformVersion)
			throws MalformedURLException {
		if(platformName.equalsIgnoreCase("android")) {
			UiAutomator2Options androidCapabilities = SetupUtil.getAndroidCapabilities(deviceName, udid, platformName, platformVersion);
			return new AndroidDriver(new URL("http://127.0.0.1:4723/"), androidCapabilities);
		}
		else if (platformName.equalsIgnoreCase("ios")){
			XCUITestOptions iosCapabilities = SetupUtil.getIosCapabilities(deviceName, udid, platformName, platformVersion);
			return new IOSDriver(new URL("http://127.0.0.1:4723/"), iosCapabilities);
		}
		else throw new RuntimeException("PLATFORM NOT SUPPORTED");
	}
	

	@Parameters({"deviceName", "udid", "platformName", "platformVersion"})
	@BeforeMethod(alwaysRun = true)
	public void setup(String deviceName, String udid, String
			platformName, String platformVersion) throws MalformedURLException {
		driver = inicializeDriver(deviceName, udid, platformName, platformVersion);
		AbstractScreen.setDriverThreadLocal(driver);
	}

	@AfterMethod
	public void closeDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
}