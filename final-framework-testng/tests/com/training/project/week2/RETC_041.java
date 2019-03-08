//To verify whether application display comments added by the user in admin page
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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class RETC_041 {
	private WebDriver driver;
	private String baseUrl;
	private String adminURL;
	private LoginPOM_Week2_RETC loginPOM;
	private static Properties properties;
	private ScreenShot screenshot;
	private String expected;
	private String actual;
	
	@Test
	public void f() throws Exception {
		driver.navigate().forward();
		loginPOM.readMore();
		System.out.println("Blog is found....");
		driver.navigate().forward();
		loginPOM.addBlogComment("Blog is updated");
		loginPOM.postBlogComment();
		Thread.sleep(3000);
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM_Week2_RETC(driver); 
		adminURL = properties.getProperty("adminURL");
		driver.get(adminURL);
		loginPOM.sendUname("admin");
		loginPOM.sendPass("admin@123");
		loginPOM.clickSubmitBtn();
		driver.navigate().forward();
		loginPOM.checkComment();
		expected = "Blog is updated";
		actual = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/form/table/tbody[1]/tr[1]/td[2]/p")).getText(); 
		assertEquals(actual, expected);
		System.out.println("Comment added is -"+actual);
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
		loginPOM.clickBlog();
	}

	@AfterClass
	public void afterClass() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}
