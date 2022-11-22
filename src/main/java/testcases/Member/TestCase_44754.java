package testcases.Member;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import driver.Driver;
import pages.LoginPage;
import pages.MemberFormPage;
import services.WebDriverServiceImpl;
import utils.DataInputProvider;
//TFS ID_44754:Verify whether Member User is able to publish and modify existing editable fields with out throwing any error on save

public class TestCase_44754 {


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
		.switchToFrame1()
		.getAccountName()
		.typeAccountName("Update")
		.updateDirectParent1()
		.updateDPwithoutScrolldonw("635436")

		.typeDPReason("Test")
		
		//Top Parent Relation =  OLM
		.selectTopParentRelationWithoutClick("Affiliate")

		
		.typeTPReason("Test")
		.selectParticipationType("Pharmacy")
		.clickSave()
		.verifyENorrorMessage()
		
		.selectMembershipEntity()
		.navigateToGeneralTab()
		.switchToFrame1()
		.typeAccountName(WebDriverServiceImpl.accountName)
		.clickSave()
		.updateDirectParent1()
		.updateDPwithoutScrolldonw("743059")

		.typeDPReason("Test")
		.clickSave()

		//6.	//Top Parent Relation =  OLM
		.selectTopParentRelationWithoutClick("Affiliate")

		
		.typeTPReason("Test")
		.clickSave()
		.verifyENorrorMessage()


		;
	}
}
