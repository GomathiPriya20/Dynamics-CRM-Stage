package testcases.Contacts;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import events.TestNgListeners;
import hooks.TestNgHooks;
import pages.LoginPage;

public class TestCase_5491 extends TestNgHooks{


	@BeforeTest
	public void setData() {
		testCaseName = "TFS ID_ 5491 : Create a New Contact";
		testDescription = "Verify if all CRM users can create a new Contact";
		category = "Supplier";
		authors = "Faridhah";  
		dataSheetName = "Create a New Contact_5491";
		nodes = "Create a New Contact";

	}

	@BeforeMethod()
	public void startLogin() {		
		
	}
	
	
	@Test(dataProvider ="fetchData", groups = "Contacts", enabled=true)

	public void createSupplierTP(String username, String password) throws InterruptedException {
		new LoginPage()
		.typeUsername(username)
		.typePassword(password)
		.clickSignIn()
		.clickWorkplace()
		.selectContacts()
		.clickNewOnContactsPage()
		.selectPrimaryAccount();
		
						
		
	}


}
