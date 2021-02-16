package com.actitime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.GenericLib;
import com.actitime.generic.WaitStatementLib;

public class OpenTasksPage 
{
	WebDriver driver;
	
	@FindBy(linkText="Projects & Customers")
	private WebElement projNCustLink;

	public OpenTasksPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void clickOnProjNCustLink()
	{
		int secs = Integer.parseInt(GenericLib.getValue("timeout"));
		WaitStatementLib.eWaitForClikable(driver, secs, projNCustLink);
		projNCustLink.click();
	}
}

