package com.amfam.qa.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.amfam.qa.utils.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	Configuration configuration = new Configuration(null);
	WebDriver driver; 
	
	
	@BeforeMethod
	public void setUp() {
		driver = localDricer("chrome");
		driver.get(configuration.getConfiguration("url"));
		driver.manage().timeouts()
				.pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("pageloadWait"))));
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("implicitWait"))));

	}
	
	public WebDriver localDricer(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();	
		}else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		return driver;
	}
	
	
	public WebDriver getDriver() {
		return driver;
	}

	@AfterMethod
	public void terminate() {
		driver.quit();
	}
	
	
	
	

}
