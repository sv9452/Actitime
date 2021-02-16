package com.actitime.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener implements ITestListener, ISuiteListener

{
	WebDriver driver;

	@Override
	public void onStart(ISuite suite) {
		System.setProperty("webdriver.chrome.driver", 
				  "./exefiles/chromedriver.exe");
 driver=new ChromeDriver();
Reporter.log("Chrome launched", true);
		
	}

	@Override
	public void onFinish(ISuite suite) {
		driver.close();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
//		ScreenshotLib slib= new ScreenshotLib();
//		slib.takeScreenshot(driver, filepath);
//		Reporter.log("Screenshot has been take", true);
//		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
	driver.quit();
		
	}

}
