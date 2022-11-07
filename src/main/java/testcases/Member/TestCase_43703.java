package testcases.Member;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import driver.Driver;
import pages.LoginPage;
import pages.MemberFormPage;
import utils.DataInputProvider;
//TFS ID_43703

public class TestCase_43703 {


	@Test
	public void verifyDraftTerminatedStatus(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
		.clickSignIn()

		//2. Go to Workplace > Accounts > +New 
		.clickWorkplace()
		.selectAccounts()
		.navigatetoTerminatedAccountview()
		.selectAccountFromSearchResults()
		.navigateToRecordStatus()
		.chooseRecordStatusPublished("Draft")
		.verifyDraftStatusMSG()

		;
	}
}
