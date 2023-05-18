package org.example.screenUtils;

import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.lang3.StringUtils;
import org.example.screens.AbstractScreen;

import java.util.Set;

public class ContextSwitcherIos extends ContextSwitcher {

    @Override
    public void switchToNativeView() {
        ((IOSDriver) AbstractScreen.getDriver()).getContextHandles();
        Set<String> contextNames = ((IOSDriver) AbstractScreen.getDriver()).getContextHandles();
        System.out.println(contextNames);
        for (String context :
                contextNames) {
            if (StringUtils.containsIgnoreCase(context, "native")) {
                ((IOSDriver) AbstractScreen.getDriver()).context(context);
                return;
            }
        }
        throw new RuntimeException("NO CONTEXT FOUND");
    }


    @Override
    public void switchToWebView() {
        ((IOSDriver) AbstractScreen.getDriver()).getContextHandles();
        Set<String> contextNames = ((IOSDriver) AbstractScreen.getDriver()).getContextHandles();
        System.out.println(contextNames);
        for (String context :
                contextNames) {
            if (StringUtils.containsIgnoreCase(context, "web")) {
                ((IOSDriver) AbstractScreen.getDriver()).context(context);
                return;
            }
        }
        throw new RuntimeException("NO CONTEXT FOUND");
    }
}
