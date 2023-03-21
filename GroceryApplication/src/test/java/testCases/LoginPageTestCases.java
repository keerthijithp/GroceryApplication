package testCases;

import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import utilities.DataProviderUtility;
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
	  String expectedResult=Constant.TEXTOFSIGNINBUTTON;
	  Assert.assertEquals(actualResult, expectedResult,Constant.ASSERTIONERRORMESSAGE);
	  
	  
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
	  testBasic();
	 lp=new LoginPage(driver);
	 lp.enterUserName(ExcelRead.readStringData(prop.getProperty("LoginExcel"),prop.getProperty("DataProviderSheet"),1,0));
	 lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"),prop.getProperty("DataProviderSheet"),1,1));
	 lp.clickLoginButton();
	 String actualUrl=Constant.LOGINURL;
	 String expectedURL= lp.getCurrentURLofLogin();
	 Assert.assertEquals(actualUrl, expectedURL,Constant.ASSERTIONERRORMESSAGE);
 }
  
  @Test(dataProvider="dataProvider",dataProviderClass=DataProviderUtility.class)
 public void verifyLoginWithInvalidCredentials(String user,String pswd) {
	  lp=new LoginPage(driver);
		 lp.enterUserName(user);
		 lp.enterPassword(pswd);
		 lp.clickLoginButton();
	 
	 boolean actalResult=lp.getErrorMessage(Constant.INVALIDLOGINALERT);
	 //String expectedResult=Constant.INVALIDLOGINALERT;
	 Assert.assertTrue(actalResult, Constant.ASSERTIONERRORMESSAGE);
	 
 }
@Test
public void verifyTheBacgroundColourOfSignInButton() {
	 lp=new LoginPage(driver);
	 String actualResult=lp.getBackgroundColorOfSignIN();
	 String expectedResult=Constant.BGCOLROFSIGNINBUTTON;
	 Assert.assertEquals(actualResult, expectedResult,Constant.ASSERTIONERRORMESSAGE);
	
}
@Test
public void verifyTheTextOftitle7MartSupermarket() {
	 lp=new LoginPage(driver);
	 String actualResult=lp.getTextOf7MartSuperMarket();
	 String expectedResult=Constant.TITLEOFAPPLICATION;
	 Assert.assertEquals(actualResult, expectedResult,Constant.ASSERTIONERRORMESSAGE);
		
}
}
