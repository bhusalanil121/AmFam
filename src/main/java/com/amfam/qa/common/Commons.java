package com.amfam.qa.common;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.amfam.qa.reporting.Loggers;

public class Commons {

	public void inputValue(WebElement element, String value) {
		try {
			element.sendKeys(value);
			Loggers.getLog(value + ": value has been passed into ------> " + element);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.getLog("Element : " + element + " Is not Found");

			Assert.fail(); // if this element is failed it will move to next element
		}

	}

	public void click(WebElement element) {
		try {
			element.click();
			Loggers.getLog(element + ": This element has been clicked!!!");

		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.getLog("Element : " + element + " Is not Found");

			Assert.fail(); // if this element is failed it will move to next element
		}

	}

	public String getText(WebElement element) {
		String valueString = null;
		try {
			valueString = element.getText();
			Loggers.getLog(element + "-------> element has text: " + valueString);

		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.getLog("Element : " + element + " Is not Found");
			Assert.fail(); // if this element is failed it will move to next element
		}
		return valueString;

	}

	public String getCurrentUrl(WebDriver driver) {
		Loggers.getLog("Current Url is : " + driver.getCurrentUrl());
		return driver.getCurrentUrl();
	}

	public void clear(WebElement element) {

		try {
			element.clear();
			Loggers.getLog(": The value has been cleared from the element: " + element);

		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.getLog("Element : " + element + " Is not Found");
			Assert.fail(); // if this element is failed it will move to next element
		}
	}

}
