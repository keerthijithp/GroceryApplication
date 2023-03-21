package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import testCases.JavascriptExecutor;
import org.openqa.selenium.JavascriptExecutor;
import utilities.ExcelRead;
import utilities.GeneralUtilities;

public class ManageOfferCode {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	ExcelRead er=new ExcelRead();
	public ManageOfferCode(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-offercode']//i[@class='fas fa-arrow-circle-right']")
	WebElement ManageOfferCode;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath="//input[@name='un']")
	WebElement typeOfferCode;
	@FindBy(xpath="//button[@name='Search']")
	WebElement searchButtonRed;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	WebElement searchResult;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Offercode/add']")
	WebElement newButton;
	@FindBy(id="offer_code")
	WebElement offerCode;
	@FindBy(xpath="//input[@name='type']")
	WebElement firstOrder;
	@FindBy(id="offer_per")
	WebElement offerPercentage;
	@FindBy(id="offer_price")
	WebElement offerprice;
	@FindBy(xpath="//div[@class='note-editable card-block']")
	WebElement description;
	@FindBy(id="main_img")
	WebElement chooseFile;
	@FindBy(xpath="//button[@name='create']")
	WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	public void clickOnManageOfferCode() {
		ManageOfferCode.click();
		
	}
	public void clickOnSearchButton() {
		searchButton.click();
	}
	public void enterOfferCode(String s) {
		typeOfferCode.sendKeys(s);
	}
	public String clickOnSearchButtonRed() {
		searchButtonRed.click();
		return gu.getTextOfWebElement(searchResult);
	}
	public void clickOnNewButton() {
		newButton.click();
	}
	public void enterOfferCodeforNewOffer(String s) {
		offerCode.sendKeys(s);
	}
	public void selectcheckbox() {
		firstOrder.click();
		
	}
	public void enterOfferPercentage(String s) {
		offerPercentage.sendKeys(s);
	}
	public void enterOfferPrice(String s) {
		offerprice.sendKeys(s);
	}
	public void enterDescription(String s) {
		description.sendKeys(s);
	}
	public void uploadFile() throws AWTException {
		
		gu.uploadFile(driver, chooseFile, System.getProperty("user.dir")+"\\src\\main\\resources\\UploadImages\\cat.jpg");
	}
	public String clickSaveButton() throws InterruptedException {
		
		saveButton.submit();
		Thread.sleep(5000);
		return gu.getElementText(alert);
	}
	public boolean getErrorMessage(String text) {
		boolean actual=gu.getExpectedResultAlert(alert, text);
		return text.contains(text);
	}
}
