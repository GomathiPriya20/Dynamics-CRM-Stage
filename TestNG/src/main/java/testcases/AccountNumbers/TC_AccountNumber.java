//package testcases.AccountNumbers;
//
//
//import java.awt.AWTException;
//
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import events.TestNgListeners;
//import hooks.TestNgHooks;
//import pages.LoginPage;
//
//
//
//public class TC_AccountNumber extends TestNgHooks{
//
//
//	@BeforeTest
//	public void setData() {
//		testCaseName = " Account Number";
//		testDescription = "Account Number Description"; 
//		category = "Member";
//		authors = "Faridhah";  
//		dataSheetName = "AccountNumber";
//		nodes = "AccountNumber Node";
//
//	}
//
//	@BeforeMethod()
//	public void startLogin() {		
//		
//	}
//	
//	
//	@Test(dataProvider ="fetchData", groups = "Member", enabled=true)
//
//	public void TerminateGPOMember(String username,String password) throws InterruptedException, AWTException {
//		new LoginPage()
//		.typeUsername(username)
//  	    .typePassword(password)
//		.clickSignIn()
//		.clickWorkplace()
//		.selectAccounts()
//		.searchOnAccountsPage()
//		.selectAccountFromSearchResults()
//		.selectAccountNumberEntity()
//		.selectEntityCodeAccountNumber();
//					
//								
//	}
//
//}
