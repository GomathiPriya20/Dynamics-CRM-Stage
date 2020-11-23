package testcases.Member;


import java.awt.AWTException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import events.TestNgListeners;
import hooks.TestNgHooks;
import pages.LoginPage;



public class TestCase_5476 extends TestNgHooks{


	@BeforeTest
	public void setData() {
		testCaseName = "TFS ID_ 5476 : Modify existing GPO Member";
		testDescription = "Verify can Modify existing GPO Member"; 
		category = "Member";
		authors = "Senthil, Faridhah";  
		dataSheetName = "Modify existing GPO Member_TP_5476";
	//	dataSheetName = "MasterData";
		nodes = "Modify existing GPO Member";

	}

	@BeforeMethod()
	public void startLogin() {		
		
	}
	
	
	@Test(dataProvider ="fetchData", groups ="Member", enabled=true)
	public void createMemberTP(String username, String password,String CrmNumber,String AccountName,String RecordStatusPublished) throws InterruptedException, AWTException {
		new LoginPage()
		.typeUsername(username)
  	    .typePassword(password)
		.clickSignIn()
		.clickWorkplace()
		.selectAccounts()
		.chooseActiveMember(CrmNumber)     
//		.accountNameDisplayed()
		.captureStatusDisplayedModify(RecordStatusPublished)
	//	.selectStatusDisplayedModify()
		.typeAccountModify(AccountName)
		//.typeAccountModify1(AccountName)
		.clickSave();
	
	}

}
