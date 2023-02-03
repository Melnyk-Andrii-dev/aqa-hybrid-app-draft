package org.example.testUtils;

import org.openqa.selenium.remote.DesiredCapabilities;

public class SetupUtil {

	public static DesiredCapabilities getCapabilities(String deviceName, String udid, String platformName,
	                                                  String platformVersion) {
		DesiredCapabilities capabilities = new DesiredCapabilities();

//		capabilities.setCapability("browserstack.user", "saomaster_rhtjE5");
//		capabilities.setCapability("browserstack.key", "VPNxx8fsnsMLKiC6CaBR");
		capabilities.setCapability("project", "First Java Project");
		capabilities.setCapability("build", "browserstack-build-1");
		capabilities.setCapability("name", "first_test");

		capabilities.setCapability("appium:deviceName", deviceName);
		capabilities.setCapability("appium:UUID", udid);
		capabilities.setCapability("appium:platformName", platformName);
		capabilities.setCapability("appium:platformVersion", platformVersion);
		capabilities.setCapability("appium:automationName", "UiAutomator2");
		capabilities.setCapability("appium:appPackage", "io.cloudgrey.the_app");
		capabilities.setCapability("appium:appActivity", ".MainActivity");
		capabilities.setCapability("appium:chromedriverExecutable", "D:\\web-drivers\\chromedriver-old.exe");
		capabilities.setCapability("appium:extractChromeAndroidPackageFromContextName", true);

		return capabilities;
	}
}
