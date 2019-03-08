//To Verify whether application allows the admin to logout from the application
package com.training.project.week1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.pom.LoginPOM_RETC14;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_015 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM_RETC14 loginPOM;
	private static Properties properties;
	private String expectedUrl;
	private String actualUrl;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM_RETC14(driver);
		baseUrl = properties.getProperty("baseURL");

		// open the browser
		driver.get(baseUrl);
		loginPOM.clickRegisterBtn();
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		actualUrl = driver.getCurrentUrl();
		System.out.println("Logged out successfull.."+ actualUrl);
//		driver.quit();
	}

	@Test(priority = 1)
	public void validTest() throws Exception {
		driver.get("http://realestate.upskills.in/my-profile/");
		loginPOM.sendUname("admin");
		loginPOM.sendPass("admin@123");
		loginPOM.clickSubmitBtn();
		driver.navigate().forward();
		loginPOM.clickUsers();
		driver.navigate().forward();
		loginPOM.howdyAdmin();
		loginPOM.logout();
		/*expectedUrl = "http://realestate.upskills.in/my-profile/";
		actualUrl = driver.getCurrentUrl();
		// assertEquals(actualMsg, expectedMsg);
		Assert.assertTrue(actualUrl.contains(expectedUrl));
		System.out.println("Logged out successfully...");*/

	}

}
