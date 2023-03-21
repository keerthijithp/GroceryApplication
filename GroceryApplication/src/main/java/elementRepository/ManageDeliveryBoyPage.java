package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class ManageDeliveryBoyPage {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	ExplicitWait ew=new ExplicitWait();
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[6]")
	WebElement status;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[2]")
	List<WebElement> email;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tr//td[8]//i[@class='fas fa-trash-alt']")
	WebElement deleteButton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Deliveryboy/add']")
	WebElement newButton;
	@FindBy(id="name")
	WebElement name;
	@FindBy(id="email")
	WebElement emailField;
	
	@FindBy(id="phone")
	WebElement phone;
	@FindBy(xpath="//button[@class='btn btn-danger']")
	WebElement save;
	public String getBagroundColourOfsearchButton() {
		return gu.getBackgroundColourOfaButton(searchButton, "background-color");
	}
	
	public void getLocator() throws InterruptedException {
		int index=gu.getTableLocatorValue(email, "trudie777@gmail.com");
		String locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+(index+1)+"]//td[6]//span";
				
		WebElement StatusLink=driver.findElement(By.xpath(locator));
		Thread.sleep(3000);
		StatusLink.click();
		
	}
	public String getTextOfAlertMessage() {
		return gu.getElementText(alert);
	}
	public String getLocatorforDeleteButton() {
		int index=gu.getTableLocatorValue(email, "trudie777@gmail.com");
		String locator="//table[@class='table table-bordered table-hover table-sm']//tr["+(index+1)+"]//td[8]//i[@class='fas fa-trash-alt']";
		WebElement delete=driver.findElement(By.xpath(locator));
		ew.elementToBeClickable(driver, delete);
		delete.click();
		String s= driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();
		return s;
		
		
		
	}
	public String getTextOFnewButton() {
		return gu.getElementText(newButton);
	}
	public String getBGColorOfNEWButton() {
		return gu.getBackgroundColourOfaButton(newButton, "background-color");
		
		
	}
	public void clickOnsave() {
		save.submit();
	}
	public boolean getErrorMessage(String text) {
		boolean actual=gu.getExpectedResultAlert(alert, text);
		return text.contains(text);
	}
}
