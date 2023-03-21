package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminHomePage;
import elementRepository.LoginPage;
import elementRepository.ManageOfferCode;
import utilities.ExcelRead;

public class ManageOfferCodeTestCases extends BaseClass{
	AdminHomePage ap;
	LoginPage lp;
	ManageOfferCode moc;
	
  @Test
  public void verifySearchButtonInManageOfferCodePAge() throws IOException {
	  lp=new LoginPage(driver);
	  moc=new ManageOfferCode(driver);
	  lp.enterUserName(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("password"));
		lp.clickLoginButton();
		moc.clickOnManageOfferCode();
		moc.clickOnSearchButton();
		moc.enterOfferCode(Constant.OFFERCODEINSEARCHBUTTON);
		
		String actualResult=moc.clickOnSearchButtonRed();
		String expectedResult=Constant.OFFERCODEINSEARCHBUTTON;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTIONERRORMESSAGE);
		
  }
	@Test
  public void verifyIfAdminAbleToaddNewOfferCode() throws IOException, AWTException, InterruptedException {
	  lp=new LoginPage(driver);
	  moc=new ManageOfferCode(driver);
	  lp.enterUserName(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("password"));
		lp.clickLoginButton();
		moc.clickOnManageOfferCode();
		moc.clickOnNewButton();
		moc.enterOfferCodeforNewOffer(Constant.OFFERCODEFORNEWOFFER);
		moc.selectcheckbox();
		moc.enterOfferPercentage("50");
		moc.enterOfferPrice("300");
		moc.enterDescription("Valid till April 2023");
		moc.clickSaveButton();
		boolean actualResult = moc.getErrorMessage(Constant.OFFERCREATEDMSg);
		Assert.assertTrue(actualResult, Constant.ASSERTIONERRORMESSAGE);

  }
}
