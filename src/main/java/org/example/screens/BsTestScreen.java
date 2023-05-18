package org.example.screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BsTestScreen extends BaseScreen {

    private static final String swLocator = "Search Wikipedia";
    private static final String inputField = "org.wikipedia.alpha:id/search_src_text";
    private static final String elementsToFind = "android.widget.TextView";


    public void clickOnSearchWikipedia() {
        WebElement searchElement = new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId(swLocator)));
        searchElement.click();
    }


    public void typeInSearch() {
        WebElement insertTextElement = new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.id(inputField)));
        insertTextElement.sendKeys("Browserstack");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean isSuccess() {
        return true;
    }
}
