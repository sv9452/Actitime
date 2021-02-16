package com.actitime.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String key="webdriver.chrome.driver";
		String value=".//exefiles/chromedriver.exe";
		System.setProperty(key, value);
WebDriver driver= new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.get("http://serviceproviders.ca-build.com/Public/Login?ReturnUrl=%2F#/");
driver.findElement(By.id("UserName")).sendKeys("kstanley@commonareas.work.dev");
driver.findElement(By.id("Password")).sendKeys("1234567Aa");
driver.findElement(By.id("login_button")).click();
Reporter.log("Logged into the application");
Thread.sleep(20000);

WebElement btnplus = driver.findElement(By.xpath("//button[@class='plus-button v-btn v-btn--fab v-btn--flat v-btn--round v-btn--text theme--light v-size--default']//i[@class='icon']//*[local-name()='svg']"));
//driver.findElement(By.xpath("//button[@class='plus-button v-btn v-btn--fab v-btn--flat v-btn--round v-btn--text theme--light v-size--default']//i[@class='icon']//*[local-name()='svg']//*[name()='path' and contains(@d,'M12 3.2c-4')]")).click();
//driver.findElement(By.xpath("//div[@class='truncate-special col'][contains(text(),'AkshatKitDemo')]")).click();

WebDriverWait wait=new WebDriverWait(driver,20);

wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='plus-button v-btn v-btn--fab v-btn--flat v-btn--round v-btn--text theme--light v-size--default']//i[@class='icon']//*[local-name()='svg']")));

btnplus.click();
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='truncate-special col'][contains(text(),'AkshatKitDemo')]")));
driver.findElement(By.xpath("//div[@class='truncate-special col'][contains(text(),'AkshatKitDemo')]")).click();


	}

}
