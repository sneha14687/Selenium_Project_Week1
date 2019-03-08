//To Verify whether application highlights required fields upon entering invalid details in  send the query in Contact Form Page
package com.training.project.week3;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders_71;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM_Week3_RETC;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_072 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM_Week3_RETC loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private String expected;
	private String actual;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM_Week3_RETC(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test(dataProvider = "excel-inputs1", dataProviderClass = LoginDataProviders_71.class)
	public void logiinEnquiry(String yourName, String Email, String Subject, String yourMessage) {
		loginPOM.newLaunch();
		driver.navigate().forward();
		loginPOM.RETC_051_3();
		driver.navigate().forward();
		//Enter details in Enquiry
		loginPOM.sendName(yourName);
		loginPOM.sendEmail(Email);
		loginPOM.sendSubject(Subject);
		loginPOM.sendMessage(yourMessage);
		loginPOM.clickSend();
		screenShot.captureScreenShot(yourName);
		expected = "There was an error trying to send your message. Please try again later.";
		actual = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div[2]/div[1]/div[2]/div/div[2]/form/div[2]")).getText();
		assertEquals(actual, expected);
		System.out.println(actual);
	}

}