package testcases.Login;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import events.TestNgListeners;
import hooks.TestNgHooks;

import pages.LoginPage;

public class GeneralLoginCheck extends TestNgHooks{


	@BeforeTest
	public void setData() {
		testCaseName = "Login Check";
		testDescription = "Login to CRM with multiple user logins";
		category = "smoke";
		authors = "Faridhah";  
		dataSheetName = "Login";
		nodes = "User Login";

	}

	@BeforeMethod()
	public void startLogin() {		
		// do nothing 
	}
		
	@Test(dataProvider ="fetchData",groups = "Login", enabled = true)

	public void login(String username, String password) throws InterruptedException {

		new LoginPage()
		.typeUsername(username)
		.typePassword(password)
		.clickSignIn()
		.clickUserIcon();
	}


}
