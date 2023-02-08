package org.example.testUtils;

import java.util.HashMap;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;

public class CapabilityUtils {

	private static final String BROWSERSTACK_USER_NAME = "kdkdkdkdddd_zxl0Mb";
	private static final String BROWSERSTACK_ACCESS_KEY = "6LsBMC4LLYZetpgzp8CH";

	private static final String BROWSERSTACK_ANDROID_APP_URL = "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c";
	private static final String BROWSERSTACK_IOS_APP_URL = "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d";


	private static HashMap<String, Object> getBrowserstackCapabilities(String platformName) {

		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();

		browserstackOptions.put("userName", BROWSERSTACK_USER_NAME);
		browserstackOptions.put("accessKey", BROWSERSTACK_ACCESS_KEY);

		browserstackOptions.put("projectName", "First Java Project");
		browserstackOptions.put("buildName", "browserstack-build-1");
		browserstackOptions.put("sessionName", "session");
		browserstackOptions.put("appiumVersion", "2.0.0");

		return browserstackOptions;
	}


	public static UiAutomator2Options getAndroidCapabilities(String deviceName, String udid, String platformName,
	                                                         String platformVersion, boolean isBrowserstackRun) {

		UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
		uiAutomator2Options.setDeviceName(deviceName);
		uiAutomator2Options.setPlatformName(platformName);
		uiAutomator2Options.setPlatformVersion(platformVersion);

		if (isBrowserstackRun) {
			uiAutomator2Options.setApp(BROWSERSTACK_ANDROID_APP_URL);
			uiAutomator2Options.setCapability("bstack:options", getBrowserstackCapabilities(platformName));
		} else {
			uiAutomator2Options.setUdid(udid);
			uiAutomator2Options.setAutomationName("UiAutomator2");
			uiAutomator2Options.setAppPackage("io.cloudgrey.the_app");
			uiAutomator2Options.setAppActivity(".MainActivity");
			uiAutomator2Options.setChromedriverExecutable("D:\\web-drivers\\chromedriver-old.exe");
			uiAutomator2Options.setExtractChromeAndroidPackageFromContextName(true);
		}

		return uiAutomator2Options;
	}


	public static XCUITestOptions getIosCapabilities(String deviceName, String udid, String platformName,
	                                                 String platformVersion, boolean isBrowserstackRun) {
		XCUITestOptions xcuiTestOptions = new XCUITestOptions();
		xcuiTestOptions.setDeviceName(deviceName);
		xcuiTestOptions.setUdid(udid);
		xcuiTestOptions.setPlatformName(platformName);
		xcuiTestOptions.setPlatformVersion(platformVersion);

		if (isBrowserstackRun) {
			xcuiTestOptions.setApp(BROWSERSTACK_IOS_APP_URL);
			xcuiTestOptions.setCapability("bstack:options", getBrowserstackCapabilities(platformName));
		} else {
			xcuiTestOptions.setUdid(udid);
			xcuiTestOptions.setAutomationName("xcuitest");
			xcuiTestOptions.setApp("");
		}

		return xcuiTestOptions;
	}
}