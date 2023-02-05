package org.example.screens;

import java.util.Set;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.lang3.StringUtils;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseScreen extends AbstractScreen {
	private static final String CONTINUE_WITH_PERMISSIONS_BUTTON = "com.android.permissioncontroller:id/continue_button";
	private static final String ACCEPT_POPUP = "android:id/button1";
	
	public void continuewWithPermissions(){
//		findElement(AppiumBy.id(CONTINUE_WITH_PERMISSIONS_BUTTON)).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		getDriver().findElement(AppiumBy.id(CONTINUE_WITH_PERMISSIONS_BUTTON)).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public void acceptPopup(){
		findElement(AppiumBy.id(ACCEPT_POPUP)).click();
	}

	public void switchToNativeView(){
		Set<String> contextNames = ((AndroidDriver)getDriver()).getContextHandles();
		for (String context :
				contextNames) {
			if(StringUtils.containsIgnoreCase(context, "native")){
				((AndroidDriver)getDriver()).context(context);
				return;
			}
		}
	}
	public void switchToWebView(){
		Set<String> contextNames = ((AndroidDriver)getDriver()).getContextHandles();
		for (String context :
				contextNames) {
			if(StringUtils.containsIgnoreCase(context, "web")){
				((AndroidDriver)getDriver()).context(context);
				return;
			}
		}
	}
	
	
}
