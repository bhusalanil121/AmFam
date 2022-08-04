package com.amfam.qa.test.car;

import org.testng.annotations.Test;
import com.amfam.qa.base.BaseClass;




public class AutoClass extends BaseClass{
	@Test(enabled = true)
	public void carInsurance() throws InterruptedException {
		homePage.homePageAutoSteps("11237");
		Thread.sleep(3000);
	}

}

