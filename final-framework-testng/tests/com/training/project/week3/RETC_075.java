//To verify whether application allows admin to add new category while adding new post & same getting displayed on home screen for user
package com.training.project.week3;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM_RETC_075;
import com.training.pom.LoginPOM_Week2_RETC;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_075 {

	private WebDriver driver;
	private String baseUrl;
	private String adminURL;
	private LoginPOM_RETC_075 loginPOM;
	private LoginPOM_Week2_RETC loginAdmin;
	private static Properties properties;
	private ScreenShot screenshot;
	private String expected;
	private String actual;

	@Test
	public void f() {
		loginPOM.mouseoverPost();
		System.out.println("Post is found....");
		driver.navigate().forward();
		loginPOM.addNewPost();
		System.out.println("New post is getting added....");
		driver.navigate().forward();
		loginPOM.addNewCat();
		System.out.println("New category is getting added....");
		loginPOM.newCat("posts");
		loginPOM.addParentCategory();
		loginPOM.addNewCatButton();
		//Posts page is getting refreshed
		driver.navigate().refresh();
		loginPOM.sendPostTitle("vihar14687");
		loginAdmin.insideBodyContent(" New Launch in Plots");
		loginAdmin.defaultFrame();
		loginPOM.selectNewLaunch();
		loginAdmin.publishPost();
		System.out.println("New post is added and published....");
		driver.navigate().forward();
		loginAdmin.viewPublishPost();
		loginPOM.mouseoverHowdy();
		loginPOM.logOut();
		driver.navigate().to("http://realestate.upskills.in/my-profile/");
		loginPOM.clickLogo();
		loginPOM.searchPost();
		expected = "vihar14687";
		actual = driver.findElement(By.xpath("//div[@class='slick-track']//div//div//div//h3//a[@class='rpc-title']"+expected)).getText(); 
		assertEquals(actual, expected);
		System.out.println("Comment added is -"+actual);
	}

	@BeforeClass
	public void beforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM_RETC_075(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenshot = new ScreenShot(driver);
		screenshot.captureScreenShot("baseURL");
		// open the browser 
		driver.get(baseUrl);
		loginAdmin.clickRegisterBtn();
		loginAdmin.sendUname("admin");
		loginAdmin.sendPass("admin@123");
		loginAdmin.clickSubmitBtn();
		driver.navigate().forward();
	}

	@AfterClass
	public void afterClass() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}  


}
