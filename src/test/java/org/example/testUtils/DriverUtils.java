package org.example.testUtils;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class DriverUtils {

	private static final String BROWSERSTACK_URL_ANDROID = "http://hub.browserstack.com/wd/hub";
	private static final String BROWSERSTACK_URL_IOS = "http://hub-cloud.browserstack.com/wd/hub";
	private static final String LOCAL_URL = "http://127.0.0.1:4723/";


	public static AppiumDriver inicializeDriver(String deviceName, String udid, String platformName,
	                                            String platformVersion, boolean isBrowserstackRun)
			throws MalformedURLException {


		if (platformName.equalsIgnoreCase("android")) {
			UiAutomator2Options androidCapabilities =
					CapabilityUtils.getAndroidCapabilities(deviceName, udid, platformName, platformVersion,
					                                       isBrowserstackRun);

			if (isBrowserstackRun) {
				return new AndroidDriver(new URL(BROWSERSTACK_URL_ANDROID), androidCapabilities);
			} else {
				return new AndroidDriver(new URL(LOCAL_URL), androidCapabilities);
			}

		} else if (platformName.equalsIgnoreCase("ios")) {
			XCUITestOptions
					iosCapabilities =
					CapabilityUtils.getIosCapabilities(deviceName, udid, platformName, platformVersion,
					                                   isBrowserstackRun);

			if (isBrowserstackRun) {
				return new IOSDriver(new URL(BROWSERSTACK_URL_IOS), iosCapabilities);
			} else {
				return new IOSDriver(new URL(LOCAL_URL), iosCapabilities);
			}

		} else throw new RuntimeException("PLATFORM NOT SUPPORTED");

	}
}
