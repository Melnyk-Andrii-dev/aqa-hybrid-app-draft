package org.example.tests;

import javax.inject.Inject;

import org.example.guice.ModuleFactory;
import org.example.screenUtils.ContextSwitcher;
import org.example.screens.BsTestScreen;
import org.example.screens.HomeScreen;
import org.example.screens.WebViewDemoScreen;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@Guice(moduleFactory = ModuleFactory.class)
public class MenuNavigationTests extends BaseTest implements ITest {

	@Inject HomeScreen homeScreen;
	@Inject WebViewDemoScreen webViewDemoScreen;

	@Inject BsTestScreen bsTestScreen;
	
	@Inject ContextSwitcher contextSwitcher;


	@Test(description = "user can use main menu - should pass")
	public void userCanUseMainMenu() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		homeScreen.continuewWithPermissions();
		homeScreen.acceptPopup();
		homeScreen.selectWebViewDemoOption();
		webViewDemoScreen.typeInUrlField("https://appiumpro.com");
		webViewDemoScreen.pressGoButton();
		contextSwitcher.switchToWebView();
		webViewDemoScreen.pressBurgerMenuButton();
		webViewDemoScreen.selectLatestOption();
		


//		bsTestScreen.clickOnSearchWikipedia();
//		bsTestScreen.typeInSearch();

		Assert.assertTrue(true);
	}

	@Test(description = "user can use main menu - should fail")
	public void userCanUseMainMenuShouldFail() throws InterruptedException {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		homeScreen.continuewWithPermissions();
		homeScreen.acceptPopup();
		homeScreen.selectWebViewDemoOption();
		webViewDemoScreen.typeInUrlField("https://appiumpro.com");
		webViewDemoScreen.pressGoButton();
		Thread.sleep(3000);
		contextSwitcher.switchToWebView();
		webViewDemoScreen.pressBurgerMenuButton();
		webViewDemoScreen.selectLatestOption();


//		bsTestScreen.clickOnSearchWikipedia();
//		bsTestScreen.typeInSearch();


		Assert.assertTrue(false);
	}


	@Override public String getTestName() {
		return "Manu Navigation Test";
	}
}
