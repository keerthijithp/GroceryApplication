package elementRepository;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class ManageSliderPage {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	ExplicitWait we=new ExplicitWait();
	public ManageSliderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-slider']//i[@class='fas fa-arrow-circle-right']")
WebElement manageSlider;

@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Slider/add']")
WebElement newButton;
@FindBy(id="main_img")
WebElement chooseFile;
@FindBy(id="link")
WebElement httpLink;
@FindBy(xpath="//button[@class='btn btn-danger']")
WebElement saveButton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
WebElement alert;
@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[3]")
WebElement status;
@FindBy(xpath="//i[@class='ace-icon fa fa-sync-alt']")
WebElement resetButton;

@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[2]")
List<WebElement> linkList;
public void clickOnManageSlider() {
	manageSlider.click();
}
public void clickOnNewButton() {
	newButton.click();
}
public void uploadImage() throws AWTException {
	gu.uploadFile(driver, chooseFile, System.getProperty("user.dir")+"\\src\\main\\resources\\UploadImages\\cat.jpg");
}
public void enterHttpLink(String s) {
	httpLink.sendKeys(s);
	saveButton.click();
}
public String getTextOfAlertMessage() {
	return gu.getElementText(alert);
}
public void getLocator() throws InterruptedException {
	int index=gu.getTableLocatorValue(linkList, "abcd");
	String locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+(index+1)+"]//td[3]//a//span";
	
	WebElement link=driver.findElement(By.xpath(locator));
	//we.Stalenesswait(driver, Link);
	Thread.sleep(3000);
	link.click();
	
}
public String getResetBtnBgColor() {
	return gu.getBackgroundColourOfaButton(resetButton, "background-color");
}
public boolean getErrorMessage(String text) {
	boolean actual=gu.getExpectedResultAlert(alert, text);
	return text.contains(text);
}
}
