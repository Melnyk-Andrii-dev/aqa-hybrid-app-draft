package org.example.screens;

import io.appium.java_client.AppiumBy;

public class HomeScreen extends BaseScreen{
	private static final String WEBVIEW_DEMO_OPTION = "Webview Demo";
	
	public void selectWebViewDemoOption(){
		findElement(AppiumBy.accessibilityId(WEBVIEW_DEMO_OPTION)).click();
	}
}
