package org.example.screens;

import org.testng.Reporter;

public class HomeScreenIos extends HomeScreen{
	
	@Override public void continuewWithPermissions() {
		Reporter.log("SKIP");
	}


	@Override public void acceptPopup() {
		Reporter.log("SKIP");
	}
}
