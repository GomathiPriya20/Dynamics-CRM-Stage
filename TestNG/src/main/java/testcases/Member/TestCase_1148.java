package testcases.Member;


import java.awt.AWTException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import events.TestNgListeners;
import hooks.TestNgHooks;
import pages.LoginPage;



public class TestCase_1148 extends TestNgHooks{

	
	@BeforeTest
	public void setData() {
		testCaseName = "TFS ID_ 1148 : Validate Address Changes";
		testDescription = "Verify Validate Address Changes"; 
		category = "Member";
		authors = "Senthil";  
		dataSheetName = "Validate Address Changes_TP_1148";
		nodes = "Validate Address Changes";

	}

	@BeforeMethod()
	public void startLogin() {		
		
		}
		
	@Test(dataProvider ="fetchData", groups ="Member", enabled=true)
	public void createMemberTP(String username,String password,String CrmNumber)
			 throws InterruptedException, AWTException {
		new LoginPage()
		.typeUsername(username)
  	    .typePassword(password)
		.clickSignIn()
		.clickWorkplace()
		.selectAccounts()
		.chooseActiveMember(CrmNumber)
		.address1IsDisplayed();
	//	.clickSystem();
	//	.melissaFiedlIsDisplayed();
	}
	
}
