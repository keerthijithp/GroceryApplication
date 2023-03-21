package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminHomePage;
import elementRepository.LoginPage;
import elementRepository.ManageSliderPage;
import utilities.ExcelRead;

public class ManageSliderPageTestCases extends BaseClass{
	LoginPage lp;
	AdminHomePage ap;
	ManageSliderPage mp;
	
  @Test
  public void verifyAdminCanAddNewSlider() throws IOException, AWTException {
	  lp=new LoginPage(driver);
	  mp=new ManageSliderPage(driver);
	  lp.enterUserName(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("password"));
		lp.clickLoginButton();
		mp.clickOnManageSlider();
		mp.clickOnNewButton();
		mp.uploadImage();
		mp.enterHttpLink(Constant.ENETERHTTPCODE);
		boolean actualResult=mp.getErrorMessage(Constant.SLIDERCREATEDMSG);
		Assert.assertTrue(actualResult, Constant.ASSERTIONERRORMESSAGE);
	  
		
  }
	
  @Test
  public void verifyAdminCanChangeTheStatusOfALinkInManageSliderPage() throws IOException, InterruptedException {
	  lp=new LoginPage(driver);
	  mp=new ManageSliderPage(driver);
	  lp.enterUserName(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("password"));
		lp.clickLoginButton();
		mp.clickOnManageSlider();
		mp.getLocator();
		boolean actualResult=mp.getErrorMessage(Constant.SLIDERSTATUSCHANGE);
		Assert.assertTrue(actualResult, Constant.ASSERTIONERRORMESSAGE);
		
  }
  
  @Test
  public void verifyBagroundColorOfRestButton() throws IOException {
	  lp=new LoginPage(driver);
	  mp=new ManageSliderPage(driver);
	  lp.enterUserName(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("password"));
		lp.clickLoginButton();
		mp.clickOnManageSlider();
		 String actualResult=mp.getResetBtnBgColor();
		 String expectedResult=Constant.BGCOLOR;
		  Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTIONERRORMESSAGE);
		}
		
  
}
