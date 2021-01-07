package testcases.Supplier;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;

public class TestCase_7158 {
	
	//Automation-Modify Address in an existing Supplier Account as a Supplier and Verify Record Change Status

	
	@Test()

	public void modifyAddressAsSupplier(int iRowNumber, String sDataSheetName) throws Exception {
		new LoginPage()		
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))
		.clickSignIn()
		.clickWorkplace()
		.selectAccounts()
		.searchOnAccountsPage(DataInputProvider.getCellData_ColName(iRowNumber, "crmNumberInput", sDataSheetName))
		.selectSupplierAccountFromSearchResults()		
		.verifyAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "verifyAccountName", sDataSheetName))		
		.defaultAccountStatus(DataInputProvider.getCellData_ColName(iRowNumber, "defaultAccountStatus", sDataSheetName))
		.defaultAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "defaultAccountType", sDataSheetName))
		.recordChangeStatus(DataInputProvider.getCellData_ColName(iRowNumber, "recordChangeStatus", sDataSheetName))
		.clickSave()
		.updateStreet1(DataInputProvider.getCellData_ColName(iRowNumber, "street1", sDataSheetName))
		.updateZipCode(DataInputProvider.getCellData_ColName(iRowNumber, "zipCode", sDataSheetName))
		.clickSave()
		//.verifyRecordStatus(DataInputProvider.getCellData_ColName(iRowNumber, "verifyRecordStatus", sDataSheetName))
		.verifyRecordStatus()
		.verifyRecordChangeStatus(DataInputProvider.getCellData_ColName(iRowNumber, "verifyRecordChangeStatus", sDataSheetName))
		.crmNumberIsDisplayed()
		.clickSave()	
		.entityCodeIsDisplayed()
		.verifyEntityCode(DataInputProvider.getCellData_ColName(iRowNumber, "verifyEntityCode", sDataSheetName));
		}


}
