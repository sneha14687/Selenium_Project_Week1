//To Verify whether application allows the admin to change the profile details
package com.training.project.week1;


import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.pom.LoginPOM_RETC13;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_013 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM_RETC13 loginPOM;
	private static Properties properties;
	private String expectedMsg;
	private String actualMsg;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM_RETC13(driver); 
		baseUrl = properties.getProperty("baseURL");

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
	public void validLoginTest() throws Exception {
		driver.get("http://realestate.upskills.in/my-profile/");
		loginPOM.sendUname("admin");
		loginPOM.sendPass("admin@123");
		loginPOM.clickSubmitBtn();
		driver.navigate().forward();
		loginPOM.clickUsers();
		driver.navigate().forward();
		loginPOM.editProfile();
		loginPOM.updateLastName("Kumbhar");
		loginPOM.updatePhoneNo("9767416382");
		loginPOM.updateProfile();
		expectedMsg = "Profile updated.";
		actualMsg = driver.findElement(By.id("message")).getText();
//		assertEquals(actualMsg, expectedMsg);
		Assert.assertTrue(actualMsg.contains(expectedMsg));
		System.out.println("Profile updated successfully...");

	}




}
