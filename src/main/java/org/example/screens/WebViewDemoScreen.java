package org.example.screens;

import io.appium.java_client.AppiumBy;

public class WebViewDemoScreen extends BaseScreen {
    private static final String URL_FIELD = "urlInput";
    private static final String GO_BUTTON = "//*[@text='Go']";
    private static final String BURGER_MENU_BUTTON = "(//a[@id='toggleMenu'])[2]";
    private static final String LATEST_OPTION = "(//div[@id='__next']/div/div[2]/div/ul/li)[3]";


    public void typeInUrlField(String url) {
        type(url, findElement(AppiumBy.accessibilityId(URL_FIELD)));
    }

    public void pressGoButton() {
        findElement(AppiumBy.xpath(GO_BUTTON)).click();
    }

    public void pressBurgerMenuButton() {
        findElement(AppiumBy.xpath(BURGER_MENU_BUTTON)).click();
    }

    public void selectLatestOption() {
        findElement(AppiumBy.xpath(LATEST_OPTION)).click();
    }
}