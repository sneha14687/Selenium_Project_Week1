package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPOM_Week2_RETC {
	private WebDriver driver;

	public LoginPOM_Week2_RETC(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Finding and clicking on Posts
	@FindBy(linkText="Posts")
	private WebElement post;

	public void posts() {
		this.post.click();
	}

	//Clicking on Add new link inside Posts	
	@FindBy(linkText="Add New")
	private WebElement addNew;

	public void addNewPost() {
		Actions actionpost = new Actions(driver);
		actionpost.moveToElement(addNew);
		this.addNew.click();
	}

	//Click on blog inside admin
	@FindBy(linkText="Blog")
	private WebElement blog;

	public void clickBlog() {
		this.blog.click();
	}

	//Click on readmore link
	@FindBy(xpath = "/html/body/div[1]/div[4]/div/div/div[1]/div[1]/div/a")
	private WebElement readMore;

	@FindBy(linkText = "New Launch")
	private WebElement newLaunch;
	
	public void readMore() {
		Actions action = new Actions(driver);

		if (newLaunch.isDisplayed()) {
			action.moveToElement(readMore);	
			this.readMore.click();
		}
	}
	
	//Add comment inside blog
	@FindBy(xpath="//div//form//p//textarea[@id='comment']")
	private WebElement blogComment;
	
	public void addBlogComment(String blogComment) {
		this.blogComment.clear();
		this.blogComment.sendKeys(blogComment);
	}
	
	//Post comment
	@FindBy(xpath="//div//form//p//input[@id='submit']")
	private WebElement postComment;
	
	public void postBlogComment() {
		this.postComment.click();
	}
	
	//Check comment added by admin
	@FindBy(xpath="/html/body/div[1]/div[1]/div[2]/ul/li[7]/a/div[3]")
	private WebElement comment;
	
	public void checkComment() {
		this.comment.click();
	}

	//Logging into realstate
	@FindBy(xpath="//*[@id=\"responsive\"]/li[8]/a")
	private WebElement login_link; 

	public void clickRegisterBtn() {
		this.login_link.click();
	}

	//Enter username - admin
	@FindBy(id="user_login")
	private WebElement username;

	public void sendUname(String username) {
		this.username.clear();
		this.username.sendKeys(username);
	}

	//Enter password - admin@123
	@FindBy(id="user_pass")
	private WebElement password;

	public void sendPass(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

	//Press login button
	@FindBy(name="login")
	private WebElement login_btn;

	public void clickSubmitBtn() {
		this.login_btn.click(); 
	}

	//Enter title into posts -> add new
	@FindBy(name="post_title")
	private WebElement post_title;

	public void sendPostTitle(String post_title) {
		this.post_title.clear();
		this.post_title.sendKeys(post_title);
	}

	//Enter contents into posts -> add new
	@FindBy(xpath = "//iframe[@title='Rich Text Area. Press Alt-Shift-H for help.']")
	private WebElement postContent;

	public void insideFrame() {

		driver.switchTo().frame(postContent);
	}

	// Writing text inside the frame body of Posts
	@FindBy(xpath = "//body[@contenteditable='true']")
	private WebElement insertTextContent;

	public void insideBodyContent(String insertTextContent) {
		this.insertTextContent.clear();
		this.insertTextContent.sendKeys(insertTextContent);
	}

	// setting frame to default
	public void defaultFrame() {

		driver.switchTo().defaultContent();
	} 

	//Click on publish button after new post is added
	@FindBy(name="publish")
	private WebElement post_publish;

	public void publishPost() {
		this.post_publish.click();
	}

	//View post
	@FindBy(linkText="View post")
	private WebElement viewPost;

	public void viewPublishPost() {
		Actions viewpost = new Actions(driver);
		viewpost.moveToElement(viewPost);
		this.viewPost.getText();
	}

	//View all posts
	@FindBy(linkText="All Posts")
	private WebElement allPost;

	public void viewAllPosts() {
		Actions viewAllPosts = new Actions(driver);
		viewAllPosts.moveToElement(allPost);
		this.allPost.click();
	}

	public void launchPost() {
		if (post_title.isDisplayed()) {
			Actions action = new Actions(driver);
			action.moveToElement(post_title);	
			this.post_title.click();
		}
	}

	//To check if added post is visible
	public void visiblePost() {
		if (post_title.isDisplayed()) {
			Actions action = new Actions(driver);
			action.moveToElement(post_title);	
			System.out.println(post_title + " is displayed");
		}
	}

	//RECT_043
	//Click on Properties link
	@FindBy(linkText="Properties")
	private WebElement properties;

	public void clickProperties() {
		this.properties.click();
	}

	//Add new property in Properties link
	@FindBy(linkText="Add New")
	private WebElement addNewProperty;

	public void addNewProperty() {
		this.addNewProperty.click();
	}

	//Add title on properties page
	@FindBy(id="title")
	private WebElement propertyTitle;

	public void sendPropertyTitle(String propertyTitle) {
		this.propertyTitle.clear();
		this.propertyTitle.sendKeys(propertyTitle);
	}

	//Enter contents into new property
	@FindBy(id="content")
	private WebElement propertyContent;

	/*public void insideFrame() {

			driver.switchTo().frame(postContent);
		}

		// Writing text inside the frame body of Posts
		@FindBy(xpath = "//body[@contenteditable='true']")
		private WebElement insertTextContent;

		public void insideBodyContent(String insertTextContent) {
			this.insertTextContent.clear();
			this.insertTextContent.sendKeys(insertTextContent);
		}

		// setting frame to default
		public void defaultFrame() {

			driver.switchTo().defaultContent();
		} */

	public void sendPropertyContent(String propertyContent) {
		this.propertyContent.clear();
		this.propertyContent.sendKeys(propertyContent);
	}

	//Click on publish button after new property is added
	@FindBy(xpath="//div//input[@class='button button-primary button-large']")
	private WebElement propertypublish;

	public void propertyPublish() {
		this.propertypublish.click();
	}
	//-----------------------------TC044-----------------------
	//Click on Feature link
	@FindBy(linkText="Features")
	private WebElement addFeatures;

	public void addFeaturesProperty() {
		this.addFeatures.click();
	}

	//Add feature name inside Properties
	@FindBy(xpath="//div//input[@id='tag-name']")
	private WebElement addFeatureName;
	public String newName;

	public void addFeatureName(String addFeatureName) {
		this.addFeatureName.clear();
		this.addFeatureName.sendKeys(addFeatureName);
		newName = this.addFeatureName.getAttribute("value");
		System.out.println("New Feature name is: "+newName);
	}

	//Add feature slug inside properties
	@FindBy(xpath="//div//input[@id='tag-slug']")
	private WebElement addFeatureSlug;

	public void addFeatureSlug(String addFeatureSlug) {
		this.addFeatureSlug.clear();
		this.addFeatureSlug.sendKeys(addFeatureSlug);
	}

	//Add feature description inside properties
	@FindBy(xpath="//div//textarea[@id='tag-description']")
	private WebElement addFeatureDesc;

	public void addFeatureDescription(String addFeatureDesc) {
		this.addFeatureDesc.clear();
		this.addFeatureDesc.sendKeys(addFeatureDesc);			
	}

	//Click on add new feature button inside properties
	@FindBy(xpath="//p//input[@name='submit']")
	private WebElement clickNewFeature;

	public void addNewFeature() {
		this.clickNewFeature.click();
	}

	//Click on checkbox for newly added feature
	public void checkboxFeature() {
		String before="//div//ul//li//lable//input[contains(text(),'";
		String after="')]/preceding-sibling::input";
		String xpathname = before+newName+after;
		driver.findElement(By.xpath(xpathname)).click();
	}

	//---------------------------TC045-------------------------
	//Click on Feature link
	@FindBy(linkText="Regions")
	private WebElement addRegion;

	public void addRegionProperty() {
		this.addRegion.click();
	}

	//Add region name inside Properties
	@FindBy(xpath="//div//input[@id='tag-name']")
	private WebElement addRegionName;
	public String newRName;

	public void addRegionName(String addRegionName) {
		this.addRegionName.clear();
		this.addRegionName.sendKeys(addRegionName);
		newName = this.addRegionName.getAttribute("value");
		System.out.println("New Feature name is: "+newRName);
	}

	//Add feature slug inside properties
	@FindBy(xpath="//div//input[@id='tag-slug']")
	private WebElement addRegionSlug;

	public void addRegionSlug(String addRegionSlug) {
		this.addRegionSlug.clear();
		this.addRegionSlug.sendKeys(addRegionSlug);
	}

	//Add feature description inside properties
	@FindBy(xpath="//div//textarea[@id='tag-description']")
	private WebElement addRegionDesc;

	public void addRegionDescription(String addRegionDesc) {
		this.addRegionDesc.clear();
		this.addRegionDesc.sendKeys(addRegionDesc);			
	}

	//Select parent region inside region of properties
	public void addParentRegion() {
		Select parentRegion = new Select(driver.findElement(By.name("parent")));
		parentRegion.selectByVisibleText("Apartments");

		List<WebElement> we_List = parentRegion.getOptions();
		for(int index = 0; index < we_List.size(); index++){
			String value = we_List.get(index).getText();
			System.out.println(value);
		}

	}

	//Click on add new region button inside properties
	@FindBy(xpath="//p//input[@name='submit']")
	private WebElement clickNewRegion;

	public void addNewRegion() {
		this.clickNewRegion.click();
	}

	//Click on checkbox for newly added region
	public void checkboxRegion() {
		String before="//div//ul//li//lable//input[contains(text(),'";
		String after="')]/preceding-sibling::input";
		String xpathname = before+newRName+after;
		driver.findElement(By.xpath(xpathname)).click();
	}
}
