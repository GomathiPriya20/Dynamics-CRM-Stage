package testcases.Member;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import utils.DataInputProvider;

//TFS ID_33105:Verify Whether "Do Not Roster" Field Name Changed to "Exclude from Roster" for Member/Non GPO/Location Type/Prospect Accounts

public class TestCase_33105 {


	@Test
	public void verifyExcludeFromRosterFOrAccountTypes(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {
		
		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
		.clickSignIn()

		//2. Go to Workplace > Accounts >
		.clickWorkplace()
		.selectAccounts()
		//Search GPO Active Member
		.searchOnAccountsPage(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber", sDataSheetName))

		//3.Double click on the account and go to Sub accounts entity by clicking > on the top 
		.selectAccountFromSearchResults()
		.navigateToExcludeFromRoster()
		.excludeFromRosterLabel();
		
		new DashboardPage()		
		.selectAccountsTab()
		//GPO Draft Member
		.searchOnAccountsPage(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber1", sDataSheetName))

		//3.Double click on the account and go to Sub accounts entity by clicking > on the top 
		.selectAccountFromSearchResults()
		.navigateToExcludeFromRoster()
		.excludeFromRosterLabel();
		
		new DashboardPage()		
		.selectAccountsTab()
		//Non GPO Active
		.searchOnAccountsPage(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber2", sDataSheetName))

		//3.Double click on the account and go to Sub accounts entity by clicking > on the top 
		.selectAccountFromSearchResults()
		.navigateToExcludeFromRoster()
		.excludeFromRosterLabel();
		
		new DashboardPage()		
		.selectAccountsTab()
		//Prospect search
		.searchOnAccountsPage(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber3", sDataSheetName))

		//3.Double click on the account and go to Sub accounts entity by clicking > on the top 
		.selectAccountFromSearchResults()
		.navigateToExcludeFromRoster()
		.excludeFromRosterLabel();
		
		new DashboardPage()		
		.selectAccountsTab()
		//Ship to Active
		.searchOnAccountsPage(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber4", sDataSheetName))

		//3.Double click on the account and go to Sub accounts entity by clicking > on the top 
		.selectAccountFromSearchResults()
		.navigateToExcludeFromRoster()
		.excludeFromRosterLabel();
		
		new DashboardPage()		
		.selectAccountsTab()
		//Ship to Draft
		.searchOnAccountsPage(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber5", sDataSheetName))

		//3.Double click on the account and go to Sub accounts entity by clicking > on the top 
		.selectAccountFromSearchResults()
		.navigateToExcludeFromRoster()
		.excludeFromRosterLabel();
		
		
	}
}
