package testcases.Member;

import org.testng.annotations.Test;

import pages.LoginPage;
import utils.DataInputProvider;
//TFS ID_45287:Validate Top Parent Relationship Date Change


public class TestCase_45287 {


	@Test
	public void verifyTPRD(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException 
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
		.selectAccountFromSearchResults()
		.navigateToRecordStatus()
		.chooseRecordStatusDraftWithFrame1()
		.clickSave()
		.selectMembershipEntity()
		.navigateToGeneralTab()
		.navigateToExcludeFromRoster()
		.selectTopParentRelationDate("11/23/2020")
		.clickSave()
		.verifyTopRelationReasonMandatory()
		.switchToFrame1()
		.typeTPReason("Test")
		.clickSave()
		.verifyTopRelationReasonMandatoryisNotDisplayed()
		.clickSave()
		.selectMembershipEntity()
		.navigateToGeneralTab()
		.switchToFrame1()
		.clearTPReason()
		.clickSave()
		.selectMembershipEntity()
		.navigateToGeneralTab()
		.clearDirectParent1()
		.updateDPwithoutScrolldown("635436")
		.typeDPReason("Test")
		.clickSave()

		//6.	//Top Parent Relation =  OLM
		.selectTopParentRelationWithoutClick("OLM")
		
		.clickSave()
		.verifyTopRelationReasonMandatory()
		.switchToFrame1()
		.typeTPReason("Test")
		.clickSave()
		
		.chooseRecordStatusPublishedWithFrame1WithoutVerification("Published")
		.clickSave()
		.verifyNoErrorMessage()
		
		.selectMembershipEntity()
		.navigateToGeneralTab()
		.switchToFrame1()
		.clearTPReason()
		.clickSave()
		
		.selectMembershipEntity()
		.navigateToGeneralTab()
		.clearDirectParent1()
		.updateDPwithoutScrolldown("743059")
		.typeDPReason("Test")
		.clickSave()

		//6.	//Top Parent Relation =  OLM
		.selectTopParentRelationWithoutClick("Affiliate")
		.selectTopParentRelationDate("11/23/2021")
		.clickSave()
		.verifyTopRelationReasonMandatoryisNotDisplayed()
		.chooseRecordStatusPublishedWithFrame1WithoutVerification("Published")
		.clickSave()
		
		.selectMembershipEntity()
		.navigateToGeneralTab()
		.switchToFrame1()
		.clearTPReason()
		.clickSave()

		
		
		
		;
	}

}