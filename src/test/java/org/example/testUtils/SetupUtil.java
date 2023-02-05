package org.example.testUtils;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;

public class SetupUtil {

	public static UiAutomator2Options getAndroidCapabilities(String deviceName, String udid, String platformName,
	                                                         String platformVersion) {
		
		UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
		uiAutomator2Options.setDeviceName(deviceName);
		uiAutomator2Options.setUdid(udid);
		uiAutomator2Options.setPlatformName(platformName);
		uiAutomator2Options.setPlatformVersion(platformVersion);
		uiAutomator2Options.setAutomationName("UiAutomator2");
		uiAutomator2Options.setAppPackage("io.cloudgrey.the_app");
		uiAutomator2Options.setAppActivity(".MainActivity");
		uiAutomator2Options.setChromedriverExecutable("D:\\web-drivers\\chromedriver-old.exe");
		uiAutomator2Options.setExtractChromeAndroidPackageFromContextName(true);
		
		return uiAutomator2Options;
	}

	public static XCUITestOptions getIosCapabilities(String deviceName, String udid, String platformName,
	                                                         String platformVersion){
		XCUITestOptions xcuiTestOptions = new XCUITestOptions();
		
		return xcuiTestOptions;
	}
}
