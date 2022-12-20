package testcases.Member;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;
//TFS ID_45311 Verify whether child Account cannot be published if DP does not have entity code

public class TestCase_45311 {


	@Test
	public void createMemberWithoutEntity(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException 
	{

		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName)) 
		.clickSignIn()

		//2.Go to Workplace > Accounts and search for EIN 673415 
		.clickWorkplace()
		.selectAccounts()
		.searchOnAccountsPage(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber", sDataSheetName))

		//3.Double click on the account and go to Sub accounts entity by clicking > on the top 
		.selectAccountFromSearchResults()
		.clickSave()
		.selectSubaccount()

		//4. Click on Add new account 
		.clickNewAccountInSubAccount()
		.switchToSubAccount()

		//6. Account Name = Any
		.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName", sDataSheetName))


		//Click on save 
		.clickSave()

		//Select member form
		.chooseMemberFormInSubAccount()


		//6.	//Top Parent Relation =  OLM
		.selectTopParentRelationInFrame0(DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelation", sDataSheetName))

		//Top Parent Relation Date = Today's Date
		.selectTopParentRelationDate( DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelationDate", sDataSheetName))

		//type TP reason
		.typeTPReason(DataInputProvider.getCellData_ColName(iRowNumber, "TPReason", sDataSheetName))

		//Click on save 
		.clickSave()


		//7. Verify CRM Account # is generated 
		.crmNumberIsDisplayedWithFrame0()	

		//8 Account  Type = Member
		.selectAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "AccountType", sDataSheetName))

		//Premier Start date = Today's Date
		//.pickPremierStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "PremierStartDate", sDataSheetName))

		//Class of Trade =Any
		.selectClassOfTrade(DataInputProvider.getCellData_ColName(iRowNumber, "ClassOfTrade", sDataSheetName))

		//Business Classification = Auto populated
		.businessClassificationIsVerified()	

		//Account Status = Auto Populated to Active
		.defaultAccountStatus()	

		//Application Start Date = Today's Date
		.chooseApplicationDate(DataInputProvider.getCellData_ColName(iRowNumber, "ApplicationDate", sDataSheetName))

		//Participation Type = Standard
		.selectParticipationType(DataInputProvider.getCellData_ColName(iRowNumber, "ParticipationType", sDataSheetName))

		//Direct Parent Relation = Managed
		.selectDirectParentRelationMEF(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelation", sDataSheetName)) 

		//Direct Parent Relation date = Today's Date
		.selectDirectParentRelationDate(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelationDate", sDataSheetName))

		//DP exception reason = Any
		.typeDPReason(DataInputProvider.getCellData_ColName(iRowNumber, "DPReason", sDataSheetName))

		//Click on Save 
		// .clickSave() 

		//9. Street 1 = Any
		.typeStreet1(DataInputProvider.getCellData_ColName(iRowNumber, "Street1", sDataSheetName))

		//City = NY
		.typeCity(DataInputProvider.getCellData_ColName(iRowNumber, "City", sDataSheetName))

		/* //Country =USA
			.typeCountry(DataInputProvider.getCellData_ColName(iRowNumber, "Country", sDataSheetName))

			//
			.typeCounty(DataInputProvider.getCellData_ColName(iRowNumber, "County", sDataSheetName))*/

		//Type Zip code
		.typeZipCode(DataInputProvider.getCellData_ColName(iRowNumber, "ZipCode", sDataSheetName))

		//Click on Save
		// .clickSave() 

		//10 Click the + icon on the Line of Business Grid		
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
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~MultiGPO Update~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
		//Add Membership provider
		.clickAddNewPremierMembershipWithFrame0()

		// Choose Membership type
		.selectMembershipProviderType1(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProviderType", sDataSheetName))
		.typeInAddNewMembershipProvider(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProvider", sDataSheetName))

		//Provide any start date and click on save
		.selectMembershipProviderStartDateInAddNewMembershipProvider(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProviderStartDate", sDataSheetName))
		.clickAddNewMembershipProviderSave()
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		
		//11 Record Status = Published
		.chooseRecordStatusPublishedWithFrame0(DataInputProvider.getCellData_ColName(iRowNumber, "RecordStatusPublished", sDataSheetName))

		//Click on Save 
		.clickSave() 
		.verifyErrorMessage(DataInputProvider.getCellData_ColName(iRowNumber, "ErrorMessage", sDataSheetName))
		.ClickOkInErrorMessage()
		;
	}

}