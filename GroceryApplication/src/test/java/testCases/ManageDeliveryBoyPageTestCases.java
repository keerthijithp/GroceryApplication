package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminHomePage;
import elementRepository.LoginPage;
import elementRepository.ManageDeliveryBoyPage;
import utilities.ExcelRead;

public class ManageDeliveryBoyPageTestCases extends BaseClass{
	LoginPage lp;
	AdminHomePage ap;
	ManageDeliveryBoyPage dbp;
	
  @Test
  public void verifyTheBagroundColorOfsearchButton() throws IOException {
	  lp=new LoginPage(driver);
	  ap=new AdminHomePage(driver);
	  dbp=new ManageDeliveryBoyPage(driver);
	  lp.enterUserName(Constant.USERNAME);
		lp.enterPassword(Constant.PASSWORD);
		lp.clickLoginButton();
		ap.clickOnManageDeliveryBoy();
		String actualResult=dbp.getBagroundColourOfsearchButton();
		String expectedResult=Constant.BGCOLROFSEARCHINDELIVERYBOYPAGE;
	  Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTIONERRORMESSAGE);
		
  }
	@Test
  public void verifyAdminCanChangeThestatusOfDeliveryBoy() throws IOException, InterruptedException {
		lp = new LoginPage(driver);
		ap = new AdminHomePage(driver);
		dbp = new ManageDeliveryBoyPage(driver);
		lp.enterUserName(Constant.USERNAME);
		lp.enterPassword(Constant.PASSWORD);
		lp.clickLoginButton();
		ap.clickOnManageDeliveryBoy();
		dbp.getLocator();
		boolean actualResult = dbp.getErrorMessage(Constant.DELIVERYBOYSTATUSMSG);
		Assert.assertTrue(actualResult, Constant.ASSERTIONERRORMESSAGE);

  }
	@Test
	public void verifyAlertMessageWhileClickingOnDeleteButton() {
		 lp=new LoginPage(driver);
		  ap=new AdminHomePage(driver);
		  dbp=new ManageDeliveryBoyPage(driver);
		  lp.enterUserName(Constant.USERNAME);
			lp.enterPassword(Constant.PASSWORD);
			lp.clickLoginButton();
			ap.clickOnManageDeliveryBoy();
			String actualResult=dbp.getLocatorforDeleteButton();
			String expectedResult=Constant.WARNINGMSGWHILEDELETION;
			Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTIONERRORMESSAGE);
	}
	@Test
	public void verifyTheTextOfNewButton() {
		lp=new LoginPage(driver);
		  ap=new AdminHomePage(driver);
		  dbp=new ManageDeliveryBoyPage(driver);
		  lp.enterUserName(Constant.USERNAME);
			lp.enterPassword(Constant.PASSWORD);
			lp.clickLoginButton();
			ap.clickOnManageDeliveryBoy();
			String actualResult=dbp.getTextOFnewButton();
			String expectedResult=Constant.TEXT;
			Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTIONERRORMESSAGE);
	}
	@Test
	public void verifyTheBGColorOFnewButton() {
		lp=new LoginPage(driver);
		  ap=new AdminHomePage(driver);
		  dbp=new ManageDeliveryBoyPage(driver);
		  lp.enterUserName(Constant.USERNAME);
			lp.enterPassword(Constant.PASSWORD);
			lp.clickLoginButton();
			ap.clickOnManageDeliveryBoy();
			String actualResult=dbp.getBGColorOfNEWButton();
			String expectedResult=Constant.BGCOLOROFNEWBUTTON;
		  Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTIONERRORMESSAGE);
	}
}
