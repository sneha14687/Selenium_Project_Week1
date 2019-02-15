package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM_RETC12 {
	private WebDriver driver; 
	
	
	public LoginPOM_RETC12(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"responsive\"]/li[8]/a")
	private WebElement login_link; 
	
	@FindBy(linkText="Log In")
	private WebElement login;
	
	@FindBy(linkText="Lost Your Password?")
	private WebElement passLink;
	
	@FindBy(id="user_login")
	private WebElement userLogin;
	
	@FindBy(name="submit")
	private WebElement resetPass;
	
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
	
	
}
