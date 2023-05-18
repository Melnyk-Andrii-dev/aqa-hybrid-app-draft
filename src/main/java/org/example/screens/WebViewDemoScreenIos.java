package org.example.screens;

import io.appium.java_client.AppiumBy;

public class WebViewDemoScreenIos extends WebViewDemoScreen {

    private static final String GO_BUTTON = "(//XCUIElementTypeOther[@name='navigateBtn'])[2]";


    @Override
    public void pressGoButton() {
        findElement(AppiumBy.xpath(GO_BUTTON)).click();
    }


}
