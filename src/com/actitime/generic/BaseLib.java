package com.actitime.generic;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



public class BaseLib {
public WebDriver driver;   //final
	
	@BeforeMethod
	@Parameters({"browser"})
	public void setUp(String browserName)
	{
		System.out.println(browserName);
		if (browserName.equalsIgnoreCase("firefox")) 
		{
			driver=new FirefoxDriver();
			Reporter.log("Firefox launched", true);
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", 
								  "./exefiles/chromedriver.exe");
			driver=new ChromeDriver();
			Reporter.log("Chrome launched", true);
		}
	//driver.manage().deleteAllCookies();  //delete browser cookies
		driver.manage().window().maximize();
	//int secs = Integer.parseInt(GenericLib.getValue("timeout"));
		//WaitStatementLib.iWaitForSecs(driver, secs);
		driver.navigate().to(GenericLib.getValue("url"));
		Reporter.log("navigating to url", true);
	}



@AfterMethod
public void tearDown(ITestResult result)
{
	String fileName = result.getMethod().getMethodName();
	if(result.isSuccess())  { //pass
		Reporter.log(fileName+ " script is passed", true);
	}
	else { //fail
		ScreenshotLib slib= new ScreenshotLib();
		slib.takeScreenshot(driver, fileName);
		Reporter.log("Screenshot has been take", true);
		
	}
	driver.close(); // driver.qui();
	Reporter.log("Browser is closed", true);
}
}



