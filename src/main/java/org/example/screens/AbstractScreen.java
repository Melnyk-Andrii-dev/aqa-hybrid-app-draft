package org.example.screens;

import java.time.Duration;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractScreen {
	
	private static final ThreadLocal<AppiumDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

	public static AppiumDriver getDriver() {
		return DRIVER_THREAD_LOCAL.get();
	}

	public static void setDriverThreadLocal(AppiumDriver appiumDriver) {
		DRIVER_THREAD_LOCAL.set(appiumDriver);
		
	}

	private WebElement waitForVisibilityOfElement(By by) {
		return new WebDriverWait(getDriver(), Duration.ofSeconds(10)).
				until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public WebElement findElement(By by) {
		return waitForVisibilityOfElement(by);
	}
	
	public void type (String text, WebElement element){
		Actions actions = new Actions(getDriver());
		actions.click(element).build().perform();
		char[] chars = text.toCharArray();
		for (char c : chars) {
//			element.sendKeys(String.valueOf(c));
			actions.sendKeys(c + "").build().perform();
			dummyWait(50);
		}
	}
	
	private void dummyWait(int millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	

	
}
