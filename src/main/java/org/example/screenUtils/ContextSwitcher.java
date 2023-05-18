package org.example.screenUtils;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.lang3.StringUtils;
import org.example.screens.AbstractScreen;

import java.util.Set;

public class ContextSwitcher {


    public void switchToNativeView() {
        ((AndroidDriver) AbstractScreen.getDriver()).getContextHandles();
        Set<String> contextNames = ((AndroidDriver) AbstractScreen.getDriver()).getContextHandles();
        System.out.println(contextNames);
        for (String context :
                contextNames) {
            if (StringUtils.containsIgnoreCase(context, "native")) {

                ((AndroidDriver) AbstractScreen.getDriver()).context(context);
                return;
            }
        }
        throw new RuntimeException("NO CONTEXT FOUND");
    }


    public void switchToWebView() {
        ((AndroidDriver) AbstractScreen.getDriver()).getContextHandles();
        Object o = ((AndroidDriver) AbstractScreen.getDriver()).executeScript("mobile:getContexts");
        Set<String> contextNames = ((AndroidDriver) AbstractScreen.getDriver()).getContextHandles();
        System.out.println(contextNames);
        for (String context :
                contextNames) {
            if (StringUtils.containsIgnoreCase(context, "web")) {
                ((AndroidDriver) AbstractScreen.getDriver()).context(context);
                return;
            }
        }
        throw new RuntimeException("NO CONTEXT FOUND");
    }
}
