package com.amfam.qa.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amfam.qa.common.Commons;

public class HomePage {
	Commons commons;

	public HomePage(WebDriver driver, Commons commons) {

		PageFactory.initElements(driver, this);
		this.commons = commons;
	}

	@FindBy(xpath = "//button[@class='LeadRouting__select a' and text() = 'Car ']")
	WebElement carElement;
	
	@FindBy(id="uid_54")
	WebElement inputZipCode;
	
	
	
	
	
	private void clickCar() {
		commons.click(carElement);
	}
	
	private void inputId(String value) {
		commons.inputValue(inputZipCode, value);
	}
	
	public void homePageAutoSteps(String zipCode) {
		clickCar();
		inputId(zipCode);
	}
	

}
