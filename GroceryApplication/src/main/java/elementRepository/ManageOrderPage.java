package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageOrderPage {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	public ManageOrderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-order']")
	WebElement manageOrder;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath="//select[@id='st']")
	WebElement status;
	public void clickOnManageOrderTab() {
		manageOrder.click();
	}
	public String getBagroundColr() {
		return gu.getBackgroundColourOfaButton(searchButton, "background-color");
		
	}
	public void clickOnsearchButtoninManageOrderPage() {
		searchButton.click();
	}
	public String selectDropdownForStatusField() {
		return gu.selectValueFromDropDown(status, "UnPaid");
	}
}
