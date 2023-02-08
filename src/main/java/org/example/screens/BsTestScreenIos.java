package org.example.screens;

import java.time.Duration;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BsTestScreenIos extends BsTestScreen{

	private static final String swLocator = "Text Button";
	private static final String inputField = "Text Input";
	private static final String output = "Text Output";

	@Override public void clickOnSearchWikipedia() {
		WebElement textButton = new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(
				ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(swLocator)));
		textButton.click();
	}


	@Override public void typeInSearch() {
		WebElement textInput = new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(
				ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(inputField)));
		textInput.sendKeys("hello@browserstack.com");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}


	@Override public boolean isSuccess() {
		WebElement textOutput = new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(
				ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(output)));
		if(textOutput != null && textOutput.getText().equals("hello@browserstack.com"))
			return true;
		else
			return false;
	}
}
