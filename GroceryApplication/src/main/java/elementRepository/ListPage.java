package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ListPage {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	public ListPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	
	@FindBy(xpath="//input[@class='form-control']")
	WebElement title;
	
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	WebElement searchButtonRed;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	WebElement searchResult;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	
	@FindBy(xpath="//div[@class='note-editable card-block']")
	WebElement description;
	
	@FindBy(id="title")
	WebElement titleInNew;
	
	@FindBy(id="page")
	WebElement pageName;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	
	@FindBy(id="main_img")
	WebElement chooseFile;
	@FindBy(xpath="//button[@name='create']")
	WebElement saveButton;
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
	public void enterTitle(String titlename) {
		title.sendKeys(titlename);
		
	}
	public String clickOnSecondSearchButton() {
		searchButtonRed.click();
		return gu.getTextOfWebElement(searchResult);
	}
	public String getselectedItemFromSearchButton() {
		return searchResult.getText();
		
		
		
	}
	public void clickOnNewButton() {
		newButton.click();
	}
	public void enterTitle1(String s) {
		titleInNew.sendKeys(s);
	}
	public void enterDescription(String s) {
		description.sendKeys(s);
	}
	public void enterPageName(String s) {
		pageName.sendKeys(s);
	}
	public void clickOnchooseButton() {
		chooseFile.click();
	}
	public void uploadImage() throws AWTException {
		gu.uploadFile(driver, chooseFile, System.getProperty("user.dir")+"\\src\\main\\resources\\UploadImages\\cat.jpg");
		
	}
	public String clickSaveButton() throws InterruptedException {
		saveButton.click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		return gu.getElementText(alert);
	}
	
	
}
