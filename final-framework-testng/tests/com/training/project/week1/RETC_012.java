package com.training.project.week1;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.pom.LoginPOM_RETC;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_012 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM_RETC loginPOM;
	private static Properties properties;
	private String email;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM_RETC(driver); 
		baseUrl = properties.getProperty("baseURL");

		// open the browser 
		driver.get(baseUrl);
		loginPOM.clickLoginBtn();
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test(priority=1)
	public void validLoginTest() throws Exception {
		driver.get("http://realestate.upskills.in/my-profile/");
		loginPOM.clickLogin();
		Thread.sleep(2000);
		loginPOM.clickPassLink();
		driver.navigate().forward();
		//driver.get("http://realestate.upskills.in/lost-password/");
		email = loginPOM.clickUserLogin("sneha14687@gmail.com");
		loginPOM.clickResetPass();
		System.out.println("Password reset request is sent to mail: "+email);

	}




}
