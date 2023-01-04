package testcases.Member;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;
//TFS ID_33110:Verify for a Direct Parent which as Child accounts ,whose "Exclude from Roster" can not be changed from No to Yes
public class TestCase_33110 {


	@Test
	public void verifyDirectParentExcludeFromRosterLogic(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException 
	{

		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName)) 
		.clickSignIn()

		//2.Go to Workplace > Accounts and search for EIN 673415 
		.clickWorkplace()
		.selectAccounts()
		.searchOnAccountsPage(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParent", sDataSheetName))

		//3.Double click on the account and go to Sub accounts entity by clicking > on the top 
		.selectAccountFromSearchResults()
		
		.choosecontentFrame1()
		
		//5. Verify Direct parent and Top parent are populated 
		.verifyDirectParent(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyDirectParent", sDataSheetName))
		.verifyTopParent(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyTopParent", sDataSheetName))

		//Verify Exclude From Roster default value
		.verifyExcludeFromRoster(DataInputProvider.getCellData_ColName(iRowNumber, "ExcludeFromRoster", sDataSheetName))

		
		//Navigate to ExcludeFromRoster field
		.navigateToExcludeFromRoster()

		//Select Exclude From Roster as Yes and verify
		.selectExcludeFromRosterFrame1(DataInputProvider.getCellData_ColName(iRowNumber, "ExcludeFromRoster1", sDataSheetName))

		//Click on save 
		.clickSave()

		//Duplicate pop-up save		
		.clickSaveinDuplicatePopup()


		//Parent Account being Rostered Error Message verification.
		.verifyErrorMessage(DataInputProvider.getCellData_ColName(iRowNumber, "ErrorMessage", sDataSheetName))
		.ClickOkInErrorMessage()


		;
	}

}