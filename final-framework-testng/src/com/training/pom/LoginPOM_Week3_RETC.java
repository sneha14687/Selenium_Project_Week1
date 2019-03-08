package com.training.pom;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPOM_Week3_RETC {
	private WebDriver driver; 

	public LoginPOM_Week3_RETC(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	//Click on New Launch link
	@FindBy(id="menu-item-354")
	private WebElement newLaunch1;

	public void newLaunch() {
		this.newLaunch1.click();
	}

	//Cllick on RETC_051_3
	@FindBy(linkText="RETC_051_3")
	private WebElement RETC_051_3;

	public void RETC_051_3() {
		this.RETC_051_3.click();
	}

	//Enter name in Inquiry
	@FindBy(name="your-name")
	private WebElement yourName;

	public String sendName(String yourName) {
		this.yourName.clear();
		this.yourName.sendKeys(yourName);
		return yourName;
	}

	//Enter Email in Inquiry
	@FindBy(name="your-email")
	private WebElement Email;

	public String sendEmail(String Email) {
		this.Email.clear();
		this.Email.sendKeys(Email);
		return Email;
	}

	//Enter Subject in Inquiry
	@FindBy(name="your-subject")
	private WebElement Subject;

	public String sendSubject(String Subject) {
		this.Subject.clear();
		this.Subject.sendKeys(Subject);
		return Subject;
	}

	//Enter Subject in Inquiry
	@FindBy(name="your-message")
	private WebElement yourMessage;

	public String sendMessage(String yourMessage) {
		this.yourMessage.clear();
		this.yourMessage.sendKeys(yourMessage);
		return yourMessage;
	}

	//Click on Send button
	@FindBy(xpath="/html/body/div[1]/div[5]/div/div[2]/div[1]/div[2]/div/div[2]/form/p[5]/input")
	private WebElement send;

	public void clickSend() {
		this.send.click();
	}

	//Click on Users link
	@FindBy(xpath="/html/body/div[1]/div[1]/div[2]/ul/li[18]/a/div[3]")
	private WebElement users;

	public void mouseoverUsers() {
		Actions action = new Actions(driver);
		action.moveToElement(users).build().perform();
	} 

	//Click on All users
	@FindBy(linkText="All Users")
	private WebElement allUsers;

	public void clickAllUsers() {
		this.allUsers.click();
	}

	//Change role for User1
	@FindBy(id="user_166")
	private WebElement user1;

	public void changeRoleUser1() {
		this.user1.click();
	}

	//Click on NewLaunch tab
	@FindBy(id="menu-item-354")
	private WebElement newLaunch;

	public void launchNew() {
		this.newLaunch.click();
	}

	//Enter User for role change
	@FindBy(id="user_168")
	private WebElement user;

	public String setUser(String user) {
		this.user.clear();
		this.user.sendKeys(user);
		return user;
	}

	//Select role to change
	public void setRole(String newRole) {
		Select role = new Select(driver.findElement(By.id("new_role")));
		role.selectByVisibleText(newRole);

		List<WebElement> we_List = role.getOptions();
		for(int index = 0; index < we_List.size(); index++){
			String value = we_List.get(index).getText();
			System.out.println(value);
		}

	}

	//Click on change button
	@FindBy(id="changeit")
	private WebElement changeRole;
	
	public void changeRoleButton() {
		this.changeRole.click();
	}
}
