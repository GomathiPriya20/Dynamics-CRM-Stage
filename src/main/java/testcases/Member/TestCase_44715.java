package testcases.Member;
import org.testng.annotations.Test;
import pages.LoginPage;

import utils.DataInputProvider;

//TFS ID_44715: Verify date validation triggers when Ship to accounts converted to Member


public class TestCase_44715 {


	@Test
	public void convertLocationTypetoMember(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
		.clickSignIn()

		//2. Go to Workplace > Accounts > +New 
		.clickWorkplace()
		.selectAccounts()
		.clickNewOnAccountsPage()
		.chooseMemberFormwithFrame1()

		//3. Account Name = Any
		.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName", sDataSheetName))

		//Click on save 			
		.clickSave() 

		//4. Verify CRM Account # is generated 
		.crmNumberIsDisplayedWithFrame1()	

		//5. Account Type = Member
		.selectAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "AccountType", sDataSheetName))

		//Premier Start date = Today's Date
		//	.pickPremierStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "PremierStartDate", sDataSheetName))

		//Class of Trade =Any
		.selectClassOfTrade(DataInputProvider.getCellData_ColName(iRowNumber, "ClassOfTrade", sDataSheetName))

		//Business Classification = Auto populated
		.businessClassificationIsVerified()	

		//Account Status = Auto Populated to Active
		.defaultAccountStatus()	

		.chooseApplicationDate("11/20/2017")
		
		//Store/Location type = Mail to
		.chooseLocationType(DataInputProvider.getCellData_ColName(iRowNumber, "LocationType", sDataSheetName))	

		//CAMS Flag = Yes
		.changeCAMSFlag()

		//6. Street 1 = Any
		.typeStreet1(DataInputProvider.getCellData_ColName(iRowNumber, "Street1", sDataSheetName))

		//City = NY
		.typeCity(DataInputProvider.getCellData_ColName(iRowNumber, "City", sDataSheetName))

		//Country =USA
		.typeCountry(DataInputProvider.getCellData_ColName(iRowNumber, "Country", sDataSheetName))

		//Enter county
		.typeCounty(DataInputProvider.getCellData_ColName(iRowNumber, "County", sDataSheetName))

		//Click on Save 

		//Direct Parent Entity Code = 673415
		.selectDirectParent(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParent", sDataSheetName))

		//Direct Parent Relation = Managed
		.selectDirectParentRelationManaged(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelation", sDataSheetName)) 

		//Direct Parent Relation date = Today's Date
		.selectDirectParentRelationDate("11/20/2017")

		//Top Parent Relation =  OLM
		.selectTopParentRelation(DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelation", sDataSheetName))

		// Top Parent Relation Date = Today's Date
		.selectTopParentRelationDate("11/20/2017")

		.clickSave() 

		//7. Record Status = Published
		.chooseRecordStatusPublishedWithFrame1(DataInputProvider.getCellData_ColName(iRowNumber, "RecordStatusPublished", sDataSheetName))

		//Click on Save 
		.clickSave() 

		//8. Verify Entity code is same as DP's entity code 
		.verifyEntityCode(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParent", sDataSheetName))

		//Change the Record status to Draft
		.navigateToDoNotVerifyAddress()
		.chooseRecordStatusPublishedWithFrame1("Draft")

		.clickSave()
		.selectMembershipEntity()
		.navigateToGeneralTab()
		.navigateToisStoreLocation()
		
		.selectParticipationType("Pharmacy")
		//Store/Location type = Blank
		.chooseLocationType("")	

		.clickSave() 
		.navigateToLOBWidget()
		//7.  Click the + icon on the Line of Business Grid
		.clickLineOfBusiness()

		// Line of Business =General GPO
		.selectLineOfBusinessGeneralGPO(DataInputProvider.getCellData_ColName(iRowNumber, "LineOfBusinessGeneralGPO", sDataSheetName))

		// Classification Type = General GPO
		.selectLineOfClassificationGeneralGPO(DataInputProvider.getCellData_ColName(iRowNumber, "LineOfClassificationGeneralGPO", sDataSheetName))

		// Start Date =Today's date
		.selectLineOfBusinessStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "LineOfBusinessStartDate", sDataSheetName))

		// Click on LOB Save 
		.clickLineOfBusinessSave()

		//Click on Save 
		.clickSave() 

		.selectMembershipEntity()
		.navigateToGeneralTab()
		.navigateToRecordStatus()

		//7. Record Status = Published
		.chooseRecordStatusPublishedWithFrame1(DataInputProvider.getCellData_ColName(iRowNumber, "RecordStatusPublished", sDataSheetName))

		//Click on Save 
		.clickSave() 
		.verifyPartialErrorMessage(DataInputProvider.getCellData_ColName(iRowNumber, "ErrorMessage", sDataSheetName))
		
		
		;

	}
}