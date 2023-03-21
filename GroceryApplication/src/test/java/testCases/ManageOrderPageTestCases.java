package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageOrderPage;
import utilities.ExcelRead;

public class ManageOrderPageTestCases extends BaseClass {
	LoginPage lp;
	 ManageOrderPage mp;
  @Test
  public void verifyBagroundColrOfSearchButtonInManageOrderPAge() throws IOException {
	  lp=new LoginPage(driver);
	  mp=new ManageOrderPage(driver);
	  lp.enterUserName(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("password"));
		lp.clickLoginButton();
		mp.clickOnManageOrderTab();
		String actualResult=mp.getBagroundColr();
		String expectedResult="#007bff";
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTIONERRORMESSAGE);
  }
  @Test
  public void verifyAdminCanSelectDropDownInstatusFieldWhileZClickingSearchButton() throws IOException {
	  lp=new LoginPage(driver);
	  mp=new ManageOrderPage(driver);
	  lp.enterUserName(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("password"));
		lp.clickLoginButton();
		mp.clickOnManageOrderTab();
		mp.clickOnsearchButtoninManageOrderPage();
		String actualResult=mp.selectDropdownForStatusField();
		String expectedResult="UnPaid";
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTIONERRORMESSAGE);
  }
}
