package testcases.Supplier;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import events.TestNgListeners;
import hooks.TestNgHooks;
import pages.LoginPage;

public class TestCase_5921 extends TestNgHooks{


	@BeforeTest
	public void setData() {
		testCaseName = "TFS ID_ 5921 : Create a supplier top parent";
		testDescription = "Verify if Supplier Supervisor can create a Supplier Top Parent";
		category = "Supplier";
		authors = "Faridhah";  
		dataSheetName = "CreateSupplier_TP_5921";
		nodes = "Create Supplier Top Parent";

	}

	@BeforeMethod()
	public void startLogin() {		
		
	}
	
	
	@Test(dataProvider ="fetchData", groups = "Supplier", enabled=true)

	public void createSupplierTP(String username, String password) throws InterruptedException {
		new LoginPage()
		.typeUsername(username)
		.typePassword(password)
		.clickSignIn()
		.clickWorkplace()
		.selectAccounts()
		.clickNewOnAccountsPage()
		.chooseSupplierForm()
		.defaultAccountStatus()
		.defaultAccountType()
		.selectAccountType()
		.typeAccountName()
		.pickPremierStartDate()
		.selectBusinessClassification()
		.clickIsTP()
		.pickTPRD()
		.typeStreet1()
		.typeZipCode()
		.clickSave()
		.crmNumberIsDisplayed();
		
				
		
	}


}
