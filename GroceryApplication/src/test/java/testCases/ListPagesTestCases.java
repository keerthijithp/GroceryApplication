package testCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminHomePage;
import elementRepository.ListPage;
import elementRepository.LoginPage;

public class ListPagesTestCases extends BaseClass {
	AdminHomePage ap;
	LoginPage lp;
	ListPage list;
	

  @Test
  public void verifyTheFunctionalityOfsearchButton() {
	  lp=new LoginPage(driver);
	  ap=new AdminHomePage(driver);
	  list=new ListPage(driver);
	  lp.enterUserName(Constant.USERNAME);
		lp.enterPassword(Constant.PASSWORD);
	  lp.clickLoginButton();
	  ap.clickOnManagePages();
	  list.clickOnSearchButton();
	  list.enterTitle(Constant.TITLEFORLISTPAGE);
	  String actualResult=list.clickOnSecondSearchButton();
	  String expected=Constant.TITLEFORLISTPAGE;
	  Assert.assertEquals(actualResult, expected,Constant.ASSERTIONERRORMESSAGE);
	
  }
  
  
  @Test
  public void verifyAdminCanAddNewPages() throws AWTException, InterruptedException {
	  lp=new LoginPage(driver);
	  ap=new AdminHomePage(driver);
	  list=new ListPage(driver);
	  lp.enterUserName(Constant.USERNAME);
		lp.enterPassword(Constant.PASSWORD);
	  lp.clickLoginButton();
	  ap.clickOnManagePages();
	  list.clickOnNewButton();
	  list.enterTitle1(Constant.nEWBUTTONTITLEINLISTPAGE);
	  list.enterDescription("abcd");
	  list.enterPageName("Test");
	  list.uploadImage();
	  list.clickSaveButton();
	    
	  boolean actualResult=list.getErrorMessage(Constant.PAGECREATEDMSG);
		
		Assert.assertTrue(actualResult, Constant.ASSERTIONERRORMESSAGE);
	  
  }
  @Test
  public void verifytheTextOfResetButton() {
	  lp=new LoginPage(driver);
	  ap=new AdminHomePage(driver);
	  list=new ListPage(driver);
	  lp.enterUserName("admin");
	  lp.enterPassword("admin");
	  lp.clickLoginButton();
	  ap.clickOnManagePages();  
	  String actualResult=list.clickOnResetButton();
	  String expectedResult=Constant.RESETTEXT;
	  Assert.assertEquals(actualResult, expectedResult,Constant.ASSERTIONERRORMESSAGE);
  }
  
}
