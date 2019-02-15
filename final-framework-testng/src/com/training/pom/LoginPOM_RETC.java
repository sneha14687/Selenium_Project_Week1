package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM_RETC {
	private WebDriver driver; 
	
	
	public LoginPOM_RETC(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Log In")
	private WebElement login;
	
	@FindBy(linkText="Lost Your Password?")
	private WebElement passLink;
	
	@FindBy(id="user_login")
	private WebElement userLogin;
	
	@FindBy(name="submit")
	private WebElement resetPass;
	
	@FindBy(id="last_name")
	private WebElement lastName;
	
	@FindBy(id="phone")
	private WebElement phoneNo;
	
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

	
	@FindBy(xpath="//*[@id=\"responsive\"]/li[8]/a")
	private WebElement login_link; 
	
	@FindBy(id="user_login")
	private WebElement username;
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement login_btn;
	
	public void clickResetPass() {
		this.resetPass.click();
	}
	public void clickLoginBtn() {
		this.login_link.click();
	}
		public void clickLogin() {
		this.login.click();
	}
	public void clickPassLink() {
		this.passLink.click();
	}
	public String clickUserLogin(String userLogin) {
		this.userLogin.clear();
		this.userLogin.sendKeys(userLogin);
		return userLogin;
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
