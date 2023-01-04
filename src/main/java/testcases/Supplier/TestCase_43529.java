package testcases.Supplier;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//TFS ID_43529:Test Case : Verify user is not able to terminate a supplier account with active children
//Created By	: Faridhah
//Created On  	:12/28/2022
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class TestCase_43529 {

	@Test()


	public void verifySupplierTerminationWithActiveChildren(int iRowNumber, String sDataSheetName) throws Exception {
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

		//Verify Default Account Type on Supplier Form
		.defaultAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "defaultAccountType", sDataSheetName))

		

//		//Account Type = Auto populated  (Supplier)
//		.defaultAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "defaultAccountType", sDataSheetName))
//
//		//Record Status = Draft (Default)
//		.recordStatusDraft()
//
//		//Save the Record
//		.clickSave()
//
//		//.crmNumberIsDisplayed()
//
//		//4. Verify the Premier Start Date *** Premier Start Date should be auto-populated as Today's date 
//		.verifyPremierStartDateAsCurrentDate()
//
//		//5.Modify Premier Start Date to different date and save ***The new Premier Start Date should be saved 
//		.pickPremierStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "premierStartDate", sDataSheetName))
//		//Save the Record
//		.clickSave()
//
//		//6.Change Record Status = Published and save  *** The Supplier Record should be published and Entity Code should be generated .
//		.recordStatusPublished(DataInputProvider.getCellData_ColName(iRowNumber, "recordStatusPublished", sDataSheetName))	
//		//Save the Record
//		.clickSave()
//		.entityCodeIsDisplayed()
//
//
//		//8.Now move the Record Status = Draft and save  *** Record should be moved to Draft 
//		.recordStatusDraft()
//		//Save the Record
//		.clickSave()
//
		//7.Go to Membership  Entity and verify the Premier/National Membership *** The Premier/National Membership should be created with Start Date as  Premier Start Date	
		.selectMembershipEntity()
		.doubleClickOnNationalMembership(DataInputProvider.getCellData_ColName(iRowNumber, "premierStartDate", sDataSheetName))

		//9. Go to Membership  Entity and End the Premier/National Membership ***  The Premier Membership should be End Dated successfully
		.typeEndDateInMembership(DataInputProvider.getCellData_ColName(iRowNumber, "membershipEndDate", sDataSheetName))

		.verifyEndResaon()

		// then save
		.clickMembershipSaveAndClose()
		
		
		//verify Supplier with active children cannot be terminated 
		.verifyErrorMessage(DataInputProvider.getCellData_ColName(iRowNumber, "expectedAccountStatusErrorText", sDataSheetName))
		
//
//		//10.Verify the Account Status***  The Account Status should be moved to "Terminated"
//		.defaultAccountStatus(DataInputProvider.getCellData_ColName(iRowNumber, "accountStatusTerminated", sDataSheetName))

		;	
	}
}
