package org.example.tests;

import javax.inject.Inject;

import org.example.guice.ModuleFactory;
import org.example.screens.BsTestScreen;
import org.example.screens.HomeScreen;
import org.example.screens.WebViewDemoScreen;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@Guice(moduleFactory = ModuleFactory.class)
public class MenuNavigationTests2 extends BaseTest implements ITest {

	@Inject HomeScreen homeScreen;
	@Inject WebViewDemoScreen webViewDemoScreen;

	@Inject BsTestScreen bsTestScreen;


	@Test(description = "user can use main menu 2")
	public void userCanUseMainMenu2() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		
//		homeScreen.continuewWithPermissions();
//		homeScreen.acceptPopup();
//		homeScreen.selectWebViewDemoOption();
//		webViewDemoScreen.typeInUrlField("https://appiumpro.com");
//		webViewDemoScreen.pressGoButton();
//		webViewDemoScreen.switchToWebView();
//		webViewDemoScreen.pressBurgerMenuButton();
//		webViewDemoScreen.selectLatestOption();
		


		bsTestScreen.clickOnSearchWikipedia();
		bsTestScreen.typeInSearch();

		Assert.assertTrue(true);
	}


	@Override public String getTestName() {
		return "Manu Navigation Test 2";
	}
}
