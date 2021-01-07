package testcases.Supplier;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;

public class TestCase_7154 {

	//Automation-Create a supplier under a DP and save using Supplier Login
	
	@Test()

	public void createSupplierWithSupplierLogin(int iRowNumber, String sDataSheetName) throws Exception {
		new LoginPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))
		.clickSignIn()
		.clickWorkplace()
		.selectAccounts()
		.clickNewOnAccountsPage()
		.chooseSupplierForm()
		.defaultAccountStatus(DataInputProvider.getCellData_ColName(iRowNumber, "defaultAccountStatus", sDataSheetName))
		.defaultAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "defaultAccountType", sDataSheetName))		
		.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "accountName", sDataSheetName))		
		.pickPremierStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "premierStartDate", sDataSheetName))		
		.selectBusinessClassification(DataInputProvider.getCellData_ColName(iRowNumber, "businessClassification", sDataSheetName))
		.selectDirectParent(DataInputProvider.getCellData_ColName(iRowNumber, "directParent", sDataSheetName))	
		.selectDPParentRelationDate(DataInputProvider.getCellData_ColName(iRowNumber, "selectDPRelationDate", sDataSheetName))
		.pickTPRD(DataInputProvider.getCellData_ColName(iRowNumber, "selectTPRelationDate", sDataSheetName))	
		.typeStreet1(DataInputProvider.getCellData_ColName(iRowNumber, "street1", sDataSheetName))		
		.typeZipCode(DataInputProvider.getCellData_ColName(iRowNumber, "zipCode", sDataSheetName))	
		.verifyDPValue(DataInputProvider.getCellData_ColName(iRowNumber, "verifyDPValue", sDataSheetName))	
		.clickSave()
		.recordStatusLock(DataInputProvider.getCellData_ColName(iRowNumber, "recordStatusLock", sDataSheetName))
		.crmNumberIsDisplayed()
		.clickSave();
		
	}


}
