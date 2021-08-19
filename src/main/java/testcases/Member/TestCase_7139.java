package testcases.Member;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;
//TFS ID_7139:Create new member - New Member entry form through sub account and save it as prospect first

public class TestCase_7139 {

	  	
	@Test
	public void createMemberTP(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException 
	{

		new LoginPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName)) 
		.clickSignIn()
		
		//2.Go to Workplace > Accounts and search for EIN 673415 
		.clickWorkplace()
		.selectAccounts()
		.searchOnAccountsPage(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParent", sDataSheetName))
		
		//3.Double click on the account and go to Sub accounts entity by clicking > on the top 
		.selectAccountFromSearchResults()
		.selectSubaccount()
		
		//4. Click on Add new account 
		.clickNewAccountInSubAccount()
		.chooseMemberEntryFormInSubAccount()
		
		//5. Verify Direct parent and Top parent are populated 
 		.verifyDirectParent(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyTopParent", sDataSheetName))
 		.verifyTopParent(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyDirectParent", sDataSheetName))
				
		//6. Account Name = Any
		.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName", sDataSheetName))
		
			//Top Parent Relation =  OLM
			 .selectTopParentRelation(DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelation", sDataSheetName))
		
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
			//	.pickPremierStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "PremierStartDate", sDataSheetName))
				
				//Class of Trade =Any
				.selectClassOfTrade(DataInputProvider.getCellData_ColName(iRowNumber, "ClassOfTrade", sDataSheetName))
				
				//Business Classification = Auto populated
				.businessClassificationIsVerified()	
				
				//Account Status = Auto Populated to Active
				.defaultAccountStatus()	
				
				//Application Start Date = Today's Date
				.chooseApplicationDate(DataInputProvider.getCellData_ColName(iRowNumber, "ApplicationDate", sDataSheetName))
				
				//CAMS Flag = Yes
				.changeCAMSFlag()
				
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
				
				//Type Zip code
				.typeZipCode(DataInputProvider.getCellData_ColName(iRowNumber, "ZipCode", sDataSheetName))
				
				 //Country =USA
			//	.typeCountry(DataInputProvider.getCellData_ColName(iRowNumber, "Country", sDataSheetName))
				
			
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
						
						// Choose Membership type and Membership Provider
						.selectMembershipProviderType1(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProviderType", sDataSheetName))
						.typeInAddNewMembershipProvider(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProvider", sDataSheetName))
						
						//Provide any start date and click on save
						.selectMembershipProviderStartDateInAddNewMembershipProvider(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProviderStartDate", sDataSheetName))
						.clickAddNewMembershipProviderSave()
				//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			
			//11 Record Status = Published
				.chooseRecordStatusPublishedWithFrame0(DataInputProvider.getCellData_ColName(iRowNumber, "RecordStatusPublished", sDataSheetName))
				
				//Click on Save 
				.clickSave() 
			
			//12 Verify Entity code is generated 
				.entityCodeIsDisplayedWithFrame0()
				
				//Verify Premier start date is auto populated
				.verifyPremierStartDateIsAutoPopulated()
				
				.verifyAffiliateGroupIsNotNull()
				.verifyAgEffectiveDateIsNotNull()
			
			//13 Verify "IS Corporate parent" field
				.verifyIsCorporateAccount(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyIsCorporateAccount", sDataSheetName))
			
			//14 Verify Corporate parent name in the form
				.verifyCorporateParentName(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyCorporateParentName", sDataSheetName))
			
			//15 Verify "Is Food Service parent" field 
				.verifyIsFoodServiceParent(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyIsFoodServiceParent", sDataSheetName))
				
			//16 Verify Food Service parent name in the form 
				.VerifyFoodServiceParentName(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyFoodServiceParentName", sDataSheetName))
						
			//17 Verify "Is Sponsor" field
				.verifySponsor(DataInputProvider.getCellData_ColName(iRowNumber, "VerifySponsor", sDataSheetName))
				
			//18 Verify Sponsor field 
				.verifyIsSponsor(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyIsSponsor", sDataSheetName))
				
			//FBO details verification
			//Verify "Is FBO" field 
			.verifyIsFBO(DataInputProvider.getCellData_ColName(iRowNumber, "isFBO", sDataSheetName))
			
			//FBO
			.VerifyFBO(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyDirectParent", sDataSheetName))
					
			//FBORD
			.VerifyFBORD(DataInputProvider.getCellData_ColName(iRowNumber, "verifyFBORD", sDataSheetName))
				
			
			//19  Go to > and click on Membership entity and double click on the Top parent membership entity
			.selectMembershipEntity()
			.doubleClickOnNationalMembershipWithFrame0()
			
			//20 Click on > and go to Audit history 
			.selectTPAuditHistory()
			
			//21 Verify "Is Member Add mail sent" flag turned from No to Yes 
			.verifyIsMemberAddMailSentwithFrame01()
			
			//22 Verify the time-stamp on which the flag gets updated 
			.verifyTimeStampInTPMembershipAuditHistory()
			
				;
	
	}
	
}
