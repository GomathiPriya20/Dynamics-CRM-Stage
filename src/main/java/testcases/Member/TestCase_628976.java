package testcases.Member;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;

//TFS ID_34805: Verify user should not be allowed to change the account status to Active manually when Premier End date is present

public class TestCase_628976 {


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

		.verifyPremierEndDate(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipEndDate", sDataSheetName))

		.verifyAccountStatus(DataInputProvider.getCellData_ColName(iRowNumber, "AccountStatus", sDataSheetName))

		.selectAccountStatus(DataInputProvider.getCellData_ColName(iRowNumber, "AccountStatus1", sDataSheetName))

		.clickSave()

		.verifyErrorMessage(DataInputProvider.getCellData_ColName(iRowNumber, "ErrorMessage", sDataSheetName))

		.ClickOkInErrorMessage()



		.navigateToRecordStatus()

		.chooseRecordStatusDraft()

		.clickSave()



		.verifyErrorMessage(DataInputProvider.getCellData_ColName(iRowNumber, "ErrorMessage", sDataSheetName))

		.ClickOkInErrorMessage()

		;
	}
}
