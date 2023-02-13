package org.example.testUtils;

import java.time.Duration;
import java.util.HashMap;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;

public class CapabilityUtils {

	private static final String BROWSERSTACK_USER_NAME = "andriimelnyk_bO5XUo";
	private static final String BROWSERSTACK_ACCESS_KEY = "cS6DzbNukoydfUPVzUAD";

	private static final String BROWSERSTACK_ANDROID_APP_URL = "bs://dd29fef22092d5003dce1141809b5f470f3cc485";
	private static final String BROWSERSTACK_IOS_APP_URL = "bs://3ddc12d466506a9f4ee636aa65954aa4e2376f33";


	private static HashMap<String, Object> getBrowserstackCapabilities(String platformName) {

		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();

		browserstackOptions.put("userName", BROWSERSTACK_USER_NAME);
		browserstackOptions.put("accessKey", BROWSERSTACK_ACCESS_KEY);

		browserstackOptions.put("projectName", "First Java Project");
		browserstackOptions.put("buildName", "browserstack-build-1");
		browserstackOptions.put("sessionName", "session");
//		browserstackOptions.put("appiumVersion", "2.0.0");
		browserstackOptions.put("networkLogs", "true");
		browserstackOptions.put("source", "appiumdesktop");

		return browserstackOptions;
	}


	public static UiAutomator2Options getAndroidCapabilities(String deviceName, String udid, String platformName,
	                                                         String platformVersion, boolean isBrowserstackRun) {

		UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
		uiAutomator2Options.setDeviceName(deviceName);
		uiAutomator2Options.setPlatformName(platformName);
		uiAutomator2Options.setPlatformVersion(platformVersion);

		uiAutomator2Options.setNewCommandTimeout(Duration.ofSeconds(3600));
		uiAutomator2Options.setChromedriverUseSystemExecutable(true);


		if (isBrowserstackRun) {
			uiAutomator2Options.setApp(BROWSERSTACK_ANDROID_APP_URL);
			uiAutomator2Options.setCapability("bstack:options", getBrowserstackCapabilities(platformName));
//			uiAutomator2Options.setCapability("browserName", "chrome");
//			uiAutomator2Options.setChromedriverExecutable("D:\\web-drivers\\chromedriver-old.exe");
//			uiAutomator2Options.setExtractChromeAndroidPackageFromContextName(true);
//			uiAutomator2Options.setAutomationName("UiAutomator2");
//			uiAutomator2Options.setAutoWebview(true);
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
		
		xcuiTestOptions.setCapability("automationName", "XCUITest");
		xcuiTestOptions.setNewCommandTimeout(Duration.ofSeconds(3600));
		xcuiTestOptions.setConnectHardwareKeyboard(true);
		xcuiTestOptions.setCapability("os_version", "14");
		
		
		
		xcuiTestOptions.setIncludeSafariInWebviews(true);

		if (isBrowserstackRun) {
			xcuiTestOptions.setApp(BROWSERSTACK_IOS_APP_URL);
			xcuiTestOptions.setCapability("bstack:options", getBrowserstackCapabilities(platformName));
		} else {
			xcuiTestOptions.setUdid(udid);
			xcuiTestOptions.setApp("");
		}

		return xcuiTestOptions;
	}
}