package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.RandomDataGenerartor;

public class AdminUsersPage {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	RandomDataGenerartor rg=new RandomDataGenerartor();
	public AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> userName;
	
	@FindBy(xpath="//a[@href='javascript:void(0)']//i[@class='fas fa-edit']")
	WebElement newButton;
	@FindBy(id="username")
	WebElement username;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="user_type")
	WebElement useType;
	@FindBy(xpath="//button[@name='Create']")
	WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td//i[@class='fas fa-trash-alt']")
	WebElement delete;
	
	
	public String getLocator() {
		int index=gu.getTableLocatorValue(userName, "dav24_02_2023_10_07_21");
		String locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+(index+1)+"]//td[3]//a//span";
		return locator;
	}
	public void clickOnNewButton() {
		newButton.click();
	}
	public void enterUserName(String s) {
		String randomString=rg.randomPassword();
		username.sendKeys(s+randomString);
		
	}
	public void enterPassword(String s) {
		password.sendKeys(s);
	}
	public String selectUserTypeFromDropDown(String type) {
		return gu.selectValueFromDropDown(useType, type);
	}
	public String clickSaveButton() throws InterruptedException {
		Thread.sleep(3000);
		saveButton.click();
		return gu.getTextOfWebElement(alert);
	}
	public String clickOnDeleteButton() throws InterruptedException {
		int index=gu.getTableLocatorValue(userName, "nnnn");
		String locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+(index+1)+"]//td//i[@class='fas fa-trash-alt']";
		WebElement deleteButton=driver.findElement(By.xpath(locator));
		Thread.sleep(3000);
		deleteButton.click();
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		return gu.getTextOfWebElement(alert);
		
	}
	public boolean getErrorMessage(String text) {
		boolean actual=gu.getExpectedResultAlert(alert, text);
		return text.contains(text);
	}
}

