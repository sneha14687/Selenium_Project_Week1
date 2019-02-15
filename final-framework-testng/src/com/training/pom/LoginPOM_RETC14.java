package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM_RETC14 {
	private WebDriver driver; 


	public LoginPOM_RETC14(WebDriver driver) {
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
	
	@FindBy(linkText="Generate Password")
	private WebElement genPass;
	
	@FindBy(id="pass1-text")
	private WebElement newPass;
	
	@FindBy(linkText="Hide password")
	private WebElement hidePass;
	
	@FindBy(linkText="Show password")
	private WebElement showPass;
	
	@FindBy(id="submit")
	private WebElement updateProfile;
	
	@FindBy(xpath="//*[@id=\"wp-admin-bar-my-account\"]/a")
	private WebElement howdy;
	
	@FindBy(xpath="//*[@id=\"wp-admin-bar-logout\"]/a")
	private WebElement logout;
	
	//@FindBy(partialLinkText="Log")
	//private WebElement logout;
	
	
	public void logout() {
		Actions action = new Actions(driver);
		action.moveToElement(logout).build().perform();
		this.logout.click();
	}
	
	public void howdyAdmin() {
		Actions action = new Actions(driver);
		action.moveToElement(howdy).build().perform();
	}
	
	public void updateProfile() {
		this.updateProfile.click();
	}
	public void showPassword() {
		this.showPass.click();
	}
	
	public void hidePassword() {
		this.hidePass.click();
	}
	public void genPassword() {
		this.genPass.click();
	}
	
	public void newPassword(String newPass) {
		this.newPass.clear();
		this.newPass.sendKeys(newPass);
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
