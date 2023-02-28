package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelRead;
import utilities.GeneralUtilities;

public class PushNotificationPage {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	ExcelRead er=new ExcelRead();
	public PushNotificationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//i[@class='nav-icon fas fa-fas fa-bell']")
	WebElement pushNotification;
	
	@FindBy(id="title")
	WebElement title;
	
	@FindBy(id="description")
	WebElement description;
	
	@FindBy(xpath="//i[@class='fa fa-bell']")
	WebElement send;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-notifications'])[2]")
	WebElement resetButton;
	
	public void clickOnPushNotification() {
		pushNotification.click();
		
	}
	public void enterTitle(String s) {
		title.sendKeys(s);
		
	}
	public void enterdescription(String s) {
		description.sendKeys(s);

	}
	public String clickOnSendButton() {
		send.click();
		return gu.getTextOfWebElement(alertMessage);
	}
	public String clickOnResetButton() {
		resetButton.click();
		return gu.getTextOfWebElement(title);
	}
	
}
