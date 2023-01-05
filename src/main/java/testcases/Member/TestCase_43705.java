package testcases.Member;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import driver.Driver;
import pages.LoginPage;
import pages.MemberFormPage;
import utils.DataInputProvider;
//TFS ID_43705 Test case 11231: Cloud: Verify warning message is NOT displayed when there is any DP change of an account with only location type children

public class TestCase_43705 {


	@Test
	public void verifyDraftTerminatedStatus(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

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
		.navigateToRecordStatus()
		.chooseRecordStatusPublishedWithFrame1("Draft")
		.clickSave()
		.selectMembershipEntity()
		.navigateToGeneralTab()
		.clickSave()
		.clearDirectParent1()
		.updateDPwithoutScrolldonw("635436")

		.typeDPReason("Test")
		.clickSave()

		//6.	//Top Parent Relation =  OLM
		.selectTopParentRelationWithoutClick("Affiliate")

		
		.typeTPReason("Test")
		.chooseRecordStatusPublishedWithFrame1("Published")
		.clickSave()
		.verifyNoErrorMessage()
		
		.chooseRecordStatusPublishedWithFrame1("Draft")
		.clickSave()
		.selectMembershipEntity()
		.navigateToGeneralTab()
		.clickSave()
		.clearDirectParent1()
		.updateDPwithoutScrolldonw("AR0006")

		.typeDPReason("Test")
		.clickSave()

		//6.	//Top Parent Relation =  OLM
		.selectTopParentRelationWithoutClick("Affiliate")

		
		.typeTPReason("Test")
		.chooseRecordStatusPublishedWithFrame1("Published")
		.clickSave()
		.verifyNoErrorMessage()


		;
	}
}
