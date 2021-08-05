package testcases.Member;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//Test Case ID	: Test Case 8218:Verify reactivating a terminated member
//Created By	: Sudha
//Created On  	:05/11/2021
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class TestCase_8218 {

	  	
	@Test
	public void createMemberTP(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {
		
		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
			.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
	  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
			.clickSignIn()
		
		//2. Go to Accounts and click on New button **** New account form should be displayed 
		.clickWorkplace()
			.selectAccounts()
			.clickNewOnAccountsPage()
			.chooseMemberFormwithFrame1()
		//3.Provide the below values in the form and save **** Account should be saved and CRM# should be captured successfully
			// Account  Type = Member
			.selectAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "AccountType", sDataSheetName))
			
			//Account name = Any
			.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName", sDataSheetName))
			
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
			
			//Direct Parent CRM number = 2000092265/822660
			.selectDirectParent(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParent", sDataSheetName))
			
			//Direct Parent Relation = Managed
			.selectDirectParentRelationManaged(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelation", sDataSheetName)) 
			
			//Direct Parent Relation date = Today's Date
			.selectDirectParentRelationDate(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelationDate", sDataSheetName))
			
			//Top Parent Relation =  OLM
			 .selectTopParentRelation(DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelation", sDataSheetName))
			 
			//Top Parent Relation Date = Today's Date
			 .selectTopParentRelationDate( DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelationDate", sDataSheetName))
			 
			 
		//4.Add the below address details ***** Account should be saved successfully
		 	//Street 1 = Any
			.typeStreet1(DataInputProvider.getCellData_ColName(iRowNumber, "Street1", sDataSheetName))
			
			 //City = NY
			.typeCity(DataInputProvider.getCellData_ColName(iRowNumber, "City", sDataSheetName))
			
			 //Country =USA
			.typeCountry(DataInputProvider.getCellData_ColName(iRowNumber, "Country", sDataSheetName))
			
			//Country = USA
			.typeCounty(DataInputProvider.getCellData_ColName(iRowNumber, "County", sDataSheetName))
			
			// Click on Save 
			 .clickSave() 
			
				 
		//5.Go to Membership entity and add ***** Premier GPO membership should be added successfully 			
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~MultiGPO Update~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
			//Add Membership provider
				.clickAddNewPremierMembershipWithFrame1()
				
				// Choose Membership type
				.selectMembershipProviderType1(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProviderType", sDataSheetName))
				.typeInAddNewMembershipProvider(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProvider", sDataSheetName))
				
				//Provide any start date and click on save
				.selectMembershipProviderStartDateInAddNewMembershipProvider(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProviderStartDate", sDataSheetName))
				.clickAddNewMembershipProviderSave()
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			
			
		//6.Click the + icon on the Line of Business Grid ***** Corresponding LOB should be added successfully 
		.clickLineOfBusinessWithFrame1()
		
			//On the Pop up window fill in the required field
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
			 			 
				 
		//7.Verify Premier start date is displayed 	*****Premier start date should be displayed in the form
			//.verifyPremierStartDateIsAutoPopulated()
				
		//8.Move the record status to Published and save *****  Account should be published successfully, EIN number should be captured successfully
			.chooseRecordStatusPublishedWithFrame1(DataInputProvider.getCellData_ColName(iRowNumber, "RecordStatusPublished", sDataSheetName))
					
			//Click on Save 
			.clickSave() 
					
			//Account should be published successfully, EIN number should be captured successfully
			.entityCodeIsDisplayedWithFrame1()
			
			//Verify Premier start date is auto populated
			.verifyPremierStartDateIsAutoPopulated()
			
			.verifyAffiliateGroupIsNotNull()
			.verifyAgEffectiveDateIsNotNull()
			
		//9.Move the record status to draft and save  ***** Record moved to draft 
			.chooseRecordStatusDraft()
			
			//Click on Save 
			.clickSave() 
		
		//10.Go to membership and Open the Premier National membership ***** Premier National membership should be opened 
			.selectMembershipEntity()
			.doubleClickOnNationalMembership()
			
		//11.Provide end date = Any future date **** Account should be saved successfully 
			.typeMembershipEndDate(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipEndDate", sDataSheetName))
			
			// End reason = Anything from dropdown,
			.selectMembershipEndReason(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipEndReason", sDataSheetName))
			
			// then save
			.clickMembershipSaveAndClose()
			
			
		//12.Verify the account status  ***** Account status should become terminated 
			.verifyAccountStatus(DataInputProvider.getCellData_ColName(iRowNumber, "AccountStatus", sDataSheetName))
			
		//13.Verify Premier end date **** Premier end date should be populated with the same date  as National membership end date 
			.verifyPremierEndDate(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipEndDate", sDataSheetName))
			
		//14.Verify the AG and AG effective date **** AG should become NON Premier.AG effective date should be Premier end date 
			.verifyAffiliateGroup(DataInputProvider.getCellData_ColName(iRowNumber, "AffiliateGroup", sDataSheetName))
			.verifyAgEffectiveDate(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipEndDate", sDataSheetName))
		
		//15. Now move the record status to Published and save **** Account should be published successfully 
			.chooseRecordStatusPublished(DataInputProvider.getCellData_ColName(iRowNumber, "RecordStatusPublished", sDataSheetName))
			
			//Click on Save 
			.clickSave() 
			
		//16.For reactivation, move the record status to draft *** Record should be moved to draft 
			.chooseRecordStatusDraftWithFrame1(DataInputProvider.getCellData_ColName(iRowNumber, "RecordStatus", sDataSheetName))
			
			//Click on Save 
			.clickSave()
			
		//17.Go to membership and add New membership **** Account should be saved successfully 
		//Add Membership provider
			.clickAddNewPremierMembershipWithFrame1()
			
			// Choose Membership type
			.selectMembershipProviderType1(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProviderType", sDataSheetName))
			.typeInAddNewMembershipProvider(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProvider1", sDataSheetName))
			
			//Provide any start date and click on save
			.selectMembershipProviderStartDateInAddNewMembershipProvider(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProviderStartDate1", sDataSheetName))
			.clickAddNewMembershipProviderSave()	
			
		//18.Now add corresponding LOB **** LOB should be added successfully 
		//Click the + icon on the Line of Business Grid
		.clickLineOfBusinessWithFrame1()

		//On the Pop up window fill in the required fields
		//Line of Business =Acurity
		.selectLineOfBusiness(DataInputProvider.getCellData_ColName(iRowNumber, "LineOfBusinessGeneralGPO1", sDataSheetName))

		//Classification Type = Acurity
		.selectLineOfClassificationGeneralGPO(DataInputProvider.getCellData_ColName(iRowNumber, "LineOfClassificationGeneralGPO1", sDataSheetName))

		//Start Date =Today's date
		.selectLineOfBusinessStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "LineOfBusinessStartDate1", sDataSheetName))

		//Click on Save 
		.clickLineOfBusinessSave()
			
		//25.Move the record status to Published ***** Account should be published and reactivated successfully 
		.chooseRecordStatusPublishedWithFrame1(DataInputProvider.getCellData_ColName(iRowNumber, "RecordStatusPublished", sDataSheetName))
		
		//Click on Save 
		.clickSave() 
			
		//19.Verify the Account status ***** Account status should be Active 
			.verifyAccountStatusWithFrame1(DataInputProvider.getCellData_ColName(iRowNumber, "AccountStatus1", sDataSheetName))
		
		//20.Verify the Premier start date **** Premier start date should be Acurity's start date 
			.verifyPremierStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProviderStartDate1", sDataSheetName))
			
		//21.Verify Premier end date ***** Premier end date should be blank 
			.verifyPremierEndDateIsNull()

		//22.Verify DPRD ***** DPRD should be same as new Premier start date 
			.verifyDirectParentRelationDate(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProviderStartDate1", sDataSheetName))
		
		//23.Verify TPRD ****TPRD should be same as New Premier start date 
			.verifyTopParentRelationDate(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProviderStartDate1", sDataSheetName))
				
		//24.Verify AG and AG effective date  ***** AG should not be NON Premier.AG effective date should be updated
			.verifyAffiliateGroup(DataInputProvider.getCellData_ColName(iRowNumber, "AffiliateGroup", sDataSheetName))
			.verifyAgEffectiveDate(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProviderStartDate1", sDataSheetName))
		
		
			
		;
	}
}
