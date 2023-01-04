package testcases.Member;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;

import utils.DataInputProvider;

//TFS ID_44716: Verify Whether "Do Not Roster" Field Name Changed to "Exclude from Roster" for Member/Non GPO/Location Type/Prospect Accounts


public class TestCase_44716 {


	@Test
	public void ExcludeFromRoster(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
		.clickSignIn()

		.clickWorkplace()
		.selectAccounts()
		.searchOnAccountsPage(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber", sDataSheetName))

		//3.Double click on the account and go to Sub accounts entity by clicking > on the top 
		.selectAccountFromSearchResults()
		.navigateToExcludeFromRoster()
		.verifyExcludeFromRoster()
		;
		
		new DashboardPage()
		.clickWorkplace()
		.selectAccounts()
		.searchOnAccountsPageNew(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber1", sDataSheetName))

		//3.Double click on the account and go to Sub accounts entity by clicking > on the top 
		.selectAccountFromSearchResults()
		.navigateToExcludeFromRoster0()
		.verifyExcludeFromRoaster0()
		;
		
		new DashboardPage()
		.clickWorkplace()
		.selectAccounts()
		.searchOnAccountsPageNew(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber2", sDataSheetName))

		//3.Double click on the account and go to Sub accounts entity by clicking > on the top 
		.selectAccountFromSearchResults()
		.navigateToExcludeFromRoster0()
		.verifyExcludeFromRoaster0()
		;
		
		new DashboardPage()
		.clickWorkplace()
		.selectAccounts()
		.searchOnAccountsPageNew(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber3", sDataSheetName))

		//3.Double click on the account and go to Sub accounts entity by clicking > on the top 
		.selectAccountFromSearchResults()
		.navigateToExcludeFromRoster0()
		.verifyExcludeFromRoaster0()
		;

	}
}