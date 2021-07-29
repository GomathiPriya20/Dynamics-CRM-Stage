package testcases.Supplier;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;

public class TestCase_7159 {
	
	//Automation-Create a supplier under DP -Save and Publish Supplier Supervisor Login
	
	
	@Test()

	public void createSupplierAsSupplierSupervisor(int iRowNumber, String sDataSheetName) throws Exception {
		
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
		
		//Click on +New ( goes to Accounts Page)
		.clickNewOnAccountsPage()
		
		//Choose 'Supplier Form' Option
		.chooseSupplierForm()
		
		//Verify Default Account Status on Supplier Form
		.defaultAccountStatus(DataInputProvider.getCellData_ColName(iRowNumber, "defaultAccountStatus", sDataSheetName))
		
		//Verify Default Account Type on Supplier Form
		.defaultAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "defaultAccountType", sDataSheetName))		
		
		//Type the Account Name
		.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "accountName", sDataSheetName))		
		
		//Enter Premier Start Date
		.pickPremierStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "premierStartDate", sDataSheetName))		
		
		//Choose the Business Classification
		.selectBusinessClassification(DataInputProvider.getCellData_ColName(iRowNumber, "businessClassification", sDataSheetName))
		
		//Choose Direct Parent
		.selectDirectParent(DataInputProvider.getCellData_ColName(iRowNumber, "directParent", sDataSheetName))	
		
		//Choose Direct Parent Relation date
		.selectDPParentRelationDate(DataInputProvider.getCellData_ColName(iRowNumber, "selectDPRelationDate", sDataSheetName))
		
		//Enter Top Parent Relation Date
		.pickTPRD(DataInputProvider.getCellData_ColName(iRowNumber, "selectTPRelationDate", sDataSheetName))	
		
		//Enter the Street1 address info
		.typeStreet1(DataInputProvider.getCellData_ColName(iRowNumber, "street1", sDataSheetName))		
		
		//Enter the Zip Code address info
		.typeZipCode(DataInputProvider.getCellData_ColName(iRowNumber, "zipCode", sDataSheetName))	
		
		//Verify the Direct Parent value same as chosen above
		.verifyDPValue(DataInputProvider.getCellData_ColName(iRowNumber, "verifyDPValue", sDataSheetName))	
		
		//Save the information
		.clickSave()
		
		//Choose Record Status as Published
		.recordStatusPublished(DataInputProvider.getCellData_ColName(iRowNumber, "recordStatusPublished", sDataSheetName))
		
		//Verify if CRM# is generated.
		.crmNumberIsDisplayed()
		
		//Save the information
		.clickSave()
		
		//Verify if Entity Code is generated.
		.entityCodeIsDisplayed();
		
	}


}