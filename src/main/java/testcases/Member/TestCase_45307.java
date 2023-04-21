package testcases.Member;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import utils.DataInputProvider;
//Test case 45307:Verify if Accounts cannot be created directly in Terminated Status.

public class TestCase_45307 {


	@Test
	public void verifyTerminatedStatus(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
		.clickSignIn()

		//2. Go to Workplace > Accounts > +New 
		.clickWorkplace()
		.selectAccounts()
		.clickNewOnAccountsPage()
		.chooseMemberFormwithFrame1()

		//3. Account Name = Any
		.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName", sDataSheetName))



		//Account Status = Auto Populated to Terminated
		.selectAccountStatus(DataInputProvider.getCellData_ColName(iRowNumber, "AcountStatus", sDataSheetName))	


		//Click on Save 
		.clickSave() 

		.verifyErrorMessage(DataInputProvider.getCellData_ColName(iRowNumber, "ErrorMessage", sDataSheetName))
		.ClickOkInErrorMessage()

		//Account Status = Auto Populated to Terminated
		.selectAccountStatus("Active")	


		//Click on Save 
		.clickSave() 
		;

		new DashboardPage()
		.clickWorkplace()
		.selectAccounts()
		.searchOnAccountsPageNew(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber", sDataSheetName))
		.selectAccountFromSearchResults()
		//Account Status = Auto Populated to Terminated
		.selectAccountStatus0(DataInputProvider.getCellData_ColName(iRowNumber, "AcountStatus", sDataSheetName))	


		//Click on Save 
		.clickSave() 

		.verifyErrorMessage(DataInputProvider.getCellData_ColName(iRowNumber, "ErrorMessage1", sDataSheetName))
		.ClickOkInErrorMessage()

		;
	}
}
