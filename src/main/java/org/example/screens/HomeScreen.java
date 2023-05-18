package org.example.screens;

import io.appium.java_client.AppiumBy;
import org.testng.Reporter;

public class HomeScreen extends BaseScreen {

    private static final String CONTINUE_WITH_PERMISSIONS_BUTTON = "com.android.permissioncontroller:id/continue_button";

    private static final String ACCEPT_POPUP = "android:id/button1";
    private static final String WEBVIEW_DEMO_OPTION = "Webview Demo";

    public void selectWebViewDemoOption() {
        findElement(AppiumBy.accessibilityId(WEBVIEW_DEMO_OPTION)).click();
    }

    public void continuewWithPermissions() {
//		findElement(AppiumBy.id(CONTINUE_WITH_PERMISSIONS_BUTTON)).click();
        Reporter.log("Continuing with permissions");
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

    public void acceptPopup() {
        findElement(AppiumBy.id(ACCEPT_POPUP)).click();
    }
}
