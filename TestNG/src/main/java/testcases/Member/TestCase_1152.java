package testcases.Member;


import java.awt.AWTException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import events.TestNgListeners;
import hooks.TestNgHooks;
import pages.LoginPage;



public class TestCase_1152 extends TestNgHooks{


	@BeforeTest
	public void setData() {
		testCaseName = "TFS ID_ 1152 : Validate Convert Acct Entity Code to Ship-to Acct";
		testDescription = "Validate Convert Acct Entity Code to Ship-to Acct"; 
		category = "Member";
		authors = "Senthil";  
		dataSheetName = "Validate Convert Acct Entity Code to Ship-to-Acct_TP_1152";
		nodes = "Validate Business Key";

	}

	@BeforeMethod()
	public void startLogin() {		
		
	}
	
	@Test(dataProvider ="fetchData", groups ="Member", enabled=true)
	public void createMemberTP(String username, String password,String CrmNumber,
			String LocationTpe
			) throws InterruptedException, AWTException {
		new LoginPage()
		.typeUsername(username)
  	    .typePassword(password)
		.clickSignIn()
		.clickWorkplace()
		.selectAccounts()
		.chooseActiveMember(CrmNumber)
		.chooseLocationType(LocationTpe)
		.clickSave()
		.manualOverrideIsDisplayed()
		.manualOverrideIsDisplayed1();
	}

}
