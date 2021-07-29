package testcases.Supplier;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;

public class TestCase_7155 {
	
//Automation-Publish an existing supplier using Supplier Supervisor Login
		
	@Test()

	public void publishExistingSupplierAsSupplier(int iRowNumber, String sDataSheetName) throws Exception {
		
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
		
		//Verify Account Name of the Selected record
		.verifyAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "verifyAccountName", sDataSheetName))		
		
		//Verify Default Account Status on Supplier Form
		.defaultAccountStatus(DataInputProvider.getCellData_ColName(iRowNumber, "defaultAccountStatus", sDataSheetName))
		
		//Change Record Status from Draft to Published
		.existingRecordStatusDraftToPublished(DataInputProvider.getCellData_ColName(iRowNumber, "recordStatusPublished", sDataSheetName))
		
		//Verify Default Account Type on Supplier Form
		.defaultAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "defaultAccountType", sDataSheetName))
		
		//.pickTPRDEdit(DataInputProvider.getCellData_ColName(iRowNumber, "selectTPRelationDate", sDataSheetName))				
		
		//Verify if CRM# is generated.
		.crmNumberIsDisplayed()
		
		//Save the information
		.clickSave()	
		
		//Verify if Entity Code is generated.
		.entityCodeIsDisplayed();	
	}
}