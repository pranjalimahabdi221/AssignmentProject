package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.web.automation.locators.ICarbohydrateCalculatorPage;
import com.web.automation.utils.WebActions;
import com.web.automation.utils.WebWaits;

public class CarbohydrateCalculatorPage extends BasePage implements ICarbohydrateCalculatorPage{
	
	static WebDriver driver=getDriver();
	
	@FindBy(name = AGE_INPUT)
	WebElement ageInput;
	
	@FindBy(name = HEIGHT_INPUT)
	WebElement heightInput;
	
	@FindBy(name = WEIGHT_INPUT)
	WebElement weightInput;
	
	@FindBy(name = ACTIVITY_DROPDOWN)
	WebElement activity_DropDown;
	
	@FindBy(xpath = CALCULATE_BTN)
	WebElement calculate_Btn;
	
	public CarbohydrateCalculatorPage(WebDriver driver) {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterAge() {
		WebWaits.waitForElementToPresent(ageInput);
		WebActions.setText(ageInput, "25");
	}
	public void enterHeight() {
		WebWaits.waitForElementToPresent(heightInput);
		WebActions.setText(heightInput, "160");
	}
	public void enterWeight() {
		WebWaits.waitForElementToPresent(weightInput);
		WebActions.setText(weightInput, "80");
	}
	public void selectActivity() {
		WebWaits.waitForElementToClikable(activity_DropDown);
		WebActions.selectDropdownByVisibleText(activity_DropDown, "Moderate: exercise 4-5 times/week");
	}
	public void clickOnCalculateBtn() {
		WebWaits.waitForElementToClikable(calculate_Btn);
		WebActions.clickElement(calculate_Btn);
	}

}
