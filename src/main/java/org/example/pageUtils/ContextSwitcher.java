package org.example.pageUtils;

import java.util.Set;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.lang3.StringUtils;
import org.example.screens.AbstractScreen;

public class ContextSwitcher {

	public void switchToNativeView() {
		((AndroidDriver)AbstractScreen.getDriver()).getContextHandles();
		Set<String> contextNames = ((AndroidDriver)AbstractScreen.getDriver()).getContextHandles();
		for (String context :
				contextNames) {
			if (StringUtils.containsIgnoreCase(context, "native")) {
				((AndroidDriver)AbstractScreen.getDriver()).context(context);
				return;
			}
		}
	}


	public void switchToWebView() {
		((AndroidDriver)AbstractScreen.getDriver()).getContextHandles();
		Object o = ((AndroidDriver)AbstractScreen.getDriver()).executeScript("mobile:getContexts");
		Set<String> contextNames = ((AndroidDriver)AbstractScreen.getDriver()).getContextHandles();
		for (String context :
				contextNames) {
			if (StringUtils.containsIgnoreCase(context, "web")) {
				((AndroidDriver)AbstractScreen.getDriver()).context(context);
				return;
			}
		}
	}
}
