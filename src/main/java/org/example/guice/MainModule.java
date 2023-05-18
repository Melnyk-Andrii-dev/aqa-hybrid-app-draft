package org.example.guice;

import com.google.inject.AbstractModule;
import org.example.screenUtils.ContextSwitcher;
import org.example.screenUtils.ContextSwitcherIos;
import org.example.screens.*;

public class MainModule extends AbstractModule {

    private final String platform;


    public MainModule(String platform) {
        this.platform = platform;
    }


    @Override
    protected void configure() {
        if (platform.equalsIgnoreCase("android")) {
            bind(ContextSwitcher.class);
            bind(BaseScreen.class);
            bind(HomeScreen.class);
            bind(WebViewDemoScreen.class);
            bind(BsTestScreen.class);
        } else if (platform.equalsIgnoreCase("ios")) {
            bind(ContextSwitcher.class).to(ContextSwitcherIos.class);
            bind(HomeScreen.class).to(HomeScreenIos.class);
            bind(WebViewDemoScreen.class).to(WebViewDemoScreenIos.class);
            bind(BsTestScreen.class).to(BsTestScreenIos.class);
        }
    }
}