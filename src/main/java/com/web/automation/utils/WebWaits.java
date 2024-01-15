package com.web.automation.utils;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.web.automation.logging.InitiateLogger;
import com.web.automation.pages.BasePage;

public class WebWaits {

	static WebDriver driver = BasePage.getDriver();
	static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	public static void waitForElementToClikable(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (NoSuchElementException e) {
			InitiateLogger.error("Element is not present " + element);
		}

	}

	public static void waitForElementToPresent(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (NoSuchElementException e) {
			InitiateLogger.error("Element is not present " + element);
		}

	}

	public static void waitToLoad(long millsec) {
		try {
			Thread.sleep(millsec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
