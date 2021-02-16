package com.actitime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class EnterTimeTrackPage extends BasePage
{
	WebDriver driver;
	public EnterTimeTrackPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	public void verifyHomePageTitle()
	{
		String expTitle="actiTIME - Enter Time-Track";
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, expTitle);
		Reporter.log("Home page title is verified", true);
	}
}
