package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminHomePage;
import elementRepository.LoginPage;
import utilities.ExcelRead;

public class AdminPageTestCases extends BaseClass {
	AdminHomePage ap;
	LoginPage lp;

	@Test(groups = {"Critical"} )
	public void verifyLogoutButton() throws IOException {
		ap = new AdminHomePage(driver);
		lp = new LoginPage(driver);
		lp.enterUserName(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("password"));
		lp.clickLoginButton();
		ap.clickOnAdmin();
		String actualResult = ap.clickOnLogoutButton();
		String expectedResult = Constant.EXPECTEDLOGOUTRURL;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTIONERRORMESSAGE);
	}

	@Test(groups = {"Regression"} )
	public void verifyingPageTiTleOfAdminHomePage() throws IOException {

		ap = new AdminHomePage(driver);
		lp = new LoginPage(driver);
		 lp.enterUserName(Constant.USERNAME);
			lp.enterPassword(Constant.PASSWORD);
		String actualResult = lp.clickLoginButton();
		String expectedResult = Constant.ADMINPAGETITLE;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTIONERRORMESSAGE);
	}
	
	@Test(groups = {"Regression"} )
	public void verifyAdminCanAccesExpenceCAtegoryPage() throws IOException, InterruptedException {
		ap = new AdminHomePage(driver);
		lp = new LoginPage(driver);
		lp.enterUserName(Constant.USERNAME);
		lp.enterPassword(Constant.PASSWORD);
		lp.clickLoginButton();
		ap.clickOnManageExpenceTab();
		Thread.sleep(3000);
		String actualResult = ap.clickOnExpenceCategoryTab();
		String expectedResult = Constant.EXPENCECATEGORYPAGE;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTIONERRORMESSAGE);
		
		
	}
	/*
	@Test
	public void verifyAdminCanaccesCreateMerchantTab() throws IOException {
		ap = new AdminHomePage(driver);
		lp = new LoginPage(driver);
		lp.enterUserName(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("password"));
		lp.clickLoginButton();
		ap.clickOnManageExpenceTab();
		String actualResult = ap.clickOnCreateMerchantTab();
		String expectedResult=Constant.EXPECTEDCREATEMECHANTTITLE;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTIONERRORMESSAGE);
	}*/
	
}
