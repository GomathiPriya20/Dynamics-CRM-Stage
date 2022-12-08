package testcases.Supplier;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//TFS ID_43980:Test Case 11064 :Verify when a Supplier is end dated, the End Reason  defaults to 'Change' automatically
//Created By	: Sudha
//Created On  	:05/13/2021
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class TestCase_43980 {

	@Test()

	public void verifyEndReason(int iRowNumber, String sDataSheetName) throws Exception {
		new LoginPage()
		//1. Login to CRM as a Supplier Supervisor  *** User should be logged in successfully 
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))
		.clickSignIn()

		//2. Go to Workplace > Accounts > +New  *** New Supplier Form should be opened 
		.clickWorkplace()
		.selectAccounts()
		.clickNewOnAccountsPage()
		.chooseSupplierForm()

		//3. Fill in the below mandatory fields *** The given details should be saved successfully and CRM# should be generated. 
		//Account Name = Any
		.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "accountName", sDataSheetName))	

		//Business Classification = Any
		.selectBusinessClassification(DataInputProvider.getCellData_ColName(iRowNumber, "businessClassification", sDataSheetName))

		//Direct Parent  =2000133648
		.selectDirectParent(DataInputProvider.getCellData_ColName(iRowNumber, "directParent", sDataSheetName))

		//Direct Parent Relation Date  =Any
		.selectDPParentRelationDate(DataInputProvider.getCellData_ColName(iRowNumber, "selectDPRelationDate", sDataSheetName))

		//Top Parent Relation Date = Any
		.pickTPRD(DataInputProvider.getCellData_ColName(iRowNumber, "selectTPRelationDate", sDataSheetName))

		//Street 1  =Any
		.typeStreet1(DataInputProvider.getCellData_ColName(iRowNumber, "street1", sDataSheetName))

		//Zip Code = Any
		.typeZipCode(DataInputProvider.getCellData_ColName(iRowNumber, "zipCode", sDataSheetName))

		//Account Status = Auto populated  ( Active)
		.defaultAccountStatus(DataInputProvider.getCellData_ColName(iRowNumber, "defaultAccountStatus", sDataSheetName))

		//Account Type = Auto populated  (Supplier)
		.defaultAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "defaultAccountType", sDataSheetName))

		//Record Status = Draft (Default)
		.recordStatusDraft()

		//Save the Record
		.clickSave()

		//.crmNumberIsDisplayed()

		//4. Verify the Premier Start Date *** Premier Start Date should be auto-populated as Today's date 
		.verifyPremierStartDateAsCurrentDate()

		//5.Modify Premier Start Date to different date and save ***The new Premier Start Date should be saved 
		.pickPremierStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "premierStartDate", sDataSheetName))
		//Save the Record
		.clickSave()

		//6.Change Record Status = Published and save  *** The Supplier Record should be published and Entity Code should be generated .
		.recordStatusPublished(DataInputProvider.getCellData_ColName(iRowNumber, "recordStatusPublished", sDataSheetName))	
		//Save the Record
		.clickSave()
		.entityCodeIsDisplayed()


		//8.Now move the Record Status = Draft and save  *** Record should be moved to Draft 
		.recordStatusDraft()
		//Save the Record
		.clickSave()

		//7.Go to Membership  Entity and verify the Premier/National Membership *** The Premier/National Membership should be created with Start Date as  Premier Start Date	
		.selectMembershipEntity()
		.doubleClickOnNationalMembership(DataInputProvider.getCellData_ColName(iRowNumber, "premierStartDate", sDataSheetName))

		//9. Go to Membership  Entity and End the Premier/National Membership ***  The Premier Membership should be End Dated successfully
		.typeEndDateInMembership(DataInputProvider.getCellData_ColName(iRowNumber, "membershipEndDate", sDataSheetName))

		.verifyEndResaon()

		// then save
		.clickMembershipSaveAndClose()

		//10.Verify the Account Status***  The Account Status should be moved to "Terminated"
		.defaultAccountStatus(DataInputProvider.getCellData_ColName(iRowNumber, "accountStatusTerminated", sDataSheetName))

		;	
	}
}
