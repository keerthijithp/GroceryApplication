package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminHomePage;
import elementRepository.AdminUsersPage;
import elementRepository.LoginPage;
import utilities.ExcelRead;

public class AdminUsersPageTestCases extends BaseClass {
	AdminHomePage ap;
	LoginPage lp;
	AdminUsersPage aup;
	/*
  @Test
  public void verifyTheStatusOfAdminUsers() throws IOException {
	  	ap = new AdminHomePage(driver);
		lp = new LoginPage(driver);
		aup=new AdminUsersPage(driver);
		lp.enterUserName(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickLoginButton();
		ap.clickOnAdminUserTab();
		String locator=aup.getLocator();
		WebElement status=driver.findElement(By.xpath(locator));
		String actualResult=status.getText();
		String expectedResult="Active";
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTIONERRORMESSAGE);
		
  }*/
	@Test
  public void verifyAdminCanAddNewAdminUsers() throws IOException {
	  ap = new AdminHomePage(driver);
		lp = new LoginPage(driver);
		aup=new AdminUsersPage(driver);
		lp.enterUserName(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickLoginButton();
		ap.clickOnAdminUserTab();
		aup.clickOnNewButton();
		aup.enterUserName();
		aup.enterPassword();
		aup.selectUserTypeFromDropDown();
		aup.clickSaveButton();
		String actualResult=aup.clickSaveButton();
		String expectedResult=" ×\n"+"Alert!\n"+"User Created Successfully";
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTIONERRORMESSAGE);
	  
  }
}
