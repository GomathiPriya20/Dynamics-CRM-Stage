package testcases.Member;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import driver.Driver;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MemberFormPage;
import utils.DataInputProvider;
//TFS ID_43706 Test case 11232: Cloud: Verify warning message is displayed when there is any DP change of an account with children (non location type)

public class TestCase_43706 {


	@Test
	public void verifyDPChangeMessage(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

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
		.clickSaveinDuplicatePopup()
		.switchToFrame1()
		.selectMembershipEntity()
		.navigateToGeneralTab()
		.clickSave()
		.updateDirectParent1()
		.updateDPwithoutScrolldonw("635436")

		.typeDPReason("Test")
		.clickSave()

		//6.	//Top Parent Relation =  OLM
		.selectTopParentRelationWithoutClick("OLM")


		.typeTPReason("Test")
		.chooseRecordStatusPublishedWithFrame1("Published")
		.clickSave()
		.verifyPartialdescriptionMessage("This account has sub accounts that will be changed as well.")
		.ClickOkInErrorMessage()
		.clickSaveinDuplicatePopup()
		.clickSave()
		;
		new DashboardPage()
		//2.Go to Workplace > Accounts and search for EIN 673415 
		.clickWorkplace()
		.selectAccounts()
		.searchOnAccountsPageNew(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber", sDataSheetName))

		//3.Double click on the account and go to Sub accounts entity by clicking > on the top 
		.selectAccountFromSearchResults()
		.navigateToRecordStatus0()
		.chooseRecordStatusPublishedWithFrame0("Draft")
		.clickSave()
		.clickSaveinDuplicatePopup()
		.switchToFrame1()
		.selectMembershipEntity()
		.navigateToGeneralTab0()
		.clickSave()
		.updateDirectParent()
		.updateDPwithoutScrolldonw("838463")

		.typeDPReason("Test")
		.clickSave()

		//6.	//Top Parent Relation =  OLM
		.selectTopParentRelationWithoutClick0("Affiliate")


		.typeTPReason("Test")
		.chooseRecordStatusPublishedWithFrame0("Published")
		.clickSave()
		.verifyPartialdescriptionMessage("This account has sub accounts that will be changed as well.")
		.ClickOkInErrorMessage()
		.clickSaveinDuplicatePopup()
		;
		
	}
}
