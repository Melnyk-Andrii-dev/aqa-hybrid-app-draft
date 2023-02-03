package org.example.tests;

import java.util.Set;

import org.example.pages.BasePage;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {
	private static final BasePage basePage = new BasePage();

	
	@Test()
	public void sampleTestStep() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
//		BasePage.getDRIVER_THREAD_LOCAL().get().findElementByAccessibilityId("Phone").click();
		BasePage.getDriver().findElementById("com.android.permissioncontroller:id" +
		                                                                     "/continue_button").click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		BasePage.getDriver().findElementById("android:id/button1").click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		BasePage.getDriver().findElementByAccessibilityId("Webview Demo").click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		BasePage.getDriver().findElementByAccessibilityId("urlInput").sendKeys("https://appiumpro.com");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		BasePage.getDriver().findElementByXPath("//*[@text='Go']").click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		Set<String> contextNames = BasePage.getDriver().getContextHandles();
		BasePage.getDriver().context((String)contextNames.toArray()[1]);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		BasePage.getDriver().findElementByXPath("(//a[@id='toggleMenu'])[2]").click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		BasePage.getDriver().findElementByXPath("(//div[@id='__next']/div/div[2]/div/ul/li)[3]").click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		        
	}
}
