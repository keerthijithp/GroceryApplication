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
	
  @Test
  public void verifyTheStatusOfAdminUsers() throws IOException {
	  	ap = new AdminHomePage(driver);
		lp = new LoginPage(driver);
		aup=new AdminUsersPage(driver);
		lp.enterUserName(Constant.USERNAME);
		lp.enterPassword(Constant.PASSWORD);
		lp.clickLoginButton();
		ap.clickOnAdminUserTab();
		String locator=aup.getLocator();
		WebElement status=driver.findElement(By.xpath(locator));
		String actualResult=status.getText();
		String expectedResult=Constant.STATUSOFADMINUSER;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTIONERRORMESSAGE);
		
  }
	@Test
  public void verifyAdminCanAddNewAdminUsers() throws IOException, InterruptedException {
	  ap = new AdminHomePage(driver);
		lp = new LoginPage(driver);
		aup=new AdminUsersPage(driver);
		lp.enterUserName(Constant.USERNAME);
		lp.enterPassword(Constant.PASSWORD);
		lp.clickLoginButton();
		ap.clickOnAdminUserTab();
		aup.clickOnNewButton();
		aup.enterUserName("zcsz");
		aup.enterPassword("sssss");
		aup.selectUserTypeFromDropDown("admin");
		aup.clickSaveButton();
		boolean actualResult=aup.getErrorMessage(Constant.NEWUSERCREATIONMSG);
		
		Assert.assertTrue(actualResult, Constant.ASSERTIONERRORMESSAGE);
	  
  }
	
  
  @Test
  public void verifyifAdminCAnDeleteUsers() throws IOException, InterruptedException {
	  	ap = new AdminHomePage(driver);
		lp = new LoginPage(driver);
		aup=new AdminUsersPage(driver);
		lp.enterUserName(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("password"));
		lp.clickLoginButton();
		ap.clickOnAdminUserTab();
		aup.clickOnDeleteButton();
		
		boolean actualResult=aup.getErrorMessage(Constant.EXPECTEDDELETEMSGINADMINUSERPAGE);
		
		Assert.assertTrue(actualResult, Constant.ASSERTIONERRORMESSAGE);
  }
  
}
