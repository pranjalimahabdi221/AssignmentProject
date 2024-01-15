package com.web.automation.tests;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.web.automation.logging.InitiateLogger;
import com.web.automation.pages.BasePage;
import com.web.automation.pages.CarbohydrateCalculatorPage;
import com.web.automation.utils.PropertyFilesUtility;

public class CarbCalculatorFlow {
	WebDriver driver= BasePage.getDriver();
	public static Logger log;
	Properties configProp = PropertyFilesUtility.readConfigProperties();
	
	@Test
	public void carbEstimationFlow() {
		log=LogManager.getLogger(CarbCalculatorFlow.class);
		CarbohydrateCalculatorPage carbohydrateCalculatorPage=new CarbohydrateCalculatorPage(driver);
		InitiateLogger.info("Navigating to Metric Units");
		carbohydrateCalculatorPage.enterAge();
		carbohydrateCalculatorPage.enterHeight();
		carbohydrateCalculatorPage.enterWeight();
		carbohydrateCalculatorPage.selectActivity();
		carbohydrateCalculatorPage.clickOnCalculateBtn();
		InitiateLogger.info("Carb Estimation Result Generted successfully....");
	}

}
