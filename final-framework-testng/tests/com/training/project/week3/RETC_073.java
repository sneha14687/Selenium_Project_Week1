//To Verify whether application allows multiple user to send the query in Contact Form Page & data should get displayed in database
package com.training.project.week3;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders_71;
import com.training.pom.LoginPOM_Week3_RETC;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_073 {
	private static WebDriver driver;
	private static String baseUrl;
	private static LoginPOM_Week3_RETC loginPOM;
	private static Properties properties;
	private String yourname;
	private String yourmail;
	private String yoursubject;
	private String yourmessage;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM_Week3_RETC(driver);
		baseUrl = properties.getProperty("baseURL");
		// open the browser
		driver.get(baseUrl);

	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders_71.class)
	public void launch(String your_name, String your_mail, String your_subject, String your_message) {
		loginPOM.launchNew();
		driver.navigate().forward();
		loginPOM.RETC_051_3();
		driver.navigate().forward();
		//Enter details in Enquiry
		yourname = loginPOM.sendName("ssk");
		yourmail = loginPOM.sendEmail("ssk@gmail.com");
		yoursubject = loginPOM.sendSubject("asdfas");
		yourmessage = loginPOM.sendMessage("sdfsdfsd");
		loginPOM.clickSend();
		//Assertions
		Assert.assertEquals(your_name, yourname);
		Assert.assertEquals(your_mail, yourmail);
		Assert.assertEquals(your_subject, yoursubject);
		Assert.assertEquals(your_message, yourmessage);
		//Printing searched value
		System.out.println("Username is found: "+ yourname);
		System.out.println("Associated Mail is: "+ yourmail);
		System.out.println("Associated Subject is: "+ yoursubject);
		System.out.println("Associated Message is: "+ yourmessage);
	}

}