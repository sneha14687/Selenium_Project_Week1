package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM_RETC13 {
	private WebDriver driver; 


	public LoginPOM_RETC13(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id=\"responsive\"]/li[8]/a")
	private WebElement login_link; 

	@FindBy(id="user_login")
	private WebElement username;

	@FindBy(id="user_pass")
	private WebElement password;

	@FindBy(name="login")
	private WebElement login_btn;

	@FindBy(linkText="Users")
	private WebElement users;

	@FindBy(linkText="Your Profile")
	private WebElement editProfile;
	
	@FindBy(id="last_name")
	private WebElement lastName;
	
	@FindBy(id="phone")
	private WebElement phoneNo;
	
	@FindBy(id="submit")
	private WebElement updateProfile;
	
	public void updateProfile() {
		this.updateProfile.click();
	}
	
	public void updatePhoneNo(String phoneNo) {
		this.phoneNo.clear();
		this.phoneNo.sendKeys(phoneNo);
	}
	
	public void updateLastName(String lastName) {
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}
	public void editProfile() {
		this.editProfile.click();
	}
	public void clickUsers() {
		this.users.click();
	}
	public void clickRegisterBtn() {
		this.login_link.click();
	}
	public void clickSubmitBtn() {
		this.login_btn.click(); 
	}
	public void sendUname(String username) {
		this.username.clear();
		this.username.sendKeys(username);
	}
	public void sendPass(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

}
