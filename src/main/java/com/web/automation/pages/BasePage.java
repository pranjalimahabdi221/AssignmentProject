package com.web.automation.pages;


import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import com.web.automation.constants.ApplicationConstants;
import com.web.automation.logging.InitiateLogger;
import com.web.automation.utils.PropertyFilesUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	private static WebDriver driver;
	Properties envprop= PropertyFilesUtility.readEnvProperties();

	public BasePage() {
		if (driver == null) {
			initilizeDriver(envprop.getProperty("browser"));
			openBrowser();

		} else {
			InitiateLogger.debug("Driver already initilized...");
		}
		
	}

	private WebDriver initilizeDriver(String browserName) {

		switch (browserName.toUpperCase()) {
		case "CHROME":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "FIREFOX":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(firefoxOptions);
			break;

		default:
			InitiateLogger.error("Wrong browser Value specified");
			break;
		}
		InitiateLogger.debug("Initilizing driver with " + browserName + "browser..");
		return driver;

	}

	public static WebDriver getDriver() {
		if (driver == null) {
			setDriver(driver);
		}
		return driver;

	}

	public static WebDriver setDriver(WebDriver driver) {
		return driver = BasePage.driver;
	}
	
	private  void openBrowser() {
		driver.manage().window().maximize();
		driver.get(PropertyFilesUtility.readConfigProperties().getProperty(ApplicationConstants.URL));
		
	}

}
