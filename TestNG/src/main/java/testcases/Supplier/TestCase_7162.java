package testcases.Supplier;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;

public class TestCase_7162 {
	
	//Automation - Convert a Supplier Main Account to Ship To Location Type Account using Supplier Supervisor Login

	
	@Test()

	public void convertMainToShipToUsingSupplierSupervisor(int iRowNumber, String sDataSheetName) throws Exception {
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
		.recordStatusDraft()
		.clickSave()
		.storeLocationType(DataInputProvider.getCellData_ColName(iRowNumber, "storeLocationType", sDataSheetName))
		.crmNumberIsDisplayed()
		.clickSave()
		.recordStatusPublished(DataInputProvider.getCellData_ColName(iRowNumber, "recordStatusPublished", sDataSheetName))
		.clickSave()
		.entityCodeIsDisplayed()
		.verifyEntityCode(DataInputProvider.getCellData_ColName(iRowNumber, "verifyEntityCode", sDataSheetName));
	
	}


}
