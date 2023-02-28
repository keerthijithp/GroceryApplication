package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelRead;
import utilities.GeneralUtilities;

public class LoginPage {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	ExcelRead er=new ExcelRead();
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//b[text()='7rmart supermarket']")
	WebElement title7Mart;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement signInButton;
	
	@FindBy(xpath="//label[@for='remember']")
	WebElement rememberMe;
	
	@FindBy(id="remember")
	WebElement rememberMeCheckBox;
	
	@FindBy(xpath="//input[@name='username']")
	WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement error;
	
	public String getTextOfSignInButton() {
		//String text=signInButton.getText();
		//return text;
		return gu.getElementText(signInButton);
		
	}
	public Boolean selectRememberMeCheckbox() {
		return gu.selectCheckBox(rememberMe);
	}
	public String getUserNameFromExcel() throws IOException {
		return er.readStringData("Sheet1", 1, 0);
	}
	public String getPasswordFromExcel() throws IOException {
		return er.readStringData("Sheet1", 1, 1);
	}
	public void enterUserName(String user) {
		userName.sendKeys(user);
		
	}
	public void enterPassword(String pswd) {
		password.sendKeys(pswd);
	}
	public String clickLoginButton() {
		signInButton.click();
		return driver.getTitle();
	}
	public String getCurrentURLofLogin() {
		String currentUrl=driver.getCurrentUrl();
		return currentUrl;
		
	}
	public String loginwithInvalidCredentials() {
		return gu.getElementText(error);
	}
	
	public String getBackgroundColorOfSignIN() {
		return gu.getBackgroundColourOfaButton(signInButton);
	}
	public String getTextOf7MartSuperMarket() {
		
		return gu.getElementText(title7Mart);
	}
}
