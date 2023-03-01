package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class AdminHomePage {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	public AdminHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//li[@class='nav-item dropdown']")
	WebElement admin;
	
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")
	WebElement logoutButton;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-money-bill-alt']")
	WebElement manageExpence;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/expense-category']")
	WebElement expenceCategory;
	
	@FindBy(xpath="//h1[text()='Expense Category']")
	WebElement pageObject;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-merchant']")
	WebElement createMerchant;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page']//i[@class='fas fa-arrow-circle-right']")
	WebElement managePages;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']//i[@class='fas fa-arrow-circle-right']")
	WebElement adminUser;
	public void clickOnAdmin() {
		admin.click();
	}
	
	public String clickOnLogoutButton() {
		logoutButton.click();
		return driver.getCurrentUrl();
	}
	public void clickOnManageExpenceTab() {
		manageExpence.click();
	}
	public String clickOnExpenceCategoryTab() {
		expenceCategory.click();
		return  gu.getElementText(pageObject);
	}
	public String clickOnCreateMerchantTab() {
		createMerchant.click();
		String s=driver.getTitle();
		System.out.println(s);
		return s;
	}
	public String clickOnManagePages() {
		managePages.click();
		return driver.getCurrentUrl();
	}
	public void clickOnAdminUserTab() {
		adminUser.click();
	}
}

