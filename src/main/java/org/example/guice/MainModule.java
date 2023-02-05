package org.example.guice;

import com.google.inject.AbstractModule;
import org.example.screens.BaseScreen;
import org.example.screens.BaseScreenIos;
import org.example.screens.HomeScreen;
import org.example.screens.WebViewDemoScreen;

public class MainModule extends AbstractModule {

	private final String platform;


	public MainModule(String platform) {this.platform = platform;}


	@Override protected void configure() {
		if (platform.equalsIgnoreCase("android")) {
			bind(BaseScreen.class);
			bind(HomeScreen.class);
			bind(WebViewDemoScreen.class);
		} else if (platform.equalsIgnoreCase("ios")) {
			bind(BaseScreen.class).to(BaseScreenIos.class);
		}
	}
}