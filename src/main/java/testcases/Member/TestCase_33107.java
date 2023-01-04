package testcases.Member;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;

//TFS ID_33107 :Verify Whether "Exclude from Roster" field is defaulted to 'No' for Member Entry Form.

public class TestCase_33107 {


	@Test
	public void verifyMemberFormExcludeFromRoster(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
		.clickSignIn()

		//2. Go to Workplace > Accounts > +New 
		.clickWorkplace()
		.selectAccounts()
		.clickNewOnAccountsPage()
		.chooseMemberEntryFormWithFrame1()
		.navigateToExcludeFromRoster()
		
		//Verify Exclude From Roster default value in Member Form
		.verifyExcludeFromRoster(DataInputProvider.getCellData_ColName(iRowNumber, "ExcludeFromRoster", sDataSheetName))
		;
	}
}
