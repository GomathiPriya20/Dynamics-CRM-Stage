package testcases.Member;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;
//TFS ID_45308 Verify user should not be allowed to change the account status to Active manually when Premier End date is present

public class TestCase_45308 {


	@Test
	public void verifyChangingStatusofTermintatedAccount(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException 
	{

		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName)) 
		.clickSignIn()

		//2.Go to Workplace > Accounts and search for EIN 673415 
		.clickWorkplace()
		.selectAccounts()
		.searchOnAccountsPage(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber", sDataSheetName))

		//3.Double click on the account and go to Sub accounts entity by clicking > on the top 
		.selectAccountFromSearchResults()
		
		//Account Status = Auto Populated to Terminated
		.selectAccountStatus1WithoutVerify("Active")	

		.clickSave() 
		.verifyErrorMessage(DataInputProvider.getCellData_ColName(iRowNumber, "ErrorMessage", sDataSheetName))
		.ClickOkInErrorMessage()
		
		.navigateToRecordStatus()
		
		.chooseRecordStatusPublishedWithFrame1("Draft")
		.clickSave() 
		.verifyErrorMessage(DataInputProvider.getCellData_ColName(iRowNumber, "ErrorMessage", sDataSheetName))
		.ClickOkInErrorMessage()
		
		;
	}

}