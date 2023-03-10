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

	@Test
	public void verifyLogoutButton() throws IOException {
		ap = new AdminHomePage(driver);
		lp = new LoginPage(driver);
		lp.enterUserName(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickLoginButton();
		ap.clickOnAdmin();
		String actualResult = ap.clickOnLogoutButton();
		String expectedResult = "https://groceryapp.uniqassosiates.com/admin/login";
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTIONERRORMESSAGE);
	}

	@Test
	public void verifyingPageTiTleOfAdminHomePage() throws IOException {

		ap = new AdminHomePage(driver);
		lp = new LoginPage(driver);
		lp.enterUserName(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		String actualResult = lp.clickLoginButton();
		String expectedResult = "Dashboard | 7rmart supermarket";
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTIONERRORMESSAGE);
	}
	
	@Test
	public void verifyAdminCanAccesExpenceCAtegoryPage() throws IOException {
		ap = new AdminHomePage(driver);
		lp = new LoginPage(driver);
		lp.enterUserName(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickLoginButton();
		ap.clickOnManageExpenceTab();
		String actualResult = ap.clickOnExpenceCategoryTab();
		String expectedResult = "Expense Category";
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTIONERRORMESSAGE);
		
		
	}
	
	@Test
	public void verifyAdminCanaccesCreateMerchantTab() throws IOException {
		ap = new AdminHomePage(driver);
		lp = new LoginPage(driver);
		lp.enterUserName(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickLoginButton();
		ap.clickOnManageExpenceTab();
		String actualResult = ap.clickOnCreateMerchantTab();
		String expectedResult="List Expense | 7rmart supermarket";
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTIONERRORMESSAGE);
	}
	
}
