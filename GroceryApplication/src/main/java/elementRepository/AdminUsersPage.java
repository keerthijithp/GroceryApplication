package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class AdminUsersPage {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
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
	@FindBy(xpath="//button[@type='submit']//i[@class='fa fa-save']")
	WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	
	public String getLocator() {
		int index=gu.getTableLocatorValue(userName, "dav24_02_2023_10_07_21");
		String locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+(index+1)+"]//td[3]//a//span";
		return locator;
	}
	public void clickOnNewButton() {
		newButton.click();
	}
	public void enterUserName() {
		username.sendKeys("Keerthidddd");
		
	}
	public void enterPassword() {
		password.sendKeys("123");
	}
	public String selectUserTypeFromDropDown() {
		return gu.selectValueFromDropDown(useType, "admin");
	}
	public String clickSaveButton() {
		saveButton.click();
		return gu.getTextOfWebElement(alert);
	}
}

