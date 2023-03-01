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
	/*

  @Test
  public void verifyTheFunctionalityOfsearchButton() {
	  lp=new LoginPage(driver);
	  ap=new AdminHomePage(driver);
	  list=new ListPage(driver);
	  lp.enterUserName("admin");
	  lp.enterPassword("admin");
	  lp.clickLoginButton();
	  ap.clickOnManagePages();
	  list.clickOnSearchButton();
	  list.enterTitle("Make A Trip15_02_2023_07_34_31");
	  String actualResult=list.clickOnSecondSearchButton();
	  String expected="Make A Trip15_02_2023_07_34_31";
	  Assert.assertEquals(actualResult, expected,Constant.ASSERTIONERRORMESSAGE);
	
  }
  */
  
  @Test
  public void verifyAdminCanAddNewPages() throws AWTException, InterruptedException {
	  lp=new LoginPage(driver);
	  ap=new AdminHomePage(driver);
	  list=new ListPage(driver);
	  lp.enterUserName("admin");
	  lp.enterPassword("admin");
	  lp.clickLoginButton();
	  ap.clickOnManagePages();
	  list.clickOnNewButton();
	  list.enterTitle1("SampleTEstData");
	  list.enterDescription("abcd");
	  list.enterPageName("Test");
	  //list.clickOnchooseButton();
	  list.uploadImage();
	  String actualResult= list.clickSaveButton();
	  String expectedResult=" ×\n"+"Alert!\n"+"Page Created Successfully";
	  Assert.assertEquals(actualResult, expectedResult,Constant.ASSERTIONERRORMESSAGE);
  }
}
