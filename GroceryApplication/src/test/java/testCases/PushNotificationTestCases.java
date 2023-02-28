package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminHomePage;
import elementRepository.LoginPage;
import elementRepository.PushNotificationPage;
import utilities.ExcelRead;

public class PushNotificationTestCases extends BaseClass {
	AdminHomePage ap;
	LoginPage lp;
	PushNotificationPage pp;

	@Test
	public void verifyIfTheAdminCanSendPushMessageNotification() {
		lp = new LoginPage(driver);
		pp = new PushNotificationPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickLoginButton();
		pp.clickOnPushNotification();
		pp.enterTitle("Enter message");
		pp.enterdescription("Messages");
		String expectedResult = "×\n" + "Alert!\n" + "Message send successfully";
		String actualResult = pp.clickOnSendButton();
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTIONERRORMESSAGE);
	}

	@Test
	public void verifyIfRestButtonIsWorking() throws IOException {
		lp = new LoginPage(driver);
		pp = new PushNotificationPage(driver);
		lp.enterUserName(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickLoginButton();
		pp.clickOnPushNotification();
		pp.enterTitle("Enter message");
		pp.enterdescription("Messages");
		String actualResult = pp.clickOnResetButton();
		String expectedResult = "";
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTIONERRORMESSAGE);

	}
}
