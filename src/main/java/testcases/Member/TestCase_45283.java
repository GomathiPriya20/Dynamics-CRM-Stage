package testcases.Member;

import org.testng.annotations.Test;

import pages.LoginPage;
import utils.DataInputProvider;
//TFS ID_45283:Verify User should be able to override "CP and FSP" values and user should not allow to choose "Supplier" as CP or FSP.

public class TestCase_45283 {


	@Test
	public void verifyCPFSP(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

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
		  .chooseMemberForm() 
		  .clickSave()
		  
		  .navigateToRecordStatus() 
		  .chooseRecordStatusPublishedWithFrame1WithoutVerification("Draft")
		  .clickSave() 
		  .selectMembershipEntity()
		  .navigateToGeneralTab()
		  .navigateToDoNotVerifyAddress()
		  .changeCPoverrideYes()
		  .selectCorporateParentName("AB9796")
		  .verifyNoRecordFound()
		  .navigatetoFSP()
		  .changeFSPoverrideYes()
		  .selectFoodServiceParentName("AB9796")
		  .verifyNoRecordFound()
		;
	}
}
