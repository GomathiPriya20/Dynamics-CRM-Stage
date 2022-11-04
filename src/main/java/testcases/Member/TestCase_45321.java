package testcases.Member;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;
////TFS ID_45321: Verify DP Relation Date is cleared if Is Top Parent Is Set to Yes

public class TestCase_45321 {


	@Test
	public void VerfiyDPRDforTP(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException 
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
		.navigateToisTopParent()
		
		.changeTopParent()
		.verifyIsTopParent("Yes")
		.verifyDPRDIsRemoved()
		.changeTopParent()
		.selectTopParentClassification()
		.selectTopParentClassification("Owner")
		.selectDirectParent("688350")
		.selectDirectParentRelationDate("11/02/2022")
		.selectTopParentRelation("Affiliate")
		.clickSave()
		.signOut()
		.pageRefresh()
		;

		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
		.getPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "UserName1", sDataSheetName))
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName)) 
		.clickSignIn()

		//2.Go to Workplace > Accounts and search for EIN 673415 
		.clickWorkplace()
		.selectAccounts()
		.searchOnAccountsPageNew(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber1", sDataSheetName))

		//3.Double click on the account and go to Sub accounts entity by clicking > on the top 
		.selectAccountFromSearchResults()
		.navigateToisTopParentFrame0()
		
		.changeTopParent()
		.verifyIsTopParent("Yes")
		.verifyDPRDIsRemoved()
		
		;


	}

}