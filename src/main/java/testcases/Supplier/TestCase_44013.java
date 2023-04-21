package testcases.Supplier;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;

//TFS ID_44008:Test Case 8771 :Supplier Form - DP & TP Search Look up should have only Supplier Accounts
//TFS ID_44012:Test Case 6065 :Cloud :Supplier Form should default Account Type and Account Status

public class TestCase_44013 {


	@Test()

	public void verifyLocationType(int iRowNumber, String sDataSheetName) throws Exception {
		//Access Login Page
		new LoginPage()	

		//Type the Username
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))

		//Type the password
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))

		//Click on SignIn button
		.clickSignIn()

		//Click on Workplace tab
		.clickWorkplace()



		.selectAccounts()
		.clickNewOnAccountsPage()


		.chooseMemberFormwithFrame1()
		.navigateToNAICSCode()
		.verifyNoMemberisDisplayed()

		;
		
		
	}




}