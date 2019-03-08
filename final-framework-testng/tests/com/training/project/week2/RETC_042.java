//To verify whether application displays added post in all post 
package com.training.project.week2;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM_Week2_RETC;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class RETC_042 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM_Week2_RETC loginPOM;
	private static Properties properties;
	private ScreenShot screenshot;
	
	@Test
	public void f() {
		loginPOM.posts();
		System.out.println("Post is found....");
		driver.navigate().forward();
		loginPOM.addNewPost();
		System.out.println("New post is getting added....");
		driver.navigate().forward();
		loginPOM.sendPostTitle("VSK Launches");
		loginPOM.insideBodyContent(" VSK Launch in Home");
		loginPOM.defaultFrame();
		loginPOM.publishPost();
		System.out.println("New post is added and published....");
		driver.navigate().forward();
		loginPOM.viewPublishPost();
		loginPOM.viewAllPosts();
		driver.navigate().to("http://realestate.upskills.in/wp-admin/edit.php");
		loginPOM.launchPost();
		loginPOM.visiblePost();
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
		//driver.quit();
	}

}
