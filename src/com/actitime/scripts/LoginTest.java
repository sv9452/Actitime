package com.actitime.scripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;
import com.actitime.generic.GenericLib;
import com.actitime.generic.WaitStatementLib;
import com.actitime.pageObjects.*;

public class LoginTest extends BaseLib {
	
	@Test(priority = 1)
	public void validLogin() {
		String username = ExcelUtilities.readData("Sheet1", 1, 1);
		String password = ExcelUtilities.readData("Sheet1", 1, 2);
		LoginPage lp = new LoginPage(driver);
		lp.login(username, password);
		EnterTimeTrackPage ettp = new EnterTimeTrackPage(driver);
		ettp.verifyHomePageLogo();
		ettp.verifyHomePageTitle();
	}

	@Test(priority = 2)
	public void invalidLogin() {
		String username = ExcelUtilities.readData("Sheet1", 2, 1);
		String password = ExcelUtilities.readData("Sheet1", 2, 2);
		LoginPage lp = new LoginPage(driver);
		lp.login(username, password);
		int secs = Integer.parseInt(GenericLib.getValue("timeout"));
		WaitStatementLib.eWaitForVisibility(driver, secs, lp.getInvalidLoginMsg());
		lp.verifyInvalidLoginMsg();
	}

}
