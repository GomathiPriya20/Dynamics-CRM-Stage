package testcases.Supplier;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;

//TFS ID_44009:Test Case 8519 :Verify whether user should be able to update Premier Start date for the "Supplier" via Membership Entity

public class TestCase_44009 {
	
	//Automation-Modify Address in an existing Supplier Account and re-publish as a Supplier Supervisor. Same Entity code should be retained
	
	@Test()

	public void verifyPremierStartDate(int iRowNumber, String sDataSheetName) throws Exception {
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
		
		//Select Accounts Entity
		.selectAccounts()
		
		
		//Search Existing Account using CRM#
		.searchOnAccountsPage(DataInputProvider.getCellData_ColName(iRowNumber, "crmNumberInput", sDataSheetName))
		
		//Choose the desired account from the search results
		.selectSupplierAccountFromSearchResults()
		
		.selectMembershipEntity()
		.doubleClickOnNationalMembership()
		.changeMembershipStartDate("2/2/2008")
		.clickMembershipSaveAndClose()
		.getPremierStartDate()
		.savePremierStartDate(false)
		.verifyPremierStartDate("2/2/2008")
		.selectMembershipEntity()
		.doubleClickOnNationalMembership()
		.changeMembershipStartDate("7/9/1997")
		.clickMembershipSaveAndClose()

		;
		}


}