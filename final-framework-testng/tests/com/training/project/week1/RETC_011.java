package com.training.project.week1;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM_RETC;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_011 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM_RETC loginPOM;
	private static Properties properties;
	private String expectedUrl;
	private String actualUrl;
	private boolean result;
	private ScreenShot screenshot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM_RETC(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenshot = new ScreenShot(driver);
		screenshot.captureScreenShot("URL");
		// open the browser 
		driver.get(baseUrl);
		loginPOM.clickRegisterBtn();
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test(priority=1)
	public void validLoginTest() {
		driver.get("http://realestate.upskills.in/my-profile/");
		loginPOM.sendUname("admin");
		loginPOM.sendPass("admin@123");
		loginPOM.clickSubmitBtn(); 
		expectedUrl = "http://realestate.upskills.in/wp-admin/";
		//String expectedTitle ="Dashboard ‹ Real Estate — WordPress";
		actualUrl = driver.getCurrentUrl();
		//actualTitle = driver.getTitle();//.findElement(By.linkText("manzoormehadi26@gmail.com")).getText();
		//assertEquals(actualUrl, expectedUrl);
		//System.out.println("Login is successful: " + actualUrl); 
		Assert.assertEquals(actualUrl, "http://realestate.upskills.in/wp-admin/");
		//Assert.assertTrue(actualUrl.contains(expectedUrl));
	}




}
