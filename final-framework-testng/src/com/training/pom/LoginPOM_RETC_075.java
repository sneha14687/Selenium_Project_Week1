package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPOM_RETC_075 {
	private WebDriver driver; 

	public LoginPOM_RETC_075(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	//Find and mouseover on "Posts" link
	@FindBy(linkText="Posts")
	private WebElement posts;

	public void mouseoverPost() {
		Actions action = new Actions(driver);
		action.moveToElement(posts).build().perform();
	}

	//Clicking on Add new link inside Posts	
	@FindBy(linkText="Add New")
	private WebElement addNew;

	public void addNewPost() {
		Actions actionpost = new Actions(driver);
		actionpost.moveToElement(addNew);
		this.addNew.click();
	}

	//Add new category inside posts
	@FindBy(linkText="+ Add New Category")
	private WebElement addNewCat;

	public void addNewCat() {
		this.addNewCat.click();
	}

	//Add text inside category textbox
	@FindBy(id="newcategory")
	private WebElement newCat;

	public void newCat(String newCat) {
		this.newCat.sendKeys(newCat);
		
	}

	//Add text inside category textbox
	public void addParentCategory() {
		Select parentRegion = new Select(driver.findElement(By.id("newcategory_parent")));
		parentRegion.selectByVisibleText("New Launches");

		List<WebElement> we_List = parentRegion.getOptions();
		for(int index = 0; index < we_List.size(); index++){
			String value = we_List.get(index).getText();
			System.out.println(value);
		}	
	}
	
	//Click to add new category in posts page
	@FindBy(id="category-add-submit")
	private WebElement newCatButton;
	
	public void addNewCatButton() {
		this.newCatButton.click();
	}
	
	//Click on checkbox for post added
	@FindBy(id="in-category-325")
	private WebElement newLaunch;
	
	public void selectNewLaunch() {
		this.newLaunch.click();
	}
	
	//Enter title into posts -> add new
		@FindBy(name="post_title")
		private WebElement post_title;

		public String sendPostTitle(String post_title) {
			this.post_title.clear();
			this.post_title.sendKeys(post_title);
			return post_title;
		}
	
	//Click on admin for logout to display
	@FindBy(partialLinkText="Howdy")
	private WebElement howdy;
	
	public void mouseoverHowdy() {
		Actions action = new Actions(driver);
		action.moveToElement(howdy).build().perform();
	}
	
	//Click on logout
	@FindBy(linkText="Log Out")
	private WebElement logOut;
	
	public void logOut() {
		this.logOut.click();
	}

	//Click on RealEstate
	@FindBy(id="logo")
	private WebElement logoRealEstate;
	
	public void clickLogo() {
		this.logoRealEstate.click();
	}
	
	//Search for newly added post
	public void searchPost() {
		Select post = new Select(driver.findElement(By.xpath("//div[@class='slick-track']//div//div//div//h3//a[@class='rpc-title']"+post_title)));
		post.selectByVisibleText("vihar14687");
	}
	
	
}