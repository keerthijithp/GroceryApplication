package testCases;

import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import utilities.ExcelRead;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTestCases extends BaseClass {
	
	LoginPage lp;
	
  @Test
  public void verifyTheTextOfSignInButton() {
	  lp=new LoginPage(driver);
	  String actualResult=lp.getTextOfSignInButton();
	  String expectedResult="Sign In";
	  Assert.assertEquals(actualResult, expectedResult);
	  
	  
  }
  @Test(groups = {"Critical"} )
  public void verifyCheckboxRemeneberMeIsSelected() {
	  lp=new LoginPage(driver);
	  Boolean actualResult=lp.selectRememberMeCheckbox();
	  Boolean expectedResult=false;
	  Assert.assertEquals(actualResult, expectedResult);
  }
  @Test(groups = {"Critical"} )
 public void verifyLoginWithValidCredentials() throws IOException {
	 lp=new LoginPage(driver);
	 lp.enterUserName(ExcelRead.readStringData("Sheet1", 1, 0));
	 lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
	 lp.clickLoginButton();
	 String actualUrl="https://groceryapp.uniqassosiates.com/admin";
	 String expectedURL= lp.getCurrentURLofLogin();
	 Assert.assertEquals(actualUrl, expectedURL,Constant.ASSERTIONERRORMESSAGE);
 }
  
  @Test(dataProvider="dataProvider",dataProviderClass=DataProviderLoginPageTest.class)
 public void verifyLoginWithInvalidCredentials(String user,String pswd) {
	  lp=new LoginPage(driver);
		 lp.enterUserName(user);
		 lp.enterPassword(pswd);
		 lp.clickLoginButton();
	 
	 String actalResult=lp.loginwithInvalidCredentials();
	 String expectedResult="×\n" + "Alert!\n"+
	 		"Invalid Username/Password";
	 Assert.assertEquals(actalResult, expectedResult);
	 
 }
@Test
public void verifyTheBacgrooundColourOfSignInButton() {
	 lp=new LoginPage(driver);
	 String actualResult=lp.getBackgroundColorOfSignIN();
	 String expectedResult="#343a40";
	 Assert.assertEquals(actualResult, expectedResult,Constant.ASSERTIONERRORMESSAGE);
	
}
@Test
public void verifyTheTextOftitle7MartSupermarket() {
	 lp=new LoginPage(driver);
	 String actualResult=lp.getTextOf7MartSuperMarket();
	 String expectedResult="7rmart supermarket";
	 Assert.assertEquals(actualResult, expectedResult,Constant.ASSERTIONERRORMESSAGE);
		
}
}
