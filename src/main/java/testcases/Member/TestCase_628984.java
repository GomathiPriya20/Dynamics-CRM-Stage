package testcases.Member;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;

//TFS ID:628984:Verify user should NOT be able to change the record status from Active to terminated manually

public class TestCase_628984 {


	@Test
	public void verifyAccountStatusTerminated(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
		.clickSignIn()

		//2. Go to Workplace > Accounts > +New 
		.clickWorkplace()
		.selectAccounts()
		.searchOnAccountsPage(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber", sDataSheetName))

		//3.Double click on the account and go to Sub accounts entity by clicking > on the top 
		.selectAccountFromSearchResults()

		.choosecontentFrame1()
		
//		//Verify Premier End Date is populated
//		.verifyPremierEndDate(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipEndDate", sDataSheetName))

		//Verify  Account Status is Active
		.verifyAccountStatus(DataInputProvider.getCellData_ColName(iRowNumber, "AccountStatus", sDataSheetName))
		
		//Choose Account Status as Terminated
		.selectAccountStatus(DataInputProvider.getCellData_ColName(iRowNumber, "AccountStatus1", sDataSheetName))
		
		//Click save
		.clickSave()
		
		//verify error message is displayed
		.verifyErrorMessage(DataInputProvider.getCellData_ColName(iRowNumber, "ErrorMessage", sDataSheetName))

		//Click OK in Error Dialog box
		.ClickOkInErrorMessage()

		//Go to Record Status field
		.navigateToRecordStatus()
		
		//Choose Record Status =Draft
		.chooseRecordStatusDraft()

		//Click Save
		.clickSave()


		//verify error message is displayed
		.verifyErrorMessage(DataInputProvider.getCellData_ColName(iRowNumber, "ErrorMessage", sDataSheetName))
		
		//Click OK in Error Dialog box
		.ClickOkInErrorMessage()

		;
	}
}
