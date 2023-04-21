package testcases.Member;

import org.testng.annotations.Test;

import pages.LoginPage;
import utils.DataInputProvider;
//TFS ID_45282:Verify whether invalid date\time error is not thrown on published location type account without TPRD moved to draft

public class TestCase_45282 {


	@Test
	public void verifyTPRD(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
		.clickSignIn()

		//2.Go to Workplace > Accounts and search for EIN 673415 
		.clickWorkplace()
		.selectAccounts()

		.searchOnAccountsPage(DataInputProvider.getCellData_ColName(iRowNumber,
				"CrmNumber", sDataSheetName))

		//3.Double click on the account and go to Sub accounts entity by clicking >on the top 
		.selectAccountFromSearchResults() 
		.navigateToExcludeFromRoster()
		.clearTopParentDate()
		.clickSave()
		.verifyTPRDErrorisnotDisplayed()
		.selectTopParentRelationDate("11/23/2021")
		.clickSave()
		.signOut()
		.pageRefresh()
		;

		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
		.getPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username1", sDataSheetName))
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
		.clickSignIn()

		//2.Go to Workplace > Accounts and search for EIN 673415 
		.clickWorkplace()
		.selectAccounts()

		.searchOnAccountsPageNew(DataInputProvider.getCellData_ColName(iRowNumber,
				"CrmNumber", sDataSheetName))

		//3.Double click on the account and go to Sub accounts entity by clicking >on the top 
		.selectAccountFromSearchResults() 
		.navigateToExcludeFromRoster0()
		.clearTopParentDate()
		.clickSave()
		.verifyTPRDErrorisnotDisplayed0()
		.selectTopParentRelationDate("11/23/2021")
		.clickSave()
		;
	}

}
