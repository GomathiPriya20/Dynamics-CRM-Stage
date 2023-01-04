package testcases.Member;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;

import utils.DataInputProvider;

//TFS ID_43700:Verify whether "Provider Select: MD" is removed from Participation Type in Member and Member Entry Forms.


public class TestCase_43700 {


	@Test
	public void verifyProviderSelect(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
		.clickSignIn()

		.clickWorkplace()
		.selectAccounts()
		.clickNewOnAccountsPage()
		.chooseMemberFormwithFrame1()
		.typeAccountName("Test")
		.clickSave()
		.navigateToExcludeFromRoster()
		.verifyParticipationType()
		;
		
		new DashboardPage()
		.clickWorkplace()
		.selectAccounts()
		.clickNewOnAccountsPage()
		.chooseMemberEntryFormWithFrame1()
		.typeAccountName("Test")
		.clickSave()
		.navigateToExcludeFromRoster()
		.verifyParticipationType()
		;
		
		new DashboardPage()
		.clickWorkplace()
		.selectAccounts()
		.searchOnAccountsPageNew(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber", sDataSheetName))
		.selectAccountFromSearchResults()
		.navigateToExcludeFromRoster0()
		.verifyParticipationType()
		
		;

	}
}