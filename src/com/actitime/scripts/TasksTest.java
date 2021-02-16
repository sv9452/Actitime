package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;
import com.actitime.generic.WaitStatementLib;
import com.actitime.pageObjects.*;


public class TasksTest extends BaseLib{
	@Test
	public void createCustomer()
	{
		String username = ExcelUtilities.readData("Sheet1", 3, 1);
		String password = ExcelUtilities.readData("Sheet1", 3, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		
		OpenTasksPage otp=new OpenTasksPage(driver);
		otp.clickOnProjNCustLink();
		ActiveProjNCustPage apcp=new ActiveProjNCustPage(driver);
		apcp.clickOnCreateNewCustBtn();
	String customerName = ExcelUtilities.readData("Sheet1", 3, 3);
		CreateNewCustPage cncp=new CreateNewCustPage(driver);
		cncp.createCustomer(customerName);
		
		apcp.verifyCreateCustMsg(customerName);
		apcp.clickOnLogoutLink();
	}
	
	@Test(dependsOnMethods={"createCustomer"})
	public void deleteCustomer()
	{
		String username = ExcelUtilities.readData("Sheet1", 4, 1);
		String password = ExcelUtilities.readData("Sheet1", 4, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		OpenTasksPage otp=new OpenTasksPage(driver);
		otp.clickOnProjNCustLink();
		String customerName = ExcelUtilities.readData("Sheet1", 4, 3);
		ActiveProjNCustPage apcp=new ActiveProjNCustPage(driver);
		apcp.showCustomer(customerName);
		EditCustInfoPage ecip=new EditCustInfoPage(driver);
		ecip.deleteCustomer();
		apcp.verifyDeleteCustMsg();
		apcp.clickOnLogoutLink();
	}
	
}
