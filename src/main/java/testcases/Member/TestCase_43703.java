package testcases.Member;

import org.testng.annotations.Test;

import pages.LoginPage;
import utils.DataInputProvider;
//TFS ID_43703 Test case 11227: Cloud: Verify "This account is in Draft status." info text is displayed when Account is Terminated and Record status is in draft

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
		.chooseRecordStatusPublishedWithoutVerification("Draft")
		.clickSave()
		.verifyDraftStatusMSG()
		.navigateToRecordStatus()
		.chooseRecordStatusPublishedWithoutVerification("Published")
		.clickSave()

		;
	}
}
