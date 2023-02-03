package org.example.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AbstractPage {
	
	private static final ThreadLocal<AndroidDriver<AndroidElement>> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

	public static AndroidDriver getDriver() {
		return DRIVER_THREAD_LOCAL.get();
	}

	public static void setDriverThreadLocal(AndroidDriver<AndroidElement> androidDriver) {
		DRIVER_THREAD_LOCAL.set(androidDriver);
	}
	
}
