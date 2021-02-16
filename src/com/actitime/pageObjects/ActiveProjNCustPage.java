package com.actitime.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class ActiveProjNCustPage extends BasePage{
	@FindBy(css="input[value='Create New Customer']")
	private WebElement createNewCustBtn;
	@FindBy(className="successmsg")
	private WebElement successMsg;  //for create/delete customer and create/delete project same
	@FindBy(name="selectedCustomer")
	private WebElement custDrpDwn;
	@FindBy(css="input[value*='Show']")
	private WebElement showBtn;
	@FindBy(xpath="//td[starts-with(@id,'customerNameCell')]//a[contains(@href,'customerId')]")
	private List<WebElement> custNameLink;
	
	
	
	public ActiveProjNCustPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCreateNewCustBtn()
	{
		createNewCustBtn.click();
	}
	
	public void verifyCreateCustMsg(String customerName)
	{
		Assert.assertTrue(successMsg.isDisplayed());
   Assert.assertTrue(successMsg.getText().contains(customerName));
		Reporter.log(successMsg.getText(),true);
	}
	
	public void showCustomer(String customerName)
	{
		Select sel=new Select(custDrpDwn);
		sel.selectByVisibleText(customerName);
		showBtn.click();
		if (custNameLink.get(0).getText().equals(customerName)) {
			custNameLink.get(0).click();
		}
		
	}
	
	public void verifyDeleteCustMsg()
	{
		String expMsg="Customer has been successfully deleted.";
		String actMsg = successMsg.getText();
		Assert.assertEquals(actMsg, expMsg);
		Reporter.log(actMsg, true);
	}
	
}
