package com.web.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.web.automation.logging.InitiateLogger;
import com.web.automation.pages.BasePage;

public class WebActions {

	static WebDriver driver = BasePage.getDriver();
	static Select select;
	
	public static void setText(WebElement element, String text) {
		WebWaits.waitForElementToPresent(element);
		if (element.getText() != null) {
			element.clear();
		}
		element.sendKeys(text);
		InitiateLogger.info("Sent "+text+" value in textbox" + element);
	}

	public static void clickElement(WebElement element) {
		WebWaits.waitForElementToClikable(element);
		element.click();
		InitiateLogger.info("Clicked on the Element" + element);
	}
	public static void selectDropdownByVisibleText(WebElement element, String text) {
		select=new Select(element);
		select.selectByVisibleText(text);
		InitiateLogger.info("Selected the "+text+" Option from the dropdown");
	}
	public static void selectDropdownByIndex(WebElement element, int index) {
		select=new Select(element);
		select.selectByIndex(index);
		InitiateLogger.info("Selected the "+index+" index Option from the dropdown");
	}
	public static void selectDropdownByValue(WebElement element, String text) {
		select=new Select(element);
		select.selectByValue(text);	
		InitiateLogger.info("Selected the "+text+" Option from the dropdown");
	}

}
