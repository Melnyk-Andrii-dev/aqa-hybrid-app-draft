package org.example.guice;

import com.google.inject.AbstractModule;
import org.example.screens.BsTestScreen;
import org.example.screens.BsTestScreenIos;

public class MainModule extends AbstractModule {

	private final String platform;


	public MainModule(String platform) {
		this.platform = platform;
	}


	@Override protected void configure() {
		if (platform.equalsIgnoreCase("android")) {
//			bind(BaseScreen.class);
//			bind(HomeScreen.class);
//			bind(WebViewDemoScreen.class);
			bind(BsTestScreen.class);
		} else if (platform.equalsIgnoreCase("ios")) {
//			bind(BaseScreen.class).to(BaseScreenIos.class);
			bind(BsTestScreen.class).to(BsTestScreenIos.class);
		}
	}
}