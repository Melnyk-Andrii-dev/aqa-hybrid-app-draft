package org.example.tests;

import javax.inject.Inject;

import org.example.guice.ModuleFactory;
import org.example.screens.HomeScreen;
import org.example.screens.WebViewDemoScreen;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@Guice(moduleFactory = ModuleFactory.class)
public class MenuNavigationTests extends BaseTest {

	@Inject HomeScreen homeScreen;
	@Inject WebViewDemoScreen webViewDemoScreen;
	
	@Test()
	public void userCanUseMainMenu() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		homeScreen.continuewWithPermissions();
		homeScreen.acceptPopup();
		homeScreen.selectWebViewDemoOption();
		webViewDemoScreen.typeInUrlField("https://appiumpro.com");
		webViewDemoScreen.pressGoButton();
		webViewDemoScreen.switchToWebView();
		webViewDemoScreen.pressBurgerMenuButton();
		webViewDemoScreen.selectLatestOption();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		
	}
}
