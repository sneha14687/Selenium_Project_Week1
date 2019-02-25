package com.training.project.week2;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM_Week2_RETC;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class RETC_043 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM_Week2_RETC loginPOM;
	private static Properties properties;
	private ScreenShot screenshot;
	private String expectedPost;
	private String actualPost;
	
	@Test
	public void f() {
		loginPOM.clickProperties();
		System.out.println("Properties are found....");
		//driver.navigate().to("http://realestate.upskills.in/wp-admin/edit.php?post_type=property");
		driver.navigate().forward();
		loginPOM.addNewProperty();
		System.out.println("New property is getting added....");
		//driver.navigate().to("http://realestate.upskills.in/wp-admin/post-new.php?post_type=property");
		driver.navigate().forward();
		loginPOM.sendPropertyTitle("New Launch");
		loginPOM.sendPropertyContent("New Launch");
		//loginPOM.defaultFrame();
		loginPOM.propertyPublish();
		System.out.println("New property is added and published....");
		//driver.navigate().to("http://realestate.upskills.in/wp-admin/post.php?post=3695&action=edit");
		driver.navigate().forward();
		loginPOM.viewPublishPost();
		driver.navigate().to("http://realestate.upskills.in/new-property/");
		expectedPost = "New property";
		actualPost = driver.getTitle();
		assertEquals(actualPost, expectedPost);
	}
	@BeforeClass
	public void beforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM_Week2_RETC(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenshot = new ScreenShot(driver);
		screenshot.captureScreenShot("baseURL");
		// open the browser 
		driver.get(baseUrl);
		loginPOM.clickRegisterBtn();
		loginPOM.sendUname("admin");
		loginPOM.sendPass("admin@123");
		loginPOM.clickSubmitBtn();
		driver.navigate().forward();
	}

	@AfterClass
	public void afterClass() throws Exception {
		Thread.sleep(1000);
//		driver.quit();
	}

}
